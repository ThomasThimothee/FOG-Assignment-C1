import data.CustomerMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathiasjepsen
 */
public class CustomerMapperTests {
    
    Connection fogTest;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ID = "fogtest";
    private static final String PW = "fogtest1234";
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
                stmt.execute( "DROP TABLE IF EXISTS Customer");
                stmt.execute( "CREATE TABLE Customer LIKE testCustomer");
                stmt.execute( "INSERT INTO Customer SELECT * FROM testCustomer");
            }
            cm = new CustomerMapper();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println( "Could not open connection to database: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
        System.out.println( "SetUpOK" );
        assertNotNull("Setup failed", con);
     }
}
