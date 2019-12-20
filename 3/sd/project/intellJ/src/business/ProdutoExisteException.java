package business;

public class ProdutoExisteException extends Exception {

    public ProdutoExisteException() {
    }

    public ProdutoExisteException(String message) {
        super(message);
    }
}
