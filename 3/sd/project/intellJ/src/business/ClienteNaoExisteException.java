package business;

public class ClienteNaoExisteException extends Exception {

    public ClienteNaoExisteException() {
        super();
    }

    public ClienteNaoExisteException(String message) {
        super(message);
    }
}
