<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<div class="container mx-auto" style="padding: 10px;margin: 5px">
    <div class="card">
        <div class="card-header">
            Witaj ${sessionScope.user.firstName} w panelu ucznia
        </div>
        <div class="card-body">
            <blockquote class="blockquote mb-0">
                <p> tekst powitania + jakieś info </p>
            </blockquote>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>