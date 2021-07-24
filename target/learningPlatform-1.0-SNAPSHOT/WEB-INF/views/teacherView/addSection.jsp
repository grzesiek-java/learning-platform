
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<form:form method="post" modelAttribute="section">

    <div class="container mx-auto" style="padding: 10px;margin: 5px">
        <div class="card ">
            <table class="tab1">
                <thead>
                <th>NAZWA ROZDZIAŁU</th><th><form:input size="100" path="name"/> <form:errors path="name"/></th>
                </thead>
            </table>
            <input type="submit" class="btn btn-primary btn-block" value="ZAPISZ">
        </div>
    </div>
</form:form>

<jsp:include page="footer.jsp"/>

