import business.Customer;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import data.CustomerMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
            try (Statement stmt = fogTest.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS Customer");
                stmt.execute("CREATE TABLE Customer LIKE CustomerCopy");
                stmt.execute("INSERT INTO Customer SELECT * FROM CustomerCopy");
            }
            cm = new CustomerMapper(fogTest);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println( "Could not open connection to database: " + e.getMessage());
        }
    }
    
    @Rule public ExpectedException thrown = ExpectedException.none();
     
    @Test
    public void customerRegistrationIncorrectEmailFormatting() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
        thrown.expect(IncorrectEmailFormattingException.class);
        String email = "test@test.comewds";
        String password = "1234567";
        String firstName = "Tester";
        String lastName = "Testerton";
        String address = "Testerstreet 139";
        String phone = "90490302";
        cm.customerSignup(email, password, firstName, lastName, address, phone);
    }
    
//    @Test
//    public void customerRegistrationInsecurePassword() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
//        thrown.expect(InsecurePasswordException.class);
//        String email = "test@test.com";
//        String password = "123456";
//        String firstName = "Tester";
//        String lastName = "Testerton";
//        String address = "Testerstreet 139";
//        String phone = "90490302";
//        cm.customerSignup(email, password, firstName, lastName, address, phone);
//    }
//    
//    @Test
//    public void customerRegistrationEmailAlreadyInUse() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException {
//        thrown.expect(EmailAlreadyInUseException.class);
//        String email = "lovro@mail.com";
//        String password = "1234567";
//        String firstName = "Tester";
//        String lastName = "Testerton";
//        String address = "Testerstreet 139";
//        String phone = "90490302";
//        cm.customerSignup(email, password, firstName, lastName, address, phone);
//    }
}
