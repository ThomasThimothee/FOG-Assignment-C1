package business;


import business.facades.OrderFacade;
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
    
    public static void main(String[] args) throws InvalidUsernameOrPasswordException {
       int i = OrderFacade.getOrderId(1 ,7);
        System.out.println("order id: "+ i);
    }
}
