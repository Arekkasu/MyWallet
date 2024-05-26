<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/HeadAdmin.jsp" %>
<script type="module" src="../../../../resources/JS/users/userHome.js"></script>
<body>
<%@ include file="../../common/NavUser.jsp" %>

<!-- Sección 1: Bienvenida y total de dinero -->
<div class="container text-center py-5">
    <h1 class="text-light"><fmt:message key="user.home.welcome" /> ${user.username}</h1>
    <p class="text-light"><fmt:message key="user.home.totalMoney" /> ${user.totalAmount}</p>
</div>

<!-- Sección 2: Últimos movimientos -->
<div class="container text-center py-5">
    <h2 class="text-light"><fmt:message key="user.home.lastMovements" /></h2>

    <!-- Gastos -->
    <div class="row">
        <div class="col-lg-6">
            <h3 class="text-light"><fmt:message key="user.home.expenses" /></h3>
            <!-- Aquí va tu datatable de gastos -->
            <section class="tableSection">
                <table id="expenses" class="display table table-striped table-dark" style="width: 100%"></table>
            </section>
        </div>

        <!-- Ingresos -->
        <article class="col-lg-6">
            <h3 class="text-light"><fmt:message key="user.home.income" /></h3>
            <!-- Aquí va tu datatable de ingresos -->
            <section class="tableSection">
                <table id="revenue" class="display table table-striped table-dark" style="width: 100%"></table>
            </section>
        </article>
    </div>
</div>

<!-- Sección 3: Footer -->
<%@ include file="../../common/footer.jsp" %>
</body>
</html>
