<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 07/01/2020
  Time: 01:57
  To change this template use File | Settings | File Templates.
--%>

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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
    <link rel="stylesheet" href="ressources/css/style.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">   
    
    <!--Fichiers-->
    <link rel="icon" type="image/png" href="ressources/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="ressources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="ressources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="ressources/css/TrajetSlide.css">
    <link rel="stylesheet" href="ressources/css/offredemande.css">

    <title>Wasselni</title>
</head>

<body>



<!--************-->
<!-- Navigateur -->
<!--************-->
<c:import url="/navbar.jsp"/>


<!--************-->
<!-- Slides -->
<!--************-->
<section id="slide">
    <div id="monSlide" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#monSlide" data-slide-to="0" class="active"></li>
            <li data-target="#monSlide" data-slide-to="1"></li>
            <li data-target="#monSlide" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">

            <!--Slide 1 avec la possibilite de schoisir un trajet-->
            <div class="carousel-item carousel-image-1   active">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-left">
                        <div class="row" >

                            <!--TEXT-->
                            <div class="col bienvenu" style="margin-top: 100px;">
                                <h2 class="display-4 d-inline mylead">Bienvenue sur Wessalni!</h2>
                                <p></p>
                                <p class="lead textbg">  Et vous, qui allez-vous retrouver ? <br> choisissez le trajet qui vous convient le mieux </p>
                            </div>
                            <div class="col">

                                <!--Trajet-->
                                <div class="grid slideactive">
                                    <div id="login">
                                        <center><h2><span  class="fa fa-road"></span >  Où allez-vous ?</h2></center>
                                        <form action="/consulterOffres" method="get">
                                            <fieldset>


                                                <!--Depart-->
                                                <div class="wrap-input100 validate-input input-group" data-validate = "indispensable">
                                                    <input class="input100" type="text" name="depart" placeholder="Départ">
                                                    <span class="focus-input100"></span>
                                                    <span class="symbol-input100"><i class="fa fa-street-view" aria-hidden="true"></i>  </span>
                                                </div>


                                                <!--Destination-->
                                                <div class="wrap-input100 validate-input input-group" data-validate = "indispensable">
                                                    <input class="input100" type="text" name="destination" placeholder="Destination">
                                                    <span class="focus-input100"></span>
                                                    <span class="symbol-input100"><i class="fa fa-map-marker" aria-hidden="true"></i></span>
                                                </div>

                                                
                                                <!--Date-->
                                                <div class="wrap-input100 input-group">
                                                    <input class="input100" type="text" name="datetrajet" value="<%=LocalDateTime.now()%>" placeholder="Date" id="input-start">
                                                    <span class="symbol-input100"><i class="fa fa-calendar-alt" aria-hidden="true"></i></span>
                                                </div>
                                                <span>${form.erreurs['datetrajet']}</span>


                                                <!--Effectif-->
                                                <div class="wrap-input100 input-group">
                                                    <div class="input-group-icon js-number-input">
                                                        <div class="icon-con">
                                                            <span class="plus">+</span>
                                                            <span class="minus">-</span>
                                                        </div>
                                                        <input class="input100 quantity" style="height: 44px; border-radius: 17px; margin-bottom: 5px; width: 288px;" type="text" name="effectif" value="2 Personnes">
                                                        <span class="symbol-input100"><i class="fa fa-users" aria-hidden="true"></i></span>
                                                    </div>
                                                </div>



                                                <!--Les checkbox-->
                                                <div class="checkbox icheck-check1">
                                                    <input type="checkbox" checked id="check1" name="bagageautorise" value="true" />
                                                    <label for="check1" style="color: darkslategray; font-style:initial;font-size: 15px;">Bagage Autorisé</label>
                                                </div>
                                                <br>



                                                <!--Button pour chercher-->
                                                <div style="margin-left: 150px; margin-top: 20px;">
                                                    <input type="submit" id="btn" ></input>
                                                </div>


                                            </fieldset>
                                        </form>

                                    </div>
                                    <!-- Fin Trajet-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Slide 2-->
            <div class="carousel-item carousel-image-2 ">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-right mb-5">
                        <div class="row" style="margin-bottom: 30px;">
                            <div class="col"></div>
                            <div class="col">
                                <h2 class="display-4 d-inline titreB text">Avoir le choix</h2>
                                <br>
                                <p class="lead textbg">L'avantage des routes ? Elles vont partout ! Littéralement. Profitez de milliers de destinations.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Slide 3-->
            <div class="carousel-item carousel-image-3 ">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-left mb-5">
                        <div class="row">
                            <div class="col"></div>
                            <div class="col">
                                <h2 class="display-4 d-inline mylead">Une communauté de confiance</h2>
                                <br>
                                <p class="lead textbg"> Wasselni compte des milliers de membres. Nous avons vérifié leurs profils, un par un. </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--Suivant & Precedant-->
        <a href="#monSlide" data-slide="prev" class="carousel-control-prev">
            <span class="carousel-control-prev-icon"></span>
        </a>

        <a href="#monSlide" data-slide="next" class="carousel-control-next">
            <span class="carousel-control-next-icon"></span>
        </a>

    </div>
