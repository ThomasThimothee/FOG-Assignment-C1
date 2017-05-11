<%-- 
    Document   : customerDetails
    Created on : May 10, 2017, 8:50:59 AM
    Author     : Lovro
--%>

<%@page import="business.Customer"%>
<%@page import="java.util.ArrayList"%>
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
        ArrayList<Customer> list = CustomerFacade.retrieveCustomerDetails(idCustomer);
        %>
      
   <table border="1">
       <thead>
           <tr>
               <th>Email</th>
               <th>Password</th>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Address</th>
               <th>Phone Number</th>
           </tr>
       </thead>
       <tbody>
           <tr>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getEmail() + "</div>");
                                            }
                                        %>
               </td>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getPassword() + "</div>");
                                            }
                                        %>
               </td>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getFirstName() + "</div>");
                                            }
                                        %>
               </td>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getLastName() + "</div>");
                                            }
                                        %>
               </td>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getAddress() + "</div>");
                                            }
                                        %>
               </td>
               <td>
                    <%
                                            for (Customer thiscustomer : list) {
                                                out.print("<div>" + thiscustomer.getPhone() + "</div>");
                                            }
                                        %>
               </td>
           </tr>
       </tbody>
   </table>

    </body>
</html>
