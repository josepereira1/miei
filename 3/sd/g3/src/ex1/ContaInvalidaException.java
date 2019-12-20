package ex1;

public class ContaInvalidaException extends Exception {
    public ContaInvalidaException(String msg){
        super(msg);
    }
    public ContaInvalidaException(){
        super();
    }
}
