package business;

public class ReservaNaoExisteException extends Exception {

    public ReservaNaoExisteException() {
        super();
    }

    public ReservaNaoExisteException(String message) {
        super(message);
    }
}
