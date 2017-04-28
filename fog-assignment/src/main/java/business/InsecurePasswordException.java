/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author mathiasjepsen
 */
public class InsecurePasswordException extends Exception {
    
    public InsecurePasswordException() {
        // TODO Auto-generated constructor stub
    }

    public InsecurePasswordException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InsecurePasswordException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public InsecurePasswordException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    
}
