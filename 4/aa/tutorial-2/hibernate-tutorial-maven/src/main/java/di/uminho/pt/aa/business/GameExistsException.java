package di.uminho.pt.aa.business;

public class GameExistsException extends Exception {
    public GameExistsException(){
        super();
    }

    public GameExistsException(String msg){
        super(msg);
    }
}
