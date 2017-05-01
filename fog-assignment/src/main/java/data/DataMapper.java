/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Customer;
import business.Employee;
import business.InsecurePasswordException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public class DataMapper {
     private final Connection con;
     
     public DataMapper() {
        con = new Connector().getConnection();
    }
      public void customerSignup(String email, String password, String firstName, String lastName, String address, String phone) throws SQLException, NullPointerException, InsecurePasswordException {
        PreparedStatement updateCustomer = null;
        String str = "INSERT INTO Customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        updateCustomer = con.prepareStatement(str);
        con.setAutoCommit(false);
        updateCustomer.setString(1, email);
        updateCustomer.setString(2, password);
        updateCustomer.setString(3, firstName);
        updateCustomer.setString(4, lastName);
        updateCustomer.setString(5, address);
        updateCustomer.setString(6, phone);
        if (password.length() < 7) {
            throw new InsecurePasswordException();
        } 
        int rowAffected = updateCustomer.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }
 public Customer customerLogin(String email, String password) throws SQLException, NullPointerException {
        ResultSet rs = null;
        Customer customer = null;
        PreparedStatement getCustomer = null;
        String getCustomerString = "SELECT * FROM Customer WHERE email = ? AND password = ? ;"; // had to change this
        getCustomer = con.prepareStatement(getCustomerString);
        getCustomer.setString(1, email);
        getCustomer.setString(2, password);
        rs = getCustomer.executeQuery();
        if (rs.next()) {
            customer = new Customer(rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7));
        }
        return customer;
        
    }
  public boolean emailExists(String email) throws SQLException 
{
    boolean emailExists = false;
        ResultSet rs = null;
        PreparedStatement st = null;
        String str = "select * from Customer order by email desc ;";
        st = con.prepareStatement(str);
        rs = st.executeQuery();
        String emailCounter;
         if(rs.next()) 
         {
           emailCounter =  rs.getString("email");
           if(emailCounter.equals(email))
           {
               System.out.println("It already exists");
              emailExists = true;
           }
         }

 return emailExists;
     }

 
 public void employeeSignup(String username, String password, String firstName, String lastName, String phone, String email) throws SQLException, NullPointerException {
      PreparedStatement updateEmployee = null;
        String str = "INSERT INTO SalesRep(userName, password, firstName, lastName, phone, email) VALUES (?,?,?,?,?,?);";
        updateEmployee = con.prepareStatement(str);
        con.setAutoCommit(false);
        updateEmployee.setString(1, username);
        updateEmployee.setString(2, password);
        updateEmployee.setString(3, firstName);
        updateEmployee.setString(4, lastName);
        updateEmployee.setString(5, phone);
        updateEmployee.setString(6, email);

        int rowAffected = updateEmployee.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }
 
 public Employee employeeLogin(String username, String password) throws SQLException, NullPointerException {
        ResultSet rs = null;
        Employee employee = null;
        PreparedStatement getBorrower = null;
        String getBorrowerString = "SELECT * FROM Customer WHERE username = ? AND password = ? ;";
        getBorrower = con.prepareStatement(getBorrowerString);
        getBorrower.setString(1, username);
        getBorrower.setString(2, password);
        rs = getBorrower.executeQuery();
        if (rs.next()) {
            employee = new Employee(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7));
        }
        return employee;
        
    }

    public int retrieveCustomerId(String email, String password) throws SQLException {
        ResultSet rs = null;
        int id = 0;
        PreparedStatement getCustomerId = null;
        String getCustomerIdString = "SELECT idCustomer FROM Customer WHERE email = ? AND password = ? ;";
        getCustomerId = con.prepareStatement(getCustomerIdString);
        getCustomerId.setString(1, email);
        getCustomerId.setString(2, password);
        rs = getCustomerId.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;    }

    public void newCarport(String concat) throws SQLException {
        PreparedStatement createCarport = null;
        String createCarportString = "INSERT INTO Carport(name) VALUES (?);";
        createCarport = con.prepareStatement(createCarportString);
        con.setAutoCommit(false);
        createCarport.setString(1, concat);
        int rowAffected = createCarport.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }    }

    public int retrieveCarportId(String concat) throws SQLException {
        ResultSet rs = null;
        int id = 0;
        PreparedStatement getCarportId = null;
        String getCarportIdString = "SELECT idCarport FROM Carport WHERE name = ?;";
        getCarportId = con.prepareStatement(getCarportIdString);
        getCarportId.setString(1, concat);
        rs = getCarportId.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;      }

}
