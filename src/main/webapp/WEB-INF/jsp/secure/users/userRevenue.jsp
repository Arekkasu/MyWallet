<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/users/userRevenue.js"></script>
<body>
<%@ include file="../../common/NavUser.jsp" %>

<!-- Sección del formulario -->
<section id="addRevenueSection" class="container-fluid">
    <h2><fmt:message key="revenue.titulo" /></h2>
    <!--COMPROBACION DE ERRORES--->

    <c:if test="${messageSucces != null}" >
        <p><fmt:message key="user.message.succes" /></p>
    </c:if>
    <!---->
    <div class="row">
        <div class="col-lg-12 col-md-12 ml-3 mb-5">
            <div class=" p-4">
                <form:form class="row g-3" modelAttribute="revenue" method="post">
                    <div class="col-md-3">
                        <label for="header" class="form-label"><fmt:message key="revenue.header" /></label>
                        <form:input path="revenueHeader" id="header" class="form-control" placeholder="Revenue Header"/>
                        <form:errors path="revenueHeader" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="description" class="form-label"><fmt:message key="revenue.description" /></label>
                        <form:input path="revenueDescription" id="description" class="form-control" placeholder="Revenue Description"/>
                        <form:errors path="revenueDescription" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="date" class="form-label"><fmt:message key="revenue.date" /></label>
                        <form:input type="date" path="revenueDate" id="date" class="form-control"/>
                        <form:errors path="revenueDate" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="amount" class="form-label"><fmt:message key="revenue.amount" /></label>
                        <form:input type="number" path="revenueAmount" id="amount" class="form-control" placeholder="Revenue Amount"/>
                        <form:errors path="revenueAmount" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-2 d-flex align-items-end">
                        <button type="submit" class="btn btn-primary"><fmt:message key="revenue.agregar" /></button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<!-- Sección de la tabla -->
<section class="tableSection">
    <table id="revenue" class="display table table-striped table-dark" style="width: 100%"></table>
</section>

<!-- Pie de página -->

<%@ include file="../../common/footer.jsp" %>
</body>
</html>