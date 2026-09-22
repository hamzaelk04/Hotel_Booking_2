package exception;

public class NullUserException extends RuntimeException {
    public NullUserException() {
        super("The User Cannot Be Null.");
    }
}
