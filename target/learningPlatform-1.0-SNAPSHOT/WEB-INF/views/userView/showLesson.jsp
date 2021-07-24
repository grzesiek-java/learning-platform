<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container mx-auto" style="padding: 10px;margin: 5px">
  <div class="card ">
    <table class="tab1">
      <thead>
      <th>TEMAT LEKCJI</th> <th><c:out value="${lesson.title}"/></th>

      </thead>
      <tbody>
      <tr><td>ROZDZIAŁ</td><td><c:out value="${lesson.section.name}"/></td></tr>
      <tr><td>TREŚĆ LEKCJI</td><td><form:textarea cols="150" rows="25" path="lesson.content"/></td></tr>
      </tbody>
    </table>
  </div>
</div>

<jsp:include page="footer.jsp"/>
