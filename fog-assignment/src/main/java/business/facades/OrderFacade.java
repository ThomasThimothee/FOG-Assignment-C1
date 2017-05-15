package business.facades;

import business.Carport;
import business.Order;
import business.Orderline;
import business.Partlist;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import business.parts.Part;
import data.DataMapper;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {

    public static void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, Boolean status, double price) throws StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.createOrder(customerId, salesRepId, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
    }

    public static int getOrderId(int customerId, Timestamp date) throws StorageLayerException {
        int id;
        DataMapper dm = new DataMapper();
        id = dm.retrieveOrderId(customerId, date);
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
        DataMapper dm = new DataMapper();
        price = dm.retrievePartPrice(partName);
        return price;
    }

    public static void createOrderline(String partName, int idOrder, double length, int quantity, String explanation, double price) throws StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.createOrderline(idOrder, partName, length, quantity, explanation, price);
    }

    public static double calculateStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double price = 0;
        DataMapper dm = new DataMapper();
        price = dm.calculateStandardOrderPrice(orderId);
        return price;
    }

    public static void setStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double totalPrice;
        DataMapper dm = new DataMapper();
        totalPrice = calculateStandardOrderPrice(orderId);
        dm.setStandardPrice(totalPrice, orderId);
    }

    public static double getStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double price = 0;
        DataMapper dm = new DataMapper();
        price = dm.retrieveStandardOrderPrice(orderId);
        return price;
    }

    public static void setDiscountRate(double rate, int orderId) throws InvalidOrderIdException {
        DataMapper dm = new DataMapper();
        dm.setDiscountRate(rate, orderId);
    }

    public static double getDiscountRate(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double discountRate = 0;
        DataMapper dm = new DataMapper();
        discountRate = dm.retrieveDiscountRate(orderId);
        return discountRate;
    }

    public static void updateFinalPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        double standardPrice;
        double discountRate;
        double finalPrice;
        DataMapper dm = new DataMapper();
        standardPrice = getStandardOrderPrice(orderId);
        discountRate = getDiscountRate(orderId) / 100;
        finalPrice = standardPrice * (1 - discountRate);
        finalPrice = finalPrice * 100;
        finalPrice = Math.round(finalPrice);
        finalPrice = finalPrice / 100;
        dm.setFinalPrice(finalPrice, orderId);
    }

    public static double getFinalPrice(int orderId) throws StorageLayerException {
        double price = 0;
        DataMapper dm = new DataMapper();
        price = dm.retrieveFinalPrice(orderId);
        return price;
    }

    public static void updateSatus(int orderId) throws StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.updateStatus(orderId);
    }

    public static Carport retrieveCarport(int idOrder) throws StorageLayerException {
        Carport carport = null;
        DataMapper dm = new DataMapper();
        carport = dm.retrieveCarport(idOrder);
        return carport;
    }

    public static ArrayList<Order> retrieveAllOrder() throws StorageLayerException {
        ArrayList<Order> order = new ArrayList<>();
        DataMapper dm = new DataMapper();
        order = dm.retrieveAllOrders();
        return order;
    }
    public static ArrayList<Orderline> retrievePartlist(int idOrder) throws WrongCustomerIDException {
        ArrayList<Orderline> list;
        DataMapper dm = new DataMapper();
        list = dm.retrievePartlist(idOrder);  
        return list;
    }
    public static ArrayList<Order> retrieveCustomerOrders(int id_customer) throws StorageLayerException {
        ArrayList<Order> list = new ArrayList<>();
        DataMapper dm = new DataMapper();
        list = dm.retrieveCustomerOrders(id_customer);
        return list;
    }

    public static Order retrieveOrder(int idOrder) throws InvalidOrderIdException, StorageLayerException {
        Order order = new Order();
        DataMapper dm = new DataMapper();
        order = dm.retrieveOrder(idOrder);    
        return order;
    }

}
