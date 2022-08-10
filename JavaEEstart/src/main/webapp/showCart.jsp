<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
    <%@ page import="org.test.hw.Cart"%>

    <% Cart cart = (Cart)session.getAttribute("cart");%>

    <p> Наименование: <%= cart.getName()%> </p>
    <p> Количество: <%= cart.getQuantity()%> </p>
</body>
</html>