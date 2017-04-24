package business;

/**
 *
 * @author mathiasjepsen
 */
public class Screw extends Part {
    
    private String unit;

    public Screw(int quantity, String unit, double width, double depth, double length, String type, String description) {
        super(quantity, width, depth, length, type, description);
        this.unit = unit;
    }

    @Override
    public String toString() {
        if (length == 0 && width == 0 && depth == 0) {
            return quantity + "x " + unit + " " + type + "   -   " + description + ".\n";
        } else if (length == 0) {
            return quantity + "x " + unit + " " + String.format("%.1f" , width) + "x" + String.format("%.0f" , depth) + " mm. " + type + "   -   " + description + ".\n";
        } else {
            return quantity + "x " + unit + " " + String.format("%.0f" , width) + "x" + String.format("%.0f" , depth) + "x" + String.format("%.0f" , length) + " mm. " + type + "   -   " + description + ".\n"; 
        }
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
