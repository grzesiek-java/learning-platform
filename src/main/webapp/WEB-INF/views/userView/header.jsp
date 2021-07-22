<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="<c:url value="/resources/css/app.css"/>" rel="stylesheet">
</head>
<body>
<div class="sidenav" style="background-color: royalblue">
    <p><i class="fa fa-fw fa-user"></i> ${sessionScope.user.firstName}</p>
    <p>&nbsp;</p>

    <a href="/user/panel">Start</a>
    <div class="divider"></div>

    <c:forEach items="${sessionScope.user.sections}" var="section">


        <a href="/user/showUserLessons/${section.id}">
<%--            <c:out value="${section.id}"/>--%>
        ${section.name}
        </a>

    </c:forEach>

    <div class="divider"></div>
    <a href="/logout">Wyjście</a>
<%--    <a href="/login">--%>
<%--        <i class="fa fa-fw fa-user"></i>--%>
<%--        Logowanie</a>--%>
<%--    <a href="/register">--%>
<%--        &lt;%&ndash;        <i class="fa fa-fw fa-home"></i>&ndash;%&gt;--%>
<%--        Rejestracja</a>--%>
</div>
<div class="main">

    <div class="topnav">
        <a>platforma edukacyjna</a>
        <%--        <a class="active" href="#home">Home</a>--%>
        <div class="topnav-right">
            <a href="/logout">wyjście</a>
        </div>
    </div>
