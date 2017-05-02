package business;

import business.facades.OrderFacade;
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
                    
                    OrderFacade.createOrder(3, 7, dateSql, false, 0.00); //hard code the idSalesRep and price
                    
                    int orderId = OrderFacade.getOrderId(3, dateSql);
                    System.out.println("order id: " + orderId);
    }
}
