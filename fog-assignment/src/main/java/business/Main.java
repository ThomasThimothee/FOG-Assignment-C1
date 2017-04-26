package business;

import business.Parts.Part;
import java.util.Iterator;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 460, 380, 180, 150, 100);
        Partlist partlist = flat.createPartList();
        Iterator partIterator = partlist.getPartList().iterator();
        while (partIterator.hasNext()) {
            Part part = (Part) (partIterator.next());
            System.out.println(part.toString());
        }
    }
}
