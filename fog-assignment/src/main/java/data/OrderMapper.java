package data;

import business.Carport;
import business.Flat;
import business.Order;
import business.Orderline;
import business.Pointy;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 This is one of our mapper classes. We execute SQL queries and based on that we either get the data or we input the data into the database
 * Order Facade creates objects out of this class
 * 
 */
public class OrderMapper {
    
    Connection con;

    /**
     *
     * @param con
     */
    public OrderMapper(Connection con) {
        this.con = con;
    }
/**
 * This mapper method creates an order with specified attributes which are given out by the user input
 * @param customerId id of the customer
 * @param salesRepId id of the employee
 * @param date date of the order creation
 * @param carportType type of the carport(pointy or flat)
 * @param roofType type of the roof
 * @param carportWidth width of the carport
 * @param carportLength length of the carport 
 * @param shedWidth width of the shed
 * @param shedLength length of the shed
 * @param angle angle of the roof
 * @param status is the order paid or not
 * @param price the amount that is needed to pay
 * @throws StorageLayerException 
 */
    public void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, boolean status, double price) throws StorageLayerException {
        String createOrderString = "INSERT INTO `Order` (`idCustomer`, `idSalesRep`, `date`, `carportType`, `roofType`, `carportWidth`, `carportLength`, `shedWidth`, `shedLength`, `angle`, `status`, `standardPrice`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        try (final PreparedStatement createOrder = con.prepareStatement(createOrderString)) {
            con.setAutoCommit(false);
            createOrder.setInt(1, customerId);
            createOrder.setInt(2, salesRepId);
            createOrder.setTimestamp(3, date);
            createOrder.setString(4, carportType);
            createOrder.setString(5, roofType);
            createOrder.setInt(6, carportWidth);
            createOrder.setInt(7, carportLength);
            createOrder.setInt(8, shedWidth);
            createOrder.setInt(9, shedLength);
            createOrder.setDouble(10, angle);
            createOrder.setBoolean(11, status);
            createOrder.setDouble(12, price);
            int rowAffected = createOrder.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param standardPrice
     * @param orderId
     * @throws StorageLayerException
     */
    public void setStandardPrice(double standardPrice, int orderId) throws StorageLayerException {
        String setStandardPriceString = "UPDATE fog.Order SET standardPrice = ? WHERE idOrder= ?;";
        try (final PreparedStatement setStandardPrice = con.prepareStatement(setStandardPriceString)) {
            con.setAutoCommit(false);
            setStandardPrice.setDouble(1, standardPrice);
            setStandardPrice.setInt(2, orderId);
            int rowAffected = setStandardPrice.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }
/**
 * This method selects all the necessary attributes about the carport from the database and returns an instance of the Carport class with the given attributes based on the order ID.
 * @param idOrder Order ID
 * @return carport
 * @throws StorageLayerException 
 */
    public Carport retrieveCarport(int idOrder) throws StorageLayerException {
        String getOrderlineString = "SELECT (carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, roofHeight) FROM fog.Order where idOrder = ?;";
        try (final PreparedStatement getOrderline = con.prepareStatement(getOrderlineString)) {
            Carport carport = null;
            try (final ResultSet rs = getOrderline.executeQuery()) {
                if (rs.next()) {
                    if (rs.getString(1).equals("Flat")) {
                        carport = new Flat(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
                    } else {
                        carport = new Pointy(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8));
                    }
                }
                return carport;
            }
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param orderId
     * @throws StorageLayerException
     */
    public void updateStatus(int orderId) throws StorageLayerException {
        String updateStatusString = "UPDATE fog.Order SET status = TRUE WHERE idOrder = ?;";
        try (final PreparedStatement updateStatus = con.prepareStatement(updateStatusString)) {
            con.setAutoCommit(false);
            updateStatus.setInt(1, orderId);
            int rowAffected = updateStatus.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param partName
     * @return double
     * @throws StorageLayerException
     */
    public double retrievePartPrice(String partName) throws StorageLayerException {
        String getPriceString = "SELECT standardPrice FROM Part WHERE name = ? ;";
        try (final PreparedStatement getPrice = con.prepareStatement(getPriceString)) {
            double price = 0;
            getPrice.setString(1, partName);
            try (final ResultSet rs = getPrice.executeQuery()) {
                if (rs.next()) {
                    price = rs.getDouble(1);
                }
            }
            return price;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param rate
     * @param orderId
     * @throws InvalidOrderIdException
     * @throws StorageLayerException
     */
    public void setDiscountRate(double rate, int orderId) throws InvalidOrderIdException, StorageLayerException {
        String setDiscountRateString = "UPDATE fog.Order SET discount = ? WHERE idOrder= ?;";
        try (final PreparedStatement setDiscountRate = con.prepareStatement(setDiscountRateString)) {
            con.setAutoCommit(false);
            setDiscountRate.setDouble(1, rate);
            setDiscountRate.setInt(2, orderId);
            int rowAffected = setDiscountRate.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param finalPrice
     * @param orderId
     * @throws StorageLayerException
     */
    public void setFinalPrice(double finalPrice, int orderId) throws StorageLayerException {
        String setFinalPriceString = "UPDATE fog.Order SET finalPrice = ? WHERE idOrder= ?;";
        try (final PreparedStatement setFinalPrice = con.prepareStatement(setFinalPriceString)) {
            con.setAutoCommit(false);
            setFinalPrice.setDouble(1, finalPrice);
            setFinalPrice.setInt(2, orderId);
            int rowAffected = setFinalPrice.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param idOrder
     * @return Order
     * @throws InvalidOrderIdException
     * @throws StorageLayerException
     */
    public Order retrieveOrder(int idOrder) throws InvalidOrderIdException, StorageLayerException {
        String getCustomerOrdersString = "SELECT * FROM `Order` where idOrder = ?;";
        try (final PreparedStatement getCustomerOrders = con.prepareStatement(getCustomerOrdersString)) {
            Order order = null;
            getCustomerOrders.setInt(1, idOrder);
            try (final ResultSet rs = getCustomerOrders.executeQuery()) {
                if (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        pointy.createPartList();
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11));
                        flat.createPartList();
                        order.setFlat(flat);
                    }
                    order.setStatus(rs.getBoolean(13));
                    order.setDiscount(rs.getDouble(14));
                    order.setStandardPrice(rs.getDouble(15));
                    order.setFinalPrice(rs.getDouble(16));
                }
            }
            if (order == null) {
                throw new InvalidOrderIdException();
            }
            return order;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param orderId
     * @return double
     * @throws StorageLayerException
     */
    public double retrieveFinalPrice(int orderId) throws StorageLayerException {
        String getFinalPriceString = "SELECT finalPrice from fog.Order WHERE idOrder = ? ;";
        try (final PreparedStatement getFinalPrice = con.prepareStatement(getFinalPriceString)) {
            double finalPrice = 0;
            getFinalPrice.setInt(1, orderId);
            try (final ResultSet rs = getFinalPrice.executeQuery()) {
                if (rs.next()) {
                    finalPrice = rs.getDouble(1);
                }
                return finalPrice;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param orderId
     * @return double
     * @throws InvalidOrderIdException
     * @throws StorageLayerException
     */
    public double retrieveDiscountRate(int orderId) throws InvalidOrderIdException, StorageLayerException {
        String getDiscountRateString = "SELECT discount FROM fog.Order WHERE idOrder = ? ;";
        try (final PreparedStatement getDiscountRate = con.prepareStatement(getDiscountRateString)) {
            double discountRate = 0;
            getDiscountRate.setInt(1, orderId);
            try (final ResultSet rs = getDiscountRate.executeQuery()) {
                if (rs.next()) {
                    discountRate = rs.getDouble(1);
                }
            }
            return discountRate;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param customerId
     * @param date
     * @return int
     * @throws StorageLayerException
     */
    public int retrieveOrderId(int customerId, Timestamp date) throws StorageLayerException {
        String getOrderIdString = "SELECT idOrder FROM `Order` WHERE idCustomer = ? AND date = ? ;";
        try (final PreparedStatement getOrderId = con.prepareStatement(getOrderIdString)) {
            int id = 0;
            getOrderId.setInt(1, customerId);
            getOrderId.setTimestamp(2, date);
            try (final ResultSet rs = getOrderId.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                return id;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param idOrder
     * @param partName
     * @param length
     * @param quantity
     * @param explanation
     * @param price
     * @throws StorageLayerException
     */
    public void createOrderline(int idOrder, String partName, double length, int quantity, String explanation, double price) throws StorageLayerException {
        String createOrderlineString = "INSERT INTO Orderline(idOrder, partName, length, quantity, explanation, price) VALUES (?,?,?,?,?,?);";
        try (final PreparedStatement createOrderline = con.prepareStatement(createOrderlineString)) {
            con.setAutoCommit(false);
            createOrderline.setInt(1, idOrder);
            createOrderline.setString(2, partName);
            createOrderline.setDouble(3, length);
            createOrderline.setInt(4, quantity);
            createOrderline.setString(5, explanation);
            createOrderline.setDouble(6, price);
            int rowAffected = createOrderline.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param idOrder
     * @return ArrayList<Orderline>
     * @throws WrongCustomerIDException
     * @throws StorageLayerException
     */
    public ArrayList<Orderline> retrievePartlist(int idOrder) throws WrongCustomerIDException, StorageLayerException {
        String getPartlistString = "SELECT * FROM Orderline where idOrder = ? ;";
        ArrayList<Orderline> list = new ArrayList<>();
        Orderline orderline = null;
        try (final PreparedStatement getPartlist = con.prepareStatement(getPartlistString)) {
            getPartlist.setInt(1, idOrder);
            try (final ResultSet rs = getPartlist.executeQuery()) {
                while (rs.next()) {
                    orderline = new Orderline(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDouble(6));
                    list.add(orderline);
                }
                if (orderline == null) {
                    throw new WrongCustomerIDException();
                }
                return list;
            }
        } catch (SQLException ex) {
            throw new WrongCustomerIDException();
        } 
    }

    /**
     *
     * @param orderId
     * @return double
     * @throws InvalidOrderIdException
     * @throws StorageLayerException
     */
    public double calculateStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        String getStandardOrderPriceString = "SELECT SUM(price) from fog.Orderline WHERE idOrder = ? ;";
        try (final PreparedStatement getStandardOrderPrice = con.prepareStatement(getStandardOrderPriceString)) {
            double standardOrderPrice = 0;
            getStandardOrderPrice.setInt(1, orderId);
            try (final ResultSet rs = getStandardOrderPrice.executeQuery()) {
                if (rs.next()) {
                    standardOrderPrice = rs.getDouble(1);
                }
            }
            if (standardOrderPrice == 0) {
                throw new InvalidOrderIdException();
            }
            return standardOrderPrice;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @param orderId
     * @return double
     * @throws InvalidOrderIdException
     * @throws StorageLayerException
     */
    public double retrieveStandardOrderPrice(int orderId) throws InvalidOrderIdException, StorageLayerException {
        String getStandardPriceString = "SELECT standardPrice from fog.Order WHERE idOrder = ? ;";
        try (final PreparedStatement getStandardPrice = con.prepareStatement(getStandardPriceString)) {
            double standardPrice = 0;
            getStandardPrice.setInt(1, orderId);
            try (final ResultSet rs = getStandardPrice.executeQuery()) {
                if (rs.next()) {
                    standardPrice = rs.getDouble(1);
                }
                if (standardPrice == 0) {
                    throw new InvalidOrderIdException();
                }
                return standardPrice;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    /**
     *
     * @return ArrayList<Order>
     * @throws StorageLayerException
     */
    public ArrayList<Order> retrieveAllOrders() throws StorageLayerException {
        String getOrderString = "SELECT * FROM fog.Order;";
        ArrayList<Order> list = new ArrayList<>();
        try (final PreparedStatement getOrders = con.prepareStatement(getOrderString)) {
            Order order;
            try (final ResultSet rs = getOrders.executeQuery()) {
                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11));
                        order.setFlat(flat);
                    }
                    order.setStatus(rs.getBoolean(13));
                    order.setDiscount(rs.getDouble(14));
                    order.setStandardPrice(rs.getDouble(15));
                    order.setFinalPrice(rs.getDouble(16));
                    list.add(order);
                }
            }
            return list;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }
    
    /**
     *
     * @param idCustomer
     * @return ArrayList<Order>
     * @throws StorageLayerException
     */
    public ArrayList<Order> retrieveCustomerOrders(int idCustomer) throws StorageLayerException {
        String getCustomerOrdersString = "SELECT * FROM fog.Order where idCustomer = ?;";
        ArrayList<Order> list = new ArrayList<>();
        try (final PreparedStatement getCustomerOrders = con.prepareStatement(getCustomerOrdersString)) {
            Order order;
            getCustomerOrders.setInt(1, idCustomer);
            try (final ResultSet rs = getCustomerOrders.executeQuery()) {
                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11));
                        order.setFlat(flat);
                    }
                    order.setStatus(rs.getBoolean(13));
                    order.setDiscount(rs.getDouble(14));
                    order.setStandardPrice(rs.getDouble(15));
                    order.setFinalPrice(rs.getDouble(16));
                    list.add(order);
                }
            }
            return list;
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        } 
    }
    
}
