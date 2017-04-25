package business.Parts;

/**
 *
 * @author mathiasjepsen
 */
public class Part {
    
    protected int quantity;
    protected double length;
    protected double width;
    protected double depth;
    protected String type;
    protected String description;

    public Part(int quantity, double width, double depth, double length, String type, String description) {
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.type = type;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
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
