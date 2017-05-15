<%@page import="presentation.utility.RenderUtils"%>
<%@page import="business.Orderline"%>
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

    <title>Partlist</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="stylesheet.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <%  int idOrder = (int) request.getAttribute("idOrder");
        ArrayList<Orderline> list = OrderFacade.retrievePartlist(idOrder);
        RenderUtils render = new RenderUtils();
    %>
    <div class="brand">FOG</div>
    <!--        <   !-- Navigation -->
    <%  String[] navBarItems = {"Orders, employeeOverview.jsp",
                                "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
                                "Logout, index.jsp"};
    %>
    <%=render.createNavBar(navBarItems)%>
    <div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12">  
                    <table border="1" width="100%"style="overflow: auto" >
                        <thead>
                            <tr>
                                <th>Part Name</th>
                                <th>Length</th>
                                <th>Quantity</th>
                                <th>Explanation</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <%
                                        for (Orderline thisorderline : list) {
                                            out.print("<div>" + thisorderline.getPartName() + "</div>");
                                        }
                                    %>
                                </td>
                                <td>
                                    <%
                                        for (Orderline thisorderline : list) {
                                            out.print("<div>" + thisorderline.getLength() + "</div>");
                                        }
                                    %>
                                </td>
                                <td>
                                    <%
                                        for (Orderline thisorderline : list) {
                                            out.print("<div>" + thisorderline.getQuantity() + "</div>");
                                        }
                                    %>
                                </td>
                                <td>
                                    <%
                                        for (Orderline thisorderline : list) {
                                            out.print("<div>" + thisorderline.getExplanation() + "</div>");
                                        }
                                    %>
                                </td>
                                <td>
                                    <%
                                        for (Orderline thisorderline : list) {
                                            out.print("<div>" + thisorderline.getPrice() + "</div>");
                                        }
                                    %>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery.js"></script>
</html>
