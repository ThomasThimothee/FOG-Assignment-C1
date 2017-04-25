package business.Parts;

/**
 *
 * @author mathiasjepsen
 */
public class Wood extends Part {

    public Wood(PartType partType, int quantity, double width, double depth, double length, String name, String description) {
        super(partType, quantity, width, depth, length, name, description);
    }

    @Override
    public String toString() {
        return quantity + "x " + String.format("%.0f" , width) + "x" + String.format("%.0f" , depth) + " mm. " + name + ": " + String.format("%.0f" , length) + " cm.   -   " + description + ".\n";
    }
}
