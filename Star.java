//Subclass for Star Piece
//Part of the model
public class Star extends Piece {
    Star(int positionX, int positionY){
        super(positionX, positionY);
    }

    @Override
    public void pieceMovement(int y, int x){
        for (int i=0;i<=7 ;i++){
            for (int j=0;j<=4 ;j++){
                if (((j==x-2||j==x||j==x+2)&&(i==y-2||i==y||i==y+2)) || ((j==x-1||j==x||j==x+1)&&(i==y-1||i==y||i==y+1)))
                    availableMovements[i][j] = 1;    
            }
        }
        availableMovements[y][x]=0;
    }
}