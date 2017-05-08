package business.exceptions;

/**
 *
 * @author mathiasjepsen
 */
public class InvalidUsernameOrPasswordException extends Exception {

    public InvalidUsernameOrPasswordException() {
        
    }

    public InvalidUsernameOrPasswordException(String message) {
        super(message);
    }

    public InvalidUsernameOrPasswordException(Throwable cause) {
        super(cause);
    }

    public InvalidUsernameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

}
    