</section>





<!--************-->
<!--Nos services  -->
<!--************-->
<div class="row" style="margin-top: 60px;margin-bottom: 60px;">


 <!-- Service Client -->
 <div class="col-12 col-lg-4 srv1">
    <div class="single-service-area mb-80">
        <div class="service-icon" >
                <i class="fa fa-life-ring" style="margin-top: 25px;"></i>
            </div>
            <h5  style="font-weight: bold;">Service Client 24/24 et 7/7</h5>
            <p></p>
        </div>
        <center>
            Assistance et d'accueil téléphonique 24/7 avec <br>
            nos expertises qui réponses Aux votre questions.
            <br> <br> <br>
            <a href="#" class="btn btn2" style="font-weight: bold;">En savoir plus</a>
        </center>
    </div>
    
    <!-- Service Proposer un trajet -->
    <div class="col-12 col-lg-4 srv2">
        <div class="single-service-area mb-80">
            <div class="service-icon">
                <i class="fa fa-bullhorn" style="margin-top: 25px;"></i>
            </div>
            <h5 style="font-weight: bold;">Comment proposer un trajet</h5>
            <p></p>
        </div>
        <center>
            permet aux conducteurs de publier une annonce <br>
             avec des places libres pour trouver des passagers <br>
              recherchant le même trajet. <br> <br>
            <a href="#" class="btn btn2" style="font-weight: bold; ">En savoir plus</a>
        </center>
    </div>

   <!-- Service la Sureté -->
   <div class="col-12 col-lg-4 srv3">
        <div class="single-service-area mb-80">
            <div class="service-icon">
                <i  class="fa fa-eye" aria-hidden="true" style="margin-top: 25px;"></i>
            </div>
            <h5  style="font-weight: bold;">Vous pouvez compter sur nous</h5>
            <p></p>
        </div>
        <center>
            Nous vous accompagnons dans votre trajet,  <br>
            en vous envoyant un signe <span style="font-weight: bold;">20 min</span>,<br>
            en enquêtant sur votre place. <br> <br>
            <a href="#" class="btn btn2" style="font-weight: bold;">En savoir plus</a>
        </center>
    </div>


</div>
</div>

<!--************-->
<!--Inscrire-->
<!--************-->
<section id="sectionMilieu" class="p-5">
    <div class="dark-overlay">
        <div class="row">
                <div class="container pt-5  inscriremv">
                    <h2 class="display-5 d-inline mylead">N'hésitez plus, abonnez vous maintenant !</h2>
                    <br><br><br><br>
                  
                    <div style="margin-left: 210px;">
                    <form method="post" action="/presinscription" class="form-inline">
                        <div class="form-group mb-2">
                            <div class=" wrap-input10i ">    
                                <input class="input10i" type="text" name="nom" placeholder="Nom">
                                <span class="focus-input10i"></span>
                                <span class="symbol-input10i"><i class="fa fa-user" aria-hidden="true"></i>  </span>
                            </div>
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <div class=" wrap-input10i ">    
                                <input class="input10i" type="email" name="email" placeholder="Email">
                                <span class="focus-input10i"></span>
                                <span class="symbol-input10i"><i class="fa fa-envelope" aria-hidden="true"></i>  </span>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-info mb-2 ">Inscrire</button>
                      </form>
                    </div>
                </div>
            
        </div>
    </div>
</section>



<!--************-->
<!--Derniere Offres  -->
<!--************-->
<h3 class="h2" style="text-align: center;">Les derniere offres</h3>
<br><br>
  <div class="section-container slider">
	<div class="row ">
		<div class="col-md-8 col-center m-auto">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Les insdicateurs-->
				<ol class="carousel-indicators carousel-indicatorss ">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
				</ol>   
                <!-- Items-->
                <center>
				<div class="carousel-inner">
                    <!--Debut item-->
                    <div class="container item carousel-item active slidecitation">
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
                                                <a style="margin-left: 100px;" href="#" id="btnd" ></a>
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
                                            <img src="ressources/img/box4.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                                        </div>
                                        <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Kamal Zoubire</h4>
                                        <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                                <a style="margin-left: 100px;" href="#" id="btnd" ></a>
                                                <br>
                                            </p>
                    
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
                <!--Fin item-->
                
                


                <!--Debut item-->
                <div class="container item carousel-item ">
                    <div class="row"> 
    
                        <!--Trajte-->
                        <div class="col-sm-6" >
                            <div class="card " style="margin-left: 50px;" >
                                <div class="post-image">
                                    <div class="imgBox">
                                        <img src="ressources/img/box2.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                                    </div>
                                    <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Abdellah Boufous</h4>
                                    <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                    <br> <br>
                                     <a style="margin-left: 100px;" href="#" id="btnd" ></a>
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
                                    <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Abdellah Boufous</h4>
                                    <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                        <a style="margin-left: 100px;" href="#" id="btnd" ></a>
                                        <br>
                                    </p>
                
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!--Fin item-->

                </center>
                <!-- *controls -->
				<a class="carousel-control left carousel-control-prev" href="#myCarousel" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				</a>
				<a class="carousel-control right carousel-control-next" href="#myCarousel" data-slide="next">
					<i class="fa fa-angle-right"></i>
                </a>
			</div>
		</div>
	</div>
