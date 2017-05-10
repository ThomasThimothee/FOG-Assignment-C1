<%-- 
    Document   : discountRate
    Created on : May 10, 2017, 10:33:30 AM
    Author     : Lovro
--%>

<%@page import="business.facades.OrderFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% double discountRate = (double) request.getAttribute("discountRate");
            int idOrder = (int) request.getAttribute("idOrder"); %>
            Discount Rate: <% out.print(OrderFacade.setDiscountRate(discountRate, idOrder)); %>
    </body>
</html>
