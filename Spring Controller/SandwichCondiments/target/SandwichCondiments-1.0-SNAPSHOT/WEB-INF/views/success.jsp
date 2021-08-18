<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2021
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách gia vị:</h1>
    <c:forEach items="${requestScope.condiment}" var="con">
        <p>${con}</p>
    </c:forEach>
    <a href="">back </a>
</body>
</html>
