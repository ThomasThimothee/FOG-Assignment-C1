package business;

/**
 *
 * @author thomasthimothee
 */
public abstract class Carport {
    
    protected String type;
    protected String roofType;
    protected double carportLength;
    protected double shedLength;
    protected double totalLength;
    protected double carportWidth;
    protected double shedWidth;
    protected double carportHeight;
    protected double roofHeight;
    protected Partlist partList;

    public Carport(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight) {
        this.type = type;
        this.roofType = roofType;
        this.carportLength = carportLength;
        this.shedLength = shedLength;
        this.totalLength = carportLength + shedLength;
        this.carportWidth = carportWidth;
        this.shedWidth = shedWidth;
        this.carportHeight = 210;
        this.roofHeight = roofHeight;
        this.partList = new Partlist();
    }
    
    abstract Partlist createPartList();
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the roofType
     */
    public String getRoofType() {
        return roofType;
    }

    /**
     * @param roofType the roofType to set
     */
    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    /**
     * @return the carportLength
     */
    public double getCarportLength() {
        return carportLength;
    }

    /**
     * @param carportLength the carportLength to set
     */
    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    /**
     * @return the shedLength
     */
    public double getShedLength() {
        return shedLength;
    }

    /**
     * @param shedLength the shedLength to set
     */
    public void setShedLength(double shedLength) {
        this.shedLength = shedLength;
    }

    /**
     * @return the carportWidth
     */
    public double getCarportWidth() {
        return carportWidth;
    }

    /**
     * @param carportWidth the carportWidth to set
     */
    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    /**
     * @return the shedWidth
     */
    public double getShedWidth() {
        return shedWidth;
    }

    /**
     * @param shedWidth the shedWidth to set
     */
    public void setShedWidth(double shedWidth) {
        this.shedWidth = shedWidth;
    }

    /**
     * @return the carportHeight
     */
    public double getCarportHeight() {
        return carportHeight;
    }

    /**
     * @param carportHeight the carportHeight to set
     */
    public void setCarportHeight(double carportHeight) {
        this.carportHeight = carportHeight;
    }

    /**
     * @return the roofHeight
     */
    public double getRoofHeight() {
        return roofHeight;
    }

    /**
     * @param roofHeight the roofHeight to set
     */
    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }
    
    public double getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(double totalLength) {
        this.totalLength = totalLength;
    }

    public Partlist getPartList() {
        return partList;
    }

    public void setPartList(Partlist partList) {
        this.partList = partList;
    } 
    
}
