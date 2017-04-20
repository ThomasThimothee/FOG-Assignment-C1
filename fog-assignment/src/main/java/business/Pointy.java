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
        
        // Træ & Tagplader       
        sb.append("_________________________________________________________________________\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        sb.append("Træplader & Tagplader\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");

        // A
        sb.append("2x 25x150 mm. trykimp. bræt: 480   -   vindskeder på rejsning.\n");

        // B
        if (carportLength == 240) {
            sb.append("1x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 270 && carportLength > 240) {
            sb.append("1x 25x150 mm. trykimp. bræt: 540   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 300 && carportLength > 270) {
            sb.append("1x 25x150 mm. trykimp. bræt: 600   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 480 && carportLength > 300) {
            sb.append("2x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 540 && carportLength > 480) {
            sb.append("2x 25x150 mm. trykimp. bræt: 540   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength <= 600 && carportLength > 540) {
            sb.append("2x 25x150 mm. trykimp. bræt: 600   -   Sternbrædder til siderne Carport del.\n");
        } else if (carportLength > 600) {
            sb.append("4x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Carport del.\n");
        }

        // C
        if (shedLength <= 240 && shedLength > 150) {
            sb.append("1x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 270 && shedLength > 240) {
            sb.append("1x 25x150 mm. trykimp. bræt: 540   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 300 && shedLength > 270) {
            sb.append("1x 25x150 mm. trykimp. bræt: 600   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 480 && shedLength > 300) {
            sb.append("2x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 540 && shedLength > 480) {
            sb.append("2x 25x150 mm. trykimp. bræt: 540   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength <= 600 && shedLength > 540) {
            sb.append("2x 25x150 mm. trykimp. bræt: 600   -   Sternbrædder til siderne Skur del.\n");
        } else if (shedLength > 600) {
            sb.append("4x 25x150 mm. trykimp. bræt: 480   -   Sternbrædder til siderne Skur del.\n");
        }

        // D
        sb.append("1 x fædigskåret   -   byg-selv spær (skal samles) 8 stk.\n");

        // E
        sb.append("9 x 97x97 mm.   -   Stolper nedgraves 90cm.\n");

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
        sb.append(numberOfPiecesRoof).append("x 19x100 mm. trykimp. bræt: ").append(carportHeight).append("   -   til beklædning af gavle 1 på 2.\n");

        // L
        int numberOfPiecesShed = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        sb.append(numberOfPiecesShed).append("x 19x100 mm. trykimp. bræt: ").append(carportHeight).append("   -   til beklædning af skur 1 på 2.\n");

        // M
        if (totalLength <= 270 && totalLength > 150) {
            sb.append("1x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 540 && totalLength > 270) {
            sb.append("2x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 810 && totalLength > 540) {
            sb.append("3x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 1080 && totalLength > 810) {
            sb.append("4x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength <= 1350 && totalLength > 1080) {
            sb.append("5x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        } else if (totalLength > 1350) {
            sb.append("6x 425x50 mm. trykimp. bræt: 540   -   til montering oven på tagfodslægte.\n");
        }

        // N
        sb.append("1x 38x73 mm. taglgte T1: 540   -   til z på bagside af dør.\n");

        // O
        sb.append("21x 38x73 mm. taglgte T1: 540   -   til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte.\n");

        // P
        if (totalLength <= 420 && totalLength > 150) {
            sb.append("1x 38x73 mm. trykimp. bræt: 420   -   toplægte.\n");
        } else if (totalLength <= 540 && totalLength > 420) {
            sb.append("1x 38x73 mm. trykimp. bræt: 540   -   toplægte.\n");
        } else if (totalLength <= 840 && totalLength > 540) {
            sb.append("2x 38x73 mm. trykimp. bræt: 420   -   toplægte.\n");
        } else if (totalLength <= 1080 && totalLength > 840) {
            sb.append("2x 38x73 mm. trykimp. bræt: 540   -   toplægte.\n");
        } else if (totalLength <= 1260 && totalLength > 1080) {
            sb.append("3x 38x73 mm. trykimp. bræt: 420   -   toplægte.\n");
        } else if (totalLength > 1260) {
            sb.append("3x 38x73 mm. trykimp. bræt: 540   -   toplægte.\n");
        }
        
        // Tagpakken
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        sb.append("Tagpakken\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        
        // A
        sb.append("300x stk. B & C Dobbelt -s sort   -   monteres på taglægter 6 rækker af 24 sten på hver side af taget.\n");
        
        // B
        sb.append("21x stk. B & C Rygsten sort   -   monteres på toplægte med medfølgende beslag. Se tagsten vejledning.\n");
        
        // C
        sb.append("8x stk. B & C Toplægte holder   -   monteres på toppen af spæret (til toplægte.\n");
        
        // D
        sb.append("21x stk. B & C Rygstensbeslag   -   til montering af rygsten.\n");
        
        // E
        sb.append("2x pk. B & C Tagstensbindere & nakkekroge   -   til montering af tagsten, alle ydersten + hver anden fastgøres.\n");
        
        // Beslag & Skruer
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        sb.append("Beslag & Skruer\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        
        // A
        sb.append("8x stk. universal 190 mm højre   -   til montering af spær på rem.\n");
        
        // B
        sb.append("8x stk. universal 190 mm venstre   -   til montering af spær på rem.\n");
        
        // C
        sb.append("1x sæt 50x75 mm. stalddørsgreb   -   til dør i skur.\n");
        
        // D
        sb.append("2x stk. 390 mm. t-hængsel   -   til dør i skur.\n");
        
        // E
        sb.append("20x stk. vinkelbeslag   -   til montering af løsholter.\n");
        
        // F
        sb.append("1x pakke 4,5x60 mm. skruer 200 stk.   -   til montering af stern, vindskeder, vindkryds & vandbræt.\n");
        
        // G
        sb.append("1x pakke 4,5x60 mm. beslagskruer 250 stk.   -   til montering af universalbeslag & toplægte.\n");
        
        // H
        sb.append("2x pakke 5,0x100 mm. skruer 100 stk.   -   til taglægter.\n");
        
        // I
        sb.append("20x stk. 10x120 mm. bræddebolt   -   til montering af rem på stolper.\n");
        
        // J
        sb.append("20x stk. 40x40x11 mm. firkantskiver   -   til montering af rem på stolper.\n");
        
        // K
        sb.append("3x pakke 4,5x70 mm. skruer 200 stk.   -   til montering af yderste bræt ved beklædning.\n");
        
        // L
        sb.append("2x pakke 4,5x50 mm. skruer 350 stk.   -   til montering af inderste bræt ved beklædning.\n");
        sb.append("_________________________________________________________________________\n");
        
        return sb.toString();
    }



    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

}
