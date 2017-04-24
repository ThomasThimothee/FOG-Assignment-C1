package business;

/**
 *
 * @author mathiasjepsen
 */
public class Wood extends Part {

    public Wood(int quantity, int width, int depth, int length, String type, String description) {
        super(quantity, width, depth, length, type, description);
    }

    @Override
    public String toString() {
        return quantity + "x " + String.format("%.0f" , width) + "x" + String.format("%.0f" , depth) + " mm. " + type + ": " + String.format("%.0f" , length) + " cm.   -   " + description + ".\n";
    }
}
