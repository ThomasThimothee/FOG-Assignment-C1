package business;

import java.util.Iterator;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 250, 160, 300, 150, 100);
        Partlist partlist = flat.createPartList();
        Iterator woodIterator = partlist.getWoodParts().iterator();
        while (woodIterator.hasNext()) {
            Wood wood  = (Wood) (woodIterator.next());
            System.out.println(wood.toString());
        }
        Iterator screwIterator = partlist.getScrewParts().iterator();
        while (screwIterator.hasNext()) {
            Screw screw = (Screw) (screwIterator.next());
            System.out.println(screw.toString());
        }
    }
    
}
