<%@page import="business.Flat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        p {
            white-space: pre;
        }
    </style>


    <body>

        <% int carportWidth = (int) request.getAttribute("carport width"); %>
        <% int carportLength = (int) request.getAttribute("carport length"); %>
        <% int shedWidth = (int) request.getAttribute("shed width"); %>
        <% int shedLength = (int) request.getAttribute("shed length");%>
        <div class="container">


            <div class="row">
                <div class="box">

                    <div class="col-lg-12">
                        <hr>
                        <h1 class="intro-text text-center">Order</h1>     
                        <p>Carport Width: <%=carportWidth%></p>
                        <p>Carport Length: <%=carportLength%></p>
                        <p>Shed Width: <%=shedWidth%></p>
                        <p>Shed Length: <%=shedLength%></p>
                        <p>Parts needed:</p>
                        <p><%= request.getAttribute("listOfParts")%></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

