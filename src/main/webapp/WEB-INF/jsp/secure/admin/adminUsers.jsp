<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/admin/adminUser.js"></script>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>

<!-- Sección del formulario -->
<section id="addUserSection" class="container-fluid">
    <h2><fmt:message key="admin.agregar.user" /></h2>
    <c:if test="${userExists != null}" >
        <p><fmt:message key="admin.user.exist" /></p>
    </c:if>
    <c:if test="${messageSucces != null}" >
        <p><fmt:message key="user.message.succes" /></p>
    </c:if>
    <div class="row">
        <div class="col-lg-12 col-md-12 ml-3 mb-5">
            <div class=" p-4">
                <form:form class="row g-3" method="post" modelAttribute="registerUser" action="/admin/users">
                    <div class="col-md-3">
                        <label for="email" class="form-label">Email</label>
                        <form:input path="Email" id="email" class="form-control" placeholder="Email"/>
                        <form:errors path="Email" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="username" class="form-label">Username</label>
                        <form:input path="Username" id="username" class="form-control" placeholder="Username"/>
                        <form:errors path="Username" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-2">
                        <label for="password" class="form-label">Password</label>
                        <form:input path="Password" id="password" class="form-control" placeholder="password"/>
                        <form:errors path="Password" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-2 d-flex align-items-end">
                        <button type="submit" class="btn btn-primary"><fmt:message key="user.boton.registrar" /></button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<!-- Sección de la tabla -->
<section class="tableSection">
    <table id="users" class="display table table-striped table-dark" style="width: 100%"></table>
</section>

<%@ include file="../../common/footer.jsp" %>
</body>
</html>
