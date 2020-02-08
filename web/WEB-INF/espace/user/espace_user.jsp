<%@ page import="com.covoiturage.dao.interfaces.UserDao" %>
<%@ page import="com.covoiturage.dao.DAOFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Espace admin</title>
    <meta name="description" content="Profile"/>
    
    

<!--************************************************-->
<!--CODE CSS-->
<!--************************************************-->


<!--Liens-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"><script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
<!--Fichiers-->
<link rel="stylesheet" href="/ressources/css/style.css">
<link href="/ressources/css/aos.css" rel="stylesheet">
<link href="/ressources/css/bootstrap.min.css" rel="stylesheet">
<link href="/ressources/css/Espace_user.css" rel="stylesheet">
<link href="/ressources/css/component.css" rel="stylesheet">
<link rel="stylesheet" href="/ressources/css/selectionner.css">



      <script>
          /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
          function readFilesAndDisplayPreview(files) {
              var imageList = document.querySelector('#profile_image');
              imageList.innerHTML = "";

              for ( var file of files ) {
                  var reader = new FileReader();

                  reader.addEventListener( "load", function( event ) {
                      var span = document.createElement('span');
                      span.innerHTML = '<img  src="' + event.target.result + '" />';
                      imageList.appendChild( span );
                  });

                  reader.readAsDataURL( file );
              }
          }
      </script>

    
    
  </head>
  <body id="top">

<!--************-->
<!-- Navigateur -->
<!--************-->
<c:import url="/navbar.jsp"/>

<!--************-->
<!-- image profile -->
<!--************-->

<div class="page-content">
<div>
<div class="profile-page">
  <div class="wrapper">
    <div class="page-header page-header-small" filter-color="blue">
      <div class="page-header-image" data-parallax="true" style="background-image: url('/ressources/img/profile_bg.jpg');"></div>
      <div class="container">
<<<<<<< HEAD
          <div class="content-center">

              <%
                  String path = (String) request.getAttribute("path");%>
              <%=path%>
              <form method="post" action="upload" enctype="multipart/form-data">
                  <div class="cc-profile-image" id="profile_image">
                      <img src="<%=path%>" alt="Image"/>
                  </div>
                  <div class="h3 title"><c:out value="${sessionScope.userSession.nom}"/> <c:out value="${sessionScope.userSession.prenom}"/></div>
                  <p class="category text-white" style="font-size:large;"><c:out value="${sessionScope.userSession.login}"/></p>


                  <div style="margin-left: 220px;">
                      <input type="file" name="files" accept="image/*"
                             onchange="readFilesAndDisplayPreview(this.files);" />
                  </div>
                  <br>
                  <input type="submit" class="btn btn-outline-info" href="#" data-aos="zoom-in" data-aos-anchor="data-aos-anchor" value="Changer"/>
=======
        <div class="content-center">

            <%
                String path = (String) request.getAttribute("path");%>
            <%=path%>
          <form method="post" action="upload" enctype="multipart/form-data">
            <div class="cc-profile-image" id="profile_image">
                <img src="<%=path%>" alt="Image"/>
            </div>
            <div class="h3 title"><c:out value="${sessionScope.userSession.nom}"/> <c:out value="${sessionScope.userSession.prenom}"/></div>
            <p class="category text-white" style="font-size:large;"><c:out value="${sessionScope.userSession.login}"/></p>
           
           
            <div style="margin-left: 220px;">
              <input type="file" name="files" accept="image/*"
                     onchange="readFilesAndDisplayPreview(this.files);" />
            </div>
            <br>
            <input type="submit" class="btn btn-outline-info" href="#" data-aos="zoom-in" data-aos-anchor="data-aos-anchor" value="Changer"/>
>>>>>>> 63821ad83cc869de0a36212c9266698de8f99988

          </form>
        </div>
      </div>
      
    </div>
  </div>
</div>

    <div>
        <p>${form.resultat}</p>
        <p>        <span>${form.erreurs['nom']}</span></p>
        <p>          <span>${form.erreurs['prenom']}</span>
        </p>
        <p>          <span>${form.erreurs['nouveaumotdepasse']}</span>
        </p>

        <p>${sessionScope.userId}</p>

    </div>
