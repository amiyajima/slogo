package exceptions;

public class InvalidInputException extends SLogoException {

    public InvalidInputException (String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
    public InvalidInputException (String message, Throwable cause) {
        super(message, cause);
    }

}
