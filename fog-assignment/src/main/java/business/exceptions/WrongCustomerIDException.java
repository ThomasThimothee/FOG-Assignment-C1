/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.exceptions;

/**
 *
 * @author Lovro
 */
public class WrongCustomerIDException extends Exception {
    public WrongCustomerIDException() {
        
    }
    public WrongCustomerIDException(String message) {
        super(message);
    }

    public WrongCustomerIDException(Throwable cause) {
        super(cause);
    }

    public WrongCustomerIDException(String message, Throwable cause) {
        super(message, cause);
    }
}