<!--************-->
<!-- Activation -->
<!--************-->
    <c:if test="${sessionScope.userSession.activation > 1}">
        <div class="section" id="activation">
            <div class="container cc-activation">

                <div class="card">
                    <div class="row">
                        <div class="col-md-3 bg-warning" data-aos="fade-right" data-aos-offset="50" data-aos-duration="500">
                            <div class="card-body cc-activation-header">
                                <div class="h3">Activation</div>
                            </div>
                        </div>
                        <div class="col-md-9" data-aos="fade-left" data-aos-offset="50" data-aos-duration="500">
                            <div class="card-body">
                                <form method="post" action="/validation" class="form-inline">
                                    <div class="form-group mb-2">
                                        <div class=" wrap-input1 " style="margin-left: 90px;">
                                            <input class="input1" type="text" name="activation" placeholder="Code d'activation">
                                            <span class="focus-input1"></span>
                                            <span class="symbol-input1"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i>  </span>
                                        </div>
                                        <span>${form.erreurs['activation']}</span>

                                    </div>
                                    <button type="submit"   style="margin-left: 0px;" class="btn btn-info mb-2 ">Activer le compte</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>



    </c:if>



<!--************-->
<!-- à PROPOS -->
<!--************-->
    <div class="section" style="margin-bottom: 50px;">
        <h3 class="h2" style="text-align: center; margin-bottom: 50px;">Vos informations</h3>
        <div class="container">
            <div class="card" data-aos="fade-up" data-aos-offset="10">
                <div class="row" style="margin-left: 100px;">
                    <div class="col-lg-6 col-md-12">
                        <div class="card-body">
                            <div class="h4 mt-0 title">Informations personnelles</div>
                            <br>
                            <div class="row">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Nom:</strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.nom}"/></div>
                            </div>
                            <div class="row mt-3">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Prenom:</strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.prenom}"/></div>
                            </div>
                            <div class="row mt-3">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Date de naissance:</strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.dateNaissance}"/></div>
                            </div>
                            <div class="row mt-3">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Adresse:</strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.region}"/></div>
                            </div>
                            <div class="row mt-3">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Sexe:</strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.sexe}"/></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-12">
                        <div class="card-body">
                            <div class="h4 mt-0 title">Informations sur le compte</div>
                            <br>
                            <div class="row">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Pseudo-Nom: </strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.login}"/></div>
                            </div>
                            <div class="row mt-3">
                                <div style="margin-left: 15px;"><strong class="text-uppercase">Email: </strong></div>
                                <div style="margin-left: 15px;"><c:out value="${sessionScope.userSession.email}"/></div>
                            </div>
                            <br>
                            <div class="row mt-3" style="margin-left: 60px;" >
                                <a href="#" id ="btnModifier" data-toggle="modal" data-target="#modifier"></a>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="section" id="skill">
  <h3 class="h2" style="text-align: center; margin-bottom: 50px;">Reviews</h3>
  <div class="container">
    <div class="card" data-aos="fade-up" data-aos-anchor-placement="top-bottom">
      <div class="card-body">
        <div class="row">
          <div class="col-md-6">
            <div class="progress-container progress-parfait"><span class="progress-badge"><span style="font-weight: bold;"> Parfait</span>  - Un trajet agréable dans l'ensemble, rien à redire.</span>
              <div class="progress">
                <div class="progress-bar progress-bar-primary" data-aos="progress-full" data-aos-offset="10" data-aos-duration="2000" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"></div><span class="progress-value">80%</span>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="progress-container progress-tresBien"><span class="progress-badge"><span style="font-weight: bold;">Très bien</span>   - C'est une personne de confiance.</span>
              <div class="progress">
                <div class="progress-bar progress-bar-primary" data-aos="progress-full" data-aos-offset="10" data-aos-duration="2000" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"></div><span class="progress-value">75%</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="progress-container progress-bien"><span class="progress-badge"> <span style="font-weight: bold;">Bien</span>  - Vous avez apprécié le trajet en sa compagnie.</span>
              <div class="progress">
                <div class="progress-bar progress-bar-primary" data-aos="progress-full" data-aos-offset="10" data-aos-duration="2000" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div><span class="progress-value">60%</span>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="progress-container progress-decevant"><span class="progress-badge"><span style="font-weight: bold;">Décevant</span>  - Expérience décevante. Peu recommandable.</span>
              <div class="progress">
                <div class="progress-bar progress-bar-primary" data-aos="progress-full" data-aos-offset="10" data-aos-duration="2000" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div><span class="progress-value">60%</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="progress-container progress-eviter"><span class="progress-badge"><span style="font-weight: bold;"> À éviter</span>  - À éviter. Plus jamais.</span>
              <div class="progress">
                <div class="progress-bar progress-bar-primary" data-aos="progress-full" data-aos-offset="10" data-aos-duration="2000" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 75%;"></div><span class="progress-value">75%</span>
              </div>
            </div>
          </div>
          
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!--************-->
<!-- Historique -->
<!--************-->
<div class="section" id="offre">
  <h3 class="h2" style="text-align: center; margin-bottom: 50px;">Historique Offres/Demandes</h3>
  <div class="container cc-offre">

