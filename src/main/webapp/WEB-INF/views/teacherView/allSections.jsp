<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 19.07.2021
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista rozdziałów</title>
</head>
<body>

<h3>Lista rozdziałów</h3>
<table border="1" cellpadding="10" style="background-color: lightgrey">
    <thead>
    <th>ID</th>
    <th>nazwa rozdzału</th>
    <th></th>
    <%--    <th>TESTY</th>--%>
    </thead>
    <tbody>
    <c:forEach items="${sections}" var="section">
        <tr>
            <td><c:out value="${section.id}"/></td>
            <td><c:out value="${section.name}"/></td>
            <td>
                <a href="<c:out value="/teacher/editLesson/${section.id}"/>">EDYTUJ</a>&nbsp;&nbsp;
                <a href="<c:out value="/teacher/deleteLesson/${section.id}"/>">USUŃ</a>&nbsp;&nbsp;
                <a href="<c:out value="/teacher/showLesson/${section.id}"/>">POKAŻ</a>
            </td>
                <%--      <td>--%>
                <%--        <a href="<c:out value="/teacher/showTest/${lesson.id}"/>">TEST</a>--%>
                <%--      </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3><a href="/teacher/panel">powrót do panelu</a></h3>
</body>
</html>
