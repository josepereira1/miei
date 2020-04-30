package di.uminho.pt.aa.business;

public class FormatExistsException extends Exception {
    public FormatExistsException(){
        super();
    }

    public FormatExistsException(String msg){
        super(msg);
    }
}
