<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Lekcji</title>
</head>
<body>

<h3>Lista lekcji</h3>
<table border="1" cellpadding="10" style="background-color: lightgrey">
  <thead>
    <th>ID</th>
    <th>TEMAT LEKCJI</th>
    <th></th>
<%--    <th>TESTY</th>--%>
  </thead>
  <tbody>
  <c:forEach items="${lessons}" var="lesson">
    <tr>
      <td><c:out value="${lesson.id}"/></td>
      <td><c:out value="${lesson.title}"/></td>
      <td>
        <a href="<c:out value="/teacher/editLesson/${lesson.id}"/>">EDYTUJ</a>&nbsp;&nbsp;
        <a href="<c:out value="/teacher/deleteLesson/${lesson.id}"/>">USUŃ</a>&nbsp;&nbsp;
        <a href="<c:out value="/teacher/showLesson/${lesson.id}"/>">POKAŻ</a>
      </td>
<%--      <td>--%>
<%--        <a href="<c:out value="/teacher/showTest/${lesson.id}"/>">TEST</a>--%>
<%--      </td>--%>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
