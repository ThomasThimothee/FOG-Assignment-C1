  <div class="row">
                <div class="box">
                    <% if ( "Error".equals( request.getAttribute( "errorMessageUserNotFound" ) ) ) {%>
                    <div class="alert alert-danger">
                        <strong>UUUPS</strong> You've entered wrong email &/or password!
                    </div>
                    <%}%>
                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">Login
                            <strong>form</strong>
                        </h2>
                        <hr>
                        <p>Sign in</p>
                       <form name ="CustomerLoginForm" action="userServlet" method="POST">
                        <input type="hidden" name="formName" value="CustomerLoginForm"/>
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label>Email</label>
                                    <input type="text" class="form-control" name="email">
                                </div>
                                <div class="form-group col-md-4">
                                    <label>password</label>
                                    <input type="password" class="form-control" name="password">
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="hidden" name="action" value="login">
                                    <label><br></label>
                                    <button type="submit" class="btn btn-success">Sign in</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
  </div>
