<%--
  Created by IntelliJ IDEA.
  User: Nacev
  Date: 30.10.2016
  Time: 12:07 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeliveryInfo</title>
    <body>
<h1>Delivery Info</h1>
    <form method="post"  action="/AddressInfo.do">
     <span>Pizza size: <%= session.getAttribute("pizzaSize") %></span><br>
    Name: <input type="text" name="name"><br>
    Address: <input type="text" name="address"><br>
    <input type="submit" value="Submit">
</form>
</body>
</head>
<body>

</body>
</html>
