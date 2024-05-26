<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/admin/adminRevenue.js"></script>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>




<section id="addRevenueSection" class="container-fluid">
    <h2><fmt:message key="revenue.titulo" /></h2>
    <!--COMPROBACION DE ERRORES--->
    <c:if test="${userExists != null}" >
        <p><fmt:message key="revenue.username.noexiste" /></p>
    </c:if>
    <c:if test="${messageSucces != null}" >
        <p><fmt:message key="user.message.succes" /></p>
    </c:if>
    <!---->
    <div class="row">
        <div class="col-lg-12 col-md-12 ml-3 mb-5">
            <div class=" p-4">
<form:form class="row g-3"  action="/admin/revenues" modelAttribute="revenue" method="post">
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
    <div class="col-md-3">
        <label for="username" class="form-label"><fmt:message key="revenue.username" /></label>
        <form:input path="username" id="username" class="form-control" placeholder="Username"/>
        <form:errors path="username" cssClass="text-danger"/>
    </div>
    <div class="col-md-2 d-flex align-items-end">
        <button type="submit" class="btn btn-primary"><fmt:message key="revenue.agregar" /></button>
    </div>
</form:form>
            </div>
        </div>
    </div>
</section>

<!--SOLUCION AL BIG DE NO REPSONSIVE CON DATATABLES-->
<section id="tableSection">
    <table id="revenue" class="display table table-striped" style="width: 100%">

    </table>
</section>


</body>
</html>