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
<div class="sidenav">
    <p></p>
    <a href="/login">
        <%--        <i class="fa fa-fw fa-user"></i>--%>
        Logowanie</a>
    <a href="/register">
        <%--        <i class="fa fa-fw fa-home"></i>--%>
        Rejestracja</a>
</div>
<div class="main">
    <div class="topnav">
        <a>platforma edukacyjna</a>
        <%--        <a class="active" href="#home">Home</a>--%>
        <%--        <a href="#news">News</a>--%>
        <%--        <a href="#contact">Contact</a>--%>

        <div class="topnav-right">
            <%--            <a href="#about">About</a>--%>
        </div>
    </div>
