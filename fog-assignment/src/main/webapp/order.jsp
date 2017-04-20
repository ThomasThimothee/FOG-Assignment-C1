<%-- 
    Document   : order
    Created on : Apr 18, 2017, 4:39:04 PM
    Author     : Lovro
--%>

<%@page import="business.FlatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <form name="fog-assignment" action="orderServlet" method="POST">
            <input type="hidden" name="formName" value="order"/>
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
                                            <p>Shed dimensions should be ATLEAST 30 cm less in both width and length than carport dimensions</p>
                            <input type="submit" value="Order" />
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>