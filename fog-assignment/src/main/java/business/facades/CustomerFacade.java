/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import business.Customer;
import data.DataMapper;
import data.ICustomerFacade;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public class CustomerFacade implements ICustomerFacade {

    private DataMapper dm = new DataMapper();
    
    @Override
    public Customer getCustomer(String email, String password) throws SQLException, NullPointerException {
        return dm.customerLogin(email, password);
    }

    @Override
    public void createCustomer(String email, String password, String firstName, String lastName, String address, String phone) throws SQLException, NullPointerException {
       dm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    @Override
    public boolean emailExists(String email) throws SQLException {
       return dm.emailExists(email);
    }
    
}
