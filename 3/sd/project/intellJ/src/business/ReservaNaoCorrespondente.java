package business;

public class ReservaNaoCorrespondente extends Exception {

    public ReservaNaoCorrespondente() {
        super();
    }

    public ReservaNaoCorrespondente(String message) {
        super(message);
    }
}
