import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.StorageLayerException;
import business.exceptions.WrongCustomerIDException;
import data.CustomerMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 *
 * @author mathiasjepsen
 */
public class CustomerMapperTests {

    private Connection fogTest;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ID = "fog";
    private static final String PW = "fog1234";
    private static final String DBNAME = "fogtest";
    private static final String HOST = "188.166.91.15";
    private CustomerMapper cm;

    public CustomerMapperTests() {

    }
    

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            fogTest = DriverManager.getConnection(url, ID, PW);
            try (Statement stmt = fogTest.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS Customer");
                stmt.execute("CREATE TABLE Customer LIKE CustomerCopy");
                stmt.execute("INSERT INTO Customer SELECT * FROM CustomerCopy");
            }
            cm = new CustomerMapper(fogTest);
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

    @Test(expected = IncorrectEmailFormattingException.class)
    public void customerSignupIncorrectEmailFormatting() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        String email = "test@test.comewds";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    @Test(expected = InsecurePasswordException.class)
    public void customerSignupInsecurePassword() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        String email = "test@test.com";
        String password = "123456";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    @Test(expected = EmailAlreadyInUseException.class)
    public void customerSignupEmailAlreadyInUse() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        String email = "lovro@mail.com";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }
    
    @Test (expected = WrongCustomerIDException.class)
    public void retrieveNonExistingCustomerDetails() throws WrongCustomerIDException, StorageLayerException {
        cm = new CustomerMapper(fogTest);
        int idCustomer = 500;
        cm.retrieveCustomerDetails(idCustomer);
    }
    
    @Test
    public void emailExistsTrue() throws EmailAlreadyInUseException, InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException {
        assertFalse(cm.emailExists("test@test.com"));
        String email = "test@test.com";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
        assertTrue(cm.emailExists(email));        
    }
    
    @Test
    public void setCustomerId() throws StorageLayerException, InsecurePasswordException, EmailAlreadyInUseException, IncorrectEmailFormattingException {
        String email = "test@test.com";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        Customer customer = new Customer(email, password, firstName, lastName, address, phone);
        cm.customerSignup(email, password, firstName, lastName, address, phone);
        assertThat(customer.getId_customer(), is(equalTo(0)));
        cm.setCustomerId(customer);
        assertThat(customer.getId_customer(), is(not(equalTo(0))));
    }
    
    @Test
    public void retrieveCustomerDetails() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException, WrongCustomerIDException {
        String email = "test@test.com";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
        Customer customer = new Customer(email, password, firstName, lastName, address, phone);
        cm.setCustomerId(customer);
        Customer customerDetails = cm.retrieveCustomerDetails(customer.getId_customer());
        assertThat(customerDetails.getAddress(), is(equalTo(address)));
        assertThat(customerDetails.getLastName(), is(equalTo(lastName)));
        assertThat(customerDetails.getPhone(), is(equalTo(phone)));
    }
}
