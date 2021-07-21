<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card ">
        <table class="tab1">
            <thead>
            <th>ID</th>
            <th>NAZWA ROZDZIAŁU</th>
            <th width="160px"></th>
            <%--    <th>TESTY</th>--%>
            </thead>
            <tbody>
            <c:forEach items="${sections}" var="section">
                <tr>
                    <td><c:out value="${section.id}"/></td>
                    <td><c:out value="${section.name}"/></td>
                    <td>
                        <a class="btn btn-warning btn-sm" href="<c:out value="/teacher/editSection/${section.id}"/>">EDYTUJ</a>&nbsp;&nbsp;
                        <a class="btn btn-danger btn-sm" href="<c:out value="/teacher/deleteSection/${section.id}"/>">USUŃ</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"/>
