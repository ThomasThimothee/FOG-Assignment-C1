<!doctype html>
<html>
<head>
    <title>Demo Html</title>
    <link href="http://mottie.github.io/tablesorter/css/theme.default.css" rel="stylesheet">
     
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
     
    <script>
        $(function(){
          $("#myDummyTable").tablesorter({widgets: ['zebra']});
        });
    </script>
</head>
<body>
     <table id="myDummyTable" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>      
          <th>Sex</th>
          <th>City</th>
          <th>Joining Date</th>
          <th>Computer IP</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Jadu</td>
          <td>24</td>
          <td>M</td>
          <td>Kolkata</td>
          <td>Feb 28, 2012</td>
          <td>169.254.23.75</td>
        </tr>
        <tr>
          <td>Madhu</td>
          <td>32</td>
          <td>F</td>
          <td>Delhi</td>
          <td>Jan 10, 2011</td>
          <td>169.254.23.23</td>
        </tr>
        <tr>
          <td>John</td>
          <td>27</td>
          <td>M</td>
          <td>Banglore</td>
          <td>Mar 17, 2010</td>
          <td>169.254.77.89</td>
        </tr>
        <tr>
          <td>Rahim</td>
          <td>43</td>
          <td>M</td>
          <td>Noida</td>
          <td>Dec 29, 2009</td>
          <td>169.254.85.88</td>
        </tr>
        <tr>
          <td>Rita</td>
          <td>37</td>
          <td>F</td>
          <td>Hydrabad</td>
          <td>Aug 16, 2011</td>
          <td>169.254.65.19</td>
        </tr>
        <tr>
          <td>Washim</td>
          <td>24</td>
          <td>M</td>
          <td>Mumbai</td>
          <td>Sep 29, 2012</td>
          <td>169.254.28.92</td>
        </tr>
       </tbody>
    </table>
</body>
</html>