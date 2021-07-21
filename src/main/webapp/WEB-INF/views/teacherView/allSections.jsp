<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card ">
        <table class="tab1">
            <thead>
            <th>ID</th>
            <th>NAZWA ROZDZIAŁU</th>
            <th></th>
            <%--    <th>TESTY</th>--%>
            </thead>
            <tbody>
            <c:forEach items="${sections}" var="section">
                <tr>
                    <td><c:out value="${section.id}"/></td>
                    <td><c:out value="${section.name}"/></td>
                    <td>
                        <a class="ui-button" href="<c:out value="/teacher/editLesson/${section.id}"/>">EDYTUJ</a>&nbsp;&nbsp;
                        <a href="<c:out value="/teacher/deleteLesson/${section.id}"/>">USUŃ</a>&nbsp;&nbsp;
                        <a href="<c:out value="/teacher/showLesson/${section.id}"/>">POKAŻ</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"/>
