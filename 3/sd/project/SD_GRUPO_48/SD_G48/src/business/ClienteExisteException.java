package business;

public class ClienteExisteException extends Exception {

    public ClienteExisteException() {
        super();
    }

    public ClienteExisteException(String message) {
        super(message);
    }
}