<<<<<<< HEAD
      <c:if test="${trajet.size() != 0}" >
          <c:forEach var="i" begin="0" end="${trajets.size()-1}" step="1">
              <div class="card">
                  <div class="row">
                      <div class="col-md-3 bg-primary" data-aos="fade-right" data-aos-offset="50" data-aos-duration="500">
                          <div class="card-body cc-offre-header">
                              <div class="h3">${estAssocieas[i].typeAssociation}</div>
                          </div>
                      </div>
                      <div class="col-md-9" data-aos="fade-left" data-aos-offset="50" data-aos-duration="500">
                          <div class="card-body">
                              <div class="h5" style="margin-bottom: 20px;">Prix de trajet: <c:out value="${detailsTrajet[i].prixPlace}"/></div>
                              <hr>
                              <div class="row">
                                  <div class="col-sm-6">
                                      <i class="fa fa-street-view" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Depart: </span><c:out value="${trajets[i].villeDepart}"/>
                                  </div>

                                  <div class="col-sm-6">
                                      <i class="fa fa-map-marker " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Destination: </span><c:out value="${trajets[i].villeDestination}"/>
                                  </div>
                              </div>
                              <br>
                              <div class="row">
                                  <div class="col-sm-6">
                                      <i class="fa fa-clock" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Date: </span>  <c:out value="${detailsTrajets[i].dateDepart}"/>
=======


                  <div class="card">
                      <div class="row">
                          <div class="col-md-3 bg-primary" data-aos="fade-right" data-aos-offset="50" data-aos-duration="500">
                              <div class="card-body cc-offre-header">
                                  <div class="h3">Demande</div>
                                  <div class="h3">${estAssocieas[i].typeAssociation}</div>
                              </div>
                          </div>
                          <div class="col-md-9" data-aos="fade-left" data-aos-offset="50" data-aos-duration="500">
                              <div class="card-body">
                                  <div class="h5" style="margin-bottom: 20px;">Prix de trajet: 180Dh</div>
                                  <hr>
                                  <div class="row">
                                      <div class="col-sm-6">
                                          <i class="fa fa-street-view" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Depart: </span>Casablanca, Anfa
                                      </div>

                                      <div class="col-sm-6">
                                          <i class="fa fa-map-marker " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Déstination: </span>Oujda, Andalous Rue Bodir
                                  <div class="h5" style="margin-bottom: 20px;">Prix de trajet: <c:out value="${detailsTrajet[i].prixPlace}"/></div>
                                  <hr>
                                  <div class="row">
                                      <div class="col-sm-6">
                                          <i class="fa fa-street-view" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Depart: </span><c:out value="${trajets[i].villeDepart}"/>
                                      </div>

                                      <div class="col-sm-6">
                                          <i class="fa fa-map-marker " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Destination: </span><c:out value="${trajets[i].villeDestination}"/>
                                      </div>
                                  </div>
                                  <br>
                                  <div class="row">
                                      <div class="col-sm-6">
                                          <i class="fa fa-clock" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Date: </span>  29 Janvier 2020
                                      </div>

                                      <div class="col-sm-6">
                                          <i class="fa fa-users " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Places:  </span> <c:out value="${details}"/>
                                          <i class="fa fa-clock" style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Date: </span>  <c:out value="${detailsTrajets[i].dateDepart}"/>
                                      </div>

                                      <div class="col-sm-6">
                                          <i class="fa fa-users " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Places:  </span> <c:out value="${detailsTrajets[i].effectif}"/>
                                      </div>
