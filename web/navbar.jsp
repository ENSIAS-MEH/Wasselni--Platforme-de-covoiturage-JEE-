<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="../../../ressources/img/logo_admin.png" alt="" width="65%" height="95%"></a></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="admin.jsp">Espace principale</a></li>
                <li><a href="<c:url value='/admin_users'/>">Utilisateurs</a></li>
                <li><a href="<c:url value='/admin_offres'/>">Offres</a></li>
                <li><a href="<c:url value='/admin_demandes'/>">Demandes</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Bienvenue, nom_de_admin</a></li>
                <li><a href="authentification.html">Déconnecter</a></li>
            </ul>
        </div>
    </div>
</nav>
