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
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

