<%@ page import="mk.ukim.finki.wp.model.Order" %><%--
  Created by IntelliJ IDEA.
  User: Nacev
  Date: 21.11.2016
  Time: 11:08 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<h1>Confirmation</h1>
<%Order or=(Order)session.getAttribute("order"); %>
<span>Name: <%= or.getClientName() %></span><br>
<span>Address: <%=or.getClientAddress() %></span><br>
<span>PizzaSize: <%= or.getPizzaType() %></span><br>
<span>AutoGeneratedID: <%= or.getOrderId()%></span><br>
</body>
</html>