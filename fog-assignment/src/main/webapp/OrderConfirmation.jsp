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
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

