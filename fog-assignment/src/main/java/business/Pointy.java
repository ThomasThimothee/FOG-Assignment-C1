package business;

import business.parts.Part;
import business.parts.Screw;
import business.parts.Tile;
import business.parts.Wood;

/**
 *
 * @author mathiasjepsen
 */
public class Pointy extends Carport {

    private double angle;

    Wood woodA, woodB, woodC, woodD, woodE, woodF, woodG, woodH, woodI, woodJ, woodK, woodL, woodM, woodN, woodO, woodP;
    Tile tileA, tileB, tileC, tileD, tileE;
    Screw screwA, screwB, screwC, screwD, screwE, screwF, screwG, screwH, screwI, screwJ, screwK, screwL, screwM, screwN;

    int qWoodA, qWoodB, qWoodC, qWoodD, qWoodE, qWoodF, qWoodG, qWoodH, qWoodI, qWoodJ, qWoodK, qWoodL, qWoodM, qWoodN, qWoodO, qWoodP,
            qTileA, qTileB, qTileC, qTileD, qTileE,
            qScrewA, qScrewB, qScrewC, qScrewD, qScrewE, qScrewF, qScrewG, qScrewH, qScrewI, qScrewJ, qScrewK, qScrewL, qScrewM, qScrewN;

    double lengthWoodA, lengthWoodB, lengthWoodC, lengthWoodD, lengthWoodE, lengthWoodF, lengthWoodG, lengthWoodH, lengthWoodI, lengthWoodJ, lengthWoodK, lengthWoodL, lengthWoodM, lengthWoodN, lengthWoodO, lengthWoodP;

    public Pointy(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight, double angle) {
        super(type, roofType, carportLength, carportWidth, shedLength, shedWidth, roofHeight);
        this.angle = angle;
    }

