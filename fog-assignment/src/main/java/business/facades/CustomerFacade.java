package business.facades;

import business.Customer;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
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

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException {
        try {
            DataMapper dm = new DataMapper();
            dm.customerSignup(email, password, firstName, lastName, address, phone);
        } catch (SQLException | NullPointerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }

    public static int getCustomerId(String email, String password) throws InvalidUsernameOrPasswordException {
        int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveCustomerId(email, password);
        } catch (SQLException | NullPointerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
        return id;
    }
}
