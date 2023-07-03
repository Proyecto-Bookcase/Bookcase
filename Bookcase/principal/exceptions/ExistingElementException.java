package exceptions;

public class ExistingElementException extends RuntimeException {

    public ExistingElementException() {
        super();
    }

    public ExistingElementException(String message) {
        super(message);
    }

    public ExistingElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingElementException(Throwable cause) {
        super(cause);
    }
}

