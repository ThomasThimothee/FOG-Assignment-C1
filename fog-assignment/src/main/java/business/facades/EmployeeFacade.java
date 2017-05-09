package business.facades;

import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.DataMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lovro
 */
public class EmployeeFacade {

    public static Employee getEmployee(String username, String password) throws InvalidUsernameOrPasswordException {
        try {
            DataMapper dm = new DataMapper();
            return dm.employeeLogin(username, password);
        } catch (StorageLayerException e) {
            InvalidUsernameOrPasswordException ex = new InvalidUsernameOrPasswordException();
            throw ex;
        }
    }

    public static void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws InvalidUsernameOrPasswordException, InsecurePasswordException {
        try {
            DataMapper dm = new DataMapper();
            dm.employeeSignup(username, password, fistName, lastName, phone, email);
        } catch (StorageLayerException e) {

        }
    }

    public static int getRandomEmployeeId() {
        ArrayList<Employee> employeesList= new ArrayList<Employee>();
        int randomIndex=0;
        try {
            DataMapper dm = new DataMapper();
            employeesList = dm.retrieveAllEmployees();
            Random r = new Random();
            randomIndex = r.nextInt(employeesList.size());
            System.out.println("size list= " + employeesList.size());
        } catch (StorageLayerException e) {

        }
         return employeesList.get(randomIndex).getEmployeeId();
    }

}
