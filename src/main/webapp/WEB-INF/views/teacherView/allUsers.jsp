<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card ">
        <table class="tab1">
            <thead>
            <th>ID</th>
            <th>IMIĘ</th>
            <th>NAZWISKO</th>
            <th>EMAIL</th>
            <th width="300px"></th>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td><c:out value="${u.id}"/></td>
                    <td><c:out value="${u.firstName}"/></td>
                    <td><c:out value="${u.lastName}"/></td>
                    <td><c:out value="${u.email}"/></td>
                    <td>
                        <a class="btn btn-info btn-sm" href="<c:out value="/teacher/editUserSections/${u.id}"/>">UDOSTĘPNIONE ROZDZIAŁY</a>&nbsp;&nbsp;
                        <a class="btn btn-danger btn-sm" href="<c:out value="/teacher/deleteUser/${u.id}"/>">USUŃ</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"/>

