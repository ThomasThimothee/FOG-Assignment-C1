import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.StorageLayerException;
import data.CustomerMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mathiasjepsen
 */
public class CustomerMapperTests {

    Connection fogTest;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ID = "fog";
    private static final String PW = "fog1234";
    private static final String DBNAME = "fogtest";
    private static final String HOST = "188.166.91.15";
    CustomerMapper cm;

    public CustomerMapperTests() {

    }

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            fogTest = DriverManager.getConnection(url, ID, PW);
            System.out.println("TESTING SETUP");
            try (Statement stmt = fogTest.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS Customer");
                stmt.execute("CREATE TABLE Customer LIKE CustomerCopy");
                stmt.execute("INSERT INTO Customer SELECT * FROM CustomerCopy");
            }
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
    public void customerRegistrationIncorrectEmailFormatting() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        cm = new CustomerMapper(fogTest);
        String email = "test@test.comewds";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    @Test(expected = InsecurePasswordException.class)
    public void customerRegistrationInsecurePassword() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        cm = new CustomerMapper(fogTest);
        String email = "test@test.com";
        String password = "123456";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }

    @Test(expected = EmailAlreadyInUseException.class)
    public void customerRegistrationEmailAlreadyInUse() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        cm = new CustomerMapper(fogTest);
        String email = "lovro@mail.com";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }
}
