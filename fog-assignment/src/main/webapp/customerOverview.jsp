<%@page import="business.Customer"%>
<%@page import="presentation.utility.RenderUtils"%>
<%@page import="business.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.facades.OrderFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Overview</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="stylesheet.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://mottie.github.io/tablesorter/css/theme.default.css" rel="stylesheet">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
    <script>
        $(function () {
            $("#myTable").tablesorter({widgets: ['zebra']});
        });
    </script>
</head>
<body>
    <% Customer customer = (Customer) session.getAttribute("currentCustomer"); %>
    <%  ArrayList<Order> list = OrderFacade.retrieveCustomerOrders(customer.getId_customer());
        RenderUtils render = new RenderUtils(); %>
    <div class="brand">FOG</div>
    <!--        <   !-- Navigation -->
    <%  String[] navBarItems = {"Home, loggedInHome.jsp",
            "Account, customerInfo.jsp",
            "My Orders, customerOverview.jsp",
            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
            "Logout, index.jsp"};
    %>
    <%=render.createNavBar(navBarItems)%>
    <div class="container">
        <div class="row">
            <div class="box">
                <div class="col-xs-12" style="height:768px; overflow: auto">   
                    <% if ("IncorrectOrderId".equals(request.getAttribute("Error"))) { %>
                    <div class="alert alert-danger">
                        <strong>Whoops</strong> You've entered wrong order ID!
                    </div>
                    <%}%>
                    <table class="table" id="myTable">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Sales Rep ID</th>
                                <th>Order date</th>
                                <th>Paid</th>
                                <th>Final Price</th>                                 
                            </tr>
                        </thead>
                        <tbody>
                            <%=render.createCustomerOverviewTable(list)%>
                        </tbody>
                    </table>
                </div>
                <div class="row" style="margin-bottom: 20px">
                    <form name="PayOrder" action="CustomerServlet" method="POST">
                        <input type="hidden" name="formName" value="PayOrder" />
                        <div class="col-xs-12">
                            <div class="form-group"> 
                                <div class="col-xs-5">
                                    <input type="text" name="idOrder" class="form-control" placeholder="Order ID">
                                </div>
                                <div class="col-xs-2">
                                    <button type="submit" name="Pay Order" class="btn btn-success">Pay Order</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="row" style="margin-bottom: 20px">
                    <form name="ViewPartlist" action="CustomerServlet" method="POST">
                        <input type="hidden" name="formName" value="ViewDrawing" />
                        <div class="col-xs-12">
                            <div class="form-group"> 
                                <div class="col-xs-10">
                                    <input type="text" name="idOrder" class="form-control" placeholder="Order ID">
                                </div>

                                <div class="col-xs-2"> 
                                    <button type="submit" name="viewDrawing" class="btn btn-success ">View drawing</button>
                                </div>  
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
