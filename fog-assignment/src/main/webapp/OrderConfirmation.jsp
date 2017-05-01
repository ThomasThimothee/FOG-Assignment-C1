<%@page import="java.util.Iterator"%>
<%@page import="business.Partlist"%>
<%@page import="business.Flat"%>
<%@page import="business.parts.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                            <svg width="<%=width + 50%>" height="<%=height + 50%>">
                                <rect x="25" y="25" rx="5" ry="5" width="<%=width%>" height="<%=height%>" style="fill:white;stroke:black;stroke-width:5;" />
                            <%  int spærtræQuantity = partlist.getPartList().get(9).getQuantity() - 2;
                                if (spærtræQuantity % 2 == 0) {
                                    spærtræQuantity--;
                                }
                                int initialSpærtræIncrement = width / spærtræQuantity;
                                int spærtræIncrement = initialSpærtræIncrement;
                                int i = 0;
                                while (i < spærtræQuantity) { %>
                                    <line x1="<%=spærtræIncrement + 25%>" y1="<%=height + 25%>" x2="<%=spærtræIncrement + 25%>" y2="25" style="fill:white;stroke:rgb(0,0,0);stroke-width:6" />
                                <%  spærtræIncrement += initialSpærtræIncrement;
                                    i++;
                                } %>
<!--                                Remme i sider-->
                                <line x1="25" y1="<%=shedWidth + 25%>" x2="<%=width + 25%>" y2="<%=shedWidth + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                                <line x1="25" y1="<%=(carportWidth-shedWidth) + 25%>" x2="<%=width + 25%>" y2="<%=(carportWidth-shedWidth) + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
<!--                                --------------->
<!--                                shed walls-->
                                <line x1="<%=carportLength + 25%>" y1="<%=(carportWidth - (carportWidth - shedWidth)) + 25%>" x2="<%=carportLength + 25%>" y2="<%=(carportWidth - shedWidth) + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                                <line x1="<%=(width + 25) - (initialSpærtræIncrement / 2)%>" y1="<%=(carportWidth - (carportWidth - shedWidth)) + 25%>" x2="<%=(width + 25) - (initialSpærtræIncrement / 2)%>" y2="<%=(carportWidth - shedWidth) + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
<!--                                ------------>
                                <line x1="<%=carportLength + 25%>" y1="<%=(carportWidth - (carportWidth - shedWidth)) + 25%>" x2="<%=initialSpærtræIncrement + 25%>" y2="<%=(carportWidth - shedWidth) + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                                <line x1="<%=carportLength + 25%>" y1="<%=(carportWidth - shedWidth) + 25%>" x2="<%=initialSpærtræIncrement + 25%>" y2="<%=(carportWidth - (carportWidth - shedWidth)) + 25%>" style="fill:white;stroke:rgb(0,0,0);stroke-width:8" />
                        </svg>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

