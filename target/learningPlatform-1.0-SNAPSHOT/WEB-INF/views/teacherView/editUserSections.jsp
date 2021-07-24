<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<form:form method="post">
  <div class="row" style="padding: 5px;margin: 5px">
<div class="container mx-auto col" style="padding: 10px;margin: 5px">
  <div class="card">
    <table class="tab1">
      <thead>
      <th style="background-color: royalblue">ROZDZIAŁY UŻYTKOWNIKA: ${user.firstName} ${user.lastName}</th>
      </thead>
    </table>
    <table class="tab1">

      <thead>

      <th>NAZWA ROZDZIAŁU</th>
      <th width="80px"></th>
      <%--    <th>TESTY</th>--%>
      </thead>

      <tbody>
      <c:forEach items="${user.sections}" var="section">
        <tr>

          <td><c:out value="${section.name}"/></td>
          <td><a class="btn btn-danger btn-sm" href="<c:out value="/teacher/deleteUserSection/${user.id}/${section.id}"/>">USUŃ</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>
    <div class="container mx-auto col" style="padding: 10px;margin: 5px">
      <div class="card">
        <table class="tab1">
          <thead>
          <th style="background-color: royalblue">WSZYSTKIE ROZDZIAŁY</th>
          </thead>
        </table>
        <table class="tab1">
          <thead>

          <th>NAZWA ROZDZIAŁU</th>
          <th width="80px"></th>
            <%--    <th>TESTY</th>--%>
          </thead>
          <tbody>
          <c:forEach items="${sections}" var="section">
            <tr>
              <td><c:out value="${section.name}"/></td>
              <td><a class="btn btn-success btn-sm" href="<c:out value="/teacher/addUserSection/${user.id}/${section.id}"/>">DODAJ</a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </div>
</form:form>

<jsp:include page="footer.jsp"/>
