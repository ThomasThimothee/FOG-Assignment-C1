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

    
//    public String createPartList() {
//        StringBuilder sb = new StringBuilder();
//
//        // A
//        if (carportWidth <= 240 && carportWidth >= 240) {
//            sb.append("1x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
//        } else if (carportWidth <= 360 && carportWidth > 270) {
//            sb.append("2x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til for- & bagende.\n");
//        } else if (carportWidth <= 540 && carportWidth > 360) {
//            sb.append("2x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
//        } else if (carportWidth <= 720 && carportWidth > 540) {
//            sb.append("4x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til for- & bagende.\n");
//        } else if (carportWidth > 720) {
//            sb.append("4x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
//        }
//    }
    
    
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    
    
    
}
