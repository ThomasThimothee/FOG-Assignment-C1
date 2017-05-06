package business.utility;

import business.Carport;

/**
 *
 * @author mathiasjepsen
 */
public class SVGUtils {
    
    private final double xOffset = 90;
    private final double yOffset = 50;

    private String drawLine(double x1, double y1, double x2, double y2, int stroke) {
        return " <line x1=\"" + (x1 + xOffset) + "\" y1=\"" + (y1 + yOffset) + "\" x2=\"" + (x2 + xOffset) + "\" y2=\"" + (y2 + yOffset) + "\" style=\"fill:white;stroke:rgb(0,0,0);stroke-width:" + stroke / 2 + "\"/>";
    }
    
    private String drawRect(double x, double y, double width, double height, int stroke) {
        return " <rect x=\"" + (x + xOffset) + "\" y=\"" + (y + yOffset) + "\" width=\"" + width / 2 + "\" height=\"" + height / 2 + "\" style=\"fill:black;stroke:black;stroke-width:" + stroke / 2 + "\"/>";
    }
    
    private String drawText(double dimensions, double x, double y, String transform) {
        return " <text x=\"" + (x + xOffset) + "\" y=\"" + (y + yOffset) + "\" fill=\"black\" transform=\"" + transform + "\">" + String.format("%.2f", (double) dimensions / 100) + "</text>";
    }
    
    private String drawCarportSides(double x, double y, double width, double height, int stroke) {
        return " <rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" style=\"fill:white;stroke:black;stroke-width:" + stroke + "\"/>";
    }
    
    public String drawFlatTopView(Carport carport) {
        double sWidth = carport.getShedWidth();
        double cWidth = carport.getCarportWidth();
        double tLength = carport.getTotalLength();
        double cLength = carport.getCarportLength();
        int spærtræQuantity = carport.getPartList().getPartList().get(0).getQuantity() - 1;
        double initialSpærtræIncrement = tLength / spærtræQuantity;
        double spærtræIncrement = initialSpærtræIncrement;
        String s = drawCarportSides(xOffset, yOffset, tLength, cWidth, 4);
        int i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement, cWidth, spærtræIncrement, 0, 4);
            spærtræIncrement += initialSpærtræIncrement;
            i++;
        }
        // 'Remme' in the sides
        s += drawLine(0, (sWidth + ((cWidth - sWidth) / 2)), tLength, (sWidth + ((cWidth - sWidth) / 2)), 8);
        s += drawLine(0, ((cWidth - sWidth) / 2), tLength, ((cWidth - sWidth) / 2), 8);
        
        // Shed walls
        s += drawLine(cLength, (sWidth + ((cWidth - sWidth) / 2)), cLength, ((cWidth - sWidth) / 2), 8);
        s += drawLine(tLength - (initialSpærtræIncrement / 2), (cWidth - ((cWidth - sWidth) / 2)), tLength - (initialSpærtræIncrement / 2), ((cWidth - sWidth) / 2), 8);
        
        // Middle cross
        s += drawLine(cLength, cWidth - ((cWidth - sWidth) / 2), initialSpærtræIncrement, ((cWidth - sWidth) / 2), 8);
        s += drawLine(cLength, ((cWidth - sWidth) / 2), initialSpærtræIncrement, cWidth - ((cWidth - sWidth) / 2), 8);
        
        // 'Stolper'
        double firstStolpeX = cLength * 0.18; 
        double secondStolpeX = cLength * 0.78;
        s += drawRect(firstStolpeX, ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        s += drawRect(secondStolpeX, ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        
        s += drawRect(firstStolpeX, cWidth - ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        s += drawRect(secondStolpeX, cWidth - ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        
        s += drawRect(cLength - 4, cWidth - ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        s += drawRect(tLength - (initialSpærtræIncrement / 2) - 4, cWidth - ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        
        s += drawRect(cLength  - 4, ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        s += drawRect(tLength - (initialSpærtræIncrement / 2) - 4, ((cWidth - sWidth) / 2) - 4, 16, 16, 8);
        
        s += drawRect(cLength - 4, (cWidth / 2) - 4, 16, 16, 8);
        s += drawRect(tLength - (initialSpærtræIncrement / 2) - 4, (cWidth / 2) - 4, 16, 16, 8);
        
        // Top dimensions
        spærtræIncrement = initialSpærtræIncrement;
        s += drawLine(0, -10, 0, -20, 2);
        s += drawText((initialSpærtræIncrement), (initialSpærtræIncrement / 4), -10, "");
        i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement, -10, spærtræIncrement, -20, 2);
            if (i < spærtræQuantity - 1) {
                s += drawText((initialSpærtræIncrement), ((initialSpærtræIncrement / 4) + spærtræIncrement), -10, "");
            }
            spærtræIncrement += initialSpærtræIncrement;
            i++;
        }
        
        // Bottom dimensions
        s += drawLine(0, cWidth + 30, 0, cWidth + 20, 2);
        s += drawLine(tLength, cWidth + 30, tLength, cWidth + 20, 2);
        s += drawLine(0, cWidth + 30, tLength, cWidth + 30, 2);
        s += drawText(tLength, (tLength / 2), cWidth + 20, "");
        
        // Left outer dimensions
        s += drawLine(-10, 0, -70, 0, 2);
        s += drawLine(-10, cWidth, -70, cWidth, 2);
        s += drawLine(-70, 0, -70, cWidth, 2);
        s += drawText(cWidth, (-(xOffset * 2) + (xOffset - yOffset)) - (cWidth / 2), -10, "rotate(-90, 0, 0)");
        
        // Left inner dimensions
        s += drawLine(-10, ((cWidth - sWidth) / 2), -40, ((cWidth - sWidth) / 2), 2);
        s += drawLine(-10, cWidth - ((cWidth - sWidth) / 2), -40, cWidth - ((cWidth - sWidth) / 2), 2);
        s += drawLine(-40, ((cWidth - sWidth) / 2), -40, cWidth - ((cWidth - sWidth) / 2), 2);
        s += drawText(sWidth, (-(xOffset * 2) + (xOffset - yOffset)) - (cWidth / 2), 20, "rotate(-90, 0, 0)");
        
        return s;
    }
}
