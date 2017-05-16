import business.Customer;
import data.CustomerMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathiasjepsen
 */
public class CustomerTests {
    
    CustomerMapper cm;
    Customer customer;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void customerLoginTest() {
         
         
         
//         try {
//            customer = cm.customerLogin("lovro@mail.com", "1234567");
//         } catch (StorageLayerException e) {
//             System.out.println("Something horrible went wrong.");
//         } catch (InvalidUsernameOrPasswordException e) {
//             System.out.println("Wrong username or password.");
//         }  
//         assertEquals(customer.getEmail(), "lovro@mail.com");
     }
}
