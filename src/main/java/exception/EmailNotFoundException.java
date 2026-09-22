package exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super ("Email Not Found!");
    }
}