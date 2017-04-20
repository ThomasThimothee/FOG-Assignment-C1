package business;

/**
 *
 * @author mathiasjepsen
 */
public class Flat extends Carport {

    public Flat(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight) {
        super(type, roofType, carportLength, shedLength, carportWidth, shedWidth, roofHeight);
    }

    public String createPartList() {
        StringBuilder sb = new StringBuilder();

        // A
        if (carportWidth <= 270 && carportWidth >= 240) {
            sb.append("1x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
        } else if (carportWidth <= 360 && carportWidth > 270) {
            sb.append("2x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til for- & bagende.\n");
        } else if (carportWidth <= 540 && carportWidth > 360) {
            sb.append("2x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
        } else if (carportWidth <= 720 && carportWidth > 540) {
            sb.append("4x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til for- & bagende.\n");
        } else if (carportWidth > 720) {
            sb.append("4x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til for- & bagende.\n");
        }

        // B
        if (totalLength <= 180 && totalLength >= 150) {
            sb.append("1x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til siderne.\n");
        } else if (totalLength <= 270 && totalLength > 180) {
            sb.append("1x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til siderne.\n");
        } else if (totalLength <= 360 && totalLength > 270) {
            sb.append("2x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til siderne.\n");
        } else if (totalLength <= 540 && totalLength > 360) {
            sb.append("2x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til siderne.\n");
        } else if (totalLength <= 720 && totalLength > 540) {
            sb.append("4x 25x200 mm. trykimp. brædt: 360   -   understernbrædder til siderne.\n");
        } else if (totalLength <= 1080 && totalLength > 720) {
            sb.append("4x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til siderne.\n");
        } else if (totalLength > 1080) {
            sb.append("6x 25x200 mm. trykimp. brædt: 540   -   understernbrædder til siderne.\n");
        }

        // C
        if (carportWidth <= 360 && carportWidth >= 240) {
            sb.append("1x 25x125 mm. trykimp. brædt: 360   -   oversternbrædder til forenden.\n");
        } else if (carportWidth < 540 && carportWidth > 360) {
            sb.append("1x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til forenden.\n");
        } else if (carportWidth < 720 && carportWidth > 540) {
            sb.append("2x 25x125 mm. trykimp. brædt: 360   -   oversternbrædder til forenden.\n");
        } else if (carportWidth > 720) {
            sb.append("2x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til forenden.\n");
        }

        // D
        if (totalLength <= 180 && totalLength >= 150) {
            sb.append("1x 25x125 mm. trykimp. brædt: 360   -   oversternbrædder til siderne.\n");
        } else if (totalLength <= 270 && totalLength > 180) {
            sb.append("1x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til siderne.\n");
        } else if (totalLength <= 360 && totalLength > 270) {
            sb.append("2x 25x125 mm. trykimp. brædt: 360   -   oversternbrædder til siderne.\n");
        } else if (totalLength <= 540 && totalLength > 360) {
            sb.append("2x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til siderne.\n");
        } else if (totalLength <= 720 && totalLength > 540) {
            sb.append("4x 25x125 mm. trykimp. brædt: 360   -   oversternbrædder til siderne.\n");
        } else if (totalLength <= 1080 && totalLength > 720) {
            sb.append("4x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til siderne.\n");
        } else if (totalLength > 1080) {
            sb.append("6x 25x125 mm. trykimp. brædt: 540   -   oversternbrædder til siderne.\n");
        }

        // E
        sb.append("1x 38x73 mm. lægte ubh.: 420   -   til Z på bagside af dør.\n");

        // F
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

        // G
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

        // H
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

        // I
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

        // J
        switch (roofType) {
            case "Plastmo Ecolite Blue":
                int nb = (int) ((totalLength / 55) + 1);
                if (carportWidth < 480) {
                    sb.append(nb).append("x 45x195 mm. spærtræ ubh.: 480   -   spær. monteres på rem.\n");
                } else if (carportWidth > 480 && carportWidth < 600) {
                    sb.append(nb).append("x 45x195 mm. spærtræ ubh.: 600   -   spær. monteres på rem.\n");
                } else if (carportWidth > 600) {
                    nb = nb * 2;
                    sb.append(nb).append("x 45x195 mm. spærtræ ubh.: 480   -   spær. monteres på rem.\n");
                }
                break;
            default:
                sb.append("    -   ROOFTYPE REQUIRED   -   \n");
                break;
        }

        // K
        sb.append("11x 97x97 mm. trykimp. Stolpe: 300   -   stolper nedgraves 90 cm. i jord.\n");

        // L
        int numberOfPieces = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        sb.append(numberOfPieces).append("x 19x100 mm. trykimp. brædt: ").append(carportHeight).append("   -   til beklædning af skur 1 på 2.\n");

        // M
        if (totalLength <= 180 && totalLength > 150) {
            sb.append("1x 19x100 mm. trykimp. brædt: 360   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 210 && totalLength > 180) {
            sb.append("2x 19x100 mm. trykimp. brædt: 210   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 240 && totalLength > 210) {
            sb.append("2x 19x100 mm. trykimp. brædt: 240   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 360 && totalLength > 240) {
            sb.append("2x 19x100 mm. trykimp. brædt: 360   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 480 && totalLength > 360) {
            sb.append("2x 19x100 mm. trykimp. brædt: 480   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 540 && totalLength > 480) {
            sb.append("2x 19x100 mm. trykimp. brædt: 540   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 720 && totalLength > 540) {
            sb.append("4x 19x100 mm. trykimp. brædt: 360   -   vandbrædt på stern i sider.\n");
        } else if (totalLength <= 1080 && totalLength > 720) {
            sb.append("4x 19x100 mm. trykimp. brædt: 540   -   vandbrædt på stern i sider.\n");
        } else if (totalLength > 1080) {
            sb.append("6x 19x100 mm. trykimp. brædt: 540   -   vandbrædt på stern i sider.\n");
        }

        // N
        if (carportWidth <= 360 && carportWidth > 240) {
            sb.append("1x 19x100 mm. trykimp. brædt: 360   -   vandbrædt på stern i forende.\n");
        } else if (carportWidth <= 540 && carportWidth > 360) {
            sb.append("1x 19x100 mm. trykimp. brædt: 540   -   vandbrædt på stern i forende.\n");
        } else if (carportWidth <= 720 && carportWidth > 540) {
            sb.append("2x 19x100 mm. trykimp. brædt: 360   -   vandbrædt på stern i forende.\n");
        } else if (carportWidth > 720) {
            sb.append("2x 19x100 mm. trykimp. brædt: 540   -   vandbrædt på stern i forende.\n");
        }

        // O
        sb.append(roofType).append(": ???   -   tagplader monteres på spær.\n");

        // P
        sb.append(roofType).append(": ???   -   tagplader monteres på spær.\n");

        return sb.toString();
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public double getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    public double getShedLength() {
        return shedLength;
    }

    public void setShedLength(double shedLength) {
        this.shedLength = shedLength;
    }

    public double getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(double totalLength) {
        this.totalLength = totalLength;
    }

    public double getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    public double getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(double shedWidth) {
        this.shedWidth = shedWidth;
    }

}
