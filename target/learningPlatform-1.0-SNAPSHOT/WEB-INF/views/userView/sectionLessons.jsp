<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card ">
        <table class="tab1">
            <thead>
            <th>ID</th>
            <th>TEMAT LEKCJI</th>
            <th>ROZDZIAŁ</th>
            <th></th>
            <%--    <th>TESTY</th>--%>
            </thead>
            <tbody>
            <c:forEach items="${section.lessons}" var="lesson">
                <tr>
                    <td><c:out value="${lesson.id}"/></td>
                    <td><c:out value="${lesson.title}"/></td>
                    <td><c:out value="${lesson.section.name}"/></td>
                    <td width="8%">

                        <a class="btn btn-info btn-sm" href="<c:out value="/user/showLesson/${lesson.id}"/>">POKAŻ</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"/>
