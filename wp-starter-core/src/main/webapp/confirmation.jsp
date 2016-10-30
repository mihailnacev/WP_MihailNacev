<%--
  Created by IntelliJ IDEA.
  User: Nacev
  Date: 30.10.2016
  Time: 05:08 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<h1>Confirmation</h1>
<span>Name: <%= session.getAttribute("name") %></span><br>
<span>Address: <%= session.getAttribute("address") %></span><br>
<span>PizzaSize: <%= session.getAttribute("pizzaSize") %></span><br>
<span>BrowserDetails: <%= session.getAttribute("browserDetails") %></span><br>
<span>OS: <%= session.getAttribute("os") %></span><br>
</body>
</html>
