<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Wasselni</title>


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
<!--Fichiers-->
   <link rel="stylesheet" type="text/css" href="ressources/css/TrajetSlide.css">
   <link rel="stylesheet" href="ressources/css/style.css">
   <link rel="stylesheet" href="ressources/css/offres.css">
   <link rel="stylesheet" href="ressources/css/offredemande.css">
    
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

   <!-- PAGE HEADER -->
   <header id="p-header">
    <div class="container">
      <div class="row" style="margin-top: 100px;">
        <div class="col-md-8 m-auto text-center offretxt" >
          <h2 class="display-4 d-inline titreB text" >Les offres actuelles</h2>
                          <br>
                         <p class="lead textbg"> Les routes vont partout ! Littéralement. Profitez de milliers de destinations.</p>
        </div>
      </div>
    </div>
  </header>


<h3 class="h2" style="text-align: center;">Les offres</h3>


<div class="container" style="margin-top: 80px; margin-bottom: 80px; max-width: 1300px;">
    
  <div class="row">
        <div class="col-2 filter" style="box-shadow:0px 0px 10px rgba(0, 0, 0, .4); border-radius: 20px;">
          <!-- Filtrage -->
            <form action="">
              <div class="aside" style="margin-top: 20px;">

                <!-- Par prix -->
                <p style="font-weight: bold;margin-left: 12px;"> Prix par passager (Dhs)</p>
                <section>
                    <div style="margin-left: -10px; margin-top: -8px;padding: 2em;">
                        <input class="prix"  type="text" min="50" max="500" value="150,370" name="prixx" step="10" />
                      <script>
                        $(document).ready(function() {
                          $(".prix").asRange({
                            range: true,
                            limit: true
                          });
                        });
                      </script>
                    </div>
                  </section>
            </div>

            <hr>

            <div class="aside">
              <!--Depart -->
                <p style="font-weight: bold; margin-left: 20px;"> Depart </p>
                <div class="wrap-input100 validate-input input-group" data-validate = "indispensable" style="  margin-top: -20px;">
                  <input class="input100"  type="text" name="depare">
                  <span class="focus-input100"></span>
                  <span class="symbol-input100"><i class="fa fa-street-view" aria-hidden="true"></i>  </span>
                </div>
            </div>

            <hr>

            <div class="aside">
              <!-- Destination -->
                <p style="font-weight: bold;margin-left: 20px;">Destination</p>
                <div class="wrap-input100 validate-input input-group" data-validate = "indispensable" style="  margin-top: -20px;">
                  <input class="input100"  type="text" name="depare">
                  <span class="focus-input100"></span>
                  <span class="symbol-input100"><i class="fa fa-map-marker-alt aria-hidden="true"></i>  </span>
                </div>
            </div>

            <hr>

            <div class="aside">
              <!-- Date -->
                <p style="font-weight: bold; margin-left: 20px;">Date</p>
                <div class="wrap-input100 input-group" style="  margin-top: -20px;">
                  <input class="input100" type="text" name="datetrajet"  id="input-start">
                  <span class="focus-input100"></span>
                  <span class="symbol-input100"><i class="fa fa-calendar-alt" aria-hidden="true"></i></span>
              </div>
            </div>

            <div class="container-offre-form-btn">
              <button class="offre-form-btn"  >Filter</button>
            </div>
       
          </form>


        </div>

        <!-- Les offres -->
        <div class="col-10 offre">
          <!-- Premier ligne des offres -->
            <div class="row ">
                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box1.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
                    </div>
                </div>




                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box3.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
                    </div>
                </div>
            </div> 

            
            <!--row--> <br> <br>



            <div class="row">

                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box1.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
                    </div>
                </div>




                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box2.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
                    </div>
                </div>





            </div>

            <!--row--> <br> <br>
            <div class="row">

                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box3.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
                    </div>
                </div>




                <!--Trajte-->
                <div class="col-sm-6" >
                    <div class="card " style="margin-left: 50px;" >
                        <div class="post-image">
                            <div class="imgBox">
                                <img src="ressources/img/box2.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                            </div>
                            <h4 style=" text-align: left; margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Hicham Assoud</h4>
                            <div style=" text-align: left;margin-left: 140px; margin-top: -10px; ">
                                <span style="color: rgb(92, 152, 206);" >Age:</span>
                                <span style="color: rgb(255, 255, 255);" >28 ans</span> <br>
                                <span style="color: rgb(92, 152, 206);" > Sex:</span>
                                <span style="color: rgb(255, 255, 255);" >F</span>
                            </div>
                            
                        </div>
                        
                        <div class="news-content">
                            <!--Prix-->
                            <span class="category">Prix de trajet: 200Dh</span>
                            <div class="post-meta">
                                <div class="row" style="text-align: left;">
                                    <!--Depart-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-street-view"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Départe: </span> Region, ville</a> </span>
                                    </div>
                                     <!--Destination-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-map-marker"></i> <span style="color: rgb(39, 114, 77);font-weight: bold;">Destination: </span>Region, ville</a> </span>
                                    </div> 
                                </div>
                                <div class="row" style="text-align: left;">
                                    <!--Date-->
                                    <div class="col-sm-5">
                                        <span style="margin-left:10px;"> <a href="#"> <i class="fa fa-clock"></i> 22 Janvier 2020 à 18h </a> </span>
                                    </div>  
                                     <!--Effectif-->
                                    <div class="col">
                                        <span > <a href="#"> <i class="fa fa-users"></i> 2 places</a> </span>
                                    </div>
                                </div>
                                <p>
                                    <br><br>
                                    <a style="margin-left: 380px; " href="#" id="btnd" ></a>
                                    <br>
                                </p>
        
                            </div>
                        </div>
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
                  <img src="ressources/img/logo-footer.png"  alt="Wasselni" style="width:50%;height:22%;">
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

<script src="ressources/js/moment.min.js"></script>
<script src="ressources/js/dateTrajetSlide.js"></script>
<script src="ressources/js/proposertrajet.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script src="ressources/js/global.js"></script>
<script src="ressources/js/jquery-asRange.js"></script>




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
  ScrollReveal().reveal('.slideactive',{
      origin:'left',
      duration:2000,
      distance:'60px'
  });

  ScrollReveal().reveal('.offretxt',{
      origin:'buttom',
      duration:2000,
      distance:'60px'
  });
  ScrollReveal().reveal('.h2',{
      origin:'top',
      duration:2000,
      distance:'60px'
  });
  
  //Service
  ScrollReveal().reveal('.filter',{
      origin:'left',
      duration:2000,
      distance:'60px'
  });
  ScrollReveal().reveal('.offre',{
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
