package business;

import business.facades.CarportFacade;
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
    
    public static void main(String[] args) throws InvalidUsernameOrPasswordException {
       Customer customer = CustomerFacade.getCustomer("testmail@mail", "testmail");
       
        System.out.println("ID = " + CustomerFacade.getCustomerId("testmail@mail", "testmail"));
        System.out.println("name = " + customer.getFirstName());
    }
}
