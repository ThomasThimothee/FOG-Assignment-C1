package business;

import business.Parts.Wood;
import business.Parts.Tile;
import business.Parts.Screw;

/**
 *
 * @author mathiasjepsen
 */
public class Flat extends Carport {
        
    public Flat(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight) {
        super(type, roofType, carportLength, shedLength, carportWidth, shedWidth, roofHeight);
    }

    public Partlist createPartList() {
        StringBuilder sb = new StringBuilder();
        
        // Træ & Tagplader       
        sb.append("_________________________________________________________________________\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        sb.append("Træplader & Tagplader\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        
        // A
        if (carportWidth <= 270 && carportWidth >= 240) {
            Wood wood = new Wood(1, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
            super.partList.getPartList().add(wood);
        } else if (carportWidth <= 360 && carportWidth > 270) {
            Wood wood = new Wood(2, 25, 200, 360, "trykimp. bræt", "understernbrædder til for- & bagende");
            super.partList.getPartList().add(wood);
        } else if (carportWidth <= 540 && carportWidth > 360) {
            Wood wood = new Wood(2, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
            super.partList.getPartList().add(wood);
        } else if (carportWidth <= 720 && carportWidth > 540) {
            Wood wood = new Wood(4, 25, 200, 360, "trykimp. bræt", "understernbrædder til for- & bagende");
            super.partList.getPartList().add(wood);
        } else if (carportWidth > 720) {
            Wood wood = new Wood(4, 25, 200, 540, "trykimp. bræt", "understernbrædder til for- & bagende");
            super.partList.getPartList().add(wood);
        }

        // B
        if (totalLength <= 180 && totalLength >= 150) {
            Wood wood = new Wood(1, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 270 && totalLength > 180) {
            Wood wood = new Wood(1, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 360 && totalLength > 270) {
            Wood wood = new Wood(2, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 540 && totalLength > 360) {
            Wood wood = new Wood(2, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 720 && totalLength > 540) {
            Wood wood = new Wood(4, 25, 200, 360, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 1080 && totalLength > 720) {
            Wood wood = new Wood(4, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength > 1080) {
            Wood wood = new Wood(6, 25, 200, 540, "trykimp. bræt", "understernbrædder til siderne");
            super.partList.getPartList().add(wood);
        }

        // C
        if (carportWidth <= 360 && carportWidth >= 240) {
            Wood wood = new Wood(1, 25, 125, 360, "trykimp. bræt", "oversternbrædder til forenden");
            super.partList.getPartList().add(wood);
        } else if (carportWidth < 540 && carportWidth > 360) {
            Wood wood = new Wood(1, 25, 125, 540, "trykimp. bræt", "oversternbrædder til forenden");
            super.partList.getPartList().add(wood);
        } else if (carportWidth < 720 && carportWidth > 540) {
            Wood wood = new Wood(2, 25, 125, 360, "trykimp. bræt", "oversternbrædder til forenden");
            super.partList.getPartList().add(wood);
        } else if (carportWidth > 720) {
            Wood wood = new Wood(2, 25, 125, 540, "trykimp. bræt", "oversternbrædder til forenden");
            super.partList.getPartList().add(wood);
        }

        // D
        if (totalLength <= 180 && totalLength >= 150) {
            Wood wood = new Wood(1, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 270 && totalLength > 180) {
            Wood wood = new Wood(1, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 360 && totalLength > 270) {
            Wood wood = new Wood(2, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 540 && totalLength > 360) {
            Wood wood = new Wood(2, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 720 && totalLength > 540) {
            Wood wood = new Wood(4, 25, 125, 360, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength <= 1080 && totalLength > 720) {
            Wood wood = new Wood(4, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        } else if (totalLength > 1080) {
            Wood wood = new Wood(6, 25, 125, 540, "trykimp. bræt", "oversternbrædder til siderne");
            super.partList.getPartList().add(wood);
        }

        // E
        Wood wood = new Wood(1, 38, 73, 420, "ubh. lægte", "til Z på bagside af dør");
        super.partList.getPartList().add(wood);

        // F
        if (shedWidth <= 240 && shedWidth > 210) {
            Wood woodF = new Wood(6, 45, 95, 240, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        } else if (shedWidth <= 270 && shedWidth > 240) {
            Wood woodF = new Wood(6, 45, 95, 270, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        } else if (shedWidth <= 360 && shedWidth > 270) {
            Wood woodF = new Wood(6, 45, 95, 360, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        } else if (shedWidth <= 480 && shedWidth > 360) {
            Wood woodF = new Wood(12, 45, 95, 240, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        } else if (shedWidth <= 540 && shedWidth > 480) {
            Wood woodF = new Wood(12, 45, 95, 270, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        } else if (shedWidth > 540) {
            Wood woodF = new Wood(12, 45, 95, 360, "ubh. reglar", "løsholter til skur gavle");
            super.partList.getPartList().add(woodF);
        }

        // G
        if (shedLength <= 240 && shedLength > 150) {
            Wood woodG = new Wood(4, 45, 95, 240, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        } else if (shedLength <= 270 && shedLength > 240) {
            Wood woodG = new Wood(4, 45, 95, 270, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        } else if (shedLength <= 360 && shedLength > 270) {
            Wood woodG = new Wood(4, 45, 95, 360, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        } else if (shedLength <= 480 && shedLength > 360) {
            Wood woodG = new Wood(8, 45, 95, 240, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        } else if (shedLength <= 540 && shedLength > 480) {
            Wood woodG = new Wood(8, 45, 95, 270, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        } else if (shedLength > 540) {
            Wood woodG = new Wood(8, 45, 95, 360, "ubh. reglar", "løsholter til skur sider");
            super.partList.getPartList().add(woodG);
        }

        // H
        if (carportLength == 240) {
            Wood woodH = new Wood(1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
            super.partList.getPartList().add(woodH);
        } else if (carportLength <= 300 && carportLength > 240) {
            Wood woodH = new Wood(1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
            super.partList.getPartList().add(woodH);
        } else if (carportLength <= 480 && carportLength > 300) {
            Wood woodH = new Wood(2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
            super.partList.getPartList().add(woodH);
        } else if (carportLength <= 600 && carportLength > 480) {
            Wood woodH = new Wood(2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
            super.partList.getPartList().add(woodH);
        } else if (carportLength > 600) {
            Wood woodH = new Wood(4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
            super.partList.getPartList().add(woodH);
        }

        // I
        if (shedLength <= 240 && shedLength > 150) {
            Wood woodI = new Wood(1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
            super.partList.getPartList().add(woodI);
        } else if (shedLength <= 300 && shedLength > 240) {
            Wood woodI = new Wood(1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
            super.partList.getPartList().add(woodI);
        } else if (shedLength <= 480 && shedLength > 300) {
            Wood woodI = new Wood(2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
            super.partList.getPartList().add(woodI);
        } else if (shedLength <= 600 && shedLength > 480) {
            Wood woodI = new Wood(2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
            super.partList.getPartList().add(woodI);
        } else if (shedLength > 600) {
            Wood woodI = new Wood(4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
            super.partList.getPartList().add(woodI);
        }

        // J
        switch (roofType) {
            case "Plastmo Ecolite Blue":
                int nb = (int) ((totalLength / 55) + 1);
                if (carportWidth < 480) {            
                    Wood woodI = new Wood(nb, 45, 195, 480, "ubh. spærtræ", "spær. monteres på rem");
                    super.partList.getPartList().add(woodI);
                } else if (carportWidth > 480 && carportWidth < 600) {
                    Wood woodI = new Wood(nb, 45, 195, 600, "ubh. spærtræ", "spær. monteres på rem");
                    super.partList.getPartList().add(woodI);
                } else if (carportWidth > 600) {
                    nb = nb * 2;
                    Wood woodI = new Wood(nb, 45, 195, 480, "ubh. spærtræ", "spær. monteres på rem");
                    super.partList.getPartList().add(woodI);
                }
                break;
            default:
                Wood woodI = new Wood(0, 0, 0, 0, "ROOFTYPE REQUIRED", "");
                super.partList.getPartList().add(woodI);
                break;
        }

        // K
        Wood woodK = new Wood(11, 97, 97, 300, "trykimp. stolpe", "stolper nedgraves 90 cm. i jord");
        super.partList.getPartList().add(woodK);
        sb.append("11x 97x97 mm. trykimp. Stolpe: 300   -   stolper nedgraves 90 cm. i jord.\n");

        // L
        int numberOfPieces = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        Wood woodL = new Wood(numberOfPieces, 19, 100, carportHeight, "trykimp. stolpe", "til beklædning af skur 1 på 2");
        super.partList.getPartList().add(woodL);

        // M
        if (totalLength <= 180 && totalLength > 150) {
            Wood woodM = new Wood(1, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 210 && totalLength > 180) {
            Wood woodM = new Wood(2, 19, 100, 210, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 240 && totalLength > 210) {
            Wood woodM = new Wood(2, 19, 100, 240, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 360 && totalLength > 240) {
            Wood woodM = new Wood(2, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 480 && totalLength > 360) {
            Wood woodM = new Wood(2, 19, 100, 480, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 540 && totalLength > 480) {
            Wood woodM = new Wood(2, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 720 && totalLength > 540) {
            Wood woodM = new Wood(4, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength <= 1080 && totalLength > 720) {
            Wood woodM = new Wood(4, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        } else if (totalLength > 1080) {
            Wood woodM = new Wood(6, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i sider");
            super.partList.getPartList().add(woodM);
        }

        // N
        if (carportWidth <= 360 && carportWidth > 240) {
            Wood woodN = new Wood(1, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i forende");
            super.partList.getPartList().add(woodN);
        } else if (carportWidth <= 540 && carportWidth > 360) {
            Wood woodN = new Wood(1, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i forende");
            super.partList.getPartList().add(woodN);
        } else if (carportWidth <= 720 && carportWidth > 540) {
            Wood woodN = new Wood(2, 19, 100, 360, "trykimp. bræt", "vandbræt på stern i forende");
            super.partList.getPartList().add(woodN);
        } else if (carportWidth > 720) {
            Wood woodN = new Wood(1, 19, 100, 540, "trykimp. bræt", "vandbræt på stern i forende");
            super.partList.getPartList().add(woodN);
        }

        // O
        Tile tileO = new Tile(6, "stk.", 0, 0, 600, roofType, "tagplader monteres på spær");
        super.partList.getPartList().add(tileO);

        // P
        Tile tileP = new Tile(6, "stk.", 0, 0, 360, roofType, "tagplader monteres på spær");
        super.partList.getPartList().add(tileP);
        
        // Beslag & Skruer
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        sb.append("Beslag & Skruer\n");
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        
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
        sb.append("_________________________________________________________________________\n");
        
        return super.partList;
    }
}
