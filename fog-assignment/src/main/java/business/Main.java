package business;

import business.facades.OrderFacade;
import business.parts.Part;
import business.parts.Part.PartType;
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
        Pointy pointy = new Pointy("Flat", "test", 540, 340, 120, 140, 0, 15);
        Partlist partList = pointy.createPartList();
        
        OrderFacade.createOrderLines(partList, 21);

    }
}
