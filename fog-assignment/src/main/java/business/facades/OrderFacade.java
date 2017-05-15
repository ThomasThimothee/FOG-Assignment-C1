package business.facades;

import business.Carport;
import business.Order;
import business.Orderline;
import business.Partlist;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import business.parts.Part;
import data.OrderMapper;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {

    public static void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, Boolean status, double price) throws StorageLayerException {
        OrderMapper om = new OrderMapper();
        om.createOrder(customerId, salesRepId, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
    }

    public static int getOrderId(int customerId, Timestamp date) throws StorageLayerException {
        int id;
        OrderMapper om = new OrderMapper();
        id = om.retrieveOrderId(customerId, date);
        return id;
    }

    public static void createOrderLines(Partlist partlist, int orderId) throws StorageLayerException {
        for (Part part : partlist.getPartList()) {
            double standardPrice = getPartPrice(part.getName());
            double finalPrice = part.partPrice(standardPrice);
            createOrderline(part.getName(), orderId, part.getLength(), part.getQuantity(), part.getDescription(), finalPrice);
        }
    }

    public static double getPartPrice(String partName) throws StorageLayerException {
        double price;
        OrderMapper om = new OrderMapper();
        price = om.retrievePartPrice(partName);
        return price;
    }

    public static void createOrderline(String partName, int idOrder, double length, int quantity, String explanation, double price) throws StorageLayerException {
        OrderMapper om = new OrderMapper();
        om.createOrderline(idOrder, partName, length, quantity, explanation, price);
    }

    public static double calculateStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double price;
        OrderMapper om = new OrderMapper();
        price = om.calculateStandardOrderPrice(orderId);
        return price;
    }

    public static void setStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double totalPrice;
        OrderMapper om = new OrderMapper();
        totalPrice = calculateStandardOrderPrice(orderId);
        om.setStandardPrice(totalPrice, orderId);
    }

    public static double getStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double price;
        OrderMapper om = new OrderMapper();
        price = om.retrieveStandardOrderPrice(orderId);
        return price;
    }

    public static void setDiscountRate(double rate, int orderId) throws InvalidOrderIdException, StorageLayerException {
        OrderMapper om = new OrderMapper();
        om.setDiscountRate(rate, orderId);
    }

    public static double getDiscountRate(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double discountRate;
        OrderMapper om = new OrderMapper();
        discountRate = om.retrieveDiscountRate(orderId);
        return discountRate;
    }

    public static void updateFinalPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double standardPrice;
        double discountRate;
        double finalPrice;
        OrderMapper om = new OrderMapper();
        standardPrice = getStandardOrderPrice(orderId);
        discountRate = getDiscountRate(orderId) / 100;
        finalPrice = standardPrice * (1 - discountRate);
        finalPrice = finalPrice * 100;
        finalPrice = Math.round(finalPrice);
        finalPrice = finalPrice / 100;
        om.setFinalPrice(finalPrice, orderId);
    }

    public static double getFinalPrice(int orderId) throws StorageLayerException {
        double price;
        OrderMapper om = new OrderMapper();
        price = om.retrieveFinalPrice(orderId);
        return price;
    }

    public static void updateSatus(int orderId) throws StorageLayerException {
        OrderMapper om = new OrderMapper();
        om.updateStatus(orderId);
    }

    public static Carport retrieveCarport(int idOrder) throws StorageLayerException {
        Carport carport;
        OrderMapper om = new OrderMapper();
        carport = om.retrieveCarport(idOrder);
        return carport;
    }

    public static ArrayList<Order> retrieveAllOrder() throws StorageLayerException {
        ArrayList<Order> order;
        OrderMapper om = new OrderMapper();
        order = om.retrieveAllOrders();
        return order;
    }
    public static ArrayList<Orderline> retrievePartlist(int idOrder) throws WrongCustomerIDException {
        ArrayList<Orderline> list;
        OrderMapper om = new OrderMapper();
        list = om.retrievePartlist(idOrder);  
        return list;
    }
    public static ArrayList<Order> retrieveCustomerOrders(int id_customer) throws StorageLayerException {
        ArrayList<Order> list;
        OrderMapper om = new OrderMapper();
        list = om.retrieveCustomerOrders(id_customer);
        return list;
    }

    public static Order retrieveOrder(int idOrder) throws InvalidOrderIdException, StorageLayerException {
        Order order;
        OrderMapper om = new OrderMapper();
        order = om.retrieveOrder(idOrder);    
        return order;
    }

}
