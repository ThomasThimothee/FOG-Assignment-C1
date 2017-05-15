<%@page import="business.Order"%>
<%@page import="presentation.utility.RenderUtils"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Order Payment</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head> 
<body>    
    <% Order order = (Order) request.getAttribute("currentOrder");%> 
    <div class="container">
        <div class="col-lg-offset-2 col-lg-8 col-xs-offset-1 col-xs-10">
             <%  if ("Error".equals(request.getAttribute("InvalideAmount"))) { %>
                            <div class="alert alert-danger alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Warning!</strong> Invalid amount, make sure you pay the exact price!. 
                            </div>
                    <%  } %>
            <div class="box">
                <hr>
                <h2 class="intro-text text-center">Customer <strong>Payment</strong></h2>
                <hr>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Order</th>
                            <th>Price</th>
                        </tr>
                        <tr>
                            <td>Order <%=order.getOrderId()%></td>
                            <td><%=order.getFinalPrice()%> DKK</td>
                        </tr>
                    </thead>
                </table>
                <form class="form-horizontal" name ="customerPayment" action="orderServlet" method="POST">
                    <input type="hidden" name="action" value="customerPayment" />
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-8">
                            <input class="form-control" type="text" id="Amount" name="amount" placeholder="Amount to pay" /> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-offset-4 col-xs-4">
                            <input class="form-control btn btn-success" type="submit" value="Pay" name="pay" />
                        </div>
                    </div>  
                    <input type="hidden" name="orderId" value=<%=order.getOrderId()%> />
                    <input type="hidden" name="finalPrice" value=<%=order.getFinalPrice()%> />                    
                </form>   
            </div>
        </div>
    </div>
</body>
<script src="js/jquery.js"></script>
</html>