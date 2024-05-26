<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/HeadAdmin.jsp" %>
<%--<script type="module" src="../../../../resources/JS/timeEdit.js"></script>--%>
<body>
<%@ include file="../../common/NavAdmin.jsp" %>

<div class="container">
    <h2 class="my-3"><fmt:message key="user.detalles"/></h2>
    <div class="card shadow-lg p-3 mb-5 bg-dark rounded">
        <div class="card-body bg-dark">
            <form:form method="post" cssClass="bg-dark text-white" modelAttribute="expenseDTO">

                <div class="mb-3">
                    <label for="idExpense" class="form-label">ID</label>
                    <input type="text" class="form-control" id="idExpense" value="${expense.idExpenses}" readonly>
                    <input type="hidden" name="idExpense" value="${expense.idExpenses}">
                </div>
                <div class="mb-3">
                    <label for="expenseHeader" class="form-label">expense Header</label>
                    <form:input path="expenseHeader" id="expenseHeader" class="form-control" placeholder="${expense.expenseHeader}"/>
                    <form:errors path="expenseHeader" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="expenseDescription" class="form-label">expense Description</label>
                    <form:input path="expenseDescription" id="expenseDescription" class="form-control" placeholder="${expense.expenseDescription}"/>
                    <form:errors path="expenseDescription" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="expenseDate" class="form-label">expense Date</label>
                    <input type="date" name="expenseDate" id="expenseDate" class="form-control" value="${expense.expenseDate}"/>
                    <form:errors path="expenseDate" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="expenseAmount" class="form-label">expense Amount</label>
                    <form:input path="expenseAmount" id="expenseAmount" class="form-control" value="${expense.expenseAmount}"/>
                    <form:errors path="expenseAmount" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary"><fmt:message key="admin.editarUserConfirmar"/></button>
                <a href="/admin/expenses" class="btn"><fmt:message key="admin.editarUserRegresar"/></a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>