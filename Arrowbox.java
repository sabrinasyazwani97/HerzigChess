//Subclass for Arrowbox Piece
//Part of the model
public class Arrowbox extends Piece {
    Arrowbox(int positionX, int positionY,String direction){
        super(positionX, positionY,direction);
    }
    
    @Override
    public void pieceMovement(int y, int x){
        if (direction=="down")
        {
            if (y==6)   
                availableMovements[7][x] = 1;
            else{
                for (int i=y;i<=y+2 ;i++)
                    availableMovements[i][x] = 1; 
            }
        }
        else
        {   
            if (y==1)
                availableMovements[0][x] = 1;
  
            else{
                for (int i=y;i>=y-2 ;i--)
                    availableMovements[i][x] = 1;
            }
        }        
        availableMovements[y][x] = 0;
    }
}