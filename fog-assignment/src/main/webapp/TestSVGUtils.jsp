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
        <% SVGUtils svg = new SVGUtils(1024, 768, 1470, 690); 
        Partlist partlist = new Partlist();
        int nb = (int) ((svg.getCarportWidth() / 55) + 1);
        System.out.println(nb);
        Wood woodJ = new Wood(PartType.WOOD, nb, 480, "ubh. spærtræ", "spær. monteres på rem");;
        partlist.getPartList().add(0, woodJ);%>
        <svg viewBox="0, 0, <%=svg.getCarportLength()%>, <%=svg.getCarportWidth()%>" width="<%=svg.getCanvasWidth()%>" height="<%=svg.getCanvasHeight()%>" preserveAspectRatio="xMinYMin meet">
        <%=svg.drawFlatTopView(partlist)%>
 
        </svg>
    </body>
</html>
