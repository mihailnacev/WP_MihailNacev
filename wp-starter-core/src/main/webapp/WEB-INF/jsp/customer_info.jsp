<%--
  Created by IntelliJ IDEA.
  User: Nacev
  Date: 21.11.2016
  Time: 10:48 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Info</title>
</head>
<body>
<h1>Delivery Info</h1>
<form method="post"  action="/order">
    <span>Pizza size: <%= session.getAttribute("pizzaType") %></span><br>
    Name: <input type="text" name="clientName"><br>
    Address: <input type="text" name="clientAddress"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
