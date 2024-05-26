<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form:form method="post" modelAttribute="registerUser" action="/register">
    <label>Email</label>
    <form:input path="Email" placeholder="Email"/>
    <form:errors path="Email"/>
    <br>
    <label>Username</label>
    <form:input path="Username" placeholder="Username"/>
    <form:errors path="Username"/>
    <br>
    <label>Password</label>
    <form:input path="Password" placeholder="password"/>
    <form:errors path="Password"/>
    <button type="submit">Registrar</button>
</form:form>
<button >Login</button>
<button onclick="window.location.href='/'">Back</button>

<c:if test="${userExists != null}" >
    <p>EL USUARIO YA EXISTE</p>
</c:if>


</body>
</html>