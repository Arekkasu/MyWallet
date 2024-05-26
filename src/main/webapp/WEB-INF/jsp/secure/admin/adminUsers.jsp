<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/admin/adminUser.js"></script>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>


<section id="addUserSection" class="container-fluid">
    <div class="row">
        <div class="col-lg-12 col-md-12 ml-3 mb-5">
            <div class=" p-4">
                <h2><fmt:message key="admin.agregar.user" /></h2>
                <c:if test="${userExists != null}" >
                    <p><fmt:message key="admin.user.exist" /></p>
                </c:if>
                <c:if test="${messageSucces != null}" >
                    <p><fmt:message key="user.message.succes" /></p>
                </c:if>
                <form:form class="row g-3"  method="post" modelAttribute="registerUser" action="/admin/users">
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

                            <!--SOLUCION AL BIG DE NO REPSONSIVE CON DATATABLES-->
<section id="tableSection">
    <table id="usersTable" class="display table table-striped" style="width: 100%">
        <thead>
        <tr>
            <th class="border-right">ID</th>
            <th class="border-right">Email</th>
            <th class="border-right">Username</th>
            <th>Total Amount</th>
        </tr>
        </thead>
        <tbody>
        <!-- Los datos de la tabla se llenarán dinámicamente con DataTables -->
        </tbody>
    </table>
</section>


</body>
</html>