<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie lekcji</title>
</head>
<body>
  <form method="post">
    <p><a href="/teacher/allLessons">ANULUJ</a></p>
    <p><input type="submit" value="USUŃ"></p>
    <p><input type="hidden" name="id" value="${lesson.id}"></p>
  </form>
</body>
</html>
