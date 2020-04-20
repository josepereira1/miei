package di.uminho.pt.aa.business;

public class UserExistsException extends Exception {
    public UserExistsException(){
        super();
    }

    public UserExistsException(String msg){
        super(msg);
    }
}
