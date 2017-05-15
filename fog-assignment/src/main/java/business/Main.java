package business;

import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.facades.EmployeeFacade;
import business.facades.OrderFacade;
import business.parts.Part;
import business.parts.Part.PartType;
import data.DataMapper;
import presentation.utility.RenderUtils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class Main {


    public static void main(String[] args) throws StorageLayerException {
        try {
            OrderFacade.setDiscountRate(50, 41);
        } catch (InvalidOrderIdException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            OrderFacade.updateFinalPrice(41);
        } catch (InvalidOrderIdException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
         }


}
