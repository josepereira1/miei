package business;

public class ProdutoOcupadoException extends Exception {
    public ProdutoOcupadoException(){
        super();
    }

    public ProdutoOcupadoException(String msg){
        super(msg);
    }
}
