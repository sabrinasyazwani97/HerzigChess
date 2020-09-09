//Subclass for Cross Piece
//Part of the model
public class Cross extends Piece {
    Cross(int positionX, int positionY){
        super(positionX, positionY);
    }

    @Override
    public void pieceMovement(int y, int x){
        for (int i=0;i<=7 ;i++){
            for (int j=0;j<=4 ;j++){
                for (int k=1;k<=4;k++){
                if ((j==x+k||j==x-k) && (i==y-k||i==y+k))
                    availableMovements[i][j] = 1;
                }
            }
        }
    }
}