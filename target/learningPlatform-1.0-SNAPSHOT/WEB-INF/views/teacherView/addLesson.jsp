
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>
<form:form method="post" modelAttribute="lessonDto">

<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card ">
        <table class="tab1">
            <thead>
            <th>TEMAT LEKCJI</th><th><form:input size="100" path="title"/> <form:errors path="title"/></th>
            </thead>
            <tbody>
            <tr><td>ROZDZIAŁ</td><td><form:select path="section" itemLabel="name" itemValue="id" items="${sections}" multiple="false"/><form:errors path="section"/></td></tr>
            <tr><td>TREŚĆ LEKCJI</td><td><form:textarea cols="150" rows="25" path="content"/><br><form:errors path="content"/></tr>
            </tbody>

        </table>
        <input type="submit" class="btn btn-primary btn-block" value="ZAPISZ">
    </div>
</div>
</form:form>
<jsp:include page="footer.jsp"/>

