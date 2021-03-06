package presentation.utility;

import business.Flat;
import business.Pointy;

/**
 *
 * @author mathiasjepsen
 */
public class SVGUtils {
    
    private final double xOffset = 90;
    private final double yOffset = 50;

    private String drawLine(double x1, double y1, double x2, double y2, int stroke) {
        return " <line x1=\"" + (x1 + getxOffset()) + "\" y1=\"" + (y1 + getyOffset()) + "\" x2=\"" + (x2 + getxOffset()) + "\" y2=\"" + (y2 + getyOffset()) + "\" style=\"fill:white;stroke:rgb(0,0,0);stroke-width:" + stroke / 2 + "\"/>";
    }
    
    private String drawRect(double x, double y, double width, double height, int stroke) {
        return " <rect x=\"" + (x + getxOffset()) + "\" y=\"" + (y + getyOffset()) + "\" width=\"" + width / 2 + "\" height=\"" + height / 2 + "\" style=\"fill:black;stroke:black;stroke-width:" + stroke / 2 + "\"/>";
    }
    
    private String drawText(double dimensions, double x, double y, String transform) {
        return " <text x=\"" + (x + getxOffset()) + "\" y=\"" + (y + getyOffset()) + "\" fill=\"black\" transform=\"" + transform + "\">" + String.format("%.2f", (double) dimensions / 100) + "</text>";
    }
    
    private String drawCarportSides(double x, double y, double width, double height, int stroke) {
        return " <rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" style=\"fill:white;stroke:black;stroke-width:" + stroke + "\"/>";
    }
    
