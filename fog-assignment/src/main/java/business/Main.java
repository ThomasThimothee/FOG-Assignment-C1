package business;

import business.exceptions.StorageLayerException;
import business.facades.EmployeeFacade;
import business.facades.OrderFacade;
import business.parts.Part;
import business.parts.Part.PartType;
import data.DataMapper;
import presentation.utility.RenderUtils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class Main {


    public static void main(String[] args) throws StorageLayerException {
        Partlist partlist = new Partlist();
        Part part1 = new Part(PartType.WOOD, 23,  352, "25x200 mm. trykimp. Braet", "understernbraedder til siderne");
        Part part2 = new Part(PartType.WOOD, 24, 353, "38x73 mm. Laegte", "til Z pa bagside af dor");
        partlist.getPartList().add(part1);
        partlist.getPartList().add(part2);
          
        OrderFacade.createOrderLines2(partlist, 47);
         }


}
