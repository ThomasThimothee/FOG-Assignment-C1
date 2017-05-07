package business;

import business.facades.OrderFacade;
import business.parts.Part;
import business.parts.Part.PartType;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class Main {

    public static void main(String[] args) {

        double priceB = OrderFacade.getStandardOrderPrice(17);
        System.out.println("Standard price of the order 17 = "+priceB);        
        
    }
}
