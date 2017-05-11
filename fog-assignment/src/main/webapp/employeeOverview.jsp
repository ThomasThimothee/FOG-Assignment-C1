<%-- 
    Document   : employeeOverview
    Created on : May 9, 2017, 2:21:19 PM
    Author     : Lovro
--%>

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
    </head>
    <body>
        <%--  <% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list"); %> --%>
        <% ArrayList<Order> list = OrderFacade.retrieveAllOrder();
        %>

        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">   
                        <table border="1" id="myTable">
                            <thead>
                                <tr>
                                    <th onclick="sortTable(0)">Order ID</th>
                                    <th>Customer ID</th>
                                    <th>Sales Rep ID</th>
                                    <th>Order date</th>
                                    <th>Carport type</th>
                                    <th>Roof type</th>
                                    <th>Carport Width</th>
                                    <th>Carport Length</th>
                                    <th>Shed Width</th>
                                    <th>Shed Length</th>
                                    <th>Roof Height</th>
                                    <th>Angle</th>
                                    <th>Status</th>
                                    <th>Discount Rate</th>
                                    <th>Standard Price</th>
                                    <th>Final Price</th>                                 
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getOrderId() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getCustomerId() + "</div>");
                                            }
                                        %>
                                    </td>


                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getSalesRepId() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getDate() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getCarportType() + "</div>");
                                            }
                                        %> 
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getRoofType() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getCarportWidth() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getCarportLength() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getShedWidth() + "</div>");
                                            }
                                        %>   
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getShedLength() + "</div>");
                                            }
                                        %> 
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getRoofHeight() + "</div>");
                                            }
                                        %> 
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getAngle() + "</div>");
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.isStatus() + "</div>");
                                            }
                                        %>   
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getDiscount() + "</div>");
                                            }
                                        %> 
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getStandardPrice() + "</div>");
                                            }
                                        %>   
                                    </td>

                                    <td>
                                        <%
                                            for (Order thisorder : list) {
                                                out.print("<div>" + thisorder.getFinalPrice() + "</div>");
                                            }
                                        %>   
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <form class="form-horizontal" name ="AddDiscount" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="AddDiscount" />
                                <div class="form-group col-md-4">
                                    <button type="submit" name="discount" class="btn btn-success">Add discount</button><input type="text" name="discountRate" class="form-control" placeholder="discount rate in %"><input type="text" name="idOrder" class="form-control">
                                </div>

                            </form>
                            <form class="form-horizontal" name ="ViewPartlist" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="ViewPartlist" />
                                <div class="form-group col-md-4">

                                    <button type="submit" name="partlist" class="btn btn-success">View partlist</button><input type="text" name="idOrder" class="form-control">
                                </div>
                            </form>
                            <form class="form-horizontal" name ="ViewCustomerDetails" action="testServlet" method="POST">
                                <input type="hidden" name="formName" value="ViewCustomerDetails" />                             
                                <div class="form-group col-md-4">

                                    <button type="submit" name="customer details" class="btn btn-success">View customer details</button><input type="text" name="idCustomer" class="form-control">
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function sortTable(n) {
                var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
                table = document.getElementById("myTable");
                switching = true;

                dir = "asc";
                while (switching) {
                    switching = false;
                    rows = table.getElementsByTagName("TR");
                    for (i = 1; i < (rows.length - 1); i++) {
                        shouldSwitch = false;
                        x = rows[i].getElementsByTagName("TD")[n];
                        y = rows[i + 1].getElementsByTagName("TD")[n];
                        if (dir == "asc") {
                            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        } else if (dir == "desc") {
                            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }
                    if (shouldSwitch) {
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        switching = true;
                        switchcount++;
                    } else {
                        if (switchcount == 0 && dir == "asc") {
                            dir = "desc";
                            switching = true;
                        }
                    }
                }
            }
        </script>   
    </body>
</html>
