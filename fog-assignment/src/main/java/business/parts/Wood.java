package business.parts;

/**
 *
 * @author mathiasjepsen
 */
public class Wood extends Part {

    public Wood(PartType partType, int quantity, double length, String name, String description) {
        super(partType, quantity, length, name, description);
    }

    @Override
    public String toString() {
        return quantity + "x " + name + ": " + String.format("%.0f" , length) + " cm.   -   " + description + ".\n";
    }
}
