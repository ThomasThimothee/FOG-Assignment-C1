<%-- 
    Document   : partList
    Created on : May 9, 2017, 6:53:48 PM
    Author     : Lovro
--%>

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
        <% int idOrder = (int) request.getAttribute("idOrder");
       
        ArrayList<Orderline> list = OrderFacade.retrievePartlist(idOrder);
        %>
         <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">  
        <table border="1">
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
</html>