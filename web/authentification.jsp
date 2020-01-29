<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  

<!--************************************************-->
<!--CODE CSS-->
<!--************************************************-->


<!--Liens-->
   <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"><script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--Fichiers-->
<link rel="stylesheet" href="ressources/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css" href="ressources/css/TrajetSlide.css">
<link rel="stylesheet" href="ressources/css/style.css">
<link rel="stylesheet" href="ressources/css/authentification.css">
<link rel="stylesheet" href="ressources/css/validation.css">



  <title>Wasselni</title>
</head>

<body>
 

<!--************-->
<!-- Navigateur -->
<!--************-->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top navmov" id="hamburger">
    <div class="container">
        <a href="#" class="navbar-brand"> <img src="ressources/img/logo.png" alt="" width="80%" height="80%"></a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav ml-auto">
  
                <li class="nav-item">
                    <a href="#" class="nav-link">Accueil</a>
                </li>
  
                <li class="nav-item">
                    <a href="#" class="nav-link">Proposer un trajet</a>
                </li>
  
                <li class="nav-item">
                    <a href="#" class="nav-link">Demander un trajet</a>
                </li>
  
            </ul>
        </div>
    </div>
  </nav>
  
  
   <!--************-->
  <!-- Inscription -->
  <!--************-->
  <section id="blog" class="py-3">
   <div  style=" margin-top: -20px; margin-bottom: -20px;">
		<div class="container-inscription insc">

            <div class="container">

                <!--Authentification par facebook-->
                <div class="row">
                    <div  style="margin-top: 130px;margin-bottom: 30px;">
                        

                    </div>
                </div>

                <!--Authentification par un compte-->
                <div class="row">
                 
                    


                    <div class="wrap-inscription" style="margin-bottom: 130px;">

                        <div class="container">
                            <div class="row">
                            
                                <form class="inscription-form validate-form" style="align-self: center;">	
                                    <span class="inscription-form-title" style="margin-left: 130px;">
                                        S'authentifier
                                    </span>			
                                    <!--Email-->
                                    <div class="wrap-input100 " >
                                        <input class="input100" type="text" name="email" placeholder="Email">
                                        <span class="focus-input100"></span>
                                        <span class="symbol-input100">
                                            <i class="fa fa-at" aria-hidden="true"></i>
                                        </span>
                                    </div>
                                
                                <!--MOT de PASSE-->
                                    <div class="wrap-input100 " >
                                        <input class="input100" type="password" name="motpass" placeholder="Mot de passe">
                                        <span class="focus-input100"></span>
                                        <span class="symbol-input100">
                                            <i class="fa fa-lock" aria-hidden="true"></i>
                                        </span>
                                    </div>
                                
                
                                <!--Buton pour connecter-->
                                <button type="submit" class="authentification-form-btn" >
                                    <span>
                                        Connecter <i class="fa fa-sign-in-alt"> </i>
                                    </span>
                                </button>
                                </form> 
                            </div>
                            <hr style="width: 300px; margin-right: 160px;">
                            <div class="row">
                                <button class="connecterFC" style="margin-left: 180px;">
                                    <span>
                                        <i class="fab fa-facebook-f"></i>
                                    </span>
                                </button>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            
		</div>
	</div>

  </section>

  

     





<!--************************************************-->
<!--CODE JAVASCRIPT-->
<!--************************************************-->


<!--Liens-->
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
<script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>

<script src="ressources/js/moment.min.js"></script>
<script src="ressources/js/dateTrajetSlide.js"></script>
<script src="ressources/js/proposertrajet.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script src="ressources/js/global.js"></script>
<script src="ressources/js/jquery-asRange.js"></script>
<script src="ressources/js/validation.js"></script>





<!--Autres (pour le tester)-->
<script>
    /*MOVEMENT LORS LE SITE SE LANCE*/
  
    //navbar
    ScrollReveal().reveal('.navmov',{
        origin:'top',
        duration:2000,
        distance:'60px'
    });
    //slide
    ScrollReveal().reveal('.insc',{
        origin:'bottom',
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
      ScrollReveal().reveal('.inscriremv' ,{
          origin:'bottom',
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
  