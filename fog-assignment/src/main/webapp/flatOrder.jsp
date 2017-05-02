<%-- 
    Document   : order
    Created on : Apr 18, 2017, 4:39:04 PM
    Author     : Lovro
--%>

<%@page import="business.facades.FlatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <form name="fog-assignment" action="orderServlet" method="POST">
            <input type="hidden" name="action" value="order"/>
            <input type="hidden" name="carportType" value="flat"/>
            <%
                int[] carportWidth = FlatFacade.getCarportWidth();
                int[] carportLength = FlatFacade.getCarportLength();
                int[] shedWidth = FlatFacade.getShedWidth();
                int[] shedLength = FlatFacade.getShedLength();
                String[] type = FlatFacade.getRoofType();
            %>  
            <div class="container">
                <div class="row">
                    <div class="box">
                        <div class="col-lg-12">   
                            <%  if ("Error".equals(request.getAttribute("errorMessageIncorrectDimensions"))) { %>
                            <div class="alert alert-danger alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Warning!</strong> The shed width and length cannot be more than 30 cm of the carport length and height 
                            </div>
                            <% } %>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Carport length</th>
                                        <th>Carport width</th>
                                        <th>Shed length</th>
                                        <th>Shed width</th>
                                        <th>Roof type</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <select name="carport length">
                                                <% for (int cl : carportLength) {%>
                                                <option><%=cl%></option>
                                                <%}%>
                                            </select></td>
                                        </td>
                                        <td>
                                            <select name="carport width">
                                                <% for (int cw : carportWidth) {%>
                                                <option><%=cw%></option>
                                                <%}%>
                                            </select>
                                        <td>
                                            <select name="shed length">
                                                <% for (int sl : shedLength) {%>
                                                <option><%=sl%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td>
                                            <select name="shed width">
                                                <% for (int sw : shedWidth) {%>
                                                <option><%=sw%></option>
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
                            <p>Shed dimensions should be AT LEAST 30 cm less in both width and length than carport dimensions</p>
                            <input type="submit" value="Order" />
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>