  <%@page import="business.Customer"%>
<%@page import="presentation.utility.RenderUtils"%>
<%@page import="business.facades.FlatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Build - Flat Carport</title>

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
    <div class="brand">FOG</div>
<%  RenderUtils render = new RenderUtils();
     Customer customer = (Customer) request.getSession().getAttribute("currentCustomer");
    String[] navBarItemsNotLoggedIn = {"Home, notLoggedInHome.jsp",
                                            "Log in, loginCustomer.jsp",
                                            "Sign up, regCustomer.jsp",
                                            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp"};
        String[] navBarItemsLoggedIn = {"Home, loggedInHome.jsp", 
                                        "Account, customerInfo.jsp",
                                        "My Orders, customerOverview.jsp",
                                        "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
                                        "Logout, index.jsp"};
        if (customer != null) {
        %> <%=render.createNavBar(navBarItemsLoggedIn)%> <%     
        } else {
        %> <%=render.createNavBar(navBarItemsNotLoggedIn)%> 
    <%  } %>
     <div class="container">


            <div class="row">
                <div class="box">  
                    <div class="col-lg-12">
                        <hr>
                        <h1 class="intro-text text-center">Woops, seems like something went wrong. We're sorry about that</h1>
                        <img src="img\group.jpg" alt="Error Picture" style="width:100%">
                    </div>
                </div>
            </div>
     </div>
</body>
</html>