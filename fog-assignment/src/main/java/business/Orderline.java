package business;

/**
 *
 * @author Lovro
 */
public class Orderline {

    private int idOrder;
    private String partName;
    private int length;
    private int quantity;
    private String explanation;
    private double price;
   
    public Orderline(String partName, int length, int quantity, String explanation, double price) {
        this.partName = partName;
        this.length = length;
        this.quantity = quantity;
        this.explanation = explanation;
        this.price = price;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Part Name: " + this.getPartName()
                + ", Length: " + this.getLength()
                + ", quantity: " + this.getQuantity()
                + ", explanation: " + this.getExplanation()
                + ", price: " + this.getPrice();
    }
}
