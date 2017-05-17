package business.facades;

import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.Connector;
import data.EmployeeMapper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lovro
 */
public class EmployeeFacade {
    
    public static EmployeeFacade facade;
    
    public static EmployeeFacade getFacade() {
        if (facade == null) {
            facade = new EmployeeFacade();
        }
        return facade;
    }
    
    public static void setFacade(EmployeeFacade newFacade) {
        facade = newFacade;
    }

    public Employee getEmployee(String username, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        Connection con = Connector.getConnection();
        EmployeeMapper em = new EmployeeMapper(con);
        return em.employeeLogin(username, password);
    }

    public void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws InvalidUsernameOrPasswordException, InsecurePasswordException, StorageLayerException {
        Connection con = Connector.getConnection();
        EmployeeMapper em = new EmployeeMapper(con);
        em.employeeSignup(username, password, fistName, lastName, phone, email);
    }

    public int getRandomEmployeeId() throws StorageLayerException {
        Connection con = Connector.getConnection();
        ArrayList<Employee> employeesList;
        int randomIndex;
        EmployeeMapper em = new EmployeeMapper(con);
        employeesList = em.retrieveAllEmployees();
        Random r = new Random();
        randomIndex = r.nextInt(employeesList.size());
        return employeesList.get(randomIndex).getEmployeeId();
    }

}
