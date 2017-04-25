/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Employee;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public interface IEmployeeFacade {
     Employee getEmployee(String username, String password) throws SQLException, NullPointerException;
   void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws SQLException, NullPointerException;
}
