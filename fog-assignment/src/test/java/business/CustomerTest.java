/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public class CustomerTest {

    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    Customer customer = new Customer("test@mail.com", "testpass", "Tester", "Testerino", "TestAddress", "2457275");

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        Customer customer = new Customer("test@mail.com", "testpass", "Tester", "Testerino", "TestAddress", "2457275");
        String expResult = "test@mail.com";
        String result = customer.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        Customer customer = new Customer("test@mail.com", "testpass", "Tester", "Testerino", "TestAddress", "2457275");
        String email = "newEmail";
        assertEquals("test@mail.com", customer.getEmail());
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        Customer customer = new Customer("test@mail.com", "testpass", "Tester", "Testerino", "TestAddress", "2457275");
        String expResult = "testpass";
        String result = customer.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Customer.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        Customer customer = new Customer("test@mail.com", "testpass", "Tester", "Testerino", "TestAddress", "2457275"); 
        String password = "newPassword";
        assertEquals("testpass", customer.getPassword());
        customer.setPassword(password);
        assertEquals(password, customer.getPassword());
    }

}
