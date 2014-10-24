package exceptions;

public class InvalidInputException extends SLogoException {

    public InvalidInputException (String message, String ... s) {
        super(message);
    }
    
    public InvalidInputException (String message, Throwable cause) {
        super(message, cause);
    }

}
