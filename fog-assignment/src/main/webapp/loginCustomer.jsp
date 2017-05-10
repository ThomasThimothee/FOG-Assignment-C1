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
<div class="brand">FOG</div>
<% RenderUtils render = new RenderUtils(); %>
<%  String[] navBarItems = {"Home, notLoggedInHome.jsp", 
                            "Log in, loginCustomer.jsp",
                            "Sign up, regCustomer.jsp",
                            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp"};
%>
<%=render.createNavBar(navBarItems)%>
<div class="container">
    <div class="row">
        <div class="col-lg-offset-2 col-lg-8 col-xs-offset-1 col-xs-10">
            <div class="box">
                <% if ("Error".equals(request.getAttribute("errorMessageUserNotFound"))) { %>
                <div class="alert alert-danger">
                    <strong>Whoops</strong> You've entered wrong email &/or password!
                </div>
                <%}%>
            
            <hr>
            <h2 class="intro-text text-center">Login
                <strong>form</strong>
            </h2>
            <hr>
                <form class="form-horizontal" name ="CustomerLoginForm" action="userServlet" method="POST">
                    <input type="hidden" name="formName" value="CustomerLoginForm"/>
                    <div class="row">
                        <% String[] values = {"email", "password"}; %>
                        <%=render.createFormRows(values)%>
                        <div class="row">
                            <div class="col-xs-offset-4 col-xs-4">
                                <input type="hidden" name="action" value="login">
                                <label><br></label>
                                <button type="submit" class="form-control btn btn-success">Sign in</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</body>
<script src="js/jquery.js"></script>
<script>
    $(function () {
        $('#Email').on('keypress', function (e) {
            if (e.which == 32)
                return false;
        });
        $('#Password').on('keypress', function (e) {
            if (e.which == 32)
                return false;
        });
    });
</script>
