<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<form:form method="post" modelAttribute="user">

  <div class="container w-50">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Rejestrowanie nowego użytkownika</div>
      <div class="card-body">
        <div class="form-group">
          <div class="form-label-group">
            <p></p>
            <form:input path="firstName" cssClass="form-control" placeholder="Imię"/>
            <p></p>
            <form:errors path="firstName"/>
            <p></p>
          </div>
        </div>
        <div class="form-group">
          <div class="form-label-group">
            <p></p>
            <form:input path="lastName" cssClass="form-control" placeholder="Nazwisko"/>
            <p></p>
            <form:errors path="lastName"/>
            <p></p>
          </div>
        </div>
        <div class="form-group">
          <div class="form-label-group">
            <p></p>
            <form:input path="email" cssClass="form-control" placeholder="Adres email"/>
            <p></p>
            <form:errors path="email"/>
            <p></p>
          </div>
        </div>
        <div class="form-group">
          <div class="form-label-group">
            <p></p>
            <form:password path="password" cssClass="form-control" placeholder="Hasło"/>
            <p></p>
            <form:errors path="password"/>
            <p></p>
          </div>
        </div>

        <input type="submit" class="btn btn-primary btn-block" value="zapisz"/>
      </div>
    </div>
  </div>
</form:form>

<jsp:include page="footer.jsp"/>
