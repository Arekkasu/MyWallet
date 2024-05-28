<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ERROR</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../../../resources/favicon_io/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../../../resources/favicon_io/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../../resources/favicon_io/favicon-16x16.png">
    <link rel="manifest" href="../../../resources/favicon_io/site.webmanifest">
    <link rel="Stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <link rel="Stylesheet" href="../../../resources/styles/style.css">
    <script src="https://kit.fontawesome.com/b7f27d0091.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../common/NavIndex.jsp"%>
<div class="container d-flex align-items-center justify-content-center" style="height: 80vh;">
    <div class="text-center">
        <h1>ERROR 500</h1>
        <h2><fmt:message key="error.500" /></h2>
    </div>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>