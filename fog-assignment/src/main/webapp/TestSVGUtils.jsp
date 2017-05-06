<%@page import="business.Pointy"%>
<%@page import="business.Flat"%>
<%@page import="business.parts.Wood"%>
<%@page import="business.parts.Part.PartType"%>
<%@page import="business.Partlist"%>
<%@page import="business.utility.SVGUtils"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%  Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 570, 600, 210, 540, 0);
            Pointy pointy = new Pointy("Pointy", "Plastmo Ecolite Blue", 510, 360, 210, 330, 0, 30);
            SVGUtils svg = new SVGUtils();
            Partlist partlistf = new Partlist();
            Partlist partlistp = new Partlist();
            int nbf = (int) ((flat.getTotalLength() / 55) + 1);
            int nbp = (int) ((pointy.getCarportLength() / 55) + 1);
            Wood woodJf = new Wood(PartType.WOOD, nbf, 480, "ubh. spærtræ", "spær. monteres på rem");
            Wood woodJp = new Wood(PartType.WOOD, nbp, 480, "ubh. spærtræ", "spær. monteres på rem");
            partlistf.getPartList().add(0, woodJf);
            partlistp.getPartList().add(0, woodJp);
            flat.setPartList(partlistf);
            pointy.setPartList(partlistp);%>
        <svg viewBox="0, 0, <%=flat.getTotalLength() + 100%>, <%=flat.getCarportWidth() + 100%>" width="1024" height="768" preserveAspectRatio="xMinYMin meet">
            <%=svg.drawFlatTopView(flat)%>
        </svg>
        <svg viewBox="0, 0, <%=pointy.getTotalLength() + 100%>, <%=pointy.getCarportWidth() + 100%>" width="1024" height="768" preserveAspectRatio="xMinYMin meet">
            <%=svg.drawPointyTopView(pointy)%>
        </svg>
    </body>
</html>
