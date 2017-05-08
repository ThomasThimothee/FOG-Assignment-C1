package business;

import business.parts.Part.PartType;
import business.parts.Wood;
import business.parts.Tile;
import business.parts.Screw;

/**
 *
 * @author mathiasjepsen
 */
public class Flat extends Carport {

    Wood woodA, woodB, woodC, woodD, woodE, woodF, woodG, woodH, woodI, woodJ, woodK, woodL, woodM, woodN;
    Tile tileA, tileB;
    Screw screwA, screwB, screwC, screwD, screwE, screwF, screwG, screwH, screwI, screwJ, screwK, screwL, screwM, screwN;

    int qWoodA, qWoodB, qWoodC, qWoodD, qWoodE, qWoodF, qWoodG, qWoodH, qWoodI, qWoodJ, qWoodK, qWoodL, qWoodM, qWoodN,
            qTileA, qTileB,
            qScrewA, qScrewB, qScrewC, qScrewD, qScrewE, qScrewF, qScrewG, qScrewH, qScrewI, qScrewJ, qScrewK, qScrewL, qScrewM, qScrewN;

    double lengthWoodA, lengthWoodB, lengthWoodC, lengthWoodD, lengthWoodE, lengthWoodF, lengthWoodG, lengthWoodH, lengthWoodI, lengthWoodJ, lengthWoodK, lengthWoodL, lengthWoodM, lengthWoodN;

    public Flat(String type, String roofType, double carportLength, double carportWidth, double shedLength, double shedWidth, double roofHeight) {
        super(type, roofType, carportLength, carportWidth, shedLength, shedWidth, roofHeight);
    }

