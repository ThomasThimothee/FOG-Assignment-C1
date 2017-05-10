<%@page import="business.Customer"%>
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
<%  RenderUtils render = new RenderUtils(); 
    Customer customer = (Customer) request.getSession().getAttribute("currentCustomer");  %>
<div class="brand">FOG</div>
<!-- Navigation -->
<%  String[] navBarItems = {"Home, index.jsp", 
                            "Settings, customerInfo.jsp",
                            "My Orders, customerOverview.jsp",
                            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp",
                            "Logout, index.jsp"};
%>
<%=render.createNavBar(navBarItems)%>
<div class="container">
    <div class="col-lg-offset-2 col-lg-8 col-xs-offset-1 col-xs-10">
        <div class="box">
            <hr>
            <h2 class="intro-text text-center">Customer <strong>Information</strong></h2>
            <hr>
            <%  if ("Error".equals(request.getAttribute("errorMessageEmailExists"))) { %>
                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Warning!</strong> E-mail already exists. 
                    </div>
            <%  } 
                if ("Error".equals(request.getAttribute("IncorrectEmailFormattingException"))) { %>
                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Warning!</strong> Please enter a valid e-mail address. 
                    </div>
            <%  } 
                if ("Error".equals(request.getAttribute("InsecurePasswordException"))) { %>
                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Warning!</strong> Your password needs to be a least 7 characters long. 
                    </div>
            <%  } 
                if ("Error".equals(request.getAttribute("EmailAlreadyInUseException"))) { %>
                        <div class="alert alert-danger alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Error!</strong> The entered e-mail is already in use. 
                        </div>
            <%  } %>
            <form class="form-horizontal" name ="CustomerInformation" action="userServlet" method="POST">
                <input type="hidden" name="formName" value="CustomerInformation" />
                    <%=render.createFormRows(customer)%>
                    <div class="row">
                        <div class="col-xs-offset-4 col-xs-4">
                            <input class="form-control btn btn-success" type="submit" value="Update" name="update" />
                        </div>
                    </div>               
            </form>   
        </div>
    </div>
</div>
</body>
<script src="js/jquery.js"></script>

