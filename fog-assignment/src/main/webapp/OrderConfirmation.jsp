<%@page import="java.util.Iterator"%>
<%@page import="business.Partlist"%>
<%@page import="business.Flat"%>
<%@page import="business.parts.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Signup</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <style>
        p {
            white-space: pre;
        }
    </style>
    <body>
        <%  int carportWidth = (int) request.getAttribute("carport width");
            int carportLength = (int) request.getAttribute("carport length");
            int shedWidth = (int) request.getAttribute("shed width");
            int shedLength = (int) request.getAttribute("shed length");
            String carportType = (String) request.getAttribute("carportType");
            int angle = 0;
            Partlist partlist = (Partlist) request.getAttribute("partList");
            if (carportType.equals("pointy")) {
                angle = (int) request.getAttribute("angle");
            } %>
        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h1 class="intro-text text-center">Order</h1>     
                        <p>Carport Width: <%=carportWidth%></p>
                        <p>Carport Length: <%=carportLength%></p>
                        <p>Shed Width: <%=shedWidth%></p>
                        <p>Shed Length: <%=shedLength%></p>
                        <% if (carportType.equals("pointy")) { %>
                        <p>Angle: <%=angle%></p>
                        <% } %>
                        <h2><strong>Parts needed:</strong></h2>
                        <%  Iterator partIterator = partlist.getPartList().iterator();
                                while (partIterator.hasNext()) { 
                                    Part part = (Part) partIterator.next();
                        %>          <p><%=part.toString() + "\n"%></p><% } %>
                        <%  int height = carportWidth;
                            int width = carportLength + shedLength;%>
                            <svg width="<%=width + 100%>" height="<%=height + 100%>">
<!--                                Carport width and length rectangle-->
                                <rect x="90" y="50" rx="5" ry="5" width="<%=width%>" height="<%=height%>" style="fill:white;stroke:black;stroke-width:4;" />
<!--                                ------------------------------------>
<!--                                Spær, monteres på rem-->
                            <%  int spærtræQuantity = partlist.getPartList().get(9).getQuantity() - 2;
                                if (spærtræQuantity % 2 == 0) {
                                    spærtræQuantity--;
                                }
                                int initialSpærtræIncrement = width / spærtræQuantity;
                                int spærtræIncrement = initialSpærtræIncrement;
                                int i = 0;
                                while (i < spærtræQuantity) { %>
                                    <line x1="<%=spærtræIncrement + 90%>" y1="<%=height + 50%>" x2="<%=spærtræIncrement + 90%>" y2="50" style="fill:white;stroke:rgb(0,0,0);stroke-width:4" />
                                <%  spærtræIncrement += initialSpærtræIncrement;
                                    i++;
                                } %>
