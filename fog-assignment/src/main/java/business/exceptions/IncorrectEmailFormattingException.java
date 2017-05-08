package business.exceptions;

/**
 *
 * @author mathiasjepsen
 */
public class IncorrectEmailFormattingException extends Exception {
        
    public IncorrectEmailFormattingException() {
        
    }

    public IncorrectEmailFormattingException(String message) {
        super(message);
    }

    public IncorrectEmailFormattingException(Throwable cause) {
        super(cause);
    }

    public IncorrectEmailFormattingException(String message, Throwable cause) {
        super(message, cause);
    }
}
