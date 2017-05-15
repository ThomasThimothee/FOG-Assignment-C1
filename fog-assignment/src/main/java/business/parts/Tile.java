package business.parts;

/**
 *
 * @author mathiasjepsen
 */
public class Tile extends Part {
    
    private String unit;
    
    public Tile(PartType partType, int quantity, String unit, double length, String name, String description) {
        super(partType, quantity, length, name, description);
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    @Override
    public String toString() {
        if (length == 0) {
            return quantity + "x " + unit + " " + name + "   -   " + description + ".\n";
        } else {
            return quantity + "x " + unit + " " + "x" + String.format("%.0f" , length) + " mm. " + name + "   -   " + description + ".\n"; 
        }
    }
}
