package business;

public class LeilaoNaoExisteException extends Exception {

    public LeilaoNaoExisteException(){
        super();
    }

    public LeilaoNaoExisteException(String msg){
        super(msg);
    }
}
