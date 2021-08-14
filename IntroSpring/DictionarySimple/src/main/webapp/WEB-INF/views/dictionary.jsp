<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/14/2021
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Từ điển Anh - Việt</h1>
    <form action="/result" method="post">
        <div>
            <label>Từ cần tìm</label>
            <input type="text" name="word">
            <button type="submit">Tìm kiếm</button>
        </div>
    </form>
</body>
</html>
