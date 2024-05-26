<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/users/userExpenses.js"></script>
<body>
<%@ include file="../../common/NavUser.jsp" %>

<section id="addexpenseSection" class="container-fluid">
    <h2><fmt:message key="expense.titulo" /></h2>
    <!--COMPROBACION DE ERRORES--->
    <c:if test="${messageSucces != null}" >
        <p><fmt:message key="user.message.succes" /></p>
    </c:if>
    <!---->
    <div class="row">
        <div class="col-lg-12 col-md-12 ml-3 mb-5">
            <div class=" p-4">
                <form:form class="row g-3"  method="post" modelAttribute="expense">
                    <div class="col-md-3">
                        <label for="header" class="form-label"><fmt:message key="expense.header" /></label>
                        <form:input path="expenseHeader" id="header" class="form-control" placeholder="expense Header"/>
                        <form:errors path="expenseHeader" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="description" class="form-label"><fmt:message key="expense.description" /></label>
                        <form:input path="expenseDescription" id="description" class="form-control" placeholder="expense Description"/>
                        <form:errors path="expenseDescription" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="date" class="form-label"><fmt:message key="expense.date" /></label>
                        <form:input type="date" path="expenseDate" id="date" class="form-control"/>
                        <form:errors path="expenseDate" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3">
                        <label for="amount" class="form-label"><fmt:message key="expense.amount" /></label>
                        <form:input type="number" path="expenseAmount" id="amount" class="form-control" placeholder="expense Amount"/>
                        <form:errors path="expenseAmount" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-2 d-flex align-items-end">
                        <button type="submit" class="btn btn-primary"><fmt:message key="expense.agregar" /></button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<!--SOLUCION AL BIG DE NO REPSONSIVE CON DATATABLES-->
<section class="tableSection">
    <table id="expenses" class="display table table-striped table-dark" style="width: 100%"></table>
</section>

<%@ include file="../../common/footer.jsp" %>

</body>
</html>