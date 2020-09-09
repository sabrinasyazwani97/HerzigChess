//This class uses Factory Design Pattern. It creates objects without specifying
//what specifying the class of each objects
public class PieceFactory 
{  
    public static Piece getPiece(String type, int x, int y, String direction){
        if("Arrowbox".equalsIgnoreCase(type)) 
            return new Arrowbox(x, y, direction);
        else if ("Star".equalsIgnoreCase(type)) 
            return new Star(x, y);
        else if ("Heart".equalsIgnoreCase(type)) 
            return new Heart(x, y);
        else if ("Cross".equalsIgnoreCase(type)) 
            return new Cross(x, y);    
            
        return null;
    }
}