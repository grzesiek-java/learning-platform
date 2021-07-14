<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>students list</title>
</head>
<body>
<h3>Lista uczniów</h3>
<table border="1" cellpadding="10" style="background-color: #f0f0f0">
    <thead>
        <th>ID</th>
        <th>IMIĘ</th>
        <th>NAZWISKO</th>
        <th>EMAIL</th>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.id}"/></td>
            <td><c:out value="${u.firstName}"/></td>
            <td><c:out value="${u.lastName}"/></td>
            <td><c:out value="${u.email}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
