package business.exceptions;

/**
 *
 * @author mathiasjepsen
 */
public class EmailAlreadyInUseException extends Exception {
    
    public EmailAlreadyInUseException() {
        
    }

    public EmailAlreadyInUseException(String message) {
        super(message);
    }

    public EmailAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    public EmailAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
