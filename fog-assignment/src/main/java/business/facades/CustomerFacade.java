package business.facades;

import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import data.DataMapper;

/**
 *
 * @author Lovro
 */
public class CustomerFacade {

    public static Customer getCustomer(String email, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        DataMapper dm = new DataMapper();
        return dm.customerLogin(email, password);
    }

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    public static void setCustomerId(Customer customer) throws StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.setCustomerId(customer);
    }

    public static void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException, StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.updateCustomerInformation(updatedCustomer, oldCustomer);
    }

    public static Customer retrieveCustomerDetails(int idCustomer) throws WrongCustomerIDException {
        Customer customer;
        DataMapper dm = new DataMapper();
        customer = dm.retrieveCustomerDetails(idCustomer);
        return customer;
    }
}
