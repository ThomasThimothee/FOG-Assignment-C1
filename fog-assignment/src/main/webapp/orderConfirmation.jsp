<%@page import="business.Pointy"%>
<%@page import="business.Carport"%>
<%@page import="presentation.utility.SVGUtils"%>
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
    <link href="stylesheet.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <style>
        p {
            white-space: pre;
        }
    </style>
    <body>
        <%  Carport carport = (Carport) request.getAttribute("selectedCarport");
            SVGUtils svg = new SVGUtils();%>
        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h1 class="intro-text text-center">Order</h1>     
                        <p>Carport Width: <%=carport.getCarportWidth()%></p>
                        <p>Carport Length: <%=carport.getCarportLength()%></p>
                        <p>Shed Width: <%=carport.getShedWidth()%></p>
                        <p>Shed Length: <%=carport.getShedLength()%></p>
                        <% if (carport.getType().equals("Pointy")) {
                                Pointy pointy = (Pointy) carport; %>
                                <p>Angle: <%=pointy.getAngle()%></p>
                        <% } %>
                        <h2><strong>Parts needed:</strong></h2>
                        <%  Iterator partIterator = carport.getPartList().getPartList().iterator();
                                while (partIterator.hasNext()) { 
                                    Part part = (Part) partIterator.next();
                        %>          <p><%=part.toString() + "\n"%></p>
                                <% } 
                            if (carport.getType().equals("Flat")) { 
                                Flat flat = (Flat) carport; %>
                                <svg viewBox="0, 0, <%=carport.getTotalLength() + 100%>, <%=carport.getCarportWidth() + 100%>" width="1024" height="768" preserveAspectRatio="xMinYMin meet">
                                    <%=svg.drawFlatTopView(flat)%>
                                </svg>
                        <%  } else { 
                                Pointy pointy = (Pointy) carport; %>    
                                <svg viewBox="0, 0, <%=pointy.getTotalLength() + 100%>, <%=pointy.getCarportWidth() + 100%>" width="1024" height="768" preserveAspectRatio="xMinYMin meet">
                                    <%=svg.drawPointyTopView(pointy)%>
                                </svg>
                        <%  } %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

