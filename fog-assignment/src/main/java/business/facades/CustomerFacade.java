package business.facades;

import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import data.CustomerMapper;

/**
 *
 * @author Lovro
 */
public class CustomerFacade {

    public static Customer getCustomer(String email, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        CustomerMapper cm = new CustomerMapper();
        return cm.customerLogin(email, password);
    }

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        CustomerMapper cm = new CustomerMapper();
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    public static void setCustomerId(Customer customer) throws StorageLayerException {
        CustomerMapper cm = new CustomerMapper();
        cm.setCustomerId(customer);
    }

    public static void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        CustomerMapper cm = new CustomerMapper();
        cm.updateCustomerInformation(updatedCustomer, oldCustomer);
    }

    public static Customer retrieveCustomerDetails(int idCustomer) throws WrongCustomerIDException {
        Customer customer;
        CustomerMapper cm = new CustomerMapper();
        customer = cm.retrieveCustomerDetails(idCustomer);
        return customer;
    }
}
