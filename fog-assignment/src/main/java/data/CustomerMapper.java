package data;

import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author mathiasjepsen
 */
public class CustomerMapper {
    
    Connection con;

    public CustomerMapper(Connection con) {
        this.con = con;
    }

    public void customerSignup(String email, String password, String firstName, String lastName, String address, String phone) throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        String str = "INSERT INTO Customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        try (final PreparedStatement updateCustomer = con.prepareStatement(str)) {
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
        try (final PreparedStatement getCustomer = con.prepareStatement(getCustomerString)) {
            Customer customer = null;
            getCustomer.setString(1, email);
            getCustomer.setString(2, password);
            try (final ResultSet rs = getCustomer.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                } else {
                    throw new InvalidUsernameOrPasswordException();
                }
            }
            return customer;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public boolean emailExists(String email) throws StorageLayerException {
        String str = "SELECT email FROM Customer;";
        try (final PreparedStatement st = con.prepareStatement(str)) {
            boolean emailExists = false;
            try (final ResultSet rs = st.executeQuery()) {
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

    public void setCustomerId(Customer customer) throws StorageLayerException {
        String getCustomerIdString = "SELECT idCustomer FROM Customer WHERE email = ? AND password = ? ;";
        try (final PreparedStatement getCustomerId = con.prepareStatement(getCustomerIdString)) {
            int id = 0;
            getCustomerId.setString(1, customer.getEmail());
            getCustomerId.setString(2, customer.getPassword());
            try (final ResultSet rs = getCustomerId.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                customer.setId_customer(id);
            }
        } catch (SQLException ex) {
            throw new StorageLayerException();
        }
    }

    public void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, InvalidUsernameOrPasswordException, EmailAlreadyInUseException {
        String str = "UPDATE Customer SET email = ?, password = ?, firstName = ?, lastName = ?, address = ?, phone = ? WHERE idCustomer = ?;";
        try (final PreparedStatement updateCustomerInformation = con.prepareStatement(str)) {
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

    public Customer retrieveCustomerDetails(int idCustomer) throws WrongCustomerIDException {
        String getCustomerString = "SELECT * FROM Customer where idCustomer = ?;";
        Customer customer = null;
        try (final PreparedStatement getCustomer = con.prepareStatement(getCustomerString)) {
            getCustomer.setInt(1, idCustomer);
            try (final ResultSet rs = getCustomer.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                }
                if (customer == null) {
                    throw new WrongCustomerIDException();
                }
                return customer;
            }
        } catch (SQLException ex) {
            throw new WrongCustomerIDException();
        }
    } 
}
