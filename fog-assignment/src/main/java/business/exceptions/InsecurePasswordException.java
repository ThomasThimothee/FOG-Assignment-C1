package business.exceptions;

/**
 *
 * @author mathiasjepsen
 */
public class InsecurePasswordException extends Exception {
    
    public InsecurePasswordException() {
        
    }

    public InsecurePasswordException(String message) {
        super(message);
    }

    public InsecurePasswordException(Throwable cause) {
        super(cause);
    }

    public InsecurePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
