
<%@page import="presentation.utility.RenderUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">


        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">
        <link href="stylesheet.css" rel="stylesheet">
        
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <% RenderUtils render = new RenderUtils(); %>
        <div class="brand">FOG</div>
        <!-- Navigation -->
        <%  String[] navBarItems = {"Home, index.jsp", 
                                    "Register, Admin, regEmployee.jsp, Customer, regCustomer.jsp",
                                    "Login, Admin, loginEmployee.jsp, Customer, loginCustomer.jsp",
                                    "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp"};
        %>
        <%=render.createNavBar(navBarItems)%>
    </body>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>


</html>