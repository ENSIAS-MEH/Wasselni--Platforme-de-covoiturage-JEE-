

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top navmov" id="hamburger">
  <div class="container">
      <a href="#" class="navbar-brand"> <img src="../ressources/img/logo.png" alt="" width="80%" height="80%"></a>
      <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav ml-auto">


              <li class="nav-item">
                  <a href="<c:url value="/accueil"/>" class="nav-link">Accueil</a>
              </li>

              <li class="nav-item">
                  <a href="<c:url value="/proposerTrajet"/>" class="nav-link">Proposer un trajet</a>
              </li>
              <c:if test="${sessionScope.userId == null}">
              <li class="nav-item">
                   <a href="<c:url value="/authentification"/>" class="nav-link"> <i class="fa fa-user"></i> se Connecter</a>
              </li>
              </c:if>
              <c:if test="${sessionScope.userId != null}">
                  <li class="nav-item">
                      <a href="<c:url value="#"/>" class="nav-link"> <i class="fa fa-user-times"></i> se Déconnecter</a>
                  </li>
              </c:if>



          </ul>
      </div>
  </div>
</nav>