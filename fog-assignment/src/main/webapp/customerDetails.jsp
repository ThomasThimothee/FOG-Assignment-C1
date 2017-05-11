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
        <% int idCustomer = (int) request.getAttribute("idCustomer");
        ArrayList<Customer> list = CustomerFacade.retrieveCustomerDetails(idCustomer);
        %>
       <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">  
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
                    </div>
                </div>
            </div>
       </div>
    </body>
</html>
