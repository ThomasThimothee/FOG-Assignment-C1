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
        
        double standardPrice = OrderFacade.calculateStandardOrderPrice(15);
        System.out.println("Calculated Standard price of the order 15 = "+standardPrice);  
        OrderFacade.setStandardOrderPrice(15);
        double newStan = OrderFacade.getStandardOrderPrice(15);
        System.out.println("Standard price of the order 15 = "+newStan);  
        OrderFacade.setDiscountRate(0.1, 15);
        double rate = OrderFacade.getDiscountRate(15);
        System.out.println("rate of the order 15 = " + rate); 
        OrderFacade.updateFinalPrice(15);
        double finalprice = OrderFacade.getFinalPrice(15);
        System.out.println("final Price is: " + finalprice);

    }
}
