package exceptions;

public class InvalidPropertyFileException extends SLogoException {

    /**
     * Exception thrown when an invalid property file is added
     */
    private static final long serialVersionUID = 1L;

    public InvalidPropertyFileException (String message, String[] s) {
        super(message, s);
    }
    
    public InvalidPropertyFileException (String message) {
        super(message);
    }


}
