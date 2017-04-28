package business;

import business.parts.Part;
import java.util.Iterator;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 460, 380, 150, 210, 100);
        Partlist partlist = flat.createPartList();
        Iterator partIterator = partlist.getPartList().iterator();
        while (partIterator.hasNext()) {
            Part part = (Part) (partIterator.next());
            System.out.println(part.toString());
            if (part.getPartType() == Part.PartType.WOOD) {
                System.out.println("THIS IS WOOD");
            }
        }
    }
}
