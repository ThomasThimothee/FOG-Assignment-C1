package business.parts;

/**
 *
 * @author mathiasjepsen
 */
public class Part {
    
    public enum PartType {
        WOOD,
        SCREW,
        TILE;
    }
    protected PartType partType;
    protected int quantity;
    protected double length;
    protected double width;
    protected double depth;
    protected String name;
    protected String description;

    public Part(PartType partType, int quantity, double width, double depth, double length, String name, String description) {
        this.partType = partType;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }
    
    
    
}
