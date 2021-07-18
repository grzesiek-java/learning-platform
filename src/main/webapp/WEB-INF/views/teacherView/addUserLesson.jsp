<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 15.07.2021
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie lekcji</title>
</head>
<body>
<h3>Dodawanie lekcji dla ucznia</h3>
<form method="post">
    <select>
        <c:forEach var="user" items="${users}" >
            <option value="${user.id}">${user.firstName}&nbsp;${user.lastName}</option>
        </c:forEach>
    </select>
    <p></p>
    <select>
        <c:forEach var="lesson" items="${lessons}" >
            <option value="${lesson.id}">${lesson.title}</option>
        </c:forEach>
    </select>
    <input type="submit" value="ZAPISZ">
</form>
</body>
</html>
