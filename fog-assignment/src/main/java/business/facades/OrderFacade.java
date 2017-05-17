package business.facades;

import business.Carport;
import business.Order;
import business.Orderline;
import business.Partlist;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import business.parts.Part;
import data.Connector;
import data.OrderMapper;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author thomasthimothee
 * Singleton pattern - saves computing power and uses same instance everywhere.
 */
public class OrderFacade {
    
    private static OrderFacade facade;
    
    public static OrderFacade getFacade() {
        if (facade == null) {
            facade = new OrderFacade();
        }
        return facade;
    }
    
    public static void setFacade(OrderFacade newFacade) {
        facade = newFacade;
    }

    public static void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, Boolean status, double price) throws StorageLayerException {
        Connection con = Connector.getConnection();
        OrderMapper om = new OrderMapper(con);
        om.createOrder(customerId, salesRepId, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
    }

    public int getOrderId(int customerId, Timestamp date) throws StorageLayerException {
        Connection con = Connector.getConnection();
        int id;
        OrderMapper om = new OrderMapper(con);
        id = om.retrieveOrderId(customerId, date);
        return id;
    }

    public void createOrderLines(Partlist partlist, int orderId) throws StorageLayerException {
        for (Part part : partlist.getPartList()) {
            double standardPrice = getPartPrice(part.getName());
            double finalPrice = part.partPrice(standardPrice);
            createOrderline(part.getName(), orderId, part.getLength(), part.getQuantity(), part.getDescription(), finalPrice);
        }
    }

    public double getPartPrice(String partName) throws StorageLayerException {
        Connection con = Connector.getConnection();
        double price;
        OrderMapper om = new OrderMapper(con);
        price = om.retrievePartPrice(partName);
        return price;
    }

    public void createOrderline(String partName, int idOrder, double length, int quantity, String explanation, double price) throws StorageLayerException {
        Connection con = Connector.getConnection();
        OrderMapper om = new OrderMapper(con);
        om.createOrderline(idOrder, partName, length, quantity, explanation, price);
    }

    public double calculateStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        double price;
        OrderMapper om = new OrderMapper(con);
        price = om.calculateStandardOrderPrice(orderId);
        return price;
    }

    public void setStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        double totalPrice;
        OrderMapper om = new OrderMapper(con);
        totalPrice = calculateStandardOrderPrice(orderId);
        om.setStandardPrice(totalPrice, orderId);
    }

    public double getStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        double price;
        OrderMapper om = new OrderMapper(con);
        price = om.retrieveStandardOrderPrice(orderId);
        return price;
    }

    public void setDiscountRate(double rate, int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        OrderMapper om = new OrderMapper(con);
        om.setDiscountRate(rate, orderId);
    }

    public double getDiscountRate(int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        double discountRate;
        OrderMapper om = new OrderMapper(con);
        discountRate = om.retrieveDiscountRate(orderId);
        return discountRate;
    }

    public void updateFinalPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        double standardPrice;
        double discountRate;
        double finalPrice;
        OrderMapper om = new OrderMapper(con);
        standardPrice = getStandardOrderPrice(orderId);
        discountRate = getDiscountRate(orderId) / 100;
        finalPrice = standardPrice * (1 - discountRate);
        finalPrice = finalPrice * 100;
        finalPrice = Math.round(finalPrice);
        finalPrice = finalPrice / 100;
        om.setFinalPrice(finalPrice, orderId);
    }

    public double getFinalPrice(int orderId) throws StorageLayerException {
        Connection con = Connector.getConnection();
        double price;
        OrderMapper om = new OrderMapper(con);
        price = om.retrieveFinalPrice(orderId);
        return price;
    }

    public void updateSatus(int orderId) throws StorageLayerException {
        Connection con = Connector.getConnection();
        OrderMapper om = new OrderMapper(con);
        om.updateStatus(orderId);
    }

    public Carport retrieveCarport(int idOrder) throws StorageLayerException {
        Connection con = Connector.getConnection();
        Carport carport;
        OrderMapper om = new OrderMapper(con);
        carport = om.retrieveCarport(idOrder);
        return carport;
    }

    public ArrayList<Order> retrieveAllOrder() throws StorageLayerException {
        Connection con = Connector.getConnection();
        ArrayList<Order> order;
        OrderMapper om = new OrderMapper(con);
        order = om.retrieveAllOrders();
        return order;
    }
    public ArrayList<Orderline> retrievePartlist(int idOrder) throws WrongCustomerIDException, StorageLayerException {
        Connection con = Connector.getConnection();
        ArrayList<Orderline> list;
        OrderMapper om = new OrderMapper(con);
        list = om.retrievePartlist(idOrder);  
        return list;
    }
    public ArrayList<Order> retrieveCustomerOrders(int id_customer) throws StorageLayerException {
        Connection con = Connector.getConnection();
        ArrayList<Order> list;
        OrderMapper om = new OrderMapper(con);
        list = om.retrieveCustomerOrders(id_customer);
        return list;
    }

    public Order retrieveOrder(int idOrder) throws InvalidOrderIdException, StorageLayerException {
        Connection con = Connector.getConnection();
        Order order;
        OrderMapper om = new OrderMapper(con);
        order = om.retrieveOrder(idOrder);    
        return order;
    }

}
