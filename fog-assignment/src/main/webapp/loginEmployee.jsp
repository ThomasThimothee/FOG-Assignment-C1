<%@page import="presentation.utility.RenderUtils"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Employee Log-in</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head> 
<body>
<% RenderUtils render = new RenderUtils(); %>
<div class="container">
    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <% if ("Error".equals(request.getAttribute("errorMessageUserNotFound"))) { %>
                <div class="alert alert-danger">
                    <strong>Whoops</strong> You've entered wrong email &/or password!
                </div>
                <%}%>
            </div>
            <hr>
            <h2 class="intro-text text-center">Login
                <strong>form</strong>
            </h2>
            <hr>
            <form class="form-horizontal" name ="EmployeeLoginForm" action="userServlet" method="POST">
                <input type="hidden" name="formName" value="EmployeeLoginForm"/>
                <div class="row">
                    <% String[] values = {"username", "password"}; %>
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
