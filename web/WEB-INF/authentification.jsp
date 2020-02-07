
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
<link rel="stylesheet" type="text/css" href="../ressources/css/TrajetSlide.css">
<link rel="stylesheet" href="../ressources/css/style.css">
<link rel="stylesheet" href="../ressources/css/authentification.css">
<link rel="stylesheet" href="../ressources/css/validation.css">



  <title>Wasselni</title>
</head>

<body>
 

<!--************-->
<!-- Navigateur -->
<!--************-->
<c:import url="/navbar.jsp"/>
   <!--************-->
  <!-- Inscription -->
  <!--************-->
  <section id="blog" class="py-3">
   <div  style=" margin-top: -20px; margin-bottom: -20px;">
		<div class="container-inscription">

            <div class="container">

                <!--Authentification par facebook-->
                <div class="row">
                    <div  style="margin-top: 130px;margin-bottom: 30px;">
                        

                    </div>
                </div>

                <!--Authentification par un compte-->
                <div class="row">
                 
                    


                    <div class="wrap-inscription insc" style="margin-bottom: 130px;">

                        <div class="container">
                            <div class="row">
                            
                                <form method="post" action="<c:url value='/upload'/> " style="align-self: center;">
                                    <span class="inscription-form-title" style="margin-left: 130px; margin-top: -20px;">
                                        S'authentifier
                                    </span>			
                                    <!--Email-->
                                    <div  class="wrap-input100 validate-input" data-validate = "Le format valide: exemple@abc.xyz">
                                        <input class="input100" type="text" value="<c:out value='${user.email}'/>" name="email" placeholder="Email">
                                        <span class="focus-input100"></span>
                                        <span class="symbol-input100">
                                            <i class="fa fa-at" aria-hidden="true"></i>
                                        </span>
                                        <span>${form.erreurs['email']}</span>
                                    </div>
                                
                                <!--MOT de PASSE-->
                                    <div  class="wrap-input100 validate-input" data-validate = "Le format valide: exemple@abc.xyz">
                                        <input class="input100" type="password" name="motdepasse" placeholder="Mot de passe">
                                        <span class="focus-input100"></span>
                                        <span class="symbol-input100">
                                            <i class="fa fa-lock" aria-hidden="true"></i>
                                        </span>
                                        <span>${form.erreurs['motdepasse']}</span>
                                        <span>${form.resultat}</span>
                                    </div>
                                
                
                                <!--Buton pour connecter-->
                                <button type="submit" class="authentification-form-btn">
                                    <span>
                                        Connecter <i class="fa fa-sign-in-alt"> </i>
                                    </span>
                                </button>


                                </form> 
                            </div>
                            <label for="check1">Vous n'avez pas un compte ?<a href="<c:url value="/inscription"/>"> Rejoins nous</a></label>
                            <hr style="width: 300px; margin-right: 160px;">
                                <div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-auto-logout-link="false" data-use-continue-as="false" onlogin="checkLoginState()"></div>
                            </div>

                        </div>

                    </div>
                </div>


            </div>
            
		</div>
	</div>

  </section>

  <!-- FB authentification -->
<script>


    function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().

        console.log('statusChangeCallback');
        console.log(response);                   // The current login status of the person.
        if (response.status === 'connected') {   // Logged into your webpage and Facebook.
            window.location.href="page_after_sign_up.jsp?accessToken="+response.authResponse.accessToken;
            //testAPI();
        } else {                                 // Not logged into your webpage or we are unable to tell.
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this webpage.';
        }
    }


    function checkLoginState() {               // Called when a person is finished with the Login Button.
        FB.getLoginStatus(function(response) {   // See the onlogin handler
            statusChangeCallback(response);
        });
    }


    window.fbAsyncInit = function() {
        FB.init({
            appId      : '176037053649511',
            cookie     : true,                     // Enable cookies to allow the server to access the session.
            xfbml      : true,                     // Parse social plugins on this webpage.
            version    : 'v5.0'           // Use this Graph API version for this call.
        });


        FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
            statusChangeCallback(response);        // Returns the login status.
        });
    };


    (function(d, s, id) {                      // Load the SDK asynchronously
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                'Thanks for logging in, ' + response.name + '!';
        });
    }

</script>





<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v5.0&appId=176037053649511&autoLogAppEvents=1"></script>
<div id="status">
</div>

  

<!--************-->
<!--Foter -->
<!--************-->

<footer>
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-3 colfooter0">
                    <img src="../ressources/img/logo-footer.png" alt="Wasselni" style="width:50%;height:22%;">
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

<script src="../ressources/js/moment.min.js"></script>
<script src="../ressources/js/dateTrajetSlide.js"></script>
<script src="../ressources/js/proposertrajet.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script src="../ressources/js/global.js"></script>
<script src="../ressources/js/jquery-asRange.js"></script>
<script src="../ressources/js/validation.js"></script>





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