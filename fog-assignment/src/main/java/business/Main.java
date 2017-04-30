package business;

import business.exceptions.InvalidUsernameOrPasswordException;
import business.facades.CustomerFacade;
import business.parts.Part;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            System.out.println(CustomerFacade.getCustomerId("tom@tom", "87654321"));
        } catch (InvalidUsernameOrPasswordException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