<!--                                ----------------------->
<!--                                Remme i sider-->
                                <line x1="90" y1="<%=shedWidth + ((carportWidth-shedWidth) / 2) + 50%>" x2="<%=width + 90%>" y2="<%=shedWidth + ((carportWidth-shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                                <line x1="90" y1="<%=((carportWidth-shedWidth) / 2) + 50%>" x2="<%=width + 90%>" y2="<%=((carportWidth-shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
<!--                                --------------->
<!--                                Shed walls-->
                                <line x1="<%=carportLength + 90%>" y1="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" x2="<%=carportLength + 90%>" y2="<%=((carportWidth - shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                                <line x1="<%=(width + 90) - (initialSpærtræIncrement / 2)%>" y1="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" x2="<%=(width + 90) - (initialSpærtræIncrement / 2)%>" y2="<%=((carportWidth - shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
<!--                                ------------>
<!--                                Middle cross-->
                                <line x1="<%=carportLength + 90%>" y1="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" x2="<%=initialSpærtræIncrement + 90%>" y2="<%=((carportWidth - shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:6" />
                                <line x1="<%=carportLength + 90%>" y1="<%=((carportWidth - shedWidth) / 2) + 50%>" x2="<%=initialSpærtræIncrement + 90%>" y2="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:6" />
<!--                                -------------->
<!--                                Stolper-->
                            <%  double firstStolpeX = carportLength * 0.18; 
                                double secondStolpeX = carportLength * 0.78; %>
                                <rect x="<%=firstStolpeX + 90%>" y="<%=((carportWidth - shedWidth) / 2) + 42%>" width="16" height="16" style="fill:black;" />
                                <rect x="<%=secondStolpeX + 90%>" y="<%=((carportWidth - shedWidth) / 2) + 42%>" width="16" height="16" style="fill:black;" />
                                
                                <rect x="<%=firstStolpeX + 90%>" y="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 42%>" width="16" height="16" style="fill:black;" />
                                <rect x="<%=secondStolpeX + 90%>" y="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 42%>" width="16" height="16" style="fill:black;" />
                                
                                <rect x="<%=carportLength + 82%>" y="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 42%>" width="16" height="16" style="fill:black;" />
                                <rect x="<%=(width + 82) - (initialSpærtræIncrement / 2)%>" y="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 42%>" width="16" height="16" style="fill:black;" />
                                
                                <rect x="<%=carportLength + 82%>" y="<%=((carportWidth - shedWidth) / 2) + 42%>" width="16" height="16" style="fill:black;" />
                                <rect x="<%=(width + 82) - (initialSpærtræIncrement / 2)%>" y="<%=((carportWidth - shedWidth) / 2) + 42%>" width="16" height="16" style="fill:black;" />
                                
                                <rect x="<%=carportLength + 82%>" y="<%=(carportWidth / 2) + 42%>" width="16" height="16" style="fill:black;" />
                                <rect x="<%=(width + 82) - (initialSpærtræIncrement / 2)%>" y="<%=(carportWidth / 2) + 42%>" width="16" height="16" style="fill:black;" />
<!--                                --------->
<!--                                Top row dimensions-->
                            <%  spærtræIncrement = initialSpærtræIncrement; %>
                                <line x1="90" y1="40" x2="90" y2="30" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <text x="<%=((initialSpærtræIncrement / 2) / 2) + 90%>" y="40" fill="black"><%=(double) initialSpærtræIncrement / 100%></text>
                            <%  i = 0;
                                while (i < spærtræQuantity) { %>
                                    <line x1="<%=spærtræIncrement + 90%>" y1="40" x2="<%=spærtræIncrement + 90%>" y2="30" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                    <%  if (i < spærtræQuantity - 1) {%>
                                            <text x="<%=(((initialSpærtræIncrement / 2) / 2) + spærtræIncrement) + 90%>" y="40" fill="black"><%=(double) initialSpærtræIncrement / 100%></text>
                                    <%  } %>
                            <%      spærtræIncrement += initialSpærtræIncrement;
                                    i++;
                                } %>
<!--                                -------------------->
<!--                                Bottom row dimensions-->
                                <line x1="90" y1="<%=height + 80%>" x2="90" y2="<%=height + 70%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="<%=width + 90%>" y1="<%=height + 80%>" x2="<%=width + 90%>" y2="<%=height + 70%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="90" y1="<%=height + 80%>" x2="<%=width + 90%>" y2="<%=height + 80%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <text x="<%=(width / 2) + 90%>" y="<%=height + 70%>" fill="black"><%=String.format("%.2f", (double) width / 100)%></text>
                                
                                <line x1="80" y1="50" x2="20" y2="50" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="80" y1="<%=height + 50%>" x2="20" y2="<%=height + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="20" y1="50" x2="20" y2="<%=height + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <text x="<%=-(shedWidth / 2) - 80%>" y="40" fill="black" transform="rotate(-90, 0, 0)"><%=String.format("%.2f", (double) carportWidth / 100)%></text>
                                
                                <line x1="80" y1="<%=((carportWidth - shedWidth) / 2) + 50%>" x2="50" y2="<%=((carportWidth - shedWidth) / 2) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="80" y1="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" x2="50" y2="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <line x1="50" y1="<%=((carportWidth - shedWidth) / 2) + 50%>" x2="50" y2="<%=(carportWidth - ((carportWidth - shedWidth) / 2)) + 50%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:2" />
                                <text x="<%=-(shedWidth / 2) - 80%>" y="70" fill="black" transform="rotate(-90, 0, 0)"><%=String.format("%.2f", (double) shedWidth / 100)%></text>
<!--                                ----------------------->
                        </svg>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

