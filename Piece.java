//Part of the model
abstract public class Piece {
    int positionX, positionY;
    int  firstClickY, firstClickX;
    String pieceName,direction;
    
    int[][] availableMovements={{0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0}};   
              
    Piece(int positionX, int positionY){
            this.positionX= positionX;
            this.positionY= positionY;          
    }

    Piece(int positionX, int positionY,String direction){
            this.positionX= positionX;
            this.positionY= positionY;   
            this.direction= direction;
            
    }

    public int[][] getAvailableMovements(){ //for testing
            return availableMovements;
    }

    public void resetAvailableMovements(){
        for (int i=0;i<=7 ;i++){        //Deleting piece old position
              for (int j=0;j<=4 ;j++)
                  availableMovements[i][j]=0;
        }
    }

    abstract void pieceMovement(int y, int x);

    public void setFisrtClickLoc(int y, int x, String pieceName){
        this.firstClickY = y;
        this.firstClickX = x;
        this.pieceName = pieceName;
    }

    public int getFirstClickX(){
        return firstClickX;
    }

    public int getFirstClickY(){
        return firstClickY;
    }

    public String getPieceName(){
        return pieceName;
    }

    void printposition( ){ //for testing
        System.out.println(positionX);  
    }

    void printposition2( ){  //for testing
        System.out.println(positionY);  
    }

    void showMove(){ //for testing
           for (int i=0;i<=7 ;i++){ 
                for (int j=0;j<=4 ;j++){
                    System.out.print(availableMovements[i][j]+ "  ") ;
                 }
                 System.out.print(" \n ");
           }
           //System.out.println(boardArray[0][0]);
    }
}