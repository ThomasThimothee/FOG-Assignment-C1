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
        <% Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 240, 240, 150, 210, 0);
            SVGUtils svg = new SVGUtils();
            Partlist partlist = new Partlist();
            int nb = (int) ((flat.getTotalLength() / 55) + 1);
            Wood woodJ = new Wood(PartType.WOOD, nb, 480, "ubh. spærtræ", "spær. monteres på rem");;
            partlist.getPartList().add(0, woodJ);
            flat.setPartList(partlist);%>
        <svg viewBox="0, 0, <%=flat.getTotalLength() + 100%>, <%=flat.getCarportWidth() + 100%>" width="1024" height="768" preserveAspectRatio="xMinYMin meet">
        <%=svg.drawFlatTopView(flat)%>
        
        </svg>
    </body>
</html>
