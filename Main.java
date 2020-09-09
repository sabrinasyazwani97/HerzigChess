public class Main
{
    public static void main(String[]args)
    {
        Piece rab1 = PieceFactory.getPiece("Arrowbox",1,6,"up");
        Piece rab2 = PieceFactory.getPiece("Arrowbox",2,6,"up");
        Piece rab3 = PieceFactory.getPiece("Arrowbox",3,6,"up");
        Piece rs1 = PieceFactory.getPiece("Star",0,7,"anywhere");
        Piece rs2 = PieceFactory.getPiece("Star",4,7,"anywhere");
        Piece rc1 = PieceFactory.getPiece("Cross",1,7,"anywhere");
        Piece rc2 = PieceFactory.getPiece("Cross",3,7,"anywhere");
        Piece rh1 = PieceFactory.getPiece("Heart",2,7,"anywhere");
        
        Piece gab1 = PieceFactory.getPiece("Arrowbox",1,1,"up");
        Piece gab2 = PieceFactory.getPiece("Arrowbox",2,1,"up");
        Piece gab3 = PieceFactory.getPiece("Arrowbox",3,1,"up");
        Piece gs1 = PieceFactory.getPiece("Star",0,0,"anywhere");
        Piece gs2 = PieceFactory.getPiece("Star",4,0,"anywhere");
        Piece gc1 = PieceFactory.getPiece("Cross",1,0,"anywhere");
        Piece gc2 = PieceFactory.getPiece("Cross",3,0,"anywhere");
        Piece gh1 = PieceFactory.getPiece("Heart",2,0,"anywhere");
        
        GUI theGUI = new GUI();
        Board chessBoard = new Board(rab1,rab2,rab3,rs1,rs2,rc1,rc2,rh1,gab1,gab2,gab3,gs1,gs2,gc1,gc2,gh1);

        Controller theController = new Controller(theGUI, chessBoard, rab1,rab2,rab3,rs1,rs2,rc1,rc2,rh1,gab1,gab2,gab3,gs1,gs2,gc1,gc2,gh1);
    }
}
