package business;

/**
 *
 * @author mathiasjepsen
 */
public class Wood {
    
    private int quantity;
    private int length;
    private String dimensions;
    private String type;
    private String description;

    public Wood(int quantity, String dimensions, String type, int length, String description) {
        this.quantity = quantity;
        this.length = length;
        this.dimensions = dimensions;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return quantity + "x " + dimensions + " " + type + ": " + length + "   -   " + description + ".\n";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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
