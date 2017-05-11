<%-- 
    Document   : employeeOverview
    Created on : May 9, 2017, 2:21:19 PM
    Author     : Lovro
--%>

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

        <title>Employee Log-in</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="/path/to/jquery-latest.js"></script> 
<script type="text/javascript" src="/path/to/jquery.tablesorter.js"></script> 
    </head>
    <body>
        <%--  <% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list"); %> --%>
        <%  ArrayList<Order> list = OrderFacade.retrieveAllOrder();
            RenderUtils render = new RenderUtils();
        %>
        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-xs-offset-1 col-xs-10" style="height:768px; overflow: auto">   
                        <table class="table table-striped table-bordered" id="myTable">
                            <thead>
                                <tr>
                                    <th>Order ID</th>
                                    <th>Customer ID</th>
                                    <th>Sales Rep ID</th>
                                    <th>Order date</th>
                                    <th>Status</th>
                                    <th>Discount Rate</th>
                                    <th>Standard Price</th>
                                    <th>Final Price</th>                                 
                                </tr>
                            </thead>
                            <tbody>
                                <%=render.employeeOverviewTest(list)%>
                            </tbody>
                        </table>
                        </div>
                        <div class="row">
                            <form class="form-horizontal" name ="AddDiscount" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="AddDiscount" />
                                <div class="form-group col-md-4">
                                    <button type="submit" name="discount" class="btn btn-success">Add discount</button><input type="text" name="discountRate" class="form-control" placeholder="discount rate in %"><input type="text" name="idOrder" class="form-control" placeholder="Order ID">
                                </div>

                            </form>
                            <form class="form-horizontal" name ="ViewPartlist" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="ViewPartlist" />
                                <div class="form-group col-md-4">

                                    <button type="submit" name="partlist" class="btn btn-success">View partlist</button><input type="text" name="idOrder" class="form-control" placeholder="Order ID">
                                </div>
                            </form>
                            <form class="form-horizontal" name ="ViewCustomerDetails" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="ViewCustomerDetails" />                             
                                <div class="form-group col-md-4">

                                    <button type="submit" name="customer details" class="btn btn-success">View customer details</button><input type="text" name="idCustomer" class="form-control" placeholder="Customer ID">
                                </div>
                            </form>

                        </div>
                </div>
            </div>
        </div>
        <script>
           $(document).ready(function() 
    { 
        $("#myTable").tablesorter(); 
    } 
); 
    
        </script>   
    </body>
</html>
