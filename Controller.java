//The program controller
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;

//Control the program 
public class Controller 
{
        private GUI theGUI;
        private Board theBoard;
        private Piece rab1,rab2,rab3,rs1,rs2,rc1,rc2,rh1,gab1,gab2,gab3,gs1,gs2,gc1,gc2,gh1;
        JButton[][] temp = new JButton[8][5];
        
        int playerTurn=0; // 0=red player, 1=green player;
        int turnCounter=0;
        int redHeartExists=0;
        int greenHeartExists=0;
        int[][] tempInt;
        int[][] nextPiece;
        
        int positionX =0;
        int positionY=0;
        int numClicks=0;

        public Controller(GUI theGUI, Board theBoard, Piece rab1,Piece rab2,Piece rab3,Piece rs1,Piece rs2,Piece rc1,Piece rc2,Piece rh1,Piece gab1,Piece gab2,
                             Piece gab3,Piece gs1,Piece gs2,Piece gc1,Piece gc2,Piece gh1) 
        {
            this.theGUI = theGUI;
            this.theBoard = theBoard;
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

            //PICTURE TO BUTTONS METHOD ((COMPARE GUI buttons WITH boardARRAY, if same then put picture))
            assignImage(theGUI.board, theBoard.boardArray);
                        
            //THROW ACTIONLISTENER FOR EVERY BUTTON
            theGUI.menuListener(new MenuListener()); 
            theGUI.boardListener(new BoardListener());
        }
        
