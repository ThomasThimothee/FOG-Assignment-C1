package data;

import business.Customer;
import business.Employee;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Lovro
 */
public class DataMapper {

    private final Connection con;

    public DataMapper() {
        con = new Connector().getConnection();
    }

    public void customerSignup(String email, String password, String firstName, String lastName, String address, String phone) throws SQLException, InsecurePasswordException, IncorrectEmailFormattingException {
        PreparedStatement updateCustomer = null;
        String str = "INSERT INTO Customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        updateCustomer = con.prepareStatement(str);
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
    }

    public Customer customerLogin(String email, String password) throws SQLException, NullPointerException {
        ResultSet rs = null;
        Customer customer = null;
        PreparedStatement getCustomer = null;
        String getCustomerString = "SELECT * FROM Customer WHERE email = ? AND password = ? ;"; // had to change this
        getCustomer = con.prepareStatement(getCustomerString);
        getCustomer.setString(1, email);
        getCustomer.setString(2, password);
        rs = getCustomer.executeQuery();
        if (rs.next()) {
            customer = new Customer(rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
        }
        return customer;

    }

    public boolean emailExists(String email) throws SQLException {
        boolean emailExists = false;
        ResultSet rs = null;
        PreparedStatement st = null;
        String str = "select * from Customer order by email desc ;";
        st = con.prepareStatement(str);
        rs = st.executeQuery();
        String emailCounter;
        if (rs.next()) {
            emailCounter = rs.getString("email");
            if (emailCounter.equals(email)) {
                System.out.println("It already exists");
                emailExists = true;
            }
        }

        return emailExists;
    }

    public void employeeSignup(String username, String password, String firstName, String lastName, String phone, String email) throws SQLException, NullPointerException, InsecurePasswordException {
        PreparedStatement updateEmployee = null;
        String str = "INSERT INTO SalesRep(userName, password, firstName, lastName, phone, email) VALUES (?,?,?,?,?,?);";
        updateEmployee = con.prepareStatement(str);
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
    }

    public Employee employeeLogin(String username, String password) throws SQLException, NullPointerException {
        ResultSet rs = null;
        Employee employee = null;
        PreparedStatement getBorrower = null;
        String getBorrowerString = "SELECT * FROM SalesRep WHERE username = ? AND password = ? ;";
        getBorrower = con.prepareStatement(getBorrowerString);
        getBorrower.setString(1, username);
        getBorrower.setString(2, password);
        rs = getBorrower.executeQuery();
        if (rs.next()) {
            employee = new Employee(rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
        }
        return employee;

    }

    public void setCustomerId(Customer customer) throws SQLException {
        ResultSet rs = null;
        int id = 0;
        PreparedStatement getCustomerId = null;
        String getCustomerIdString = "SELECT idCustomer FROM Customer WHERE email = ? AND password = ? ;";
        getCustomerId = con.prepareStatement(getCustomerIdString);
        getCustomerId.setString(1, customer.getEmail());
        getCustomerId.setString(2, customer.getPassword());
        rs = getCustomerId.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        customer.setId_customer(id);
    }

    public void createOrder(int customerId, int salesRepId, Timestamp date, String carportType, String roofType,  int carportWidth, int carportLength, int shedWidth, int shedLength, Double angle, boolean status, double price) throws SQLException {
        PreparedStatement createOrder = null;
        String createOrderString = "INSERT INTO fog.Order(idCustomer, idSalesRep, date, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, standardPrice) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        createOrder = con.prepareStatement(createOrderString);
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
    }

    public int retrieveOrderId(int customerId, Timestamp date) throws SQLException {
        ResultSet rs = null;
        int id = 0;
        PreparedStatement getOrderId = null;
        String getOrderIdString = "SELECT idOrder FROM fog.Order WHERE idCustomer = ? AND date = ? ;";
        getOrderId = con.prepareStatement(getOrderIdString);
        getOrderId.setInt(1, customerId);
        getOrderId.setTimestamp(2, date);
        rs = getOrderId.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public double retrievePartPrice(String partName) throws SQLException {
        ResultSet rs = null;
        double price = 0;
        PreparedStatement getPrice = null;
        String getPriceString = "SELECT standardPrice FROM fog.Part WHERE name = ? ;";
        getPrice = con.prepareStatement(getPriceString);
        getPrice.setString(1, partName);
        rs = getPrice.executeQuery();
        if (rs.next()) {
            price = rs.getDouble(1);
        }
        return price;
    }

    public void createOrderline(String partName, int orderId, double length, int quantity, String explanation, double price) throws SQLException {
        PreparedStatement createOrderline = null;
        String createOrderlineString = "INSERT INTO fog.Orderline(partName, orderId, length, quantity, explanation, price) VALUES (?,?,?,?,?,?);";
        createOrderline = con.prepareStatement(createOrderlineString);
        con.setAutoCommit(false);
        createOrderline.setString(1, partName);
        createOrderline.setInt(2, orderId);
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
    }

    public double calculateStandardOrderPrice(int orderId) throws SQLException {
        ResultSet rs = null;
        double standardOrderPrice = 0;
        PreparedStatement getStandardOrderPrice = null;
        String getStandardOrderPriceString = "SELECT SUM(price) from fog.Orderline WHERE idOrder = ? ;";
        getStandardOrderPrice = con.prepareStatement(getStandardOrderPriceString);
        getStandardOrderPrice.setInt(1, orderId);
        rs = getStandardOrderPrice.executeQuery();
        if (rs.next()) {
            standardOrderPrice = rs.getDouble(1);
        }
        return standardOrderPrice;
    }

    public double retrieveDiscountRate(int orderId) throws SQLException {
        ResultSet rs = null;
        double discountRate = 0;
        PreparedStatement getDiscountRate = null;
        String getDiscountRateString = "SELECT discount from fog.Order WHERE idOrder = ? ;";
        getDiscountRate = con.prepareStatement(getDiscountRateString);
        getDiscountRate.setInt(1, orderId);
        rs = getDiscountRate.executeQuery();
        if (rs.next()) {
            discountRate = rs.getDouble(1);
        }
        return discountRate;
    }

    public void setDiscountRate(double rate, int orderId) throws SQLException {
        ResultSet rs = null;
        PreparedStatement setDiscountRate = null;
        String setDiscountRateString = "UPDATE fog.Order SET discount = ? WHERE idOrder= ?;";
        setDiscountRate = con.prepareStatement(setDiscountRateString);
        con.setAutoCommit(false);
        setDiscountRate.setDouble(1, rate);
        setDiscountRate.setInt(2, orderId);
        int rowAffected = setDiscountRate.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }

    public void setStandardPrice(double standardPrice, int orderId) throws SQLException {
        ResultSet rs = null;
        PreparedStatement setStandardPrice = null;
        String setStandardPriceString = "UPDATE fog.Order SET standardPrice = ? WHERE idOrder= ?;";
        setStandardPrice = con.prepareStatement(setStandardPriceString);
        con.setAutoCommit(false);
        setStandardPrice.setDouble(1, standardPrice);
        setStandardPrice.setInt(2, orderId);
        int rowAffected = setStandardPrice.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }

    public void setFinalPrice(double finalPrice, int orderId) throws SQLException {
        ResultSet rs = null;
        PreparedStatement setFinalPrice = null;
        String setFinalPriceString = "UPDATE fog.Order SET finalPrice = ? WHERE idOrder= ?;";
        setFinalPrice = con.prepareStatement(setFinalPriceString);
        con.setAutoCommit(false);
        setFinalPrice.setDouble(1, finalPrice);
        setFinalPrice.setInt(2, orderId);
        int rowAffected = setFinalPrice.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }

    public double retrieveFinalPrice(int orderId) throws SQLException {
        ResultSet rs = null;
        double finalPrice = 0;
        PreparedStatement getFinalPrice = null;
        String getFinalPriceString = "SELECT finalPrice from fog.Order WHERE idOrder = ? ;";
        getFinalPrice = con.prepareStatement(getFinalPriceString);
        getFinalPrice.setInt(1, orderId);
        rs = getFinalPrice.executeQuery();
        if (rs.next()) {
            finalPrice = rs.getDouble(1);
        }
        return finalPrice;
    }

    public double retrieveStandardOrderPrice(int orderId) throws SQLException {
        ResultSet rs = null;
        double standardPrice = 0;
        PreparedStatement getStandardPrice = null;
        String getStandardPriceString = "SELECT standardPrice from fog.Order WHERE idOrder = ? ;";
        getStandardPrice = con.prepareStatement(getStandardPriceString);
        getStandardPrice.setInt(1, orderId);
        rs = getStandardPrice.executeQuery();
        if (rs.next()) {
            standardPrice = rs.getDouble(1);
        }
        return standardPrice;
    }

}
