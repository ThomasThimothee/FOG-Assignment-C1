 <div class="container">


            <div class="row">
                <div class="box">  
                    <div class="col-lg-12">
                        <%  if ("Error".equals(request.getAttribute("errorMessageEmailExists"))) { %>
                            <div class="alert alert-danger alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Warning!</strong>Email already Exists 
                            </div>
                            <% } %>
                        <hr>
                        <h1 class="intro-text text-center">Welcome, please fill out the following fields to create your account.</h1>
                    <hr>
                    <form name ="CustomerRegistrationForm" action="userServlet" method="POST">
                        <input type="hidden" name="formName" value="CustomerRegistrationForm" />
                        <table border="1">

                            <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td><input type="text" name="email" value="" /></td>
                                </tr>
                                 <tr>
                                    <td>Password</td>
                                    <td><input type="text" name="password" value="" /></td>
                                </tr>
                                <tr>
                                    <td>First Name</td>
                                    <td><input type="text" name="firstName" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Last Name</td>
                                    <td><input type="text" name="lastName" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <td><input type="text" name="address" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Phone</td>
                                    <td><input type="text" name="phone" value="" /></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="submit" value="Register" name="register" />
                    </form>
                </div>
            </div>
        </div>
 </div>
    </body>
</html>
