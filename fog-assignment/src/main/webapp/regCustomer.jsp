<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Signup</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head> 
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
                            if ("Error".equals(request.getAttribute("IncorrectEmailFormattingException"))) { %>
                                <div class="alert alert-danger alert-dismissable">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> Please enter a valid e-mail address. 
                                </div>
                        <%  } %>
                        <hr>
                        <h1 class="intro-text text-center">Welcome, please fill out the following fields to create your account.</h1>
                        <hr>
                    </div>
                    <div class="col-xs-offset-3 col-xs-7">
                    <form class="form-horizontal" name ="CustomerRegistrationForm" action="userServlet" method="POST">
                        <input type="hidden" name="formName" value="CustomerRegistrationForm" />
                        <div class="form-group">
                                <div class="col-xs-10">
                                    <%  if ("Error".equals(request.getAttribute("InsecurePasswordException"))) { %>
                                        <input class="form-control" type="text" id="Email" name="email" placeholder="E-mail" value=<%=request.getAttribute("email")%> />
                                    <% } else { %>
                                        <input class="form-control" type="text" id="Email" name="email" placeholder="E-mail" />
                                    <% } %>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-10">
                                    <input class="form-control" type="password" id="Password" name="password" placeholder="Password" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" id="FirstName" name="firstName" placeholder="First Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" id="LastName" name="lastName" placeholder="Last Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" id="Address" name="address" placeholder="Address" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" id="Phone" name="phone" placeholder="Phone Number" />
                                </div>
                            </div>    
                            <div class="row">
                                <div class="col-xs-offset-2 col-xs-6">
                                    <input class="form-control btn btn-success" type="submit" value="Register" name="register" />
                                </div>
                            </div>               
                    </form>                                 
                    </div>
                </div>
            </div>
        </div>
</div>
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
    </body>
</html>
