package business;

/**
 *
 * @author mathiasjepsen
 */
public class Wood {
    
    private int quantity;
    private int length;
    private int width;
    private int depth;
    private String type;
    private String description;

    public Wood(int quantity, int width, int depth, int length, String type, String description) {
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return quantity + "x " + width + "x" + depth + " mm. " + type + ": " + length + "   -   " + description + ".\n";
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
}
