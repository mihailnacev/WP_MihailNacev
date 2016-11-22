<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Nacev
  Date: 21.11.2016
  Time: 12:31 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="/favicon.ico" type="image/png">
    <title>PizzaIndex</title>
</head>
<body>
<h1>Order Pizza</h1>
<% List<String> list = (ArrayList<String>) request.getAttribute("list"); %>
<form class="form-group" method="post"  action="/by_user/<%= (int) new Random().nextInt(100) %>">

    <c:forEach var="entry" items="${list}">
    <input class="form-control" type="radio" name="pizzaType" value="${entry}"> ${entry}<br>
</c:forEach>
<br/>
<input type="submit" class="form-control" value="Submit">

</form>
</body>
</html>
