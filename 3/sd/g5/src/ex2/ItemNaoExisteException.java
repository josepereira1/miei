package ex2;

public class ItemNaoExisteException extends Exception{

    public ItemNaoExisteException(){
        super();
    }

    public ItemNaoExisteException(String msg){
        super(msg);
    }
}
