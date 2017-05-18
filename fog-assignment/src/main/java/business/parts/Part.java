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
    protected String name;
    protected String description;
    protected int price;
    private int carportId;

    public Part(PartType partType, int quantity, double length, String name, String description) {
        this.partType = partType;
        this.quantity = quantity;
        this.length = length;
        this.name = name;
        this.description = description;
    }

    public int getCarportId() {
        return carportId;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
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

    public double partPrice(double standardPrice) {
        double price = 0;
        switch (this.partType) {
            case WOOD:
                price = standardPrice * this.length * this.quantity;
                break;

            case SCREW:
                price = standardPrice * this.quantity;;
                break;

            case TILE:
                price = standardPrice * this.quantity;
                break;
            default:
                price = 0;
                break;
        }

        return price;
    }
}
