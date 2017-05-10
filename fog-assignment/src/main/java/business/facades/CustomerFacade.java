package business.facades;

import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.DataMapper;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException {
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
        } catch (StorageLayerException | NullPointerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }

    
    public static void updateCustomerInformation(Customer updatedCustomer, Customer oldCustomer) throws IncorrectEmailFormattingException, InvalidUsernameOrPasswordException, InsecurePasswordException, EmailAlreadyInUseException {
        try {
            DataMapper dm = new DataMapper();
            dm.updateCustomerInformation(updatedCustomer, oldCustomer);
        } catch (StorageLayerException e) {
            
        }
    }


    public static ArrayList<Customer> retrieveCustomerDetails(int idCustomer){
          ArrayList<Customer> list = new ArrayList<>();
       try{
           DataMapper dm = new DataMapper();
          list = dm.retrieveCustomerDetails(idCustomer);
       }catch (StorageLayerException e)
       {
    }
        return list;
    }

}

