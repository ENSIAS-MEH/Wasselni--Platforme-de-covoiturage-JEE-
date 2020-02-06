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
<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
<!--Fichiers-->
<link rel="stylesheet" href="ressources/css/style.css">
<link href="/ressources/css/aos.css" rel="stylesheet">
<link href="/ressources/css/bootstrap.min.css" rel="stylesheet">
<link href="/ressources/css/apres_inscription.css" rel="stylesheet">
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
<!-- Activation -->
<!--************-->

<c:if test="${sessionScope.userSession.activation > 1}">
    <div class="section" id="activation" style="margin-top: 100px;">
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
                                        <span class="symbol-input1"><i class="fa fa-user" aria-hidden="true"></i>  </span>
                                    </div>
                                </div>
                                <span>${form.erreurs['activation']}</span>
                                <button type="submit"   style="margin-left: 150px;" class="btn btn-info mb-2 ">Activer</button>
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


          </div>
        </div>
      </div>
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
                  <img src="ressources/img/logo-footer.png" alt="Wasselni" style="width:50%;height:22%;">
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