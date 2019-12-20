package business;

public class ProdutoNaoExisteException extends Exception{

    /**
     * Construtor vazio.
     */
    public ProdutoNaoExisteException(){
        super();
    }

    /**
     * Construtor vazio.
     * @param msg mensagem da exception.
     */
    public ProdutoNaoExisteException(String msg){
        super(msg);
    }
}
