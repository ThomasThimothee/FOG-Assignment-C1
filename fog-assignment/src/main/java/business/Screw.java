package business;

/**
 *
 * @author mathiasjepsen
 */
public class Screw {
    
     private int quantity;
     private String scale;
     private String type;
     private String dimensions;
     private String description;

    public Screw(int quantity, String scale, String dimensions, String type, String description) {
        this.quantity = quantity;
        this.scale = scale;
        this.type = type;
        this.dimensions = dimensions;
        this.description = description;
    }

    @Override
    public String toString() {
        return quantity + "x " + scale + " " + dimensions + " " + type + "   -   " + description + ".\n";
    }
    
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
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
     
     
}
