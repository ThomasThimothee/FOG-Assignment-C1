import business.Order;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import data.OrderMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathiasjepsen
 */
public class OrderMapperTests {

    Connection fogTest;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ID = "fog";
    private static final String PW = "fog1234";
    private static final String DBNAME = "fogtest";
    private static final String HOST = "188.166.91.15";
    OrderMapper om;

    public OrderMapperTests() {

    }

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            fogTest = DriverManager.getConnection(url, ID, PW);
            try (Statement stmt = fogTest.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS `Order`, `Orderline`, `Part`;");
                stmt.execute("CREATE TABLE `Order` LIKE `OrderCopy`;");
                stmt.execute("CREATE TABLE `Orderline` LIKE `OrderlineCopy`;");
                stmt.execute("CREATE TABLE `Part` LIKE `PartCopy`;");
                stmt.execute("INSERT INTO `Part` SELECT * FROM `PartCopy`;");
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

    @Test
    public void orderMapperCreateOrder() throws InsecurePasswordException, IncorrectEmailFormattingException, StorageLayerException, EmailAlreadyInUseException, InvalidOrderIdException {
        om = new OrderMapper(fogTest);
        int customerId = 10;
        int salesRepId = 7;
        Date dateJava = new java.util.Date();
        Timestamp dateSql = new Timestamp(dateJava.getTime()); 
        String carportType = "Flat";
        String roofType = "Plastmo Ecolite Blue";
        int carportWidth = 600;
        int carportLength = 570;
        int shedWidth = 570;
        int shedLength = 210;
        double angle = 0;
        boolean status = false;
        double price = 0.00;
        om.createOrder(customerId, salesRepId, dateSql, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
        int orderId = om.retrieveOrderId(customerId, dateSql);
        Order order = om.retrieveOrder(orderId);
        assertEquals(order.getCustomerId(), 10);
    }
    
    @Test(expected = InvalidOrderIdException.class)
    public void orderMapperInvalidOrderId() throws StorageLayerException, InvalidOrderIdException  {
        om = new OrderMapper(fogTest);
        int customerId = 11;
        int salesRepId = 7;
        Date dateJava = new java.util.Date();
        Timestamp dateSql = new Timestamp(dateJava.getTime()); 
        String carportType = "Flat";
        String roofType = "Plastmo Ecolite Blue";
        int carportWidth = 600;
        int carportLength = 570;
        int shedWidth = 570;
        int shedLength = 210;
        double angle = 0;
        boolean status = false;
        double price = 0.00;
        om.createOrder(customerId, salesRepId, dateSql, carportType, roofType, carportWidth, carportLength, shedWidth, shedLength, angle, status, price);
        int orderId = om.retrieveOrderId(customerId, dateSql);
        Order order = om.retrieveOrder(orderId + 99999);
    }
}
