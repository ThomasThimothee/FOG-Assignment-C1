package business.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomasthimothee
 */
public class InvalidOrderIdException extends Exception {
    
    public InvalidOrderIdException() {
        
    }

    public InvalidOrderIdException(String message) {
        super(message);
    }

    public InvalidOrderIdException(Throwable cause) {
        super(cause);
    }

    public InvalidOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }

}
