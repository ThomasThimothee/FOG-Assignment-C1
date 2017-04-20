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

    public String createPartList() {
        StringBuilder sb = new StringBuilder();

        // A
        sb.append("2x 25x150 mm. trykimp. brædt: 480   -   vindskeder på rejsning.\n");

        // B
        if (carportLength == 240) {
            sb.append("1x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 270 && carportLength > 240) {
            sb.append("1x 25x150 mm. trykimp. brædt: 540   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 300 && carportLength > 270) {
            sb.append("1x 25x150 mm. trykimp. brædt: 600   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 480 && carportLength > 300) {
            sb.append("2x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 540 && carportLength > 480) {
            sb.append("2x 25x150 mm. trykimp. brædt: 540   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 600 && carportLength > 540) {
            sb.append("2x 25x150 mm. trykimp. brædt: 600   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength > 600) {
            sb.append("4x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Carport del.\n");
        }

        // C
        if (shedLength <= 240 && shedLength > 150) {
            sb.append("1x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 270 && shedLength > 240) {
            sb.append("1x 25x150 mm. trykimp. brædt: 540   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 300 && shedLength > 270) {
            sb.append("1x 25x150 mm. trykimp. brædt: 600   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 480 && shedLength > 300) {
            sb.append("2x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 540 && shedLength > 480) {
            sb.append("2x 25x150 mm. trykimp. brædt: 540   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 600 && shedLength > 540) {
            sb.append("2x 25x150 mm. trykimp. brædt: 600   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength > 600) {
            sb.append("4x 25x150 mm. trykimp. brædt: 480   -   Sternbrædder til siderne Skur del.\n");
        }

        // D
        sb.append("1 x fædigskåret - byg-selv spær (skal samles) 8 stk.\n");

        // E
        sb.append("9 x 97x97 mm - Stolper nedgraves 90cm.\n");

        // F
        if (carportLength == 240) {
            sb.append("1x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper.\n");
        } else if (carportLength <= 300 && carportLength > 240) {
            sb.append("1x 45x195 mm. spærtræ ubh.: 600   -   remme i sider, sadles ned i stolper.\n");
        } else if (carportLength <= 480 && carportLength > 300) {
            sb.append("2x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper.\n");
        } else if (carportLength <= 600 && carportLength > 480) {
            sb.append("2x 45x195 mm. spærtræ ubh.: 600   -   remme i sider, sadles ned i stolper.\n");
        } else if (carportLength > 600) {
            sb.append("4x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper.\n");
        }

        // G
        if (shedLength <= 240 && shedLength > 150) {
            sb.append("1x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper (skur del, deles).\n");
        } else if (shedLength <= 300 && shedLength > 240) {
            sb.append("1x 45x195 mm. spærtræ ubh.: 600   -   remme i sider, sadles ned i stolper (skur del, deles).\n");
        } else if (shedLength <= 480 && shedLength > 300) {
            sb.append("2x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper (skur del, deles).\n");
        } else if (shedLength <= 600 && shedLength > 480) {
            sb.append("2x 45x195 mm. spærtræ ubh.: 600   -   remme i sider, sadles ned i stolper (skur del, deles).\n");
        } else if (shedLength > 600) {
            sb.append("4x 45x195 mm. spærtræ ubh.: 480   -   remme i sider, sadles ned i stolper (skur del, deles).\n");
        }

        // H
        if (shedLength <= 240 && shedLength > 150) {
            sb.append("4x 45x95 mm. reglar ubh.: 240   -   løsholter til skur gavle.\n");
        } else if (shedLength <= 270 && shedLength > 240) {
            sb.append("4x 45x95 mm. reglar ubh.: 270   -   løsholter til skur gavle.\n");
        } else if (shedLength <= 360 && shedLength > 270) {
            sb.append("4x 45x95 mm. reglar ubh.: 360   -   løsholter til skur gavle.\n");
        } else if (shedLength <= 480 && shedLength > 360) {
            sb.append("8x 45x95 mm. reglar ubh.: 240   -   løsholter til skur gavle.\n");
        } else if (shedLength <= 540 && shedLength > 480) {
            sb.append("8x 45x95 mm. reglar ubh.: 270   -   løsholter til skur gavle.\n");
        } else if (shedLength > 540) {
            sb.append("8x 45x95 mm. reglar ubh.: 360   -   løsholter til skur gavle.\n");
        }

        // I
        if (shedWidth <= 240 && shedWidth > 210) {
            sb.append("6x 45x95 mm. reglar ubh.: 240   -   løsholter til skur gavle.\n");
        } else if (shedWidth <= 270 && shedWidth > 240) {
            sb.append("6x 45x95 mm. reglar ubh.: 270   -   løsholter til skur gavle.\n");
        } else if (shedWidth <= 360 && shedWidth > 270) {
            sb.append("6x 45x95 mm. reglar ubh.: 360   -   løsholter til skur gavle.\n");
        } else if (shedWidth <= 480 && shedWidth > 360) {
            sb.append("12x 45x95 mm. reglar ubh.: 240   -   løsholter til skur gavle.\n");
        } else if (shedWidth <= 540 && shedWidth > 480) {
            sb.append("12x 45x95 mm. reglar ubh.: 270   -   løsholter til skur gavle.\n");
        } else if (shedWidth > 540) {
            sb.append("12x 45x95 mm. reglar ubh.: 360   -   løsholter til skur gavle.\n");
        }

        // J
        sb.append("2 x 19x100mm trykimp. Bræt - Vand bræt på vindskeder.\n");

        // K
        int numberOfPiecesRoof = (int) ((carportWidth * 2 * 10 - 100) / 73 / 3);
        sb.append(numberOfPiecesRoof).append("x 19x100 mm. trykimp. brædt: ").append(carportHeight).append("   -   til beklædning af gavle 1 på 2.\n");

        // L
        int numberOfPiecesShed = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        sb.append(numberOfPiecesShed).append("x 19x100 mm. trykimp. brædt: ").append(carportHeight).append("   -   til beklædning af skur 1 på 2.\n");

        // M
        if (totalLength <= 270 && totalLength > 150) {
            sb.append("1x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 540 && totalLength > 270) {
            sb.append("2x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 810 && totalLength > 540) {
            sb.append("3x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 1080 && totalLength > 810) {
            sb.append("4x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 1350 && totalLength > 1080) {
            sb.append("5x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength > 1350) {
            sb.append("6x 425x50 mm. trykimp. brædt: 540   -   til montering oven på tagfodslægte.\n");
        }

        // N
        sb.append("1x 38x73 mm. taglgte T1: 540   -   til z på bagside af dør.\n");

        // O
        sb.append("21x 38x73 mm. taglgte T1: 540   -   til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte.\n");

        // P
        if (totalLength <= 420 && totalLength > 150) {
            sb.append("1x 38x73 mm. trykimp. brædt: 420   -   toplægte.\n");
        } else if (totalLength <= 540 && totalLength > 420) {
            sb.append("1x 38x73 mm. trykimp. brædt: 540   -   toplægte.\n");
        } else if (totalLength <= 840 && totalLength > 540) {
            sb.append("2x 38x73 mm. trykimp. brædt: 420   -   toplægte.\n");
        } else if (totalLength <= 1080 && totalLength > 840) {
            sb.append("2x 38x73 mm. trykimp. brædt: 540   -   toplægte.\n");
        } else if (totalLength <= 1260 && totalLength > 1080) {
            sb.append("3x 38x73 mm. trykimp. brædt: 420   -   toplægte.\n");
        } else if (totalLength > 1260) {
            sb.append("3x 38x73 mm. trykimp. brædt: 540   -   toplægte.\n");
        }
        return sb.toString();
    }


    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

}