    public Partlist createPartList() {

        // Træ & Tagplader       
        // A
        if (carportWidth <= 270 && carportWidth >= 240) {
            qWoodA = 1;
            lengthWoodA = 540;
        } else if (carportWidth <= 360 && carportWidth > 270) {
            qWoodA = 2;
            lengthWoodA = 360;
        } else if (carportWidth <= 540 && carportWidth > 360) {
            qWoodA = 2;
            lengthWoodA = 540;
        } else if (carportWidth <= 720 && carportWidth > 540) {
            qWoodA = 4;
            lengthWoodA = 360;
        } else if (carportWidth > 720) {
            qWoodA = 4;
            lengthWoodA = 540;
        }
        woodA = new Wood(PartType.WOOD, qWoodA, lengthWoodA, "25x200 mm. trykimp. Braet", "understernbraedder til for- & bagende");
        super.partList.getPartList().add(woodA);

        // B
        if (totalLength <= 180 && totalLength >= 150) {
            qWoodB = 1;
            lengthWoodB = 360;
        } else if (totalLength <= 270 && totalLength > 180) {
            qWoodB = 1;
            lengthWoodB = 540;
        } else if (totalLength <= 360 && totalLength > 270) {
            qWoodB = 2;
            lengthWoodB = 360;
        } else if (totalLength <= 540 && totalLength > 360) {
            qWoodB = 2;
            lengthWoodB = 540;
        } else if (totalLength <= 720 && totalLength > 540) {
            qWoodB = 4;
            lengthWoodB = 360;
        } else if (totalLength <= 1080 && totalLength > 720) {
            qWoodB = 4;
            lengthWoodB = 540;
        } else if (totalLength > 1080) {
            qWoodB = 6;
            lengthWoodB = 540;
        }
        woodB = new Wood(PartType.WOOD, qWoodB,  lengthWoodB, "25x200 mm. trykimp. Braet", "understernbraedder til siderne");
        super.partList.getPartList().add(woodB);

        // C
        if (carportWidth <= 360 && carportWidth >= 240) {
            qWoodC = 1;
            lengthWoodC = 360;
        } else if (carportWidth <= 540 && carportWidth > 360) {
            qWoodC = 1;
            lengthWoodC = 540;
        } else if (carportWidth <= 720 && carportWidth > 540) {
            qWoodC = 2;
            lengthWoodC = 360;
        } else if (carportWidth > 720) {
            qWoodC = 2;
            lengthWoodC = 540;
        }
        woodC = new Wood(PartType.WOOD, qWoodC, lengthWoodC, "25x125 mm. trykimp. Braet", "oversternbraedder til forenden");
        super.partList.getPartList().add(woodC);

        // D
        if (totalLength <= 180 && totalLength >= 150) {
            qWoodD = 1;
            lengthWoodD = 360;
        } else if (totalLength <= 270 && totalLength > 180) {
            qWoodD = 1;
            lengthWoodD = 540;
        } else if (totalLength <= 360 && totalLength > 270) {
            qWoodD = 2;
            lengthWoodD = 360;
        } else if (totalLength <= 540 && totalLength > 360) {
            qWoodD = 2;
            lengthWoodD = 540;
        } else if (totalLength <= 720 && totalLength > 540) {
            qWoodD = 4;
            lengthWoodD = 360;
        } else if (totalLength <= 1080 && totalLength > 720) {
            qWoodC = 4;
            lengthWoodC = 540;
        } else if (totalLength > 1080) {
            qWoodD = 6;
            lengthWoodD = 540;
        }
        woodD = new Wood(PartType.WOOD, qWoodD, lengthWoodD, "25x125 mm. trykimp. Braet", "oversternbraedder til siderne");
        super.partList.getPartList().add(woodD);

        // E
        qWoodE = 1;
        lengthWoodE = 420;
        woodE = new Wood(PartType.WOOD, qWoodE, lengthWoodE, "38x73 mm. Laegte", "til Z pa bagside af dor");
        super.partList.getPartList().add(woodE);

        // F
        if (shedWidth <= 240 && shedWidth >= 210) {
            qWoodF = 6;
            lengthWoodF = 240;
        } else if (shedWidth <= 270 && shedWidth > 240) {
            qWoodF = 6;
            lengthWoodF = 270;
        } else if (shedWidth <= 360 && shedWidth > 270) {
            qWoodF = 6;
            lengthWoodF = 360;
        } else if (shedWidth <= 480 && shedWidth > 360) {
            qWoodF = 12;
            lengthWoodF = 240;
        } else if (shedWidth <= 540 && shedWidth > 480) {
            qWoodF = 12;
            lengthWoodF = 270;
        } else if (shedWidth > 540) {
            qWoodF = 12;
            lengthWoodF = 360;
        }
        woodF = new Wood(PartType.WOOD, qWoodF, lengthWoodF, "45x95 mm. ubh. Reglar", "losholter til skur gavle");
        super.partList.getPartList().add(woodF);

        // G
        if (shedLength <= 240 && shedLength >= 150) {
            qWoodG = 4;
            lengthWoodG = 240;
        } else if (shedLength <= 270 && shedLength > 240) {
            qWoodG = 4;
            lengthWoodG = 270;
        } else if (shedLength <= 360 && shedLength > 270) {
            qWoodG = 4;
            lengthWoodG = 360;
        } else if (shedLength <= 480 && shedLength > 360) {
            qWoodG = 8;
            lengthWoodG = 240;
        } else if (shedLength <= 540 && shedLength > 480) {
            qWoodG = 8;
            lengthWoodG = 270;
        } else if (shedLength > 540) {
            qWoodG = 8;
            lengthWoodG = 360;
        }
        woodG = new Wood(PartType.WOOD, 8,  360, "45x95 mm. ubh. Reglar", "losholter til skur sider");
        super.partList.getPartList().add(woodG);

        // H
        if (carportLength == 240) {
            qWoodH = 1;
            lengthWoodH = 480;
        } else if (carportLength <= 300 && carportLength > 240) {
            qWoodH = 1;
            lengthWoodH = 600;
        } else if (carportLength <= 480 && carportLength > 300) {
            qWoodH = 2;
            lengthWoodH = 480;
        } else if (carportLength <= 600 && carportLength > 480) {
            qWoodH = 2;
            lengthWoodH = 600;
        } else if (carportLength > 600) {
            qWoodH = 4;
            lengthWoodH = 480;
        }
        woodH = new Wood(PartType.WOOD, qWoodH, lengthWoodH, "45x195 mm. ubh. Spaertrae", "remme i sider, sadles ned i stolper");
        super.partList.getPartList().add(woodH);

        // I
        if (shedLength <= 240 && shedLength >= 150) {
            qWoodI = 1;
            lengthWoodI = 480;
        } else if (shedLength <= 300 && shedLength > 240) {
            qWoodI = 1;
            lengthWoodI = 600;
        } else if (shedLength <= 480 && shedLength > 300) {
            qWoodI = 2;
            lengthWoodI = 480;
        } else if (shedLength <= 600 && shedLength > 480) {
            qWoodI = 2;
            lengthWoodI = 600;
        } else if (shedLength > 600) {
            qWoodI = 4;
            lengthWoodI = 480;
        }
        woodI = new Wood(PartType.WOOD, qWoodI,  lengthWoodI, "45x195 mm. ubh. Spaertrae", "remme i sider, sadles ned i stolper (skur del, deles)");
        super.partList.getPartList().add(woodI);

        // J
        switch (roofType) {
            case "Plastmo Ecolite Blue":
                qWoodJ = (int) ((totalLength / 55) + 1);
                if (carportWidth < 480) {
                    lengthWoodJ = 480;
                } else if (carportWidth > 480 && carportWidth <= 600) {
                    lengthWoodJ = 600;
                } else if (carportWidth > 600) {
                    lengthWoodJ = 480;
                    qWoodJ = qWoodJ * 2;
                }
                woodJ = new Wood(PartType.WOOD, qWoodJ,  lengthWoodJ, "45x195 mm. ubh. Spaertrae", "spaer. monteres pa rem");
                super.partList.getPartList().add(woodJ);
                break;
            default:
                woodJ = new Wood(PartType.WOOD, 0, 0, "ROOFTYPE REQUIRED", "");
                super.partList.getPartList().add(woodJ);
                break;
        }

        // K
        qWoodK = 11;
        lengthWoodK = 300;        
        woodK = new Wood(PartType.WOOD, qWoodK, lengthWoodK, "97x97 mm. trykimp. Stolpe", "stolper nedgraves 90 cm. i jord");
        super.partList.getPartList().add(woodK);

        // L
        qWoodL = (int) (((shedLength * 2 + shedWidth * 2) * 10 - 100) / 73);
        woodL = new Wood(PartType.WOOD, qWoodL, carportHeight, "19x100 mm. trykimp. Braet", "til beklaedning af skur 1 pa 2");
        super.partList.getPartList().add(woodL);

        // M
        if (totalLength <= 180 && totalLength >= 150) {
            qWoodM = 1;
            lengthWoodM = 360;
        } else if (totalLength <= 210 && totalLength > 180) {
            qWoodM = 2;
            lengthWoodM = 210;
        } else if (totalLength <= 240 && totalLength > 210) {
            qWoodM = 2;
            lengthWoodM = 240;
        } else if (totalLength <= 360 && totalLength > 240) {
            qWoodM = 2;
            lengthWoodM = 360;
        } else if (totalLength <= 480 && totalLength > 360) {
            qWoodM = 2;
            lengthWoodM = 480;
        } else if (totalLength <= 540 && totalLength > 480) {
            qWoodM = 2;
            lengthWoodM = 540;
        } else if (totalLength <= 720 && totalLength > 540) {
            qWoodM = 4;
            lengthWoodM = 360;
        } else if (totalLength <= 1080 && totalLength > 720) {
            qWoodM = 4;
            lengthWoodM = 540;
        } else if (totalLength > 1080) {
            qWoodM = 6;
            lengthWoodM = 540;
        } else {
            woodM = new Wood(PartType.WOOD, 0, 0, "UNINITIALIZED", "");
        }
        woodM = new Wood(PartType.WOOD, qWoodM,  lengthWoodM, "19x100 mm. trykimp. Braet", "vandbraet pa stern i sider");
        super.partList.getPartList().add(woodM);

        // N
        if (carportWidth <= 360 && carportWidth >= 240) {
            qWoodN = 1;
            lengthWoodN = 360;
        } else if (carportWidth <= 540 && carportWidth > 360) {
            qWoodN = 1;
            lengthWoodN = 540;
        } else if (carportWidth <= 720 && carportWidth > 540) {
            qWoodN = 2;
            lengthWoodN = 360;
        } else if (carportWidth > 720) {
            qWoodN = 2;
            lengthWoodN = 540;
        }
        woodN = new Wood(PartType.WOOD, qWoodN, lengthWoodN, "19x100 mm. trykimp. Braet", "vandbraet pa stern i forende");
        super.partList.getPartList().add(woodN);

        // O (tile but saved as wood for the price method and saved as wood in example)
        qTileA = 6;        
        tileA = new Tile(PartType.WOOD, qTileA, "stk.", 600, roofType, "tagplader monteres pa spaer");
        super.partList.getPartList().add(tileA);

        // P
        qTileB = 6;
        tileB = new Tile(PartType.WOOD, qTileB, "stk.", 360, roofType, "tagplader monteres pa spaer");
        super.partList.getPartList().add(tileB);

        // Beslag & Skruer
        // A
        qScrewA = 3;
        screwA = new Screw(PartType.SCREW, qScrewA, "pakke", 0, "Plastmo bundskruer 200 stk.", "skruer til tagplader");
        super.partList.getPartList().add(screwA);

        // B
        qScrewB = 2;
        screwB = new Screw(PartType.SCREW, qScrewB, "rulle", 0, "1x20 mm. hulband 10 mtr.", "til vindkryds pa spaer");
        super.partList.getPartList().add(screwB);

        // C
        qScrewC = 15;
        screwC = new Screw(PartType.SCREW, qScrewC, "stk.",  190, "universal hojre", "til montering af spaer pa rem");
        super.partList.getPartList().add(screwC);

        // D
        qScrewD = 15;
        screwD = new Screw(PartType.SCREW, qScrewD, "stk.", 190, "universal venstre", "til montering af spaer pa rem");
        super.partList.getPartList().add(screwD);

        // E
        qScrewE = 1;
        screwE = new Screw(PartType.SCREW, qScrewE, "pakke", 0, "4,5x60 mm. skruer 200 stk.", "til montering af stern & vandbraet");
        super.partList.getPartList().add(screwE);

        // F
        qScrewF = 3;
        screwF = new Screw(PartType.SCREW, qScrewF, "pakke", 0, "4x50 mm. beslagskruer 250 stk.", "til montering af universalbeslag & hulband");
        super.partList.getPartList().add(screwF);

        // G
        qScrewG = 18;
        screwG = new Screw(PartType.SCREW, qScrewG, "stk.", 0, "10x120 mm. Braeddebolt", "til montering af rem pa stolper");
        super.partList.getPartList().add(screwG);

        // H
        qScrewH = 12;
        screwH = new Screw(PartType.SCREW, qScrewH, "stk.", 11, "40x40 mm. firkantskiver", "til montering af rem pa stolper");
        super.partList.getPartList().add(screwH);

        // I
        qScrewI = 2;
        screwI = new Screw(PartType.SCREW, qScrewI, "pakke", 0, "4,5x70 mm. skruer 400 stk.", "til montering af yderste beklaedning");
        super.partList.getPartList().add(screwI);

        // J
        qScrewJ = 2;
        screwJ = new Screw(PartType.SCREW, qScrewJ, "pakke", 0, "4,5x50 mm. skruer 300 stk.", "til montering af inderste beklaedning");
        super.partList.getPartList().add(screwJ);

        // K
        qScrewK = 1;
        screwK = new Screw(PartType.SCREW, qScrewK, "sæt", 0, "50x75 mm. Stalddorsgreb", "til las pa dor i skur");
        super.partList.getPartList().add(screwK);

        // L
        qScrewL = 2;
        screwL = new Screw(PartType.SCREW, qScrewL, "stk.", 390, "t-haengsel", "til skurdor");
        super.partList.getPartList().add(screwL);

        // M
        qScrewM = 32;
        screwM = new Screw(PartType.SCREW, qScrewM, "stk.", 35, "vinkelbeslag", "til montering af losholter i skur");
        super.partList.getPartList().add(screwM);

        return super.partList;
    }
}
