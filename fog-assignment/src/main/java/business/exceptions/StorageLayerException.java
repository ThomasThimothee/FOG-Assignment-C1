package business.exceptions;

/**
 *
 * @author mathiasjepsen
 */
public class StorageLayerException extends Exception {
    
    public StorageLayerException(String message) {
        super(message);
    }

    public StorageLayerException(Throwable cause) {
        super(cause);
    }

    public StorageLayerException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
