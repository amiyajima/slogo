package exceptions;

public class ExcessParametersException extends SLogoException {
    // for serialization
    private static final long serialVersionUID = 1L;
    private static String MESSAGE = "excess parameters";

    /**
     * Create an exception based on an issue in our code.
     */
    public ExcessParametersException () {
        super(MESSAGE);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public ExcessParametersException (Throwable exception) {
        super(exception);
    }

    /**
     * Create an exception based on a caught exception with a different message.
     */
    public ExcessParametersException (String message, Throwable cause) {
        super(message, cause);
    }
}
