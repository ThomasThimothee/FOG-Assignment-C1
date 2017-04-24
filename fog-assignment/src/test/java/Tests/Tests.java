package Tests;

import business.Flat;
import business.Partlist;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mathiasjepsen
 */
public class Tests {
    
    Flat flat;
    Partlist partlist;
    
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        flat = new Flat("Flat", "Plastmo Ecolite Blue", 250, 160, 300, 150, 100);
        partlist = flat.createPartList();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void hello() {
        assertEquals(360, partlist.getWoodParts().get(0).getLength());
    }
}
