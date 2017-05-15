package business.facades;

import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.EmployeeMapper;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lovro
 */
public class EmployeeFacade {

    public static Employee getEmployee(String username, String password) throws InvalidUsernameOrPasswordException, StorageLayerException {
        EmployeeMapper em = new EmployeeMapper();
        return em.employeeLogin(username, password);
    }

    public static void createEmployee(String username, String password, String fistName, String lastName, String phone, String email) throws InvalidUsernameOrPasswordException, InsecurePasswordException, StorageLayerException {
        EmployeeMapper em = new EmployeeMapper();
        em.employeeSignup(username, password, fistName, lastName, phone, email);
    }

    public static int getRandomEmployeeId() throws StorageLayerException {
        ArrayList<Employee> employeesList;
        int randomIndex;
        EmployeeMapper em = new EmployeeMapper();
        employeesList = em.retrieveAllEmployees();
        Random r = new Random();
        randomIndex = r.nextInt(employeesList.size());
        return employeesList.get(randomIndex).getEmployeeId();
    }

}
