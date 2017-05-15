<%@page import="business.Customer"%>
<%@page import="presentation.utility.RenderUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Index</title>
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="stylesheet.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="brand">FOG</div>
    <div class="container">
        <div class="col-lg-offset-2 col-lg-8 col-xs-offset-1 col-xs-10 text-center">
            <div class="box">
                <div class="row">
                    <form  name ="Action" action="IndexServlet" method="POST">
                        <input type="hidden" name="formName" value="customer" />
                        <div class="btn-group">
                            <button type="submit" class="btn btn-default btn-lg" style="margin-bottom: 20px">Customer</button>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <div class="dropdown btn-group">
                        <button class="btn btn-default btn-lg dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Employee
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <form  name ="Action" action="IndexServlet" method="POST">
                                <input type="hidden" name="formName" value="loginEmployee" />
                                <li><button type="submit" class="btn btn-default btn-lg dropdown-item">Log in</button></li>
                            </form>
                            <form name ="Action" action="IndexServlet" method="POST">
                                <input type="hidden" name="formName" value="regEmployee" />
                                <li><button type="submit" class="btn btn-default btn-lg dropdown-item">Register</button></li>
                            </form>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>