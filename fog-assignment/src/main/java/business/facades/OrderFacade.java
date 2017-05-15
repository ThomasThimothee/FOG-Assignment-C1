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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {

    public static void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, Boolean status, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrder(customerId, salesRepId, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
        } catch (StorageLayerException e) {

        }
    }

    public static int getOrderId(int customerId, Timestamp date) {
        int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveOrderId(customerId, date);
        } catch (StorageLayerException e) {

        }
        return id;
    }

    public static void createOrderLines(Partlist partlist, int orderId) {
        try {
            Iterator partIterator = partlist.getPartList().iterator();
            while (partIterator.hasNext()) {
                Part part = (Part) partIterator.next();
                double standardPrice = getPartPrice(part.getName());
                double finalPrice = part.partPrice(standardPrice);
                createOrderline(part.getName(), orderId, part.getLength(), part.getQuantity(), part.getDescription(), finalPrice);
            }
        } catch (NullPointerException e) {
        }
    }

    public static double getPartPrice(String partName) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrievePartPrice(partName);
        } catch (StorageLayerException e) {
        }
        return price;
    }

    public static void createOrderline(String partName, int idOrder, double length, int quantity, String explanation, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrderline(idOrder, partName, length, quantity, explanation, price);
        } catch (StorageLayerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculateStandardOrderPrice(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.calculateStandardOrderPrice(orderId);
        } catch (StorageLayerException e) {
        }
        return price;
    }

    public static void setStandardOrderPrice(int orderId) {
        double totalPrice;
        try {
            DataMapper dm = new DataMapper();
            totalPrice = calculateStandardOrderPrice(orderId);
            dm.setStandardPrice(totalPrice, orderId);
        } catch (StorageLayerException ex) {
        }
    }

    public static double getStandardOrderPrice(int orderId) throws InvalidOrderIdException {
        double price = 0;
        DataMapper dm = new DataMapper();
        price = dm.retrieveStandardOrderPrice(orderId);
        return price;
    }

    public static void setDiscountRate(double rate, int orderId) throws InvalidOrderIdException {
        DataMapper dm = new DataMapper();
        dm.setDiscountRate(rate, orderId);
    }

    public static double getDiscountRate(int orderId) {
        double discountRate = 0;
        try {
            DataMapper dm = new DataMapper();
            discountRate = dm.retrieveDiscountRate(orderId);
        } catch (StorageLayerException e) {
        }
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

    public static double getFinalPrice(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrieveFinalPrice(orderId);
        } catch (StorageLayerException e) {
        }
        return price;
    }

    public static void updateSatus(int orderId) {
        try {
            DataMapper dm = new DataMapper();
            dm.updateStatus(orderId);
        } catch (StorageLayerException ex) {
        }
    }

    public static Carport retrieveCarport(int idOrder) {
        Carport carport = null;
        try {
            DataMapper dm = new DataMapper();
            carport = dm.retrieveCarport(idOrder);
        } catch (StorageLayerException e) {
        }
        return carport;
    }

    public static ArrayList<Order> retrieveAllOrder() {
        ArrayList<Order> order = new ArrayList<>();
        try {
            DataMapper dm = new DataMapper();
            order = dm.retrieveAllOrders();
        } catch (StorageLayerException e) {

        }
        return order;
    }
    public static ArrayList<Orderline> retrievePartlist(int idOrder) throws WrongCustomerIDException {
        ArrayList<Orderline> list;
        DataMapper dm = new DataMapper();
        list = dm.retrievePartlist(idOrder);  
        return list;
    }
    public static ArrayList<Order> retrieveCustomerOrders(int id_customer) {
        ArrayList<Order> list = new ArrayList<>();
        try {
            DataMapper dm = new DataMapper();
            list = dm.retrieveCustomerOrders(id_customer);
        } catch (StorageLayerException e) {

        }
        return list;
    }

    public static Order retrieveOrder(int idOrder) throws InvalidOrderIdException {
        Order order = new Order();
        DataMapper dm = new DataMapper();
        order = dm.retrieveOrder(idOrder);    
        return order;
    }

}
