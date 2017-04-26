/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import business.Employee;
import data.DataMapper;
import data.IEmployeeFacade;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public class EmployeeFacade implements IEmployeeFacade {
    private DataMapper dm = new DataMapper();

    @Override
    public Employee getEmployee(String username, String password) throws SQLException, NullPointerException {
       return dm.employeeLogin(username, password);
        
    }

    @Override
    public void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws SQLException, NullPointerException {
        dm.employeeSignup(username, password, fistName, lastName, phone, email);
    }
    
    
}
