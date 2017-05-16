package business.facades;

import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import data.Connector;
import data.CustomerMapper;
import java.sql.Connection;

/**
 *
 * @author Lovro
 */
public class CustomerFacade {
    
    public static CustomerFacade facade;
    
    public static CustomerFacade getFacade() {
        if (facade == null) {
            facade = new CustomerFacade();
        }
        return facade;
    }
    
    public static void setFacade(CustomerFacade newFacade) {
        facade = newFacade;
    }
       
    public Customer getCustomer(String email, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        Connection con = Connector.getConnection();
        CustomerMapper cm = new CustomerMapper(con);
        return cm.customerLogin(email, password);
    }

    public void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        Connection con = Connector.getConnection();
        CustomerMapper cm = new CustomerMapper(con);
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    public void setCustomerId(Customer customer) throws StorageLayerException {
        Connection con = Connector.getConnection();
        CustomerMapper cm = new CustomerMapper(con);
        cm.setCustomerId(customer);
    }

    public void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        Connection con = Connector.getConnection();
        CustomerMapper cm = new CustomerMapper(con);
        cm.updateCustomerInformation(updatedCustomer, oldCustomer);
    }

    public Customer retrieveCustomerDetails(int idCustomer) throws WrongCustomerIDException {
        Customer customer;
        Connection con = Connector.getConnection();
        CustomerMapper cm = new CustomerMapper(con);
        customer = cm.retrieveCustomerDetails(idCustomer);
        return customer;
    }
}
