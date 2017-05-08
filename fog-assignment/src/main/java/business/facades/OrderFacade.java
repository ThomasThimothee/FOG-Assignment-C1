package business.facades;

import business.Partlist;
import business.parts.Part;
import data.DataMapper;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {

    public static void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType,  int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, Boolean status, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrder(customerId, salesRepId, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
        } catch (SQLException | NullPointerException e) {
            
        }
    }

    public static int getOrderId(int customerId, Timestamp date) {
        int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveOrderId(customerId, date);
        } catch (SQLException | NullPointerException e) {

        }
        return id;
    }

    public static void createOrderLines(Partlist partlist, int orderId) {
        try {
            int i= 0;
            Iterator partIterator = partlist.getPartList().iterator();
            while (partIterator.hasNext()) {
                Part part = (Part) partIterator.next();
                double standardPrice = getPartPrice(part.getName());
                double finalPrice = part.partPrice(standardPrice);
                createOrderline(part.getName(), orderId, part.getLength(), part.getQuantity(), part.getDescription(), finalPrice);
                i++;
            }
        } catch (NullPointerException e) {
        }
    }

    public static double getPartPrice(String partName) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrievePartPrice(partName);
        } catch (SQLException | NullPointerException e) {
        }
        return price;
    }

    public static void createOrderline(String partName, int idOrder, double length, int quantity, String explanation, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrderline(idOrder, partName, length, quantity, explanation, price);
        } catch (SQLException | NullPointerException e) {
        }
    }

    public static double calculateStandardOrderPrice(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.calculateStandardOrderPrice(orderId);
        } catch (SQLException | NullPointerException e) {
        }
        return price;
    }

    public static void setStandardOrderPrice(int orderId) {
        double totalPrice;
        try {
            DataMapper dm = new DataMapper();
            totalPrice = calculateStandardOrderPrice(orderId);
            dm.setStandardPrice(totalPrice, orderId);
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static double getStandardOrderPrice(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrieveStandardOrderPrice(orderId);
        } catch (SQLException | NullPointerException e) {
        }
        return price;
    }

    public static void setDiscountRate(double rate, int orderId) {
        try {
            DataMapper dm = new DataMapper();
            dm.setDiscountRate(rate, orderId);
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static double getDiscountRate(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrieveDiscountRate(orderId);
        } catch (SQLException | NullPointerException e) {
        }
        return price;
    }

    public static void updateFinalPrice(int orderId) {
        double standardPrice;
        double discountRate;
        double finalPrice;
        try {
            DataMapper dm = new DataMapper();
            standardPrice = getStandardOrderPrice(orderId);
            discountRate = getDiscountRate(orderId);
            finalPrice = standardPrice * (1 - discountRate);
            dm.setFinalPrice(finalPrice, orderId);
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static double getFinalPrice(int orderId) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrieveFinalPrice(orderId);
        } catch (SQLException | NullPointerException e) {
        }
        return price;
    }
}
