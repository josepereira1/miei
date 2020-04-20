package di.uminho.pt.aa.business;

public class PlatformExistsException extends Exception {
    public PlatformExistsException(){
        super();
    }

    public PlatformExistsException(String msg){
        super(msg);
    }
}
