/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Customer;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public interface ICustomerFacade {
    Customer getCustomer(String email, String password)  throws SQLException, NullPointerException;
  void createCustomer(String email, String password, String firstName, String lastName, String address, String phone)throws SQLException, NullPointerException ;
  boolean emailExists(String email) throws SQLException;
}
