<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="container w-25">
  <div class="card card-login mx-auto mt-5">
    <div class="card-header">
      Usunąć lekcję?
    </div>

    <div class="card-body">
      <form method="post">
        <p><input type="submit" class="btn btn-danger btn-block" value="USUŃ"></p>
        <p><a class="btn btn-secondary btn-block" href="/teacher/allLessons">ANULUJ</a></p>
        <p><input type="hidden" name="id" value="${lesson.id}"></p>
      </form>
    </div>
    </div>
  </div>
</div>



<jsp:include page="footer.jsp"/>