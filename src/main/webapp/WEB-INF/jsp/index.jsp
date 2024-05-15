<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyWallet</title>
    <link rel="Stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <link rel="Stylesheet" href="../../resources/styles/style.css">

</head>
<body>

<header>


<%--    <nav class="navbar bg-body-tertiary">--%>
<%--        <div class="container-fluid">--%>
<%--            <a class="navbar-brand" href="#">--%>
<%--                MyWallet--%>
<%--                <img src="../../resources/images/MywalletLogo.png" alt="MyWallet" id="logo-nav" class="d-inline-block align-text-top">--%>
<%--            </a>--%>

<%--                <a class="nav-link" href="#">Home</a>--%>
<%--                <a class="nav-link" href="#">About</a>--%>
<%--                <a class="nav-link" href="#">Contact</a>--%>
<%--                <a class="nav-link" href="#">Login</a>--%>
<%--                <a class="nav-link" href="#">Register</a>--%>
<%--        </div>--%>

    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid ">

                    <a class="navbar-brand d-flex align-items-center me-5" href="#">
                        MyWallet
                        <img src="../../resources/images/MywalletLogo.png" alt="MyWallet" id="logo-nav" class="d-inline-block align-self-center">
                    </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNav">
                <ul class="navbar-nav justify-content-between w-100">
                    <li class="nav-item text-center">
                        <a class="nav-link" aria-current="page" href="#">Inicio</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" href="#">Que es my wallet</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" href="#">Que puedes hacer</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" aria-disabled="true">FAQ</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" aria-disabled="true">Iniciar Sesion</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" aria-disabled="true" href="/register">Registrarse</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>




</header>


<section class="green-backgorund d-flex flex-row justify-content-center align-items-center">



    <article class="info-wallet container text-center">
        <div class="row">
            <div class="col-5">
                <h1 class="">Título</h1>
                <p>Parrafo</p>
            </div>
            <div class="col-7">
                <img src="../../resources/images/ImageSection.png" alt="Descripción de la imagen" class="mb-3 me-3" id="image-section">
            </div>
        </div>



    </article>


</section>





</body>
</html>