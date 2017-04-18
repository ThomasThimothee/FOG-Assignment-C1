<%-- 
    Document   : order
    Created on : Apr 18, 2017, 4:39:04 PM
    Author     : Lovro
--%>

<%@page import="business.FlatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Contact - Business Casual - Start Bootstrap Theme</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
       <form name="fog-assignment" action="orderServlet" method="POST">
            <input type="hidden" name="formName" value="order"/>
            <%

                int[] carportWidth= FlatFacade.getCarportWidth();
                int[] carportLength = FlatFacade.getCarportLength();
                int[] shedWidth = FlatFacade.getShedWidth();
                int[] shedLength = FlatFacade.getShedLength();
                String[]type = FlatFacade.getRoofType();
            %>  
  <div class="container">


            <div class="row">
                <div class="box">
                 <div class="col-lg-12">     
            <table border="1">
                <thead>
                    <tr>
                        <th>Carport width</th>
                        <th>Carport length</th>
                        <th>Shed width</th>
                        <th>Shed length</th>
                        <th>Roof type</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="carport width">
                                <% for (int cw : carportWidth) {%>
                                <option><%=cw%></option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="carport length">
                                <% for (int cl : carportLength) {%>
                                <option><%=cl%></option>
                                <%}%>
                            </select></td>
                              <td>
                                <select name="shed width">
                        <% for (int sw : shedWidth) {%>
                        <option><%=sw%></option>
                        <%}%>
                    </select>
                            </td>
                              <td>
                                <select name="shed length">
                        <% for (int sl : shedLength) {%>
                        <option><%=sl%></option>
                        <%}%>
                    </select>
                            </td>
                            <td>
                                <select name="roof type">
                        <% for (String t : type) {%>
                        <option><%=t%></option>
                        <%}%>
                    </select>
                            </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Order" />
                 </div>
                </div>
            </div>
  </div>
       </form>
    </body>
</html>
