package business;

import business.Parts.Wood;
import business.Parts.Tile;
import business.Parts.Screw;

/**
 *
 * @author mathiasjepsen
 */
public class Flat extends Carport {
        
    Wood woodA;
    Wood woodB;
    Wood woodC;
    Wood woodD;
    Wood woodE;
    Wood woodF;
    Wood woodG;
    Wood woodH;
    Wood woodI;
    Wood woodJ;
    Wood woodK;
    Wood woodL;
    Wood woodM;
    Wood woodN;
    
    public Flat(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight) {
        super(type, roofType, carportLength, shedLength, carportWidth, shedWidth, roofHeight);
    }

    public Partlist createPartList() {
        
        // Træ & Tagplader       
        // A
        if (carportWidth <= 270 && carportWidth >= 240) {
            woodA = new Wood(1, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
        } else if (carportWidth <= 360 && carportWidth > 270) {
            woodA = new Wood(2, 25, 200, 360, "trykimp. bræt", "understernbrædder til for- & bagende");
        } else if (carportWidth <= 540 && carportWidth > 360) {
            woodA = new Wood(2, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
        } else if (carportWidth <= 720 && carportWidth > 540) {
            woodA = new Wood(4, 25, 200, 360, "trykimp. bræt", "understernbrædder til for- & bagende");
        } else if (carportWidth > 720) {
            woodA = new Wood(4, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
        } 
        super.partList.getPartList().add(woodA);


        // B
        if (totalLength <= 180 && totalLength >= 150) {
            woodB = new Wood(1, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength <= 270 && totalLength > 180) {
            woodB = new Wood(1, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength <= 360 && totalLength > 270) {
            woodB = new Wood(2, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength <= 540 && totalLength > 360) {
            woodB = new Wood(2, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength <= 720 && totalLength > 540) {
            woodB = new Wood(4, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength <= 1080 && totalLength > 720) {
            woodB = new Wood(4, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
        } else if (totalLength > 1080) {
            woodB = new Wood(6, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
        } 
        super.partList.getPartList().add(woodB);

        // C
        if (carportWidth <= 360 && carportWidth >= 240) {
            woodC = new Wood(1, 25, 125, 360, "trykimp. bræt", "oversternbrædder til forenden");
        } else if (carportWidth < 540 && carportWidth > 360) {
            woodC = new Wood(1, 25, 125, 540, "trykimp. bræt", "oversternbrædder til forenden");
        } else if (carportWidth < 720 && carportWidth > 540) {
            woodC = new Wood(2, 25, 125, 360, "trykimp. bræt", "oversternbrædder til forenden");
        } else if (carportWidth > 720) {
            woodC = new Wood(2, 25, 125, 540, "trykimp. bræt", "oversternbrædder til forenden");
        } 
        super.partList.getPartList().add(woodC);

        // D
        if (totalLength <= 180 && totalLength >= 150) {
            woodD = new Wood(1, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength <= 270 && totalLength > 180) {
            woodD = new Wood(1, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength <= 360 && totalLength > 270) {
            woodD = new Wood(2, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength <= 540 && totalLength > 360) {
            woodD = new Wood(2, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength <= 720 && totalLength > 540) {
            woodD = new Wood(4, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength <= 1080 && totalLength > 720) {
            woodD = new Wood(4, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
        } else if (totalLength > 1080) {
            woodD = new Wood(6, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
        } 
        super.partList.getPartList().add(woodD);

        // E
        woodE = new Wood(1, 38, 73, 420, "ubh. lægte", "til Z på bagside af dør");
        super.partList.getPartList().add(woodE);

        // F
        if (shedWidth <= 240 && shedWidth > 210) {
            woodF = new Wood(6, 45, 95, 240, "ubh. reglar", "løsholter til skur gavle");
        } else if (shedWidth <= 270 && shedWidth > 240) {
            woodF = new Wood(6, 45, 95, 270, "ubh. reglar", "løsholter til skur gavle");
        } else if (shedWidth <= 360 && shedWidth > 270) {
            woodF = new Wood(6, 45, 95, 360, "ubh. reglar", "løsholter til skur gavle");
        } else if (shedWidth <= 480 && shedWidth > 360) {
            woodF = new Wood(12, 45, 95, 240, "ubh. reglar", "løsholter til skur gavle");
        } else if (shedWidth <= 540 && shedWidth > 480) {
            woodF = new Wood(12, 45, 95, 270, "ubh. reglar", "løsholter til skur gavle");
        } else if (shedWidth > 540) {
            woodF = new Wood(12, 45, 95, 360, "ubh. reglar", "løsholter til skur gavle");
        } 
        super.partList.getPartList().add(woodF);

        // G
        if (shedLength <= 240 && shedLength > 150) {
            woodG = new Wood(4, 45, 95, 240, "ubh. reglar", "løsholter til skur sider");
        } else if (shedLength <= 270 && shedLength > 240) {
            woodG = new Wood(4, 45, 95, 270, "ubh. reglar", "løsholter til skur sider");
        } else if (shedLength <= 360 && shedLength > 270) {
            woodG = new Wood(4, 45, 95, 360, "ubh. reglar", "løsholter til skur sider");
        } else if (shedLength <= 480 && shedLength > 360) {
            woodG = new Wood(8, 45, 95, 240, "ubh. reglar", "løsholter til skur sider");
        } else if (shedLength <= 540 && shedLength > 480) {
            woodG = new Wood(8, 45, 95, 270, "ubh. reglar", "løsholter til skur sider");
        } else if (shedLength > 540) {
            woodG = new Wood(8, 45, 95, 360, "ubh. reglar", "løsholter til skur sider");
        }
        super.partList.getPartList().add(woodG);

        // H
        if (carportLength == 240) {
            woodH = new Wood(1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 300 && carportLength > 240) {
            woodH = new Wood(1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 480 && carportLength > 300) {
            woodH = new Wood(2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 600 && carportLength > 480) {
            woodH = new Wood(2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength > 600) {
            woodH = new Wood(4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        }
        super.partList.getPartList().add(woodH);

        // I
        if (shedLength <= 240 && shedLength > 150) {
            woodI = new Wood(1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 300 && shedLength > 240) {
            woodI = new Wood(1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 480 && shedLength > 300) {
            woodI = new Wood(2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 600 && shedLength > 480) {
            woodI = new Wood(2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength > 600) {
            woodI = new Wood(4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        }
        super.partList.getPartList().add(woodI);

        // J
        switch (roofType) {
            case "Plastmo Ecolite Blue":
                int nb = (int) ((totalLength / 55) + 1);
                if (carportWidth < 480) {            
                    woodI = new Wood(nb, 45, 195, 480, "ubh. spærtræ", "spær. monteres på rem");
                } else if (carportWidth > 480 && carportWidth < 600) {
                    woodI = new Wood(nb, 45, 195, 600, "ubh. spærtræ", "spær. monteres på rem");
                } else if (carportWidth > 600) {
                    nb = nb * 2;
                    woodI = new Wood(nb, 45, 195, 480, "ubh. spærtræ", "spær. monteres på rem");
                }
                super.partList.getPartList().add(woodI);
                break;
            default:
                woodI = new Wood(0, 0, 0, 0, "ROOFTYPE REQUIRED", "");
                super.partList.getPartList().add(woodI);
                break;
        }

        // K
        woodK = new Wood(11, 97, 97, 300, "trykimp. stolpe", "stolper nedgraves 90 cm. i jord");
        super.partList.getPartList().add(woodK);

        // L
        int numberOfPieces = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        woodL = new Wood(numberOfPieces, 19, 100, carportHeight, "trykimp. stolpe", "til beklædning af skur 1 på 2");
        super.partList.getPartList().add(woodL);

        // M
        if (totalLength <= 180 && totalLength > 150) {
            woodM = new Wood(1, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 210 && totalLength > 180) {
            woodM = new Wood(2, 19, 100, 210, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 240 && totalLength > 210) {
            woodM = new Wood(2, 19, 100, 240, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 360 && totalLength > 240) {
            woodM = new Wood(2, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 480 && totalLength > 360) {
            woodM = new Wood(2, 19, 100, 480, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 540 && totalLength > 480) {
            woodM = new Wood(2, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 720 && totalLength > 540) {
            woodM = new Wood(4, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength <= 1080 && totalLength > 720) {
            woodM = new Wood(4, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
        } else if (totalLength > 1080) {
            woodM = new Wood(6, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
        } else {
            woodM = new Wood(0, 0, 0, 0, "UNINITIALIZED", "");
        }
        super.partList.getPartList().add(woodM);


        // N
        if (carportWidth <= 360 && carportWidth > 240) {
            woodN = new Wood(1, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i forende");
        } else if (carportWidth <= 540 && carportWidth > 360) {
            woodN = new Wood(1, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i forende");
        } else if (carportWidth <= 720 && carportWidth > 540) {
            woodN = new Wood(2, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i forende");
        } else if (carportWidth > 720) {
            woodN = new Wood(1, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i forende");
        }
        super.partList.getPartList().add(woodN);

        // O
        Tile tileO = new Tile(6, "stk.", 0, 0, 600, roofType, "tagplader monteres på spær");
        super.partList.getPartList().add(tileO);

        // P
        Tile tileP = new Tile(6, "stk.", 0, 0, 360, roofType, "tagplader monteres på spær");
        super.partList.getPartList().add(tileP);
        
        // Beslag & Skruer
        // A
        Screw screwA = new Screw(3, "pakke", 0, 0, 0, "Plastmo bundskruer 200 stk.", "skruer til tagplader");
        super.partList.getPartList().add(screwA);
        
        // B
        Screw screwB = new Screw(2, "rulle", 1, 20, 0, "hulbånd 10 mtr.", "til vindkryds på spær");
        super.partList.getPartList().add(screwB);
        
        // C
        Screw screwC = new Screw(15, "stk.", 0, 0, 190, "universal højre", "til montering af spær på rem");
        super.partList.getPartList().add(screwC);
        
        // D
        Screw screwD = new Screw(15, "stk.", 0, 0, 190, "universal venstre", "til montering af spær på rem");
        super.partList.getPartList().add(screwD);
        
        // E
        Screw screwE = new Screw(1, "pakke", 4.5, 60, 0, "skruer 200 stk.", "til montering af stern & vandbræt");
        super.partList.getPartList().add(screwE);
        
        // F
        Screw screwF = new Screw(3, "pakke", 4, 50, 0, "beslagskruer 250 stk.", "til montering af universalbeslag & hulbånd");
        super.partList.getPartList().add(screwF);
        
        // G
        Screw screwG = new Screw(18, "stk.", 10, 120, 0, "bræddebolt", "til montering af rem på stolper");
        super.partList.getPartList().add(screwG);
        
        // H
        Screw screwH = new Screw(12, "stk.", 40, 40, 11, "firkantskiver", "til montering af rem på stolper");
        super.partList.getPartList().add(screwH);
        
        // I
        Screw screwI = new Screw(2, "pakke", 4.5, 70, 0, "skruer 400 stk.", "til montering af yderste beklædning");
        super.partList.getPartList().add(screwI);
        
        // J
        Screw screwJ = new Screw(2, "pakke", 4.5, 50, 0, "skruer 300 stk.", "til montering af inderste beklædning");
        super.partList.getPartList().add(screwJ);
        
        // K
        Screw screwK = new Screw(1, "pakke", 50, 75, 0, "stalddørsgreb", "til lås på dør i skur");
        super.partList.getPartList().add(screwK);
        
        // L
        Screw screwL = new Screw(2, "stk.", 0, 0, 390, "t-hængsel", "til skurdør");
        super.partList.getPartList().add(screwL);
        
        // M
        Screw screwM = new Screw(32, "stk.", 0, 0, 35, "vinkelbeslag", "til montering af løsholter i skur");
        super.partList.getPartList().add(screwM);
        
        return super.partList;
    }
}
