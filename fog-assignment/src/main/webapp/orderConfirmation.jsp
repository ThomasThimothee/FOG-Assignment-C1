<%@page import="presentation.utility.RenderUtils"%>
<%@page import="business.Pointy"%>
<%@page import="business.Carport"%>
<%@page import="presentation.utility.SVGUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="business.Flat"%>
<%@page import="business.parts.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
</head>
<body>
    <%  Carport carport = (Carport) request.getAttribute("selectedCarport");
        SVGUtils svg = new SVGUtils();
        RenderUtils render = new RenderUtils(); %>
    <div class="brand">FOG</div>
    <!-- Navigation -->
    <%  String[] navBarItems = {"Home, loggedInHome.jsp", 
                                "Account, customerInfo.jsp",
                                "My Orders, customerOverview.jsp",
                                "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
                                "Logout, index.jsp"};
    %>
    <%=render.createNavBar(navBarItems)%>
    <div class="container">
        <div class="row">
            <div class="col-xs-offset-1 col-xs-10">
                <div class="box">
                    <hr>
                    <h1 class="intro-text text-center">Order</h1>     
                    <hr>
                    <p>Carport Width: <%=carport.getCarportWidth()%></p>
                    <p>Carport Length: <%=carport.getCarportLength()%></p>
                    <p>Shed Width: <%=carport.getShedWidth()%></p>
                    <p>Shed Length: <%=carport.getShedLength()%></p>
                    <%  if (carport.getType().equals("Pointy")) {
                            Pointy pointy = (Pointy) carport; %>
                            <p>Angle: <%=pointy.getAngle()%></p>
                    <%  } 
                        if (carport.getType().equals("Flat")) { 
                            Flat flat = (Flat) carport; %>
                            <svg viewBox="0, 0, <%=carport.getTotalLength() + svg.getxOffset()%>, <%=carport.getCarportWidth() + svg.getyOffset()%>" style="width: 100%" preserveAspectRatio="xMinYMin meet">
                                <%=svg.drawFlatTopView(flat)%>
                            </svg>
                    <%  } else { 
                            Pointy pointy = (Pointy) carport; %>    
                            <svg viewBox="0, 0, <%=pointy.getTotalLength() + 100%>, <%=pointy.getCarportWidth() + 100%>" style="width: 100%" preserveAspectRatio="xMinYMin meet">
                                <%=svg.drawPointyTopView(pointy)%>
                            </svg>
                    <%  } %>
                </div>
            </div>
        </div>
    </div>
</body>¨
<script src="js/jquery.js"></script>
</html>

