<%@page import="presentation.utility.RenderUtils"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Employee Signup</title>

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
<%  String[] navBarItems = {"Home, index.jsp", 
                            "Log in, loginEmployee.jsp",
                            "Sign up, regCustomer.jsp",
                            "Build, Pointy Carport, pointyOrder.jsp, Flat Carport, flatOrder.jsp"};
%>
<%=render.createNavBar(navBarItems)%>
<div class="container">
            <div class="row">
                <div class="box">  
                    <div class="col-lg-12">
                        <%  if ("Error".equals(request.getAttribute("errorMessageEmailExists"))) { %>
                                <div class="alert alert-danger alert-dismissable">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> E-mail already exists. 
                                </div>
                        <%  } 
                            if ("Error".equals(request.getAttribute("InsecurePasswordException"))) { %>
                                <div class="alert alert-danger alert-dismissable">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> Your password needs to be a least 7 characters long. 
                                </div>
                        <%  } %>
                        <hr>
                        <h1 class="intro-text text-center">Welcome, please fill out the following fields to create your account.</h1>
                        <hr>
                    </div>
                    <form class="form-horizontal" name ="EmployeeRegistrationForm" action="userServlet" method="POST">
                        <input type="hidden" name="formName" value="EmployeeRegistrationForm" />
                            <div class="form-group">
                                <div class="col-xs-offset-2 col-xs-8">
                                    <%  if ("Error".equals(request.getAttribute("InsecurePasswordException"))) { %>
                                        <input class="form-control" type="text" id="Username" name="username" placeholder="Username" value=<%=request.getAttribute("username")%> />
                                    <% } else { %>
                                        <input class="form-control" type="text" id="Username" name="username" placeholder="Username" />
                                    <% } %>
                                </div>
                            </div>
                            <% String[] values = {"password", "firstName", "lastName", "email", "phone"}; %>
                            <%=render.createFormRows(values)%>
                            <div class="row">
                                <div class="col-xs-offset-4 col-xs-4">
                                    <input class="form-control btn btn-success" type="submit" value="Register" name="register" />
                                </div>
                            </div>               
                    </form>                                 
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
</html>


