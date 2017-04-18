<%@page import="business.Flat"%>
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
         
           <% int carportWidth = (int)request.getAttribute("carport width"); %>
           <% int carportLength = (int)request.getAttribute("carport length"); %>
           <% int shedWidth = (int)request.getAttribute("shed width"); %>
           <% int shedLength = (int)request.getAttribute("shed length"); %>
           <div class="container">


            <div class="row">
                <div class="box">
                    
          <div class="col-lg-12">
        <hr>
        <h1 class="intro-text text-center">Your Order</h1>     
        <p>Carport Width: <%=carportWidth%></p>
          <p>Carport Length: <%=carportLength%></p>
            <p>Shed Width: <%=shedWidth%></p>
              <p>Shed Length: <%=shedLength%></p>
           <p>You ordered  <%= request.getAttribute("listOfParts") %></p>
          </div>
                </div>
            </div>
           </div>
    </body>
</html>

