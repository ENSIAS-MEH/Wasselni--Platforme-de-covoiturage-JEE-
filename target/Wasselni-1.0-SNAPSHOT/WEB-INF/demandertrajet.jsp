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
   <link rel="stylesheet" type="text/css" href="../ressources/css/TrajetSlide.css">
   <link rel="stylesheet" type="text/css" href="../ressources/css/proposertrajet.css">
   <link rel="stylesheet" type="text/css" href="../ressources/css/TrajetSlide.css">
   <link rel="stylesheet" href="../ressources/css/style.css">
   <link rel="stylesheet" href="../ressources/css/demandertrajet.css">
    
</head>


<body>

<!--************-->
<!-- Navigateur -->
<!--************-->
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

              <li class="nav-item">
                  <a href="<c:url value="/demanderTrajet"/>" class="nav-link">Demander un trajet</a>
              </li>

          </ul>
      </div>
  </div>
</nav>


<center>
    <div class="container-proposer" ></div>
        <form id="proposer" style="margin-top: 80px;">
                    <div class="loader">
                            <div class="loader-img"></div>
                        </div>
                    <ul id="progressbar" >
                        <li class="active"> Itinéraire</li>
                        <li> Annonce</li>
                      </ul>
                      <!--Phase 1-->
                      <fieldset>
                         <h4 style="font-family: Montserrat-Bold;">Concernant le trajet</h4> 
                                <br>


                                <div style="margin-left: 20px; text-align: left; font-weight: bold; margin-top: 25px;"> D’où partez-vous</div>
                                        <!--Depart-->
                                        <div class="wrap-input100 validate-input input-group" data-validate = "indispensable">
                                              <input class="input100"  type="text" name="depare" placeholder="Exemple: Madinat AlIrfan, Rabat">
                                            <span class="focus-input100"></span>
                                            <span class="symbol-input100"><i class="fa fa-street-view" aria-hidden="true"></i>  </span>
                                        </div>


                                        <div style="margin-left: 20px;text-align: left; font-weight: bold; margin-top: 25px;"> Où allez-vous</div>
                                        <!--Destination-->
                                        <div class="wrap-input100 validate-input input-group" data-validate = "indispensable">
                                            <input class="input100"type="text" name="destination" placeholder="Exemple: Boukhalef, Tanger">
                                            <span class="focus-input100"></span>
                                            <span class="symbol-input100"><i class="fa fa-map-marker-alt" aria-hidden="true"></i>  </span>
                                        </div>


                                        <div style="margin-left: 20px;text-align: left; font-weight: bold; margin-top: 25px;">Quand partez-vous ?</div>
                                        <!--Date-->
                                        <div class="wrap-input100 input-group">
                                          <input class="input100" type="text" name="datetrajet" placeholder="Date" id="input-start">
                                          <span class="symbol-input100"><i class="fa fa-calendar-alt" aria-hidden="true"></i></span>
                                      </div>
                                         
                                <br>
                                <!--Suivant-->
                        <input type="button" name="suivant" class="next suivant" value="Suivant" />
                      </fieldset>
                    
                    <!--Phase 2-->
                      <fieldset>
                        <h4 style="font-family: Montserrat-Bold;">Concernant l'annonce</h4> 
                        <br>

                            <div style="margin-left: 20px; text-align: left; font-weight: bold; margin-top: 8px;">Nombre de places que vous souhaitez réserver</div>
                              <!--Effectif-->
                              <div class="wrap-input100 input-group">
                                    <div class="input-group-icon js-number-input">
                                      <div class="icon-con">
                                          <span class="plus">+</span>
                                          <span class="minus">-</span>
                                      </div>
                                        <input class="input100 quantity" style="width: 520px; height: 45px; margin-bottom: 10px;" type="text" name="effectif" value="2 Personnes">
                                        <span class="focus-input100"></span>
                                        <span class="symbol-input100"><i class="fa fa-users" aria-hidden="true"></i>  </span>     
                                    </div>
                                </div>
                                <div style="margin-left: 20px; text-align: left; font-weight: bold; margin-top: 8px;">La limite de  prix par passager (Dhs)</div>
                                 <!--La limite de prix-->
                                 <section>
                                  <div style="margin-top: 10px;padding: 2em;">
                                    
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
                           <!--Les checkbox-->
                           <div style="text-align: left;margin-left: 20px;">
                            <div class="checkbox icheck-check1">
                              <input type="checkbox" checked id="check1" />
                              <label for="check1" style="color: darkslategray; font-style:initial;font-size: 15px;">Bagage</label>
                          </div> 
                           </div>
                            
                        <br>
                        <!--precedant-->
                        <input type="button" name="precedant" class="previous precedant" value="précedant" />
                        <!--PROPOSER (submet button)-->
                        <input type="submit" name="suivant" class="proposer" value="Proposer" />
                    </fieldset>
                    
        </form>
        
        </div>
        
</center>

<!--************************************************-->
<!--CODE JAVASCRIPT-->
<!--************************************************-->


<script src="../ressources/js/moment.min.js"></script>
<script src="../ressources/js/dateTrajetSlide.js"></script>
<script src="../ressources/js/proposertrajet.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script src="../ressources/js/global.js"></script>
<script src="../ressources/js/jquery-asRange.js"></script>


</body>
</html>