>>>>>>> 63821ad83cc869de0a36212c9266698de8f99988
                                  </div>

                                  <div class="col-sm-6">
                                      <i class="fa fa-users " style="color: rgb(38, 130, 167);"></i> <span style="font-weight: bold;color: rgb(124, 124, 124); "> Places:  </span> <c:out value="${detailsTrajets[i].effectif}"/>
                                  </div>
                              </div>

                          </div>
                      </div>
                  </div>
<<<<<<< HEAD
              </div>
          </c:forEach>


      </c:if>
=======


>>>>>>> 63821ad83cc869de0a36212c9266698de8f99988

    <div style="margin-top: 40px; margin-bottom: 100px;">
      <ul class="pagination  justify-content-center ">
          <li class="page-item disabled">
            <span class="page-link">Précédent</span>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item active">
            <span class="page-link">
              2
              <span class="sr-only">(current)</span>
            </span>
          </li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a class="page-link" href="#">Suivant</a>
          </li>
        </ul>
  </div>

  </div>
</div>




<!--************-->
<!--Foter -->
<!--************-->

<footer>
  <div class="footer-top">
      <div class="container">
          <div class="row">
              <div class="col-md-3 colfooter0">
                  <img src="/ressources/img/logo-footer.png" alt="Wasselni" style="width:50%;height:22%;">
                  <br>
                  <p>
                      Notre équipe travaillent  pour vous offrir des conseilles fidèles, des offres originaux.
                  </p>
                  <p><a href="#" class="a">Notre équipe </a></p>
              </div>
              <div class="col-md-4 offset-md-1 colfooter1">
                  <h3>Contact</h3>
                  <p><i class="fas fa-map-marker-alt"></i> Avune de france, Agdal, Rabat</p>
                  <p><i class="fas fa-phone" ></i> Téléphone: O5 36 22 67 11</p>
                  <p><i class="fas fa-envelope"></i> Email: <a href="mailto:hello@domain.com" class="a">support@wasselni.com</a></p>
              </div>
              <div class="col-md-4 footer-links colfooter2">
                  <div class="row">
                      <div class="col">
                          <h3>Liens</h3>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-6">
                          <p><a class="scroll-link a" href="#top-content">Accueil</a></p>
                          <p><a href="#" class="a">proposer un trajet</a></p>
                          <p><a href="#" class="a">Demande un trajet</a></p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <div class="footer-bottom">
      <div class="container">
          <div class="row rowfooter">
              <div class="col-md-6 footer-copyright">
                  Copyright &copy; <span id="year"></span>, powered by ENSIAS
              </div>
              <div class="col-md-6 footer-social">
                  <a href="#"><i class="fab fa-facebook-f"></i></a>
                  <a href="#"><i class="fab fa-twitter"></i></a>
                  <a href="#"><i class="fab fa-google-plus-g"></i></a>
              </div>
          </div>
      </div>
  </div>
</footer>