    private String drawSpær(Flat flat, int spærtræQuantity, double initialSpærtræIncrement) {
        String s = "";
        double increment = initialSpærtræIncrement;
        int i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(increment, flat.getCarportWidth(), increment, 0, 4);
            increment += initialSpærtræIncrement;
            i++;
        }
        return s;
    }
    
    private String drawRemme(String s, double sWidth, double cWidth, double tLength, double cLength, double initialSpærtræIncrement) {
        s += drawLine(0, (sWidth + ((cWidth - sWidth) / 2)), tLength, (sWidth + ((cWidth - sWidth) / 2)), 8);
        s += drawLine(0, ((cWidth - sWidth) / 2), tLength, ((cWidth - sWidth) / 2), 8);
        s += drawLine(cLength, (sWidth + ((cWidth - sWidth) / 2)), cLength, ((cWidth - sWidth) / 2), 8);
        s += drawLine(tLength - (initialSpærtræIncrement / 2), (cWidth - ((cWidth - sWidth) / 2)), tLength - (initialSpærtræIncrement / 2), ((cWidth - sWidth) / 2), 8);
        s += drawLine(cLength, cWidth - ((cWidth - sWidth) / 2), initialSpærtræIncrement, ((cWidth - sWidth) / 2), 8);
        s += drawLine(cLength, ((cWidth - sWidth) / 2), initialSpærtræIncrement, cWidth - ((cWidth - sWidth) / 2), 8);
        return s;
    }
    
    private String drawStolper(double cLength, String s, double cWidth, double sWidth, double tLength, double initialSpærtræIncrement) {
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
        return s;
    }
    
    private String drawTopDimensions(double spærtræIncrement, double initialSpærtræIncrement, String s, int spærtræQuantity) {
        // Top dimensions
        spærtræIncrement = initialSpærtræIncrement;
        s += drawLine(0, -10, 0, -20, 2);
        s += drawText((initialSpærtræIncrement), (initialSpærtræIncrement / 4), -10, "");
        int i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement, -10, spærtræIncrement, -20, 2);
            if (i < spærtræQuantity - 1) {
                s += drawText((initialSpærtræIncrement), ((initialSpærtræIncrement / 4) + spærtræIncrement), -10, "");
            }
            spærtræIncrement += initialSpærtræIncrement;
            i++;
        }
        return s;
    }
    
    private String drawLeftOuterDimensions(String s, double cWidth) {
        // Left outer dimensions
        s += drawLine(-10, 0, -70, 0, 2);
        s += drawLine(-10, cWidth, -70, cWidth, 2);
        s += drawLine(-70, 0, -70, cWidth, 2);
        s += drawText(cWidth, (-(xOffset * 2) + (getxOffset() - getyOffset())) - (cWidth / 2), -10, "rotate(-90, 0, 0)");
        return s;
    }
     
    private String drawBottomDimensions(String s, double cWidth, double tLength) {
        // Bottom dimensions
        s += drawLine(0, cWidth + 30, 0, cWidth + 20, 2);
        s += drawLine(tLength, cWidth + 30, tLength, cWidth + 20, 2);
        s += drawLine(0, cWidth + 30, tLength, cWidth + 30, 2);
        s += drawText(tLength, (tLength / 2), cWidth + 20, "");
        return s;
    }
    
    private String drawLeftInnerDimensions(String s, double cWidth, double sWidth) {
        // Left inner dimensions
        s += drawLine(-10, ((cWidth - sWidth) / 2), -40, ((cWidth - sWidth) / 2), 2);
        s += drawLine(-10, cWidth - ((cWidth - sWidth) / 2), -40, cWidth - ((cWidth - sWidth) / 2), 2);
        s += drawLine(-40, ((cWidth - sWidth) / 2), -40, cWidth - ((cWidth - sWidth) / 2), 2);
        s += drawText(sWidth, (-(xOffset * 2) + (getxOffset() - getyOffset())) - (cWidth / 2), 20, "rotate(-90, 0, 0)");
        return s;
    }
    
    public String drawFlatTopView(Flat flat) {
        double sWidth = flat.getShedWidth();
        double cWidth = flat.getCarportWidth();
        double tLength = flat.getTotalLength();
        double cLength = flat.getCarportLength();
        // Carport sides
        String s = drawCarportSides(getxOffset(), getyOffset(), tLength, cWidth, 4);
        
        // 'Spær' 
        int spærtræQuantity = flat.getPartList().get(9).getQuantity() - 1;
        double initialSpærtræIncrement = flat.getTotalLength() / spærtræQuantity;
        double spærtræIncrement = initialSpærtræIncrement;
        s += drawSpær(flat, spærtræQuantity, initialSpærtræIncrement);
        
        // 'Remme'
        s += drawRemme(s, sWidth, cWidth, tLength, cLength, initialSpærtræIncrement);
        
        // 'Stolper'
        s += drawStolper(cLength, s, cWidth, sWidth, tLength, initialSpærtræIncrement);
        
        // Top dimensions
        s += drawTopDimensions(spærtræIncrement, initialSpærtræIncrement, s, spærtræQuantity);
        
        // Bottom dimensions
        s += drawBottomDimensions(s, cWidth, tLength);
        
        // Left outer dimensions
        s += drawLeftOuterDimensions(s, cWidth);
        
        // Left inner dimensions
        s += drawLeftInnerDimensions(s, cWidth, sWidth);
        
        return s;
    }

    public String drawPointyTopView(Pointy pointy) {
        double sWidth = pointy.getShedWidth();
        double sLength = pointy.getShedLength();
        double cWidth = pointy.getCarportWidth();
        double tLength = pointy.getTotalLength();
        double cLength = pointy.getCarportLength();
        
        // Carport sides
        String s = drawCarportSides(getxOffset(), getyOffset(), tLength, cWidth, 4);
        
        // 'Spær'
        int spærtræQuantity = 5;
        double initialSpærtræIncrement = cLength / spærtræQuantity;
        double initialOffset = (cLength - (initialSpærtræIncrement / 2)) / spærtræQuantity;
        double spærtræIncrement = initialOffset;
        int i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement - (initialOffset / 2), cWidth, spærtræIncrement - (initialOffset / 2), 0, 4);
            spærtræIncrement += initialOffset;
            i++;
        }
        s += drawLine(cLength, cWidth, cLength, 0, 4);
        s += drawLine(cLength + ((sLength / 2) - (initialSpærtræIncrement / 4)), cWidth, cLength + ((sLength / 2) - (initialSpærtræIncrement / 4)), 0, 4);
        s += drawLine(tLength - (initialSpærtræIncrement / 2), cWidth, tLength - (initialSpærtræIncrement / 2), 0, 4);
        
        // 'Remme' in the sides
        s += drawLine(0 + (initialOffset / 2), (sWidth + ((cWidth - sWidth) / 2)), tLength - (initialOffset / 2), (sWidth + ((cWidth - sWidth) / 2)), 10);
        s += drawLine(0 + (initialOffset / 2), ((cWidth - sWidth) / 2), tLength - (initialOffset / 2), ((cWidth - sWidth) / 2), 10);
        
        // Shed walls
        s += drawLine(cLength, (sWidth + ((cWidth - sWidth) / 2)), cLength, ((cWidth - sWidth) / 2), 10);
        s += drawLine(tLength - (initialSpærtræIncrement / 2), (cWidth - ((cWidth - sWidth) / 2)), tLength - (initialSpærtræIncrement / 2), ((cWidth - sWidth) / 2), 10);
        
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
        
        // Horizontal beams
        double initialBeamIncrement = cWidth / 8;
        double beamIncrement = initialBeamIncrement;
        i = 0;
        while (i < 8) {
            s += drawLine(0, beamIncrement, tLength, beamIncrement, 6);
            beamIncrement += initialBeamIncrement;
            i++;
        }
        s += drawLine(0, (cWidth / 2) - 4, tLength, (cWidth / 2) - 4, 6);
        s += drawLine(0, (cWidth / 2) + 4, tLength, (cWidth / 2) + 4, 6);
        
        // Top dimensions
        spærtræIncrement = initialOffset;
        s += drawLine(0 + (initialOffset / 2), -10, 0 + (initialOffset / 2), -20, 2);
        s += drawText(initialOffset, (initialOffset / 4) + (initialOffset / 2), -10, "");
        i = 0;
        while (i < spærtræQuantity) {
            s += drawLine(spærtræIncrement + (initialOffset / 2), -10, spærtræIncrement + (initialOffset / 2), -20, 2);
            if (i < spærtræQuantity - 1) {
                s += drawText(initialOffset, ((initialOffset / 4) + (initialOffset / 2) + spærtræIncrement), -10, "");
            }
            spærtræIncrement += initialOffset;
            i++;
        }
        s += drawLine(cLength + ((sLength / 2) - (initialSpærtræIncrement / 4)), -10, cLength + ((sLength / 2) - (initialSpærtræIncrement / 4)), -20, 2);
        s += drawLine(tLength - (initialSpærtræIncrement / 2), -10, tLength - (initialSpærtræIncrement / 2), -20, 2 );
        s += drawText((sLength / 2), cLength + ((sLength / 4) - (initialSpærtræIncrement / 4)), -10, "");
        s += drawText((sLength / 2), cLength + ((sLength / 2) + ((sLength / 8)) - (initialSpærtræIncrement / 4)), -10, "");
        
        // Bottom dimensions
        s = drawBottomDimensions(s, cWidth, tLength);
        
        // Left outer dimensions
        s = drawLeftOuterDimensions(s, cWidth);
        
        // Left inner dimensions
        s = drawLeftInnerDimensions(s, cWidth, sWidth);
        
        return s;
    }

    public double getxOffset() {
        return xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }
    
}
