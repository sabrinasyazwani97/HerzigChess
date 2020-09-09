//Part of the model
import java.io.*;
import java.lang.*;
import java.util.*;

public class Board 
{
        Formatter save_file;
        Scanner save_scanner;
        String[][] temp = { {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"},
                            {"_", "_", "_", "_", "_"}};
                            
        String[][] boardArray = { {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"},
                                {"_", "_", "_", "_", "_"}};
                                
        Piece rab1,rab2,rab3,rs1,rs2,rc1,rc2,rh1,gab1,gab2,gab3,gs1,gs2,gc1,gc2,gh1;
 
        Board(Piece rab1,Piece rab2,Piece rab3,Piece rs1,Piece rs2,Piece rc1,Piece rc2,Piece rh1,Piece gab1,Piece gab2,
                         Piece gab3,Piece gs1,Piece gs2,Piece gc1,Piece gc2,Piece gh1) 
        {       
            this.rab1=rab1;
            this.rab2=rab2;
            this.rab3=rab3;
            this.rs1=rs1;
            this.rs2=rs2;
            this.rc1=rc1;
            this.rc2=rc2;
            this.rh1=rh1;
            this.gab1=gab1;
            this.gab2=gab2;
            this.gab3=gab3;
            this.gs1=gs1;
            this.gs2=gs2;
            this.gc1=gc1;
            this.gc2=gc2;
            this.gh1=gh1;
 
            for (int i=0;i<=7 ;i++){        //Inserting pieces into their initial position
                for (int j=0;j<=4 ;j++){
                    if (i==rab1.positionY && j==rab1.positionX)
                        boardArray[i][j]="rab1";
                    if (i==rab2.positionY && j==rab2.positionX)
                        boardArray[i][j]="rab2";
                    if (i==rab3.positionY && j==rab3.positionX)
                        boardArray[i][j]="rab3";
                    if (i==rs1.positionY && j==rs1.positionX)
                        boardArray[i][j]="rs1";
                    if (i==rs2.positionY && j==rs2.positionX)
                        boardArray[i][j]="rs2";
                    if (i==rc1.positionY && j==rc1.positionX)
                        boardArray[i][j]="rc1";
                    if (i==rc2.positionY && j==rc2.positionX)
                        boardArray[i][j]="rc2";
                    if (i==rh1.positionY && j==rh1.positionX)
                        boardArray[i][j]="rh1";
                    if (i==gab1.positionY && j==gab1.positionX)
                        boardArray[i][j]="gab1";
                    if (i==gab2.positionY && j==gab2.positionX)
                        boardArray[i][j]="gab2";
                    if (i==gab3.positionY && j==gab3.positionX)
                        boardArray[i][j]="gab3";
                    if (i==gs1.positionY && j==gs1.positionX)
                        boardArray[i][j]="gs1";
                    if (i==gs2.positionY && j==gs2.positionX)
                        boardArray[i][j]="gs2";
                    if (i==gc1.positionY && j==gc1.positionX)
                        boardArray[i][j]="gc1";
                    if (i==gc2.positionY && j==gc2.positionX)
                        boardArray[i][j]="gc2";
                    if (i==gh1.positionY && j==gh1.positionX)
                        boardArray[i][j]="gh1"; 
                }
            }
        }
        
        void showBoard(){ //for testing
           for (int i=0;i<=7 ;i++){ 
                for (int j=0;j<=4 ;j++){
                    System.out.print(boardArray[i][j]+ "  ") ;
                 }
                 System.out.print(" \n ");
           }
        }
        
        public void flipBoard() 
        {
           for(int i=0; i<=7; i++)
           {
                for(int j=0; j<=4; j++){
                    temp[i][j] = boardArray[i][j];
                }
           }
           for(int i=0; i<=7; i++)
           {
                for(int j=0; j<=4; j++){                    
                    boardArray[i][j] = temp[7-i][4-j];
                }
           }
        }
        
        void boardAfterMove(int x, int y, String piece_name){
            for (int i=0;i<=7 ;i++){        //Deleting piece old position
                for (int j=0;j<=4 ;j++)
                {
                    if (boardArray[i][j].equals(piece_name))
                        boardArray[i][j]="_";
                }
            }
            boardArray[y][x]=piece_name;
            if (y==0)
            {
                if (piece_name=="rab1")
                rab1.direction="down";
                if (piece_name=="rab2")
                rab2.direction="down";
                if (piece_name=="rab3")
                rab3.direction="down";
                if (piece_name=="gab1")
                gab1.direction="down";
                if (piece_name=="gab2")
                gab2.direction="down";
                if (piece_name=="gab3")
                gab3.direction="down";
            }
            if (y==7)
            {
                if (piece_name=="rab1")
                rab1.direction="up";
                if (piece_name=="rab2")
                rab2.direction="up";
                if (piece_name=="rab3")
                rab3.direction="up";
                if (piece_name=="gab1")
                gab1.direction="up";
                if (piece_name=="gab2")
                gab2.direction="up";
                if (piece_name=="gab3")
                gab3.direction="up";
            }
        }
        
        void afterFourTurns () 
        {
            for (int i=0;i<=7 ;i++)
            {
                for (int j=0;j<=4 ;j++)
                {
                    if (boardArray[i][j].startsWith("rc1"))
                        boardArray[i][j]="rs1";
                    else if (boardArray[i][j].startsWith("rc2"))
                        boardArray[i][j]="rs2";
                    else if (boardArray[i][j].startsWith("rs1"))
                        boardArray[i][j]="rc1";
                    else if (boardArray[i][j].startsWith("rs2"))
                        boardArray[i][j]="rc2";
                    else if (boardArray[i][j].startsWith("gc1"))
                        boardArray[i][j]="gs1";
                    else if (boardArray[i][j].startsWith("gc2"))
                        boardArray[i][j]="gs2";
                    else if (boardArray[i][j].startsWith("gs1"))
                        boardArray[i][j]="gc1";
                    else if (boardArray[i][j].startsWith("gs2"))
                        boardArray[i][j]="gc2";
                    else;
                }
            }
        }

        void saveGameFileCreation()
        {
            try{
                save_file= new Formatter ("SaveGame.txt");
            }
            catch(Exception e){
                System.out.println("Error in saving game.");
            }
        }
    
        void saveGame()
        {
            for (int i=0;i<=7 ;i++)
                save_file.format("%s%s%s%s%s%n",boardArray[i][0]+" ",boardArray[i][1]+" ",boardArray[i][2]+" ",boardArray[i][3]+" ",boardArray[i][4]+" ");
            save_file.close();
        }

        void loadGameScanner()
        {
            try{
                save_scanner= new Scanner(new File("SaveGame.txt"));
            }
            catch(Exception e){
                System.out.println("Error, could not find file.");
            }
        }

        void loadGame(){
            while(save_scanner.hasNext()){
                for (int i=0;i<=7 ;i++){
                    boardArray[i][0] = save_scanner.next();
                    boardArray[i][1] = save_scanner.next();
                    boardArray[i][2] = save_scanner.next();
                    boardArray[i][3] = save_scanner.next();
                    boardArray[i][4] = save_scanner.next();
                }
            }
            save_scanner.close();
        }  
}
