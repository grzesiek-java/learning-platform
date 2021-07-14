<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja ucznia</title>
</head>
<body>
<h3>Witaj, zapraszamy do rejestracji.</h3>
<form:form method="post" modelAttribute="user">

  <table border="1" cellpadding="5" style="background-color: lightcyan">
    <tr><td>IMIĘ</td><td><form:input path="firstName"/> <form:errors path="firstName"/></td></tr>
    <tr><td>NAZWISKO</td><td><form:input path="lastName"/> <form:errors path="lastName"/></td></tr>
    <tr><td>EMAIL</td><td><form:input path="email"/> <form:errors path="email"/></td></tr>
    <tr><td>HASŁO</td><td><form:password path="password"/> <form:errors path="password"/></td></tr>
  </table>
  <form:hidden path="role" value="student"/>
  <p> </p>
  <h2><input type="submit" value="ZAPISZ"></h2>

</form:form>
</body>
</html>
