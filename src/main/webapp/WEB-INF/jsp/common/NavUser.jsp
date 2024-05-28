<section id="nav-bar">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" aria-disabled="true"><fmt:message key="navbar.brand" /></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/"><fmt:message key="navbar.users" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/expenses"><fmt:message key="navbar.expenses" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/revenues"><fmt:message key="navbar.income" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout"><fmt:message key="navbar.logout" /></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fas fa-globe"></i> <fmt:message key="navbar.language" />
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end " aria-labelledby="navbarDropdown">
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
</section>

