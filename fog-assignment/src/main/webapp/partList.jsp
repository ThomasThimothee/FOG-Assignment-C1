<%-- 
    Document   : partList
    Created on : May 9, 2017, 6:53:48 PM
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
        <% int idOrder = (int) request.getAttribute("idOrder");
        %>
        Parts: <% out.print(OrderFacade.retrieveAllOrder());
   %>
    </body>
</html>
