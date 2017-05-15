package data;

import business.exceptions.InvalidOrderIdException;
import business.Carport;
import business.Customer;
import business.Employee;
import business.exceptions.EmailAlreadyInUseException;
import business.Flat;
import business.Order;
import business.Orderline;
import business.Partlist;
import business.Pointy;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import business.parts.Part;
import business.parts.Part.PartType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Lovro
 */
public class DataMapper {

    public void customerSignup(String email, String password, String firstName, String lastName, String address, String phone) throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        String str = "INSERT INTO Customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        try (Connection con = new Connector().getConnection(); PreparedStatement updateCustomer = con.prepareStatement(str)) {
            con.setAutoCommit(false);
            if (!emailExists(email)) {
                updateCustomer.setString(1, email);
            } else {
                throw new EmailAlreadyInUseException();
            }
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
        } catch (SQLException ex) {
            throw new InvalidUsernameOrPasswordException();
        }
    }

    public boolean emailExists(String email) throws StorageLayerException {
        String str = "SELECT email FROM Customer;";
        try (Connection con = new Connector().getConnection(); PreparedStatement st = con.prepareStatement(str)) {
            boolean emailExists = false;
            try (ResultSet rs = st.executeQuery()) {
                String emailCounter;
                while (rs.next()) {
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
                    employee.setEmployeeId(rs.getInt(1));
                }
            }
            return employee;
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        }
    }

    public void setCustomerId(Customer customer) throws StorageLayerException, InvalidUsernameOrPasswordException {
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
        } catch (NullPointerException e) {
            throw new InvalidUsernameOrPasswordException();
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

    public ArrayList<Employee> retrieveAllEmployees() throws StorageLayerException {
        String getEmployeesString = "SELECT * FROM SalesRep;";
        ArrayList<Employee> list = new ArrayList<>();
        try (Connection con = new Connector().getConnection(); PreparedStatement getEmployees = con.prepareStatement(getEmployeesString)) {
            Employee employee = null;
            try (ResultSet rs = getEmployees.executeQuery()) {
                while (rs.next()) {
                    int userId = rs.getInt(1);
                    employee = new Employee(rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                    employee.setEmployeeId(userId);
                    employee.setEmployeeId(rs.getInt(1));
                    list.add(employee);
                }
            }
            return list;
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        }
    }

    public void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, InvalidUsernameOrPasswordException, EmailAlreadyInUseException {
        String str = "UPDATE Customer SET email = ?, password = ?, firstName = ?, lastName = ?, address = ?, phone = ? WHERE idCustomer = ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement updateCustomerInformation = con.prepareStatement(str)) {
            con.setAutoCommit(false);
            if (emailExists(updatedCustomer.getEmail()) && updatedCustomer.getEmail().equals(oldCustomer.getEmail())) {
                updateCustomerInformation.setString(1, oldCustomer.getEmail());
            } else if (emailExists(updatedCustomer.getEmail()) && !updatedCustomer.getEmail().equals(oldCustomer.getEmail())) {
                throw new EmailAlreadyInUseException();
            } else {
                updateCustomerInformation.setString(1, updatedCustomer.getEmail());
            }
            updateCustomerInformation.setString(2, updatedCustomer.getPassword());
            updateCustomerInformation.setString(3, updatedCustomer.getFirstName());
            updateCustomerInformation.setString(4, updatedCustomer.getLastName());
            updateCustomerInformation.setString(5, updatedCustomer.getAddress());
            updateCustomerInformation.setString(6, updatedCustomer.getPhone());
            updateCustomerInformation.setInt(7, oldCustomer.getId_customer());
            boolean valid = EmailValidator.getInstance().isValid(updatedCustomer.getEmail());
            if (!valid) {
                throw new IncorrectEmailFormattingException();
            }
            if (updatedCustomer.getPassword().length() < 7) {
                throw new InsecurePasswordException();
            }
            int rowAffected = updateCustomerInformation.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
        }
    }

    public Carport retrieveCarport(int idOrder) throws StorageLayerException {
        String getOrderlineString = "SELECT (carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, roofHeight) FROM fog.Order where idOrder = ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getOrderline = con.prepareStatement(getOrderlineString)) {
            Carport carport = null;
            try (ResultSet rs = getOrderline.executeQuery()) {
                if (rs.next()) {
                    if (rs.getString(1).equals("Flat")) {
                        carport = new Flat(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getDouble(5),
                                rs.getDouble(6),
                                rs.getDouble(7));
                    } else {
                        carport = new Pointy(rs.getString(1),
                                rs.getString(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getDouble(5),
                                rs.getDouble(6),
                                rs.getDouble(7),
                                rs.getDouble(8));
                    }

                }
                return carport;
            }
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        }
    }

    public ArrayList<Integer> retrieveCarportId() throws StorageLayerException {
        String getCarportIdString = "SELECT * FROM Orderline where carportId = ? ;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getCarportId = con.prepareStatement(getCarportIdString)) {
            ArrayList<Integer> list = new ArrayList<>();
            try (ResultSet rs = getCarportId.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getInt(3));

                }
                return list;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void updateStatus(int orderId) throws StorageLayerException {
        String updateStatusString = "UPDATE fog.Order SET status = TRUE WHERE idOrder = ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement updateStatus = con.prepareStatement(updateStatusString)) {
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

    public Customer retrieveCustomerDetails(int idCustomer) throws StorageLayerException, WrongCustomerIDException {
        String getCustomerString = "SELECT * FROM Customer where idCustomer = ?;";
         Customer customer = null;
        try (Connection con = new Connector().getConnection(); PreparedStatement getCustomer = con.prepareStatement(getCustomerString)) {
            getCustomer.setInt(1, idCustomer);
            try (ResultSet rs = getCustomer.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                    if (customer == null) {
                        throw new WrongCustomerIDException();
                    }
                }
                return customer;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public ArrayList<Order> retrieveAllOrders() throws StorageLayerException {
        String getOrderString = "SELECT * FROM fog.Order;";
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = new Connector().getConnection(); PreparedStatement getOrders = con.prepareStatement(getOrderString)) {
            Order order = null;
            try (ResultSet rs = getOrders.executeQuery()) {
                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11));
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

    public ArrayList<Orderline> retrievePartlist(int idOrder) throws StorageLayerException, WrongCustomerIDException {
        String getPartlistString = "SELECT * FROM Orderline where idOrder = ? ;";
        ArrayList<Orderline> list = new ArrayList<>();
        Orderline orderline = null;
        try (Connection con = new Connector().getConnection(); PreparedStatement getPartlist = con.prepareStatement(getPartlistString)) {
            getPartlist.setInt(1, idOrder);
            try (ResultSet rs = getPartlist.executeQuery()) {
                while (rs.next()) {
                    orderline = new Orderline(rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getDouble(6));
                    list.add(orderline);
                }
                if (orderline == null) {
                    throw new WrongCustomerIDException();
                }
                return list;
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public ArrayList<Order> retrieveCustomerOrders(int idCustomer) throws StorageLayerException {
        String getCustomerOrdersString = "SELECT * FROM fog.Order where idCustomer = ?;";
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = new Connector().getConnection(); PreparedStatement getCustomerOrders = con.prepareStatement(getCustomerOrdersString)) {
            Order order = null;
            getCustomerOrders.setInt(1, idCustomer);
            try (ResultSet rs = getCustomerOrders.executeQuery()) {
                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11));
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

    public Order retrieveOrder(int idOrder) throws InvalidOrderIdException {
        String getCustomerOrdersString = "SELECT * FROM fog.Order where idOrder = ?;";
        try (Connection con = new Connector().getConnection(); PreparedStatement getCustomerOrders = con.prepareStatement(getCustomerOrdersString)) {
            Order order = null;
            getCustomerOrders.setInt(1, idOrder);
            try (ResultSet rs = getCustomerOrders.executeQuery()) {
                if (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setCustomerId(rs.getInt(2));
                    order.setSalesRepId(rs.getInt(3));
                    order.setDate(rs.getTimestamp(4));
                    String carportType = rs.getString(5);
                    if ("Pointy".equals(carportType)) {
                        Pointy pointy = new Pointy(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
                        pointy.createPartList();
                        order.setPointy(pointy);
                    } else if ("Flat".equals(carportType)) {
                        Flat flat = new Flat(carportType, rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                                rs.getDouble(10), rs.getDouble(11));
                        flat.createPartList();
                        order.setFlat(flat);
                    }
                    order.setStatus(rs.getBoolean(13));
                    order.setDiscount(rs.getDouble(14));
                    order.setStandardPrice(rs.getDouble(15));
                    order.setFinalPrice(rs.getDouble(16));
                }
            }
            return order;
        } catch (NullPointerException | SQLException ex) {
            throw new InvalidOrderIdException();
        }
    }
}
