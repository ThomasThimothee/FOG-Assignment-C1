<%@page import="presentation.utility.RenderUtils"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Log-in</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="stylesheet.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head> 
<body>
<% RenderUtils render = new RenderUtils(); %>
<div class="brand">FOG</div>
<!-- Navigation -->
<%  String[] navBarItems = {"Home, loggedInHome.jsp", 
                            "Account, customerInfo.jsp",
                            "My Orders, customerOverview.jsp",
                            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
                            "Logout, index.jsp"};
%>
<%=render.createNavBar(navBarItems)%>
<div class="container">
    <div class="row">
        <div class="col-xs-offset-2 col-xs-8 text-center">
            <div class="box">
                <div id="carousel-example-generic" class="carousel slide">
                    <!-- Indicators -->
                    <ol class="carousel-indicators hidden-xs">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <a href="flatOrder.jsp"><img class="img-responsive img-full" src="img/flatCarport.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href="pointyOrder.jsp"><img class="img-responsive img-full" src="img/pointyCarport.jpg" alt=""></a>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/jquery.js"></script>