        public class MenuListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(e.getSource() == theGUI.save){
                   if (playerTurn==0)
                   {
                       theBoard.saveGameFileCreation();
                       theBoard.saveGame();
                       JOptionPane.showMessageDialog(null, "Game saved!");
                   }
                   if(playerTurn==1)
                       JOptionPane.showMessageDialog(null, "Save Failed. Game can only be saved when both player has made a move.");
                }
                if(e.getSource() == theGUI.load)
                {  
                    if(playerTurn==0)
                    {
                        theBoard.loadGameScanner();
                        theBoard.loadGame();
                        resetImage(theGUI.board);
                        assignImage(theGUI.board,theBoard.boardArray);
                        positionX=0;
                        positionY=0;
                        numClicks=0;
    
                        JOptionPane.showMessageDialog(null, "Game loaded!");
                    }
                    if(playerTurn==1)
                        JOptionPane.showMessageDialog(null, "Load Failed. Game can only be loaded when both player finish making a move.");
                }
            }
        }
        
        
        public class BoardListener extends JFrame implements ActionListener
        {
             public void actionPerformed(ActionEvent e) 
             {
                if (playerTurn==0)
                {
                    for(int row=0; row<8; row++)
                    {
                        for(int col=0; col<5; col++)
                        {                            
                            if(e.getSource() == theGUI.board[row][col])
                            {
                                if(theBoard.boardArray[row][col].equals("rab1") && numClicks == 0)
                                {  
                                    rab1.pieceMovement(row, col);
                                    rab1.getAvailableMovements();
                                    showMove(theGUI.board, rab1.availableMovements);
                                    numClicks = 1;   
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }  
                                else if(theBoard.boardArray[row][col].equals("rab2") && numClicks == 0) {  

                                    rab2.pieceMovement(row, col);
                                    rab2.getAvailableMovements();
                                    showMove(theGUI.board, rab2.availableMovements);
                                    numClicks = 1;  
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rab3") && numClicks == 0) {  
                                    rab3.pieceMovement(row, col);
                                    rab3.getAvailableMovements();
                                    showMove(theGUI.board, rab3.availableMovements);
                                    numClicks = 1;  
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rs1") && numClicks == 0) {  
                                    rs1.pieceMovement(row, col);
                                    rs1.getAvailableMovements();
                                    showMove(theGUI.board, rs1.availableMovements);
                                    numClicks = 1;
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rs2") && numClicks == 0) {  
                                    rs2.pieceMovement(row, col);
                                    rs2.getAvailableMovements();
                                    showMove(theGUI.board, rs2.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rc1") && numClicks == 0) {  
                                    rc1.pieceMovement(row, col);
                                    rc1.getAvailableMovements();
                                    showMove(theGUI.board, rc1.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rc2") && numClicks == 0) {  
                                    rc2.pieceMovement(row, col);
                                    rc2.getAvailableMovements();
                                    showMove(theGUI.board, rc2.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("rh1") && numClicks == 0) {  
                                    rh1.pieceMovement(row, col);
                                    rh1.getAvailableMovements();
                                    showMove(theGUI.board, rh1.availableMovements);
                                    numClicks = 1;
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                
                                if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rab1")){
                                    rab1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rab1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rab1");  
                                        numClicks = 2;

                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rab2")){
                                    rab2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rab2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rab2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rab3")){
                                    rab3.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rab3.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rab3");   
                                        numClicks = 2;
                                    }
                                     else
                                                                            
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rc1")){
                                    rc1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rc1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rc1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rc2")){
                                    rc2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rc2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rc2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rs1")){
                                    rs1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rs1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rs1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rs2")){
                                    rs2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rs2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "rs2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("rh1")){
                                    rh1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("r") == false && rh1.availableMovements[row][col] == 1){
                                    
                                        theBoard.boardAfterMove(col, row, "rh1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                
                                }
                                
                                if(numClicks==2){

                                    playerTurn=1;
                                    turnCounter=turnCounter+1;
                                    checkWinner(0);
                                    if (turnCounter%4==0 && turnCounter!= 0)
                                    theBoard.afterFourTurns();
                                    resetImage(theGUI.board);
                                    theBoard.flipBoard();
                                    assignImage_Flip(theGUI.board, theBoard.boardArray);
                                }                                
                                
                                if (numClicks!=0)
                                {
                                    rab1.resetAvailableMovements();
                                    rab2.resetAvailableMovements();
                                    rab3.resetAvailableMovements();
                                    rs1.resetAvailableMovements();
                                    rs2.resetAvailableMovements();
                                    rc1.resetAvailableMovements();
                                    rc2.resetAvailableMovements();
                                    rh1.resetAvailableMovements();
                                    restoreShowMove();
                                    positionX = 0;
                                    positionY = 0;
                                    numClicks=0;                              
                                }
                        }                        
                    }
                }               
            }
            
            else if(playerTurn==1)
            {
                    for(int row=0; row<8; row++)
                    {
                        for(int col=0; col<5; col++)
                        {                            
                            if(e.getSource() == theGUI.board[row][col])
                            {
                                
                                if(theBoard.boardArray[row][col].equals("gab1") && numClicks == 0)
                                {  
                                    gab1.pieceMovement(row, col);
                                    gab1.getAvailableMovements();
                                    showMove(theGUI.board, gab1.availableMovements);
                                    numClicks = 1;   
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }  
                                else if(theBoard.boardArray[row][col].equals("gab2") && numClicks == 0) {  
                                    gab2.pieceMovement(row, col);
                                    gab2.getAvailableMovements();
                                    showMove(theGUI.board, gab2.availableMovements);
                                    numClicks = 1;  
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("gab3") && numClicks == 0) {  
                                    gab3.pieceMovement(row, col);
                                    gab3.getAvailableMovements();
                                    showMove(theGUI.board, gab3.availableMovements);
                                    numClicks = 1;  
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("gs1") && numClicks == 0) {  
                                    gs1.pieceMovement(row, col);
                                    gs1.getAvailableMovements();
                                    showMove(theGUI.board, gs1.availableMovements);
                                    numClicks = 1;
                                    positionX = col;
                                    positionY = row;
                                    break;
                                    
                                }
                                else if(theBoard.boardArray[row][col].equals("gs2") && numClicks == 0) {  
                                    gs2.pieceMovement(row, col);
                                    gs2.getAvailableMovements();
                                    showMove(theGUI.board, gs2.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("gc1") && numClicks == 0) {  
                                    gc1.pieceMovement(row, col);
                                    gc1.getAvailableMovements();
                                    showMove(theGUI.board, gc1.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("gc2") && numClicks == 0) {  
                                    gc2.pieceMovement(row, col);
                                    gc2.getAvailableMovements();
                                    showMove(theGUI.board, gc2.availableMovements);
                                     numClicks = 1;
                                     positionX = col;
                                    positionY = row;
                                    break;
                                }
                                else if(theBoard.boardArray[row][col].equals("gh1") && numClicks == 0) {  
                                    gh1.pieceMovement(row, col);
                                    gh1.getAvailableMovements();
                                    showMove(theGUI.board, gh1.availableMovements);
                                    numClicks = 1;
                                    positionX = col;
                                    positionY = row;
                                    break;
                                }
                                
                                if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gab1")){
                                    gab1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gab1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gab1");  
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gab2")){
                                    gab2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gab2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gab2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gab3")){
                                    gab3.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gab3.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gab3");   
                                        numClicks = 2;
                                    }
                                     else
                                                                            
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gc1")){
                                    gc1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gc1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gc1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                    
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gc2")){
                                    gc2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gc2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gc2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gs1")){
                                    gs1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gs1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gs1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gs2")){
                                    gs2.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gs2.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gs2");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");
                                }
                                else if(numClicks == 1 && theBoard.boardArray[positionY][positionX].equals("gh1")){
                                    gh1.pieceMovement(positionY, positionX);
                                    if(theBoard.boardArray[row][col].startsWith("g") == false && gh1.availableMovements[row][col] == 1){
                                        theBoard.boardAfterMove(col, row, "gh1");   
                                        numClicks = 2;
                                    }
                                    else
                                         JOptionPane.showMessageDialog(null, "Invalid Move!");                                
                                }
                                
                                if(numClicks==2){

                                    playerTurn=0;
                                    turnCounter=turnCounter+1;
                                    checkWinner(1);
                                    if (turnCounter%4==0 && turnCounter!= 0)
                                        theBoard.afterFourTurns();
                                    resetImage(theGUI.board);
                                    theBoard.flipBoard();
                                    assignImage(theGUI.board,theBoard.boardArray);

                                    
                                }                                
                                
                                if (numClicks!=0)
                                {
                                    gab1.resetAvailableMovements();
                                    gab2.resetAvailableMovements();
                                    gab3.resetAvailableMovements();
                                    gs1.resetAvailableMovements();
                                    gs2.resetAvailableMovements();
                                    gc1.resetAvailableMovements();
                                    gc2.resetAvailableMovements();
                                    gh1.resetAvailableMovements();
                                    restoreShowMove();
                                    positionX = 0;
                                    positionY = 0;
                                    numClicks=0;                              
                                }
                            }
                        }
                    }
                }                
            }               
        }          

        public void showMove(JButton[][] board, int[][] availableMovements)
        {
                for(int row=0; row<8; row++)
                {
                        for(int col=0; col<5; col++)
                        {
                           if(playerTurn == 0){ 
                                if((availableMovements[row][col] == 1 && theBoard.boardArray[row][col].equals("_") )|| 
                                    (availableMovements[row][col] == 1 && theBoard.boardArray[row][col].startsWith("g"))){ 
                                    theGUI.board[row][col].setBackground(Color.BLUE); 
                                }
                           }
                           if(playerTurn == 1){ 
                                if((availableMovements[row][col] == 1 && theBoard.boardArray[row][col].equals("_")) || 
                                    (availableMovements[row][col] == 1 && theBoard.boardArray[row][col].startsWith("r"))){ 
                                    theGUI.board[row][col].setBackground(Color.BLUE); 
                                }
                           }
                        }
                }            
            }
        
        public void restoreShowMove() {
            for(int row=0; row<8; row++){
                for (int col=0; col<5; col++){
                    theGUI.board[row][col].setBackground(Color.WHITE);
                }
            }
        }

        public void assignImage(JButton[][] board, String[][] boardArray)
        {
            try {
                for(int row=0; row<8; row++){
                    for(int col=0; col<5; col++){
                        if(theBoard.boardArray[row][col].startsWith("gs1") || theBoard.boardArray[row][col].startsWith("gs2")){
                                    Image img = ImageIO.read(getClass().getResource("Image/greenStar.png"));
                                    Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                                    board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("gc1") || theBoard.boardArray[row][col].startsWith("gc2")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenCross.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("gh1")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenHeart.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("gab1") && gab1.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("gab2") && gab2.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("gab3") && gab3.direction == "up")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenBox.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("gab1") && gab1.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("gab2") && gab2.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("gab3") && gab3.direction == "down")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenBox2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rs1") || theBoard.boardArray[row][col].startsWith("rs2")){
                            Image img = ImageIO.read(getClass().getResource("Image/redStar.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rc1") || theBoard.boardArray[row][col].startsWith("rc2")){
                            Image img = ImageIO.read(getClass().getResource("Image/redCross.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rh1") ){
                            Image img = ImageIO.read(getClass().getResource("Image/redHeart.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("rab1") && rab1.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("rab2") && rab2.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("rab3") && rab3.direction == "up")){
                            Image img = ImageIO.read(getClass().getResource("Image/redBox.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("rab1") && rab1.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("rab2") && rab2.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("rab3") && rab3.direction == "down")){
                            Image img = ImageIO.read(getClass().getResource("Image/redBox2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                    }
                }
        
            }
            catch(IOException ex){
                JDialog dialog = new JDialog();
                dialog.add(new JLabel("Could not load the image"));
                dialog.pack();
                dialog.setDefaultCloseOperation(theGUI.EXIT_ON_CLOSE);
            }
        }

        private void assignImage_Flip(JButton[][] board, String[][] boardArray) 
        {
            try
            {
                for(int row=0; row<8; row++)
                {
                    for(int col=0; col<5; col++)
                    {
                        if(theBoard.boardArray[row][col].startsWith(" - ")){
                            board[row][col].setIcon(null);
                        }
                        if(theBoard.boardArray[row][col].startsWith("gs1") || theBoard.boardArray[row][col].startsWith("gs2")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenStar2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("gc1") || theBoard.boardArray[row][col].startsWith("gc2")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenCross.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("gh1")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenHeart2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("gab1") && gab1.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("gab2") && gab2.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("gab3") && gab3.direction == "up")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenBox2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("gab1") && gab1.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("gab2") && gab2.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("gab3") && gab3.direction == "down")){
                            Image img = ImageIO.read(getClass().getResource("Image/greenBox.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rs1") || theBoard.boardArray[row][col].startsWith("rs2")){
                            Image img = ImageIO.read(getClass().getResource("Image/redStar2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rc1") || theBoard.boardArray[row][col].startsWith("rc2")){
                            Image img = ImageIO.read(getClass().getResource("Image/redCross.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if(theBoard.boardArray[row][col].startsWith("rh1") ){
                            Image img = ImageIO.read(getClass().getResource("Image/redHeart2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("rab1") && rab1.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("rab2") && rab2.direction == "up") || 
                            (theBoard.boardArray[row][col].startsWith("rab3") && rab3.direction == "up")){
                            Image img = ImageIO.read(getClass().getResource("Image/redBox2.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                        if((theBoard.boardArray[row][col].startsWith("rab1") && rab1.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("rab2") && rab2.direction == "down") || 
                            (theBoard.boardArray[row][col].startsWith("rab3") && rab3.direction == "down")){
                            Image img = ImageIO.read(getClass().getResource("Image/redBox.png"));
                            Image newimg = img.getScaledInstance( 50, 50,Image.SCALE_SMOOTH ) ;
                            board[row][col].setIcon(new ImageIcon(newimg));
                        }
                    }
                }     
            }
            catch(IOException ex)
            {
                JDialog dialog = new JDialog();
                dialog.add(new JLabel("Could not load the image"));
                dialog.pack();
                dialog.setDefaultCloseOperation(theGUI.EXIT_ON_CLOSE);
            }
        }

        public void resetImage(JButton[][] board)
        {    
            for(int row=0; row<8; row++){
                for(int col=0; col<5; col++){
                    board[row][col].setIcon(null);   
                    }
            }
        }    

        public void checkWinner(int winner)
        {
            for (int i=0;i<=7 ;i++)
            {
                for (int j=0;j<=4 ;j++)
                {
                    if (theBoard.boardArray[i][j].equals("rh1"))
                        redHeartExists=1;
                    if (theBoard.boardArray[i][j].equals("gh1"))
                        greenHeartExists=1;
                }
            }
                    
            //TO CHECK WINNER
            if (redHeartExists==0)
            {
                //PRINT GREEN PLAYER WINS
                restoreShowMove();
                resetImage(theGUI.board);
                assignImage_Flip(theGUI.board, theBoard.boardArray);
                JOptionPane.showMessageDialog(null, "Green Player Wins the Game!");
                System.exit(0);
            }  
            else if (greenHeartExists==0)
            {
                //PRINT RED PLAYER WINS
                restoreShowMove();
                resetImage(theGUI.board);
                assignImage(theGUI.board, theBoard.boardArray);
                JOptionPane.showMessageDialog(null, "Red Player Wins the Game!");
                System.exit(0);      
                     
            }
            else{
                greenHeartExists=0;
                redHeartExists=0;
            }             
        }
}    