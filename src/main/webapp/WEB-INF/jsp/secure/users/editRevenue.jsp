<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<%--<script type="module" src="../../../../resources/JS/timeEdit.js"></script>--%>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>

<div class="container">
    <h2 class="my-3"><fmt:message key="user.detalles"/></h2>
    <div class="card shadow-lg p-3 mb-5 bg-dark rounded">
        <div class="card-body bg-dark">
            <form:form method="post" cssClass="bg-dark text-white" modelAttribute="revenueDTO">

                <div class="mb-3">
                    <label for="idRevenue" class="form-label">ID</label>
                    <input type="text" class="form-control" id="idRevenue" value="${revenue.idRevenue}" readonly>
                    <input type="hidden" name="idRevenue" value="${revenue.idRevenue}">
                </div>
                <div class="mb-3">
                    <label for="revenueHeader" class="form-label">Revenue Header</label>
                    <form:input path="revenueHeader" id="revenueHeader" class="form-control" placeholder="${revenue.revenueHeader}"/>
                    <form:errors path="revenueHeader" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="revenueDescription" class="form-label">Revenue Description</label>
                    <form:input path="revenueDescription" id="revenueDescription" class="form-control" placeholder="${revenue.revenueDescription}"/>
                    <form:errors path="revenueDescription" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="revenueDate" class="form-label">Revenue Date</label>
                    <input type="date" name="revenueDate" id="revenueDate" class="form-control" value="${revenue.revenueDate}"/>
                    <form:errors path="revenueDate" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="revenueAmount" class="form-label">Revenue Amount</label>
                    <form:input path="revenueAmount" id="revenueAmount" class="form-control" value="${revenue.revenueAmount}"/>
                    <form:errors path="revenueAmount" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary"><fmt:message key="admin.editarUserConfirmar"/></button>
                <a href="/admin/revenues" class="btn"><fmt:message key="admin.editarUserRegresar"/></a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>