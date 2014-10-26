package exceptions;

public class UndefinedVariableException extends SLogoException {

    // for serialization
    private static final long serialVersionUID = 1L;

    public UndefinedVariableException (String message, String ... s) {
        super(message, s);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public UndefinedVariableException (Throwable exception) {
        super(exception);
    }

    /**
     * Create an exception based on a caught exception with a different message.
     */
    public UndefinedVariableException (String message, Throwable cause) {
        super(message, cause);
    }
}
