<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center me-5" >
                <fmt:message key="navbar.brand" />
                <img src="../../../resources/images/MywalletLogo.png" alt="<fmt:message key="navbar.brand" />" id="logo-nav" class="d-inline-block align-self-center">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav justify-content-between w-100">
                    <li class="nav-item text-center">
                        <a class="nav-link" aria-current="page" href="/"><fmt:message key="navbar.home" /></a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" href="/#features"><fmt:message key="navbar.features" /></a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" href="/login"><fmt:message key="navbar.login" /></a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link" href="/register"><fmt:message key="navbar.register" /></a>
                    </li>
                    <!-- Dropdown para seleccionar el idioma -->
                    <li class="nav-item dropdown text-center">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fas fa-globe"></i> <fmt:message key="navbar.language" />
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="?lang=us"><fmt:message key="navbar.lang.english" /></a></li>
                            <li><a class="dropdown-item" href="?lang=es"><fmt:message key="navbar.lang.spanish" /></a></li>
                            <li><a class="dropdown-item" href="?lang=de"><fmt:message key="navbar.lang.german" /></a></li>
                            <li><a class="dropdown-item" href="?lang=fr"><fmt:message key="navbar.lang.french" /></a></li>
                            <!-- Agrega más idiomas aquí -->
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
