package business.facades;

import business.Customer;
import business.InvalidUsernameOrPasswordException;
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
        } catch (SQLException | NullPointerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws InvalidUsernameOrPasswordException {
        try {
            DataMapper dm = new DataMapper();
            dm.customerSignup(email, password, firstName, lastName, address, phone);
        } catch (SQLException | NullPointerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }
}
