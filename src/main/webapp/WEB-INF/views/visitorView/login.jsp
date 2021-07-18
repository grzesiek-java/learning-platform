<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 18.07.2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h3>Logowanie do platformy.</h3>
<form:form method="post" action="/login">

    <table border="1" cellpadding="5" style="background-color: lightgoldenrodyellow">
        <tr><td>EMAIL</td><td><input name="email" type="email"/></td></tr>
        <tr><td>HASŁO</td><td><input name="password" type="password"/></td></tr>
    </table>
    <p> </p>
    <h2><input type="submit" value="LOGUJ"></h2>

</form:form>
</body>
</html>
