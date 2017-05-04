package business;

import business.facades.OrderFacade;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class Main {

    public static void main(String[] args) {
       OrderFacade.createOrderline("universal venstre", 12, 0, 2, "understernbrædder til siderne", 15.00);
    }
}
