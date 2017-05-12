package business;

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

/**
 *
 * @author mathiasjepsen
 */
public class Main {


    public static void main(String[] args) throws StorageLayerException {
           ArrayList<Order> orderList = OrderFacade.retrieveCustomerOrders(1);
           for( Order order : orderList){
               System.out.println("user id " + order.getCustomerId());
               System.out.println("order id " + order.getOrderId());
               if (order.getFlat() != null){
                   System.out.println("this carport is a flat one");
                   System.out.println("carport type " + order.getFlat().getType());
                   System.out.println("roof type " + order.getFlat().getRoofType());
                   System.out.println("carportWidth " + order.getFlat().getCarportWidth());
                   System.out.println("carportLength " + order.getFlat().getCarportLength());
                   System.out.println("shedWidth " + order.getFlat().getShedWidth());
                   System.out.println("shedLength " + order.getFlat().getShedLength());
                   System.out.println("roofHeight " + order.getFlat().getRoofHeight());    
               }
               else if (order.getPointy() != null){
                   System.out.println("this carport is a flat one");
                   System.out.println("carport type " + order.getPointy().getType());
                   System.out.println("roof type " + order.getPointy().getRoofType());
                   System.out.println("carportWidth " + order.getPointy().getCarportWidth());
                   System.out.println("carportLength " + order.getPointy().getCarportLength());
                   System.out.println("shedWidth " + order.getPointy().getShedWidth());
                   System.out.println("shedLength " + order.getPointy().getShedLength());
                   System.out.println("roofHeight " + order.getPointy().getRoofHeight());   
                   System.out.println("angle " + order.getPointy().getAngle());
                   
               }
               
               
           }
         }


}
