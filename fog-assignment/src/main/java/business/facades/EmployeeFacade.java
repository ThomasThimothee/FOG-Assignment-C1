package business.facades;

import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.DataMapper;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lovro
 */
public class EmployeeFacade {

    public static Employee getEmployee(String username, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        DataMapper dm = new DataMapper();
        return dm.employeeLogin(username, password);
    }

    public static void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws InvalidUsernameOrPasswordException, InsecurePasswordException, StorageLayerException {
        DataMapper dm = new DataMapper();
        dm.employeeSignup(username, password, fistName, lastName, phone, email);
    }

    public static int getRandomEmployeeId() throws StorageLayerException {
        ArrayList<Employee> employeesList = new ArrayList<>();
        int randomIndex = 0;
        DataMapper dm = new DataMapper();
        employeesList = dm.retrieveAllEmployees();
        Random r = new Random();
        randomIndex = r.nextInt(employeesList.size());
        return employeesList.get(randomIndex).getEmployeeId();
    }

}
