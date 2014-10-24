package exceptions;

public class SLogoException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     */
    public SLogoException (String message, String ... s) {
        super(message);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public SLogoException (Throwable exception) {
        super(exception);
    }

    /**
     * Create an exception based on a caught exception with a different message.
     */
    public SLogoException (String message, Throwable cause) {
        super(message, cause);
    }
}
