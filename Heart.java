//Subclass for Heart Piece
//Part of the model
public class Heart extends Piece {
    Heart(int positionX, int positionY){
        super(positionX, positionY);
    }
      
    @Override
    void pieceMovement(int y, int x){
        for (int i=0;i<=7 ;i++){
            for (int j=0;j<=4 ;j++){
                if ((j==x-1||j==x||j==x+1)&&(i==y-1||i==y||i==y+1))
                    availableMovements[i][j] = 1;
            }
        }
        availableMovements[y][x]=0;
    }
}