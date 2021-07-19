<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie lekcji</title>
</head>
<body>
<h3>Dodawanie lekcji</h3>
<form:form method="post" modelAttribute="lesson">

    <table border="1" cellpadding="5" style="background-color: lightgrey">

        <tr>
            <td>TEMAT LEKCJI</td>
            <td><form:input size="100" path="title"/> <form:errors path="title"/></td>
        </tr>
        <tr>
            <td>ROZDZIAŁ</td>
            <td><form:select path="section" itemLabel="name" itemValue="id" id="" items="${sections}"/><form:errors path="section"/></td>
        </tr>
        <tr>
            <td>TREŚĆ LEKCJI</td>
            <td><form:textarea cols="150" rows="40" path="content"/> <form:errors path="content"/></td>
        </tr>

    </table>
    <p> </p>
    <h2><input type="submit" value="ZAPISZ"></h2>

</form:form>
</body>
</html>
