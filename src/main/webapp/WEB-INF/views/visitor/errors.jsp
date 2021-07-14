<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Errors</title>
</head>
<body>
<ul>
  <c:forEach items="${validate}" var="v">
    <li>  ${v.propertyPath} : ${v.message}</li>
  </c:forEach>
</ul>
</body>
</html>
