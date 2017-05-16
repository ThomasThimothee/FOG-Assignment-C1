package business;

import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.facades.OrderFacade;
import data.Connector;
import data.CustomerMapper;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class Main {


    public static void main(String[] args) throws StorageLayerException {
//        try {
//            OrderFacade.setDiscountRate(50, 41);
//        } catch (InvalidOrderIdException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            OrderFacade.updateFinalPrice(41);
//        } catch (InvalidOrderIdException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//           
    }

}
