package business;

/**
 *
 * @author mathiasjepsen
 */
public class Screw {
    
     private int quantity;
     private String unit;
     private String type;
     private double width;
     private double depth;
     private double length;
     private String description;

    public Screw(int quantity, String scale, double width, double depth, double length, String type, String description) {
        this.quantity = quantity;
        this.unit = scale;
        this.type = type;
        this.description = description;
        this.width = width;
        this.depth = depth;
        this.length = length;
    }

    @Override
    public String toString() {
        if (getLength() == 0) {
            return quantity + "x " + unit + " " + width + "x" + depth + " mm. " + type + "   -   " + description + ".\n";
        } else {
            return quantity + "x " + unit + " " + width + "x" + depth + "x" + length + " mm. " + type + "   -   " + description + ".\n"; 
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScale() {
        return unit;
    }

    public void setScale(String scale) {
        this.unit = scale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    
     
}
