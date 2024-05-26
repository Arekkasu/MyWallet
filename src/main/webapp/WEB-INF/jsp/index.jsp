<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
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



<!--SECCIO UNO---->
<section class="d-flex flex-column justify-content-center align-items-center py-5">
    <div class="info-wallet container text-center">
        <div class="row align-items-center">
            <div class="col-lg-6 d-none d-lg-block">
                <img src="../../resources/images/ImageSectionOne.png" alt="chico con billetera" class="img-fluid">
            </div>
            <div class="col-lg-6">
                <h1 class="display-4"><fmt:message key="section.one.title" /></h1>
            </div>
        </div>
    </div>
</section>
<!--SECCIO UNO---->

<!--SECCIO DOS---->
<section class="d-flex flex-column justify-content-center align-items-center py-5 bg-section-two">
    <div class="container text-center">
        <div class="row">
            <div class="col-lg-4">
                <i class="fas fa-user-friends fa-3x icon-color-1"></i><br>
                <h2><fmt:message key="section.two.feature1.title" /></h2>
                <p><fmt:message key="section.two.feature1.description" /></p>
            </div>
            <div class="col-lg-4">
                <i class="fas fa-mobile-alt fa-3x icon-color-2"></i><br>
                <h2><fmt:message key="section.two.feature2.title" /></h2>
                <p><fmt:message key="section.two.feature2.description" /></p>
            </div>
            <div class="col-lg-4">
                <i class="fas fa-chart-line fa-3x icon-color-3"></i>
                <br>
                <h2><fmt:message key="section.two.feature3.title" /></h2>
                <p><fmt:message key="section.two.feature3.description" /></p>
            </div>
        </div>
    </div>
</section>
<!--SECCIO DOS---->


<!--SECCION TRES--->
<section class="d-flex flex-column justify-content-center align-items-center py-5 bg-section-one" >
    <div class="container text-center">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <img src="../../resources/images/girlWallet.png" alt="chica pensando en finanzas" class="img-fluid d-none d-lg-block">
            </div>
            <div class="col-lg-6 text-start" >
                <h2 class="text-center"><fmt:message key="section.three.title" /></h2>
                <p><fmt:message key="section.three.description" /></p>
            </div>
        </div>
    </div>
</section>

<!--SECCION TRES--->


<!--SECCION CUATRO--->
<section class="d-flex flex-column justify-content-center align-items-center py-5 bg-section-two" id="features" >
    <h2><fmt:message key="section.four.title" /></h2>
    <div class="container text-center mt-5">
        <div class="row">
            <div class="col-md-6 mb-4"> <!-- Espaciado en la columna -->
                <div class="feature p-3 border rounded"> <!-- Agregar borde y padding para mejorar el diseño -->
                    <i class="fas fa-cash-register fa-3x icon-color-1 mb-3"></i>
                    <h3><fmt:message key="section.four.feature1.title" /></h3>
                    <p><fmt:message key="section.four.feature1.description" /></p>
                </div>
            </div>
            <div class="col-md-6 mb-4"> <!-- Espaciado en la columna -->
                <div class="feature p-3 border rounded"> <!-- Agregar borde y padding para mejorar el diseño -->
                    <i class="fas fa-wallet fa-3x icon-color-2 mb-3"></i>
                    <h3><fmt:message key="section.four.feature2.title" /></h3>
                    <p><fmt:message key="section.four.feature2.description" /></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-4"> <!-- Espaciado en la columna -->
                <div class="feature p-3 border rounded"> <!-- Agregar borde y padding para mejorar el diseño -->
                    <i class="fas fa-history fa-3x icon-color-3 mb-3"></i>
                    <h3><fmt:message key="section.four.feature3.title" /></h3>
                    <p><fmt:message key="section.four.feature3.description" /></p>
                </div>
            </div>
            <div class="col-md-6 mb-4"> <!-- Espaciado en la columna -->
                <div class="feature p-3 border rounded"> <!-- Agregar borde y padding para mejorar el diseño -->
                    <i class="fas fa-mobile-alt fa-3x icon-color-4 mb-3"></i>
                    <h3><fmt:message key="section.four.feature4.title" /></h3>
                    <p><fmt:message key="section.four.feature4.description" /></p>
                </div>
            </div>
        </div>
    </div>
</section>
<!--SECCION CUATRO--->


<!--SECCIONCINCO-->

<section class="d-flex flex-column justify-content-center align-items-center py-5">
    <div class="container text-center">
        <h2><fmt:message key="section.five.title" />
            </h2>
        <p><fmt:message key="section.five.description" /></p>
    </div>
</section>


<%@ include file="common/footer.jsp"%>

</body>
</html>