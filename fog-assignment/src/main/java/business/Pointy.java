package business;

import business.Parts.Part;
import business.Parts.Screw;
import business.Parts.Tile;
import business.Parts.Wood;

/**
 *
 * @author mathiasjepsen
 */
public class Pointy extends Carport {
    
    Wood woodA, woodB, woodC, woodD, woodE, woodF, woodG, woodH, woodI, woodJ, woodK, woodL, woodM, woodN, woodO, woodP;
    Tile tileA, tileB, tileC, tileD, tileE;
    Screw screwA, screwB, screwC, screwD, screwE, screwF, screwG, screwH, screwI, screwJ, screwK, screwL, screwM, screwN;
    private double angle;

    public Pointy(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight, double angle) {
        super(type, roofType, carportLength, carportWidth, shedLength, shedWidth, roofHeight);
        this.angle = angle;
    }

    public Partlist createPartList() {
        
        // Træ & Tagplader       
        // A
        woodA = new Wood(Part.PartType.WOOD, 2, 25, 150, 480, "trykimp. bræt", "vindskeder på rejsning");
        super.partList.getPartList().add(woodA);

        // B
        if (carportLength == 240) {
            woodB = new Wood(Part.PartType.WOOD, 1, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength <= 270 && carportLength > 240) {
            woodB = new Wood(Part.PartType.WOOD, 1, 25, 150, 540, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength <= 300 && carportLength > 270) {
            woodB = new Wood(Part.PartType.WOOD, 1, 25, 150, 600, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength <= 480 && carportLength > 300) {
            woodB = new Wood(Part.PartType.WOOD, 2, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength <= 540 && carportLength > 480) {
            woodB = new Wood(Part.PartType.WOOD, 2, 25, 150, 540, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength <= 600 && carportLength > 540) {
            woodB = new Wood(Part.PartType.WOOD, 2, 25, 150, 600, "trykimp. bræt", "Sternbrædder til siderne carport del");
        } else if (carportLength > 600) {
            woodB = new Wood(Part.PartType.WOOD, 4, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne carport del");
        }
        super.partList.getPartList().add(woodB);
        
        // C
        if (shedLength <= 240 && shedLength > 150) {
            woodC = new Wood(Part.PartType.WOOD, 1, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength <= 270 && shedLength > 240) {
            woodC = new Wood(Part.PartType.WOOD, 1, 25, 150, 540, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength <= 300 && shedLength > 270) {
            woodC = new Wood(Part.PartType.WOOD, 1, 25, 150, 600, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength <= 480 && shedLength > 300) {
            woodC = new Wood(Part.PartType.WOOD, 2, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength <= 540 && shedLength > 480) {
            woodC = new Wood(Part.PartType.WOOD, 2, 25, 150, 540, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength <= 600 && shedLength > 540) {
            woodC = new Wood(Part.PartType.WOOD, 2, 25, 150, 600, "trykimp. bræt", "Sternbrædder til siderne skur del");
        } else if (shedLength > 600) {
            woodC = new Wood(Part.PartType.WOOD, 4, 25, 150, 480, "trykimp. bræt", "Sternbrædder til siderne skur del");
        }
        super.partList.getPartList().add(woodC);

        // D
        woodD = new Wood(Part.PartType.WOOD, 1, 0, 0, 0, "fædigskåret", "byg-selv spær (skal samles) 8 stk");
        super.partList.getPartList().add(woodD);

        // E
        woodE = new Wood(Part.PartType.WOOD, 9, 97, 97, 300, "trykimp. stolpe", "Stolper nedgraves 90 cm");
        super.partList.getPartList().add(woodE);

        // F
        if (carportLength == 240) {
            woodF = new Wood(Part.PartType.WOOD, 1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 300 && carportLength > 240) {
            woodF = new Wood(Part.PartType.WOOD, 1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 480 && carportLength > 300) {
            woodF = new Wood(Part.PartType.WOOD, 2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength <= 600 && carportLength > 480) {
            woodF = new Wood(Part.PartType.WOOD, 2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        } else if (carportLength > 600) {
            woodF = new Wood(Part.PartType.WOOD, 4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper");
        }
        super.partList.getPartList().add(woodF);
        
        // G
        if (shedLength <= 240 && shedLength > 150) {
            woodG = new Wood(Part.PartType.WOOD, 1, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 300 && shedLength > 240) {
            woodG = new Wood(Part.PartType.WOOD, 1, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 480 && shedLength > 300) {
            woodG = new Wood(Part.PartType.WOOD, 2, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength <= 600 && shedLength > 480) {
            woodG = new Wood(Part.PartType.WOOD, 2, 45, 195, 600, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        } else if (shedLength > 600) {
            woodG = new Wood(Part.PartType.WOOD, 4, 45, 195, 480, "ubh. spærtræ", "remme i sider, sadles ned i stolper (skur del, deles)");
        }
        super.partList.getPartList().add(woodG);

        // H
        if (shedLength <= 240 && shedLength > 150) {
            woodH = new Wood(Part.PartType.WOOD, 4, 45, 95, 240, "ubh. reglar", "løsholter i siderne af skur");
        } else if (shedLength <= 270 && shedLength > 240) {
            woodH = new Wood(Part.PartType.WOOD, 4, 45, 95, 270, "ubh. reglar", "løsholter i siderne af skur");
        } else if (shedLength <= 360 && shedLength > 270) {
            woodH = new Wood(Part.PartType.WOOD, 4, 45, 95, 360, "ubh. reglar", "løsholter i siderne af skur");
        } else if (shedLength <= 480 && shedLength > 360) {
            woodH = new Wood(Part.PartType.WOOD, 8, 45, 95, 240, "ubh. reglar", "løsholter i siderne af skur");
        } else if (shedLength <= 540 && shedLength > 480) {
            woodH = new Wood(Part.PartType.WOOD, 8, 45, 95, 270, "ubh. reglar", "løsholter i siderne af skur");
        } else if (shedLength > 540) {
            woodH = new Wood(Part.PartType.WOOD, 8, 45, 95, 360, "ubh. reglar", "løsholter i siderne af skur");
        }
        super.partList.getPartList().add(woodH);

        // I
        if (shedWidth <= 240 && shedWidth > 210) {
            woodI = new Wood(Part.PartType.WOOD, 6, 45, 95, 240, "ubh. reglar", "løsholter i gavle af skur");
        } else if (shedWidth <= 270 && shedWidth > 240) {
            woodI = new Wood(Part.PartType.WOOD, 6, 45, 95, 270, "ubh. reglar", "løsholter i gavle af skur");
        } else if (shedWidth <= 360 && shedWidth > 270) {
            woodI = new Wood(Part.PartType.WOOD, 6, 45, 95, 360, "ubh. reglar", "løsholter i gavle af skur");
        } else if (shedWidth <= 480 && shedWidth > 360) {
            woodI = new Wood(Part.PartType.WOOD, 12, 45, 95, 240, "ubh. reglar", "løsholter i gavle af skur");
        } else if (shedWidth <= 540 && shedWidth > 480) {
            woodI = new Wood(Part.PartType.WOOD, 12, 45, 95, 270, "ubh. reglar", "løsholter i gavle af skur");
        } else if (shedWidth > 540) {
            woodI = new Wood(Part.PartType.WOOD, 12, 45, 95, 360, "ubh. reglar", "løsholter i gavle af skur");
        }
        super.partList.getPartList().add(woodI);

        // J
        woodJ = new Wood(Part.PartType.WOOD, 2, 19, 100, woodA.getLength(), "trykimp. bræt", "Vand bræt på vindskeder");
        super.partList.getPartList().add(woodJ);

        // K
        int numberOfPiecesRoof = (int) ((carportWidth * 2 * 10 - 100) / 73 / 3);
        woodK = new Wood(Part.PartType.WOOD, numberOfPiecesRoof, 19, 100, 240, "trykimp. bræt", "til beklædning af gavle 1 på 2");
        super.partList.getPartList().add(woodK);

        // L
        int numberOfPiecesShed = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        woodL = new Wood(Part.PartType.WOOD, numberOfPiecesShed, 19, 100, 210, "trykimp. bræt", "til beklædning af skur 1 på 2");
        super.partList.getPartList().add(woodL);

        // M
        if (totalLength <= 270 && totalLength > 150) {
            woodM = new Wood(Part.PartType.WOOD, 1, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        } else if (totalLength <= 540 && totalLength > 270) {
            woodM = new Wood(Part.PartType.WOOD, 2, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        } else if (totalLength <= 810 && totalLength > 540) {
            woodM = new Wood(Part.PartType.WOOD, 3, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        } else if (totalLength <= 1080 && totalLength > 810) {
            woodM = new Wood(Part.PartType.WOOD, 4, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        } else if (totalLength <= 1350 && totalLength > 1080) {
            woodM = new Wood(Part.PartType.WOOD, 5, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        } else if (totalLength > 1350) {
            woodM = new Wood(Part.PartType.WOOD, 6, 425, 50, 540, "trykimp. bræt", "til montering oven på tagfodslægte");
        }
        super.partList.getPartList().add(woodM);

        // N
        woodN = new Wood(Part.PartType.WOOD, 1, 38, 73, 540, "taglægte T1", "til Z på bagside af dør");
        super.partList.getPartList().add(woodN);

        // O
        woodO = new Wood(Part.PartType.WOOD, 21, 38, 73, 540, "taglægte T1", "til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte");
        super.partList.getPartList().add(woodO);

        // P
        if (totalLength <= 420 && totalLength > 150) {
            woodP = new Wood(Part.PartType.WOOD, 1, 38, 73, 420, "trykimp. bræt", "toplægte");
        } else if (totalLength <= 540 && totalLength > 420) {
            woodP = new Wood(Part.PartType.WOOD, 1, 38, 73, 540, "trykimp. bræt", "toplægte");
        } else if (totalLength <= 840 && totalLength > 540) {
            woodP = new Wood(Part.PartType.WOOD, 2, 38, 73, 420, "trykimp. bræt", "toplægte");
        } else if (totalLength <= 1080 && totalLength > 840) {
            woodP = new Wood(Part.PartType.WOOD, 2, 38, 73, 540, "trykimp. bræt", "toplægte");
        } else if (totalLength <= 1260 && totalLength > 1080) {
            woodP = new Wood(Part.PartType.WOOD, 3, 38, 73, 420, "trykimp. bræt", "toplægte");
        } else if (totalLength > 1260) {
            woodP = new Wood(Part.PartType.WOOD, 3, 38, 73, 540, "trykimp. bræt", "toplægte");
        }
        super.partList.getPartList().add(woodP);
        
        // Tagpakken
        // A
        tileA = new Tile(Part.PartType.TILE, 300, "stk.", 0, 0, 0, "B&C Dobbelt -s sort", "monteres på taglægter 6 rækker af 24 sten på hver side af taget");
        super.partList.getPartList().add(tileA);
        
        // B
        tileB = new Tile(Part.PartType.TILE, 21, "stk.", 0, 0, 0, "B&C Rygsten sort", "monteres på toplægte med medfølgende beslag. Se tagsten vejledning");
        super.partList.getPartList().add(tileB);
        
        // C
        tileC = new Tile(Part.PartType.TILE, 8, "stk.", 0, 0, 0, "B&C Toplægte holder", "monteres på toppen af spæret (til toplægte)");
        super.partList.getPartList().add(tileC);
        
        // D
        tileD = new Tile(Part.PartType.TILE, 21, "stk.", 0, 0, 0, "B&C Rygstensbeslag", "til montering af rygsten");
        super.partList.getPartList().add(tileD);
        
        // E
        tileE = new Tile(Part.PartType.TILE, 2, "pakke", 0, 0, 0, "B&C Tagstensbindere & nakkekroge", "til montering af tagsten, alle ydersten + hver anden fastgøres");
        super.partList.getPartList().add(tileE);
        
        // Beslag & Skruer        
        // A
        screwA = new Screw(Part.PartType.SCREW, 8, "stk.", 0, 0, 190, "universal højre", "til montering af spær på rem");
        super.partList.getPartList().add(screwA);
        
        // B
        screwB = new Screw(Part.PartType.SCREW, 8, "stk.", 0, 0, 190, "universal venstre", "til montering af spær på rem");
        super.partList.getPartList().add(screwB);
        
        // C
        screwC = new Screw(Part.PartType.SCREW, 1, "sæt", 50, 75, 0, "stalddørsgreb", "til lås på dør i skur");
        super.partList.getPartList().add(screwC);
        
        // D
        screwD = new Screw(Part.PartType.SCREW, 2, "stk.", 0, 0, 390, "t-hængsel", "til dør i skur");
        super.partList.getPartList().add(screwD);
        
        // E
        screwE = new Screw(Part.PartType.SCREW, 20, "stk.", 0, 0, 35, "vinkelbeslag", "til montering af løsholter i skur");
        super.partList.getPartList().add(screwE);
        
        // F
        screwF = new Screw(Part.PartType.SCREW, 1, "pakke", 4.5, 60, 0, "skruer 200 stk.", "til montering af stern, vindskeder, vindkryds & vandbræt");
        super.partList.getPartList().add(screwF);
        
        // G
        screwG = new Screw(Part.PartType.SCREW, 1, "pakke", 5, 40, 0, "beslagskruer 250 stk.", "til montering af universalbeslag & toplægte");
        super.partList.getPartList().add(screwG);
        
        // H
        screwH = new Screw(Part.PartType.SCREW, 2, "pakke", 5, 100, 0, "skruer 100 stk.", "til taglægter");
        super.partList.getPartList().add(screwH);
        
        // I
        screwI = new Screw(Part.PartType.SCREW, 20, "stk.", 10, 120, 0, "bræddebolt", "til montering af rem på stolper");
        super.partList.getPartList().add(screwI);
        
        // J    
        screwJ = new Screw(Part.PartType.SCREW, 20, "stk.", 40, 40, 11, "firkantskiver", "til montering af rem på stolper");
        super.partList.getPartList().add(screwJ);
        
        // K
        screwK = new Screw(Part.PartType.SCREW, 3, "pakke", 4.5, 70, 0, "skruer 200 stk.", "til montering af yderste bræt ved beklædning");
        super.partList.getPartList().add(screwK);
        
        // L
        screwL = new Screw(Part.PartType.SCREW, 2, "pakke", 4.5, 50, 0, "skruer 350 stk.", "til montering af inderste bræt ved beklædning");
        super.partList.getPartList().add(screwL);
        
        return super.partList;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

}
