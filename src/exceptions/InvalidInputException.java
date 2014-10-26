package exceptions;

/**
 * Exception thrown when the input is not a valid command
 * @author Ethan Chang
 *
 */
public class InvalidInputException extends SLogoException {

    private static final long serialVersionUID = 1L;

    public InvalidInputException (String message, String ... s) {
        super(message, s);
    }
    
    public InvalidInputException (String message, Throwable cause) {
        super(message, cause);
    }

}
