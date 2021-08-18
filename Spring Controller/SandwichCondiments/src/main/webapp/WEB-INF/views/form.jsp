
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <div>
            <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
            <input type="checkbox" name="condiment" value="Tomato"> Tomato
            <input type="checkbox" name="condiment" value="Mustard"> Mustard
            <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
        </div>
        <hr>
        <c:if test="${mess != null}">
            <p>${mess}</p>
        </c:if>
        <button type="submit">Save</button>

    </form>

</body>
</html>
