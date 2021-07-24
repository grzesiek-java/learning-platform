<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<form:form method="post" modelAttribute="user">
    <div class="container w-50">
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Logowanie</div>
            <div class="card-body">
                <div class="form-group">
                    <div class="form-label-group">
                        <p></p><input type="email" name="email" id="inputEmail" class="form-control" placeholder="Adres email" required="required">
                        <p></p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Hasło" required="required">
                    </div>
                    <p></p>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="zaloguj"/>
            </div>
        </div>
    </div>
</form:form>

<jsp:include page="footer.jsp"/>