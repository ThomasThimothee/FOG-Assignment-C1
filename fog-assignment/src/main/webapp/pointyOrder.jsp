<%@page import="business.Customer"%>
<%@page import="presentation.utility.RenderUtils"%>
<%@page import="business.facades.PointyFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Build - Pointy Carport</title>

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
        int[] carportWidth = PointyFacade.getCarportWidth();
        int[] carportLength = PointyFacade.getCarportLength();
        int[] shedWidth = PointyFacade.getShedWidth();
        int[] shedLength = PointyFacade.getShedLength();
        String[] type = PointyFacade.getRoofType();
        int[] angle = PointyFacade.getAngle();
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
            <div class="col-xs-offset-1 col-xs-10">
                <div class="box">  
                    <%  if ("Error".equals(request.getAttribute("errorMessageIncorrectDimensions"))) { %>
                            <div class="alert alert-danger alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Warning!</strong> The shed width and length cannot be more than 30 cm of the carport length and height 
                            </div>
                    <%  } 
                        if (customer == null) { %>
                            <div class="alert alert-warning alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Warning!</strong> You are not logged in. You will not be able to make an order. 
                            </div>
                   <% } %>
                    <div class="row">
                        <div class="col-xs-offset-2 col-xs-8">
                            <p class="text-warning">The shed's dimensions need to be at least 30 cm. less in both width and length compared to the carport's dimensions</p>
                        </div>
                    </div>
                    <div class="row">
                    <form class="form-horizontal" name="fog-assignment" action="OrderServlet" method="POST">
                        <% if (customer != null) {%>
                            <input type="hidden" name="action" value="order"/>
                        <% } else { %>
                            <input type="hidden" name="action" value="notLoggedIn"/>
                        <% } %>
                        <input type="hidden" name="carportType" value="Pointy"/>
                        <div class="form-group">    
                            <label class="control-label col-sm-offset-2 col-sm-2" for="carportLength">Carport length</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control "name="carport length" id="carportLength">
                                    <% for (int cl : carportLength) {%>
                                    <option><%=cl%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">   
                            <label class="control-label  col-sm-offset-2 col-sm-2" for="carportWidth">Carport width</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control" name="carport width" id="carportWidth">
                                    <% for (int cw : carportWidth) {%>
                                    <option><%=cw%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">  
                            <label class="control-label  col-sm-offset-2 col-sm-2" for="shedLength">Shed length</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control" name="shed length" id="shedLength">
                                    <% for (int sl : shedLength) {%>
                                    <option><%=sl%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">  
                            <label class="control-label  col-sm-offset-2 col-sm-2" for="shedWidth">Shed width</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control" name="shed width" id="shedWidth">
                                    <% for (int sw : shedWidth) {%>
                                    <option><%=sw%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">   
                            <label class="control-label col-sm-offset-2 col-sm-2" for="roofType">Roof type</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control" name="roof type" id="roofType">
                                    <% for (String t : type) {%>
                                    <option><%=t%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">   
                            <label class="control-label col-sm-offset-2 col-sm-2" for="angle">Angle</label>                                    
                            <div class="col-sm-6">
                                <select class="form-control" name="angle" id="angle">
                                    <% for (int a : angle) {%>
                                    <option><%=a%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-4">
                                <input type="submit" class="btn btn-default" value="Order" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery.js"></script>
</html>