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
       Part newpart = new Part (PartType.SCREW, 2, 150.00, "t-hngsel", "to test" );
       double priceA = OrderFacade.getPartPrice(newpart.getName());
        System.out.println("standard price of the part :" + priceA);
        double priceB = newpart.partPrice(priceA);
        System.out.println("price of the orderline = "+priceB);        
        
    }
}
