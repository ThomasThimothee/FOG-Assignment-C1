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
        java.util.Date dateJava = new java.util.Date();
                    java.sql.Timestamp dateSql = new Timestamp(dateJava.getTime());
        
        OrderFacade.createOrder(3, 7, dateSql, 630, 690, 240, 270, false, 0);

    }
}