    public Partlist createPartList() {

        // Træ & Tagplader       
        // A
        qWoodA = 2;
        lengthWoodA = 480;
        woodA = new Wood(Part.PartType.WOOD, qWoodA, lengthWoodA, "25x150 mm. trykimp. Braet", "vindskeder pa rejsning");
        super.partList.getPartList().add(woodA);

        // B
        if (carportLength == 240) {
            qWoodB = 1;
            lengthWoodB = 480;
        } else if (carportLength <= 270 && carportLength > 240) {
            qWoodB = 1;
            lengthWoodB = 540;
        } else if (carportLength <= 300 && carportLength > 270) {
            qWoodB = 1;
            lengthWoodB = 600;
        } else if (carportLength <= 480 && carportLength > 300) {
            qWoodB = 2;
            lengthWoodB = 480;
        } else if (carportLength <= 540 && carportLength > 480) {
            qWoodB = 2;
            lengthWoodB = 540;
        } else if (carportLength <= 600 && carportLength > 540) {
            qWoodB = 2;
            lengthWoodB = 600;
        } else if (carportLength > 600) {
            qWoodB = 4;
            lengthWoodB = 480;
        }
        woodB = new Wood(Part.PartType.WOOD, qWoodB, lengthWoodB, "25x150 mm. trykimp. Braet", "Sternbraedder til siderne carport del");
        super.partList.getPartList().add(woodB);

        // C
        if (shedLength <= 240 && shedLength >= 150) {
            qWoodC = 1;
            lengthWoodC = 480;
        } else if (shedLength <= 270 && shedLength > 240) {
            qWoodC = 1;
            lengthWoodC = 540;
        } else if (shedLength <= 300 && shedLength > 270) {
            qWoodC = 1;
            lengthWoodC = 600;
        } else if (shedLength <= 480 && shedLength > 300) {
            qWoodC = 2;
            lengthWoodC = 480;
        } else if (shedLength <= 540 && shedLength > 480) {
            qWoodC = 2;
            lengthWoodC = 540;
        } else if (shedLength <= 600 && shedLength > 540) {
            qWoodC = 2;
            lengthWoodC = 600;
        } else if (shedLength > 600) {
            qWoodC = 4;
            lengthWoodC = 480;
        }
        woodC = new Wood(Part.PartType.WOOD, qWoodC, lengthWoodC, "25x150 mm. trykimp. Braet", "Sternbraedder til siderne skur del");
        super.partList.getPartList().add(woodC);

        // D
        qWoodD = 1;
        lengthWoodD = 1;
        woodD = new Wood(Part.PartType.WOOD, qWoodD, lengthWoodD, "faedigskaret", "byg-selv spaer (skal samles) 8 stk");
        super.partList.getPartList().add(woodD);

        // E
        qWoodE = 9;
        lengthWoodE = 300;
        woodE = new Wood(Part.PartType.WOOD, qWoodE, lengthWoodE, "97x97 mm. trykimp. Stolpe", "Stolper nedgraves 90 cm");
        super.partList.getPartList().add(woodE);

        // F
        if (carportLength == 240) {
            qWoodF = 1;
            lengthWoodF = 480;
        } else if (carportLength <= 300 && carportLength > 240) {
            qWoodF = 1;
            lengthWoodF = 600;
        } else if (carportLength <= 480 && carportLength > 300) {
            qWoodF = 2;
            lengthWoodF = 480;
        } else if (carportLength <= 600 && carportLength > 480) {
            qWoodF = 2;
            lengthWoodF = 600;
        } else if (carportLength > 600) {
            qWoodF = 4;
            lengthWoodF = 480;
        }
        woodF = new Wood(Part.PartType.WOOD, qWoodF, lengthWoodF, "45x195 mm. ubh. Spaertrae", "remme i sider, sadles ned i stolper Carport del");
        super.partList.getPartList().add(woodF);

        // G
        if (shedLength <= 240 && shedLength >= 150) {
            qWoodG = 1;
            lengthWoodG = 480;
        } else if (shedLength <= 300 && shedLength > 240) {
            qWoodG = 1;
            lengthWoodG = 600;
        } else if (shedLength <= 480 && shedLength > 300) {
            qWoodG = 2;
            lengthWoodG = 480;
        } else if (shedLength <= 600 && shedLength > 480) {
            qWoodG = 2;
            lengthWoodG = 600;
        } else if (shedLength > 600) {
            qWoodG = 4;
            lengthWoodG = 480;
        }
        woodG = new Wood(Part.PartType.WOOD, qWoodG, lengthWoodG, "45x195 mm. ubh. Spaertrae", "remme i sider, sadles ned i stolper (skur del, deles)");
        super.partList.getPartList().add(woodG);

        // H
        if (shedLength <= 240 && shedLength >= 150) {
            qWoodH = 4;
            lengthWoodH = 240;
        } else if (shedLength <= 270 && shedLength > 240) {
            qWoodH = 4;
            lengthWoodH = 270;
        } else if (shedLength <= 360 && shedLength > 270) {
            qWoodH = 4;
            lengthWoodH = 360;
        } else if (shedLength <= 480 && shedLength > 360) {
            qWoodH = 8;
            lengthWoodH = 240;
        } else if (shedLength <= 540 && shedLength > 480) {
            qWoodH = 8;
            lengthWoodH = 270;
        } else if (shedLength > 540) {
            qWoodH = 8;
            lengthWoodH = 360;
        }
        woodH = new Wood(Part.PartType.WOOD, qWoodH, lengthWoodH, "45x95 mm. ubh. Reglar", "losholter i siderne af skur");
        super.partList.getPartList().add(woodH);

        // I
        if (shedWidth <= 240 && shedWidth >= 210) {
            qWoodI = 6;
            lengthWoodI = 240;
        } else if (shedWidth <= 270 && shedWidth > 240) {
            qWoodI = 6;
            lengthWoodI = 270;
        } else if (shedWidth <= 360 && shedWidth > 270) {
            qWoodI = 6;
            lengthWoodI = 360;
        } else if (shedWidth <= 480 && shedWidth > 360) {
            qWoodI = 12;
            lengthWoodI = 240;
        } else if (shedWidth <= 540 && shedWidth > 480) {
            qWoodI = 12;
            lengthWoodI = 270;
        } else if (shedWidth > 540) {
            qWoodI = 12;
            lengthWoodI = 360;
        }
        woodI = new Wood(Part.PartType.WOOD, qWoodI, lengthWoodI, "45x95 mm. ubh. Reglar", "losholter i gavle af skur");
        super.partList.getPartList().add(woodI);

        // J
        qWoodJ = 2;
        lengthWoodJ = woodA.getLength();
        woodJ = new Wood(Part.PartType.WOOD, qWoodJ, lengthWoodJ, "19x100 mm. trykimp. Braet", "Vand bræt pa vindskeder");
        super.partList.getPartList().add(woodJ);

        // K
        qWoodK = (int) ((carportWidth * 2 * 10 - 100) / 73 / 3);
        lengthWoodK = 240;
        woodK = new Wood(Part.PartType.WOOD, qWoodK, lengthWoodK, "19x100 mm. trykimp. Braet", "til beklaedning af gavle 1 pa 2");
        super.partList.getPartList().add(woodK);

        // L
        qWoodL = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        lengthWoodK = 210;
        woodL = new Wood(Part.PartType.WOOD, qWoodL, lengthWoodK, "19x100 mm. trykimp. Braet", "til beklaedning af skur 1 pa 2");
        super.partList.getPartList().add(woodL);

        // M
        if (totalLength <= 270 && totalLength >= 150) {
            qWoodM = 1;
            lengthWoodM = 540;
        } else if (totalLength <= 540 && totalLength > 270) {
            qWoodM = 2;
            lengthWoodM = 540;
        } else if (totalLength <= 810 && totalLength > 540) {
            qWoodM = 3;
            lengthWoodM = 540;
        } else if (totalLength <= 1080 && totalLength > 810) {
            qWoodM = 4;
            lengthWoodM = 540;
        } else if (totalLength <= 1350 && totalLength > 1080) {
            qWoodM = 5;
            lengthWoodM = 540;
        } else if (totalLength > 1350) {
            qWoodM = 6;
            lengthWoodM = 540;
        }
        woodM = new Wood(Part.PartType.WOOD, qWoodM, lengthWoodM, "25x50 mm. trykimp. Braet", "til montering oven pa tagfodslaegte");
        super.partList.getPartList().add(woodM);

        // N
        qWoodN = 1;
        lengthWoodN = 540;
        woodN = new Wood(Part.PartType.WOOD, qWoodN, lengthWoodN, "38x73 mm. Taglaegte T1", "til z pa bagside af dor");
        super.partList.getPartList().add(woodN);

        // O
        qWoodO = 21;
        lengthWoodO = 540;
        woodO = new Wood(Part.PartType.WOOD, qWoodO, lengthWoodO, "38x73 mm. Taglaegte T1", "til montering pa spaer, 7 raekker laegter pa hver skiftevis 1 hel & 1 halv laegte");
        super.partList.getPartList().add(woodO);

        // P
        if (totalLength <= 420 && totalLength >= 150) {
            qWoodP = 1;
            lengthWoodP = 420;
        } else if (totalLength <= 540 && totalLength > 420) {
            qWoodP = 1;
            lengthWoodP = 540;
        } else if (totalLength <= 840 && totalLength > 540) {
            qWoodP = 2;
            lengthWoodP = 420;
        } else if (totalLength <= 1080 && totalLength > 840) {
            qWoodP = 2;
            lengthWoodP = 540;
        } else if (totalLength <= 1260 && totalLength > 1080) {
            qWoodP = 3;
            lengthWoodP = 420;
        } else if (totalLength > 1260) {
            qWoodP = 3;
            lengthWoodP = 540;
        }
        woodP = new Wood(Part.PartType.WOOD, qWoodP, lengthWoodP, "38x73 mm. Taglaegte T1", "toplaegte");
        super.partList.getPartList().add(woodP);

        // Tagpakken
        // A
        qTileA = 300;
        tileA = new Tile(Part.PartType.TILE, qTileA, "stk.", 0, "B&C Dobbelt -s sort", "monteres pa taglaegter 6 raekker af 24 sten pa hver side af taget");
        super.partList.getPartList().add(tileA);

        // B
        qTileB = 21;
        tileB = new Tile(Part.PartType.TILE, qTileB, "stk.", 0, "B&C Rygsten sort", "monteres pa toplaegte med medfolgende beslag. Se tagsten vejledning");
        super.partList.getPartList().add(tileB);

        // C
        qTileC = 8;
        tileC = new Tile(Part.PartType.TILE, qTileC, "stk.", 0, "B&C Toplaegte holder", "monteres pa toppen af spaeret (til toplaegte)");
        super.partList.getPartList().add(tileC);

        // D
        qTileD = 21;
        tileD = new Tile(Part.PartType.TILE, qTileD, "stk.", 0, "B&C Rygstensbeslag", "til montering af rygsten");
        super.partList.getPartList().add(tileD);

        // E
        qTileE = 2;
        tileE = new Tile(Part.PartType.TILE, qTileE, "pakke", 0, "B&C Tagstensbindere & nakkekroge", "til montering af tagsten, alle ydersten + hver anden fastgores");
        super.partList.getPartList().add(tileE);

        // Beslag & Skruer        
        // A
        qScrewA = 8;
        screwA = new Screw(Part.PartType.SCREW, qScrewA, "stk.", 190, "universal hojre", "til montering af spaer pa rem");
        super.partList.getPartList().add(screwA);

        // B
        qScrewB = 8;
        screwB = new Screw(Part.PartType.SCREW, qScrewB, "stk.", 190, "universal venstre", "til montering af spaer pa rem");
        super.partList.getPartList().add(screwB);

        // C
        qScrewC = 1;
        screwC = new Screw(Part.PartType.SCREW, qScrewC, "sæt", 0, "50x75 mm. Stalddorsgreb", "til las på dor i skur");
        super.partList.getPartList().add(screwC);

        // D
        qScrewD = 2;
        screwD = new Screw(Part.PartType.SCREW, qScrewD, "stk.", 390, "t-haengsel", "til dor i skur");
        super.partList.getPartList().add(screwD);

        // E
        qScrewE = 20;
        screwE = new Screw(Part.PartType.SCREW, qScrewE, "stk.", 35, "vinkelbeslag", "til montering af losholter i skur");
        super.partList.getPartList().add(screwE);

        // F
        qScrewF = 1;
        screwF = new Screw(Part.PartType.SCREW, qScrewF, "pakke", 0, "4,5x60 mm. skruer 200 stk.", "til montering af stern, vindskeder, vindkryds & vandbraet");
        super.partList.getPartList().add(screwF);

        // G
        qScrewG = 1;
        screwG = new Screw(Part.PartType.SCREW, qScrewG, "pakke", 0, "5x40 mm. beslagskruer 250 stk.", "til montering af universalbeslag & toplaegte");
        super.partList.getPartList().add(screwG);

        // H
        qScrewH = 2;
        screwH = new Screw(Part.PartType.SCREW, qScrewH, "pakke", 0, "5x100 mm. skruer 100 stk.", "til taglaegter");
        super.partList.getPartList().add(screwH);

        // I
        qScrewI = 20;
        screwI = new Screw(Part.PartType.SCREW, qScrewI, "stk.", 0, "10x120 mm. Braeddebolt", "til montering af rem pa stolper");
        super.partList.getPartList().add(screwI);

        // J  
        qScrewJ = 20;
        screwJ = new Screw(Part.PartType.SCREW, qScrewJ, "stk.", 11, "40x40 mm. firkantskiver", "til montering af rem pa stolper");
        super.partList.getPartList().add(screwJ);

        // K
        qScrewK = 3;
        screwK = new Screw(Part.PartType.SCREW, qScrewK, "pakke", 0, "4,5x70 mm. skruer 200 stk.", "til montering af yderste braet ved beklaedning");
        super.partList.getPartList().add(screwK);

        // L
        qScrewL = 2;
        screwL = new Screw(Part.PartType.SCREW, qScrewL, "pakke", 0, "4,5x50 mm. skruer 350 stk.", "til montering af inderste braet ved beklaedning");
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
