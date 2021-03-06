
import business.Employee;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.EmployeeMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lovro
 */
public class EmployeeMapperTests {

    private Connection fogTest;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ID = "fog";
    private static final String PW = "fog1234";
    private static final String DBNAME = "fogtest";
    private static final String HOST = "188.166.91.15";
    private EmployeeMapper em;

    public EmployeeMapperTests() {
    }

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            fogTest = DriverManager.getConnection(url, ID, PW);
            try (Statement stmt = fogTest.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS `SalesRep`;");
                stmt.execute("CREATE TABLE `SalesRep` LIKE `SalesRepCopy`;");
                stmt.execute("INSERT INTO SalesRep SELECT * FROM SalesRepCopy");
            }
            em = new EmployeeMapper(fogTest);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not open connection to database: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            fogTest.close();
        } catch (SQLException ex) {
            System.out.println("Failed to close fogTest - " + ex.getMessage());
            Logger.getLogger(OrderMapperTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void employeeLoginSuccess() throws InsecurePasswordException, StorageLayerException, InvalidUsernameOrPasswordException {
        String username = "overlord";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String email = "lovro@mail.com";
        String phone = "90490302";
        em.employeeSignup(username, password, firstName, lastName, phone, email);
        Employee employee = em.employeeLogin(username, password);
        assertEquals(username, employee.getUsername());
        assertEquals(email, employee.getEmail());
    }

    @Test(expected = InvalidUsernameOrPasswordException.class)
    public void employeeLoginIncorrectUsername() throws InvalidUsernameOrPasswordException, StorageLayerException {
        String username = "lovro";
        String password = "1234";
        em.employeeLogin(username, password);
    }

    @Test
    public void retrieveEmployee() throws StorageLayerException {
        ArrayList<Employee> list;
        list = em.retrieveAllEmployees();
        assertNotEquals(new ArrayList<>(0), list);
    }
}
