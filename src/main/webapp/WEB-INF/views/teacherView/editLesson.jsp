<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 15.07.2021
  Time: 07:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja lekcji</title>
</head>
<body>
<h3>Edycja lekcji</h3>
<form:form method="post" modelAttribute="lessonDto">

    <table border="1" cellpadding="5" style="background-color: lightgrey">
        <tr><td>TYTUŁ LEKCJI</td><td><form:input size="100" path="title"/> <form:errors path="title"/></td></tr>
        <tr><td>TREŚĆ LEKCJI</td><td><form:textarea cols="150" rows="40" path="content"/> <form:errors path="content"/></td></tr>
            <%--        <tr><td>ROZDZIAŁ</td><td><form:input path="chapter"/> <form:errors path="chapter"/></td></tr>--%>
    </table>
    <p> </p>













    <input type="submit" value="ZAPISZ">
    <h3><a href="/teacher/allLessons">powrót do listy lekcji</a></h3>

</form:form>
</body>
</html>
