package exceptions;

public class MissingParametersException extends SLogoException {
    // for serialization
    private static final long serialVersionUID = 1L;

    
    public MissingParametersException (String message, String ... s) {
        super(message, s);
    }
    
    /**
     * Create an exception based on a caught exception.
     */
    public MissingParametersException (Throwable exception) {
        super(exception);
    }


    
    /**
     * Create an exception based on a caught exception with a different message.
     */
    public MissingParametersException (String message, Throwable cause) {
        super(message, cause);
    }
    
}
