package business.facades;

import business.Customer;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.DataMapper;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public class CustomerFacade {

    public static Customer getCustomer(String email, String password) throws InvalidUsernameOrPasswordException {
        try {
            DataMapper dm = new DataMapper();
            return dm.customerLogin(email, password);
        } catch (StorageLayerException e) {
            throw new InvalidUsernameOrPasswordException();
        }
    }

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException {
        try {
            DataMapper dm = new DataMapper();
            dm.customerSignup(email, password, firstName, lastName, address, phone);
        } catch (StorageLayerException e) {

        }
    }

    public static void setCustomerId(Customer customer) throws InvalidUsernameOrPasswordException {
        try {
            DataMapper dm = new DataMapper();
            dm.setCustomerId(customer);
        } catch (StorageLayerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }
}
