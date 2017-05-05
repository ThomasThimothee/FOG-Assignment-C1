package business.utility;

import business.Partlist;

/**
 *
 * @author mathiasjepsen
 */
public class SVGUtils {

    private final double canvasWidth;
    private final double canvasHeight;
    private final double carportLength;
    private final double carportWidth;

    public SVGUtils(double width, double height, double carportLength, double carportWidth) {
        this.canvasWidth = width;
        this.canvasHeight = height;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
    }

    public String drawLine(double x1, double y1, double x2, double y2, int stroke) {
        return " <line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\"" + x2 + "\" y2=\"" + y2 + "\" style=\"fill:white;stroke:rgb(0,0,0);stroke-width:" + stroke + "\"/>";
    }
    
    public String drawRect(double x, double y, int stroke) {
        return " <rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + getCarportLength() + "\" height=\"" + getCarportWidth() + "\" style=\"fill:white;stroke:black;stroke-width:" + stroke + "\"/>";
    }
    
    public String drawFlatTopView(Partlist partlist) {
        int spærtræQuantity = partlist.getPartList().get(0).getQuantity() - 1;

        System.out.println(spærtræQuantity);
        double initialSpærtræIncrement = carportLength / spærtræQuantity;
        double spærtræIncrement = initialSpærtræIncrement;
        String s = drawRect(0, 0, 6);
        int i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement, getCarportWidth(), spærtræIncrement, 0, 4);
            spærtræIncrement += initialSpærtræIncrement;
            i++;
        }
        return s;
    }

    public double getCanvasWidth() {
        return canvasWidth;
    }

    public double getCanvasHeight() {
        return canvasHeight;
    }

    public double getCarportLength() {
        return carportLength;
    }

    public double getCarportWidth() {
        return carportWidth;
    }
    
    

}
