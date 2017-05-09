package business;

import business.facades.EmployeeFacade;
import business.facades.OrderFacade;
import business.parts.Part;
import business.parts.Part.PartType;
import presentation.utility.RenderUtils;
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
        for (int i = 0; i < 10; i++)
        {
        System.out.println(EmployeeFacade.getRandomEmployeeId());
        }

    }
}
