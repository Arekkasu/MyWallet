<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyWallet</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../../resources/favicon_io/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../../resources/favicon_io/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../resources/favicon_io/favicon-16x16.png">
    <link rel="manifest" href="../../resources/favicon_io/site.webmanifest">
    <link rel="Stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <link rel="Stylesheet" href="../../resources/styles/style.css">
    <script src="https://kit.fontawesome.com/b7f27d0091.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="common/NavIndex.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 mt-5">
            <div class="card register-form">
                <div class="card-header bg-dark text-white"><fmt:message key="register.title" /></div>
                <c:if test="${userExists != null}">
                    <p class="text-danger"><fmt:message key="user.exist" /> </p>
                </c:if>
                <div class="card-body">
                    <form:form method="post" modelAttribute="registerUser" action="/register">
                        <div class="form-group">
                            <label><fmt:message key="register.email" /> </label>
                            <form:input path="Email" placeholder="Email" class="form-control"/>
                            <form:errors path="Email" class="text-danger"/>
                        </div>
                        <div class="form-group">

                            <label><fmt:message key="register.username" /></label>
                            <form:input path="Username" placeholder="Username" class="form-control"/>
                            <form:errors path="Username" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label><fmt:message key="register.password" /></label>
                            <form:input path="Password" type="password" placeholder="Password" class="form-control"/>
                            <form:errors path="Password" class="text-danger"/>
                        </div>
                        <button type="submit" class="btn btn-primary mt-3"><fmt:message key="user.boton.registrar" /></button>
                        <c:if test="${messageSucces != null}">
                            <p class="text-success"><fmt:message key="user.message.succes" /></p>
                        </c:if>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>
</body>
</html>