package exceptions;

public class DuplicateLoanException extends Exception {

    public DuplicateLoanException(String message) {
        super(message);
    }
}
