<%@page import="business.Order"%>
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

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head> 
<body>    
    <% RenderUtils render = new RenderUtils();%>
<%--     <% Order order = (Order) request.getAttribute("Order");%>  --%>
    <% Order order = new Order(); %>
    <% order.setOrderId(1234); %>
    <% order.setFinalPrice(1500.0); %>
    <div class="container">
        <div class="row">
            <div class="box">  
                <div class="col-lg-12">
                    <table border="1" cellpadding="2">
                        <thead>
                            <tr>
                                <th>Order</th>
                                <th>Amount to pay</th>
                            </tr>
                            <tr>
                                <td>Order <%=order.getOrderId()%></td>
                                <td><%=order.getFinalPrice()%> DKK</td>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <form class="form-horizontal" name ="CustomerPaymentForm" action="userServlet" method="POST">
        <input type="hidden" name="formName" value="CustomerPaymentForm" />
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-8">
                <input class="form-control" type="text" id="Amount" name="Amount" placeholder="Amount to pay" /> 
            </div>
        </div>
        <div class="row">
            <div class="col-xs-offset-4 col-xs-4">
                <input class="form-control btn btn-success" type="submit" value="Pay" name="pay" />
            </div>
        </div>               
    </form>                                 

</body>
<script src="js/jquery.js"></script>