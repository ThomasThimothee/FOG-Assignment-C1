package business;

/**
 *
 * @author mathiasjepsen
 */
public class Pointy extends Carport {
    
    private double angle;
    
    public Pointy(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight, double angle) {
        super(type, roofType, carportLength, shedLength, carportWidth, shedWidth, roofHeight);
        this.angle = angle;
    }

//    
//    public String createPartList() {
//        
//    }
//    
    
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    
    
    
}
