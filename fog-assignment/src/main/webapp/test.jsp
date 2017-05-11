<%-- 
    Document   : test
    Created on : May 10, 2017, 4:38:52 PM
    Author     : Lovro
--%>

<%@page import="business.facades.OrderFacade"%>
<%@page import="business.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <% ArrayList<Order> list = OrderFacade.retrieveAllOrder(); 
   for(Order thisorder:list) { 
      out.print("<div>"+thisorder.getOrderId()+"</div>"); 
   } 
%>
    </body>
</html>
