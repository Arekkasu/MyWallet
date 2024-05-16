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
<h1>LOGIN</h1>
<form:form action="/login" method="post" modelAttribute="loginUser">
    <label>Username</label>
    <form:input path="username" placeholder="username"/>
    <form:errors path="username"/>
    <label>Password</label>
    <form:input path="password" placeholder="password"/>
    <form:errors path="password"/>
    <input type="submit" value="login"/>
</form:form>

<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>
</body>
</html>