<div class="modal fade" id="modifier" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <form>
      <form action="/userAccueil" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">


        <div class="form-group">
          <label>Nom:</label>
          <input type="text"  class="form-control" name="prenom" placeholder="Nom" value="Mohammed">
        </div>
     
     <div class="form-group">
      <label>Prenom</label>
      <input type="text"  class="form-control" name="nom" placeholder="Prenom" value="Sabid">
    </div>

       <div class="form-group">
            <label>Email</label>
            <input type="text"  class="form-control" name="email" placeholder="email" value="mohammedsabi0@gmail.com">
       </div>

       <div class="form-group">
        <label>Numéro Téléphone</label>
        <input type="text" class="form-control" name="tel" placeholder="Telephone" value="068874125423">

        <div class="form-group">
          <label>Nom:</label>
          <input type="text"  class="form-control" name="nom" placeholder="Nom" value="<c:out value="${sessionScope.userSession.nom}"/>">
        </div>

          <div class="form-group">
      <label>Prenom</label>
      <input type="text"  class="form-control" name="prenom" placeholder="Prenom" value="<c:out value="${sessionScope.userSession.prenom}"/>">
    </div>


          <div class="form-group">
            <label>Email</label>
            <input type="text"  class="form-control" name="email" disabled placeholder="email" value="<c:out value="${sessionScope.userSession.email}"/>">
       </div>

       <div class="form-group">
        <label>Adresse</label>
        <input type="text" class="form-control" name="adresse" placeholder="Adresse" value="Adresse" >
       </div>

       <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        <button type="submit" class="btn btn-success">Modifier</button>
      </div>
    </form>
       <hr>
      
       <form action="">
        <div class="form-group">
          <label>Ancien mot de passe</label>
          <input type="text" class="form-control" placeholder="Ancien le mote de passe">

        <input type="text" class="form-control" name="adresse" placeholder="Adresse" value="<c:out value="${sessionScope.userSession.region}"/>" >
       </div>

      </div>
          <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
              <button type="submit" class="btn btn-success">Modifier</button>
          </div>

        <div class="form-group">
          <label>Ancien mot de passe</label>
          <input type="password" class="form-control" disabled name ="ancienmotdepasse" value="${sessionScope.userSession.password}" placeholder="Ancien le mote de passe">
         </div>
  
         <div class="form-group">
          <label>Nouveau mot de passe</label>
          <input type="text" class="form-control" placeholder="Nouveau le mote de passe" >
         </div>
              
         <div class="form-group">
          <label>Confirmer le mote de passe</label>
          <input type="text" class="form-control" placeholder="Confirmer le mote de passe"  >
          <input type="password" class="form-control" name = "nouveaumotdepasse" value="" placeholder="Nouveau mot de passe" >
         </div>


          <div class="form-group">
          <label>Confirmer le mot de passe</label>
          <input type="password" class="form-control" name="confirmation" value="" placeholder="Confirmer le mot de passe"  >
         </div>
  
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
          <button type="submit" class="btn btn-success">Modifier</button>
        </div>
       </form>
    
    </div>
  </div>
</div>

</div>
<script>
  CKEDITOR.replace( 'editor1' );
</script>
    


<!--Liens-->
<script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
<script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
<!--Fichiers-->
<script src="/ressources/js/moment.min.js"></script>
<script src="/ressources/js/dateTrajetSlide.js"></script>
<script src="/ressources/js/global.js"></script>
<script src="/ressources/js/aos.js"></script>
<script src="/ressources/js/espace_user.js"></script>
<script src="/ressources/js/selectionner.js"></script>
	<script>
		new InputFile({
			
		});
	</script>


<!--Autres (pour le tester)-->
<script>
  /*MOVEMENT LORS LE SITE SE LANCE*/

  //navbar
  ScrollReveal().reveal('.navmov',{
      origin:'top',
      duration:2000,
      distance:'60px'
  });


  //footer
  ScrollReveal().reveal('.colfooter0',{
      origin:'bottom',
      duration:2000,
      distance:'60px'
  });
  ScrollReveal().reveal('.colfooter1',{
      origin:'bottom',
      duration:2000,
      distance:'60px'
  });
  ScrollReveal().reveal('.colfooter2',{
      origin:'bottom',
      duration:2000,
      distance:'60px'
  });
  ScrollReveal().reveal('.rowfooter',{
      origin:'right',
      duration:2000,
      distance:'60px'
  });

  // Get the current year for the copyright
  $('#year').text(new Date().getFullYear());




  // Configure Slider
  $('.carousel').carousel({
      interval: 6000,
      pause: 'hover'
  });

  // Lightbox Init
  $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
  });







  /*POUR LA NAVIGATION*/
  var open = document.getElementById('hamburger');
  var changeIcon = true;

  open.addEventListener("click", function(){

      var overlay = document.querySelector('.overlay');
      var nav = document.querySelector('nav');
      var icon = document.querySelector('.menu-toggle i');

      overlay.classList.toggle("menu-open");
      nav.classList.toggle("menu-open");

      if (changeIcon) {
          icon.classList.remove("fa-bars");
          icon.classList.add("fa-times");

          changeIcon = false;
      }
      else {
          icon.classList.remove("fa-times");
          icon.classList.add("fa-bars");
          changeIcon = true;
      }
  });
</script>

  </body>
</html>