<%-- 
    Document   : customerDetails
    Created on : May 10, 2017, 8:50:59 AM
    Author     : Lovro
--%>

<%@page import="business.facades.CustomerFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int idCustomer = (int) request.getAttribute("idCustomer");
        %>
        Customer details: <% out.print(CustomerFacade.retrieveCustomerDetails(idCustomer));
   %>
    </body>
</html>
