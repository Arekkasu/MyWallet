<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>

<div class="container">
    <h2 class="my-3"><fmt:message key="user.detalles"/></h2>
    <div class="card shadow-lg p-3 mb-5 bg-white rounded">
        <div class="card-body">
            <form:form method="post" modelAttribute="editUser">
                <div class="mb-3">
                    <label for="idUsers" class="form-label">ID</label>
                    <input type="text" class="form-control" id="idUsers" value="${user.idUsers}" readonly>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <form:input path="Email" id="email" class="form-control" placeholder="${user.email}"/>
                    <form:errors path="Email" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <form:input path="Username" id="username" class="form-control" placeholder="${user.username}"/>
                    <form:errors path="Username" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <form:password path="Password" id="password" class="form-control" placeholder="Enter new password"/>
                    <form:errors path="Password" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary"><fmt:message key="admin.editarUserConfirmar"/></button>
                <a href="/admin/users" class="btn"><fmt:message key="admin.editarUserRegresar"/></a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>