</div>

<!--************-->
<!--Proposer-->
<!--************-->
<section id="sectionProposer" class="p-5">
    <div class="proposer-overlay">
        <div class="row">
                <div class="container pt-5  inscriremv">
                    <h2 class="display-5 d-inline mylead">vous pouvez proposer un trajet facilement! </h2>
                    <br><br> <br> <br>
                    <div >
                    <form method="post" action="/proposerTrajet" class="form-inline">
                        <div class="form-group mx-sm-3 mb-2">
                            <div class=" wrap-input10i ">
                                <input class="input10i" type="text" name="depart" placeholder="Depart">
                                <span class="focus-input10i"></span>
                                <span class="symbol-input10i"><i class="fa fa-street-view" aria-hidden="true"></i>  </span>
                            </div>
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <div class=" wrap-input10i ">
                                <input class="input10i" type="text" name="destination" placeholder="Destination">
                                <span class="focus-input10i"></span>
                                <span class="symbol-input10i"><i class="fa fa-map-marker" aria-hidden="true"></i>  </span>
                            </div>
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <div class=" wrap-input10i ">
                                <input class="input10i" type="text" name="prix" placeholder="Prix">
                                <span class="focus-input10i"></span>
                                <span class="symbol-input10i"><i class="fa fa-dollar-sign" aria-hidden="true"></i>  </span>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-info mb-2 ">Proposer</button>
                      </form>
                    </div>
                </div>

        </div>
    </div>
</section>



<!--************-->
<!--Derniere demande  -->
<!--************-->
<h3 class="h2" style="text-align: center;">Les derniere demandes</h3>
<br><br>
  <div class="section-container slider">
	<div class="row ">
		<div class="col-md-8 col-center m-auto">
			<div id="myCarouselOffere" class="carousel slide" data-ride="carousel">
				<!-- Les insdicateurs-->
				<ol class="carousel-indicators carousel-indicatorss ">
					<li data-target="#myCarouselOffere" data-slide-to="0" class="active"></li>
					<li data-target="#myCarouselOffere" data-slide-to="1"></li>
				</ol>   
                <!-- Items-->
                <center>
				<div class="carousel-inner">
                    <!--Debut item-->
                    <div class="container item carousel-item active slidecitation">
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
                                        <br> <br>
                                         <a style="margin-left: 100px;" href="#" id="btnd" ></a>
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
                                            <img src="ressources/img/box4.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                                        </div>
                                        <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Kamal Zoubire</h4>
                                        <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                        <br> <br>
                                         <a style="margin-left: 100px;" href="#" id="btnd" ></a>
                                         <br>
                    
                                        </p>
                    
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
                <!--Fin item-->
                
                


                <!--Debut item-->
                <div class="container item carousel-item ">
                    <div class="row"> 
    
                        <!--Trajte-->
                        <div class="col-sm-6" >
                            <div class="card " style="margin-left: 50px;" >
                                <div class="post-image">
                                    <div class="imgBox">
                                        <img src="ressources/img/box2.jpg" alt="" style="max-height: 120px; max-height: 150px;">
                                    </div>
                                    <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Abdellah Boufous</h4>
                                    <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                    <br> <br>
                                     <a style="margin-left: 100px;" href="#" id="btnd" ></a>
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
                                    <h4 style="text-align: left;margin-left: 140px; margin-top: 20px; color: rgb(92, 152, 206);">Abdellah Boufous</h4>
                                    <div style="text-align: left;margin-left: 140px; margin-top: -10px; ">
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
                                        <a style="margin-left: 100px;" href="#" id="btnd" ></a>
                                        <br>
                                    </p>
                
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!--Fin item-->

                </center>
                <!-- *controls -->
				<a class="carousel-control left carousel-control-prev" href="#myCarouselOffere" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				</a>
				<a class="carousel-control right carousel-control-next" href="#myCarouselOffere" data-slide="next">
					<i class="fa fa-angle-right"></i>
                </a>
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
<!--Fichiers-->
<script src="ressources/js/moment.min.js"></script>
<script src="ressources/js/dateTrajetSlide.js"></script>
<script src="ressources/js/global.js"></script>


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

    ScrollReveal().reveal('.bienvenu',{
        origin:'buttom',
        duration:2000,
        distance:'60px'
    });
    
    //Service
    ScrollReveal().reveal('.srv1',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.srv2',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.srv3',{
        origin:'right',
        duration:2000,
        distance:'60px'
    });

      //mini slider
      ScrollReveal().reveal('.slider',{
        origin:'left',
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