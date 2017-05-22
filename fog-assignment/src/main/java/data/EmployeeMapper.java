package data;

import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mathiasjepsen
 */
public class EmployeeMapper {
    
    Connection con;

    public EmployeeMapper(Connection con) {
        this.con = con;
    }

    public void employeeSignup(String username, String password, String firstName, String lastName, String phone, String email) throws InsecurePasswordException, StorageLayerException {
        String str = "INSERT INTO SalesRep(userName, password, firstName, lastName, phone, email) VALUES (?,?,?,?,?,?);";
        try (final PreparedStatement employeeSignup = con.prepareStatement(str)) {
            con.setAutoCommit(false);
            employeeSignup.setString(1, username);
            employeeSignup.setString(2, password);
            employeeSignup.setString(3, firstName);
            employeeSignup.setString(4, lastName);
            employeeSignup.setString(5, phone);
            employeeSignup.setString(6, email);
            if (password.length() < 7) {
                throw new InsecurePasswordException();
            }
            int rowAffected = employeeSignup.executeUpdate();
            if (rowAffected == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        } 
    }

    public Employee employeeLogin(String username, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        String employeeLoginString = "SELECT * FROM SalesRep WHERE username = ? AND password = ? ;";
        try (final PreparedStatement employeeLogin = con.prepareStatement(employeeLoginString)) {
            Employee employee = null;
            employeeLogin.setString(1, username);
            employeeLogin.setString(2, password);
            try (final ResultSet rs = employeeLogin.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    employee.setEmployeeId(rs.getInt(1));
                }
            }
            if (employee == null) {
                throw new InvalidUsernameOrPasswordException();
            }
            return employee;
        } catch (SQLException ex) {
            throw new StorageLayerException();
        } 
    }

    public ArrayList<Employee> retrieveAllEmployees() throws StorageLayerException {
        String getEmployeesString = "SELECT * FROM SalesRep;";
        ArrayList<Employee> list = new ArrayList<>();
        try (final PreparedStatement getEmployees = con.prepareStatement(getEmployeesString)) {
            Employee employee = null;
            try (final ResultSet rs = getEmployees.executeQuery()) {
                while (rs.next()) {
                    int userId = rs.getInt(1);
                    employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    employee.setEmployeeId(userId);
                    employee.setEmployeeId(rs.getInt(1));
                    list.add(employee);
                }
            }
            return list;
        } catch (SQLException | NullPointerException ex) {
            throw new StorageLayerException();
        } 
    }
    
}
