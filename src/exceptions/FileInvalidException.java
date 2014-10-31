package exceptions;

public class FileInvalidException extends SLogoException {

    public FileInvalidException(String message){
        this(message, null);
    }
    
    public FileInvalidException (String message, String[] s) {
        super(message, s);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

}
