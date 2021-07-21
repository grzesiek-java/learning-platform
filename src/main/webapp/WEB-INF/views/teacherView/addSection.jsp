
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 16.07.2021
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie rozdziału</title>
</head>
<body>
<h3>Dodawanie rozdziału</h3>
<form:form method="post" modelAttribute="section">

    <table border="1" cellpadding="5" style="background-color: lightgrey">
        <tr><td>NAZWA ROZDZIAŁU</td><td><form:input size="50" path="name"/> <form:errors path="name"/></td></tr>
    </table>
    <p> </p>
    <h2><input type="submit" value="ZAPISZ"></h2>

</form:form>
</body>
</html>
