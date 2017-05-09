package data;

import business.Customer;
import business.Employee;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Lovro
 */
public class DataMapper {

    public void customerSignup(String email, String password, String firstName, String lastName, String address, String phone) throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException {
        String str = "INSERT INTO Customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        try (Connection con = new Connector().getConnection(); PreparedStatement updateCustomer = con.prepareStatement(str)) {
            con.setAutoCommit(false);
            updateCustomer.setString(1, email);
            updateCustomer.setString(2, password);
            updateCustomer.setString(3, firstName);
            updateCustomer.setString(4, lastName);
            updateCustomer.setString(5, address);
            updateCustomer.setString(6, phone);
            boolean valid = EmailValidator.getInstance().isValid(email);
            if (!valid) {
                throw new IncorrectEmailFormattingException();
            }
            if (password.length() < 7) {
                throw new InsecurePasswordException();
            }
            int rowAffected = updateCustomer.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            throw new StorageLayerException();
        }
    }

    public Customer customerLogin(String email, String password) throws StorageLayerException, InvalidUsernameOrPasswordException {
        String getCustomerString = "SELECT * FROM Customer WHERE email = ? AND password = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getCustomer = con.prepareStatement(getCustomerString)) {
            Customer customer = null;
            getCustomer.setString(1, email);
            getCustomer.setString(2, password);
            try (ResultSet rs = getCustomer.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7));
                }
            } 
            return customer;
        } catch (SQLException | NullPointerException ex) {
            throw new InvalidUsernameOrPasswordException();
        }
    }

    public boolean emailExists(String email) throws StorageLayerException {
        String str = "select * from Customer order by email desc ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement st = con.prepareStatement(str)) {
            boolean emailExists = false;
            try (ResultSet rs = st.executeQuery()) {
                String emailCounter;
                if (rs.next()) {
                    emailCounter = rs.getString("email");
                    if (emailCounter.equals(email)) {
                        emailExists = true;
                    }
                }
            }
            return emailExists;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void employeeSignup(String username, String password, String firstName, String lastName, String phone, String email) throws InsecurePasswordException, StorageLayerException {
        String str = "INSERT INTO SalesRep(userName, password, firstName, lastName, phone, email) VALUES (?,?,?,?,?,?);";
        try (Connection con = new Connector().getConnection(); PreparedStatement updateEmployee = con.prepareStatement(str)) {
            con.setAutoCommit(false);
            updateEmployee.setString(1, username);
            updateEmployee.setString(2, password);
            updateEmployee.setString(3, firstName);
            updateEmployee.setString(4, lastName);
            updateEmployee.setString(5, phone);
            updateEmployee.setString(6, email);
            if (password.length() < 7) {
                throw new InsecurePasswordException();
            }
            int rowAffected = updateEmployee.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        }
    }

    public Employee employeeLogin(String username, String password) throws StorageLayerException {
        String getBorrowerString = "SELECT * FROM SalesRep WHERE username = ? AND password = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getBorrower = con.prepareStatement(getBorrowerString)) {
            Employee employee = null;
            getBorrower.setString(1, username);
            getBorrower.setString(2, password);
            try (ResultSet rs = getBorrower.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee(rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7));
                }
            }
            return employee;
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        }
    }

    public void setCustomerId(Customer customer) throws StorageLayerException {
        String getCustomerIdString = "SELECT idCustomer FROM Customer WHERE email = ? AND password = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getCustomerId = con.prepareStatement(getCustomerIdString)) {
            int id = 0;
            getCustomerId.setString(1, customer.getEmail());
            getCustomerId.setString(2, customer.getPassword());
            try (ResultSet rs = getCustomerId.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                customer.setId_customer(id);
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType, int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, boolean status, double price) throws StorageLayerException {
        String createOrderString = "INSERT INTO fog.Order(idCustomer, idSalesRep, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, standardPrice) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        try (Connection con = new Connector().getConnection(); PreparedStatement createOrder = con.prepareStatement(createOrderString)) {
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

    public int retrieveOrderId(int customerId, Timestamp date) throws StorageLayerException {
        String getOrderIdString = "SELECT idOrder FROM fog.Order WHERE idCustomer = ? AND date = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getOrderId = con.prepareStatement(getOrderIdString)) {
            int id = 0;
            getOrderId.setInt(1, customerId);
            getOrderId.setTimestamp(2, date);
            try (ResultSet rs = getOrderId.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                return id;
            } 
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public double retrievePartPrice(String partName) throws StorageLayerException {
        String getPriceString = "SELECT standardPrice FROM fog.Part WHERE name = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getPrice = con.prepareStatement(getPriceString)) {
            double price = 0;
            getPrice.setString(1, partName);
            try (ResultSet rs = getPrice.executeQuery()) {
                if (rs.next()) {
                    price = rs.getDouble(1);
                }
            }
            return price;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void createOrderline(int idOrder, String partName, double length, int quantity, String explanation, double price) throws StorageLayerException {
        String createOrderlineString = "INSERT INTO fog.Orderline(idOrder, partName, length, quantity, explanation, price) VALUES (?,?,?,?,?,?);";
        try (Connection con = new Connector().getConnection(); PreparedStatement createOrderline = con.prepareStatement(createOrderlineString)) {
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

    public double calculateStandardOrderPrice(int orderId) throws StorageLayerException {
        String getStandardOrderPriceString = "SELECT SUM(price) from fog.Orderline WHERE idOrder = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getStandardOrderPrice = con.prepareStatement(getStandardOrderPriceString)) {
            double standardOrderPrice = 0;
            getStandardOrderPrice.setInt(1, orderId);
            try (ResultSet rs = getStandardOrderPrice.executeQuery()) {
                if (rs.next()) {
                    standardOrderPrice = rs.getDouble(1);
                }
            }
            return standardOrderPrice;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    } 

    public double retrieveDiscountRate(int orderId) throws StorageLayerException {
        String getDiscountRateString = "SELECT discount from fog.Order WHERE idOrder = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getDiscountRate = con.prepareStatement(getDiscountRateString)) {
            double discountRate = 0;
            getDiscountRate.setInt(1, orderId);
            try (ResultSet rs = getDiscountRate.executeQuery()) {
                if (rs.next()) {
                    discountRate = rs.getDouble(1);
                }
            }
            return discountRate;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void setDiscountRate(double rate, int orderId) throws StorageLayerException {
        String setDiscountRateString = "UPDATE fog.Order SET discount = ? WHERE idOrder= ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement setDiscountRate = con.prepareStatement(setDiscountRateString)) {
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

    public void setStandardPrice(double standardPrice, int orderId) throws StorageLayerException {
        String setStandardPriceString = "UPDATE fog.Order SET standardPrice = ? WHERE idOrder= ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement setStandardPrice = con.prepareStatement(setStandardPriceString)) {
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

    public void setFinalPrice(double finalPrice, int orderId) throws StorageLayerException {
        String setFinalPriceString = "UPDATE fog.Order SET finalPrice = ? WHERE idOrder= ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement setFinalPrice = con.prepareStatement(setFinalPriceString)) {
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

    public double retrieveFinalPrice(int orderId) throws StorageLayerException {
        String getFinalPriceString = "SELECT finalPrice from fog.Order WHERE idOrder = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getFinalPrice = con.prepareStatement(getFinalPriceString)) {
            double finalPrice = 0;
            getFinalPrice.setInt(1, orderId);
            try (ResultSet rs = getFinalPrice.executeQuery()) {
                if (rs.next()) {
                    finalPrice = rs.getDouble(1);
                }
                return finalPrice;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public double retrieveStandardOrderPrice(int orderId) throws StorageLayerException {
        String getStandardPriceString = "SELECT standardPrice from fog.Order WHERE idOrder = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getStandardPrice = con.prepareStatement(getStandardPriceString)) {
            double standardPrice = 0;
            getStandardPrice.setInt(1, orderId);
            try (ResultSet rs = getStandardPrice.executeQuery()) {
                if (rs.next()) {
                    standardPrice = rs.getDouble(1);
                }
                return standardPrice;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }
}
