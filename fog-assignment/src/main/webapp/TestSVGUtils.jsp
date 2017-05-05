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
        <% SVGUtils svg = new SVGUtils(768, 512, 780, 600); 
        Partlist partlist = new Partlist();
        int nb = (int) ((svg.getCarportWidth() / 55) + 1);
        Wood woodJ = new Wood(PartType.WOOD, nb, 45, 195, 480, "ubh. spærtræ", "spær. monteres på rem");;
        partlist.getPartList().add(0, woodJ);%>
        <svg width="<%=svg.getCanvasWidth()%>" height="<%=svg.getCanvasHeight()%>">
        <%=svg.drawFlatTopView(partlist)%>

                
        </svg>
    </body>
</html>
