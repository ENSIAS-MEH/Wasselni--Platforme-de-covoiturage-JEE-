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
<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"><script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--Fichiers-->
<link rel="stylesheet" type="text/css" href="../ressources/css/TrajetSlide.css">
<link rel="stylesheet" href="../ressources/css/style.css">
<link rel="stylesheet" href="../ressources/css/offres.css">
<link rel="stylesheet" href="../ressources/css/inscription.css">
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
		<div class="container-inscription ">
			<div class="wrap-inscription insc" style="margin-top: 110px;margin-bottom: 130px;">
                <span class="inscription-form-title" style="margin-left: 130px;">
                    Rejoins nous
                </span>
                
				<form method="post" action="<c:url value='/inscription'/>" style="align-self: center;">

                   <!--NOM-->
                    <div class="wrap-input100 validate-input" data-validate ="">
						<input class="input100" type="text" name="nom" value="<c:out value='${user.nom}'/>" placeholder="Nom">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-info" aria-hidden="true"></i>
						</span>
                        <span>${form.erreurs['nom']}</span>
					</div>

					
					 <!--PRENOM-->
                   
                     <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" type="text" value="<c:out value='${user.prenom}'/>" name="prenom" placeholder="Prénom">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-info" aria-hidden="true"></i>
						</span>
                         <span>${form.erreurs['prenom']}</span>
					</div>

                    <!--Sexe-->
                    <div class="mylabel" style="font-weight: bold; margin-left: 50px;"> Sexe: </div>
                    <div class="mylabel">
                        <input type="radio" id="M" name="sexe"  value="M" checked>
                        <div class="slidinggroove"></div>
                        <label class="mylabel" for="M"><p class="labelterm">M</p></label>
                    </div>

                    <div class="mylabel" style="margin-left: 150px;">
                        <input type="radio" id="F" name="sexe"  value="F">
                        <div class="slidinggroove"></div>
                        <label class="mylabel" for="F" ><p class="labelterm">F</p></100Dhs></label>
                    </div>
                    <!--Date naissance-->
                    <div class="wrap-input100 " data-validate="Champ obligatoire">
                        <input class="input100" type="text" value="<c:out value='${user.dateNaissance}'/>" name="datenaissance"  id="input-start" placeholder="Date naissance">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100"><i class="fa fa-birthday-cake" aria-hidden="true"></i></span>
                        <span style="color: #721c24">${form.erreurs['datenaissance']}</span>
                    </div>

                    <!--Region-->
                    <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" value="<c:out value='${user.region}'/>" type="text" name="region" placeholder="Région">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-map-marker-alt" aria-hidden="true"></i>
						</span>
					</div>
                    <br> <br> <br>

                    <!--Nom d'utilisateur-->
                    <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" type="text" value="<c:out value='${user.login}'/>" name="pseudo" placeholder="Pseudo-Nom">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                        <span>${form.erreurs['pseudo']}</span>
					</div>					
					<!--Email-->
					<div class="wrap-input100 validate-input" data-validate = "Le format valide: exemple@abc.xyz">
						<input class="input100" type="email" value="<c:out value='${user.email}'/>" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-at" aria-hidden="true"></i>
						</span>
                        <span>${form.erreurs['email']}</span>
					</div>
                   
                   <!--MOT de PASSE-->
                    <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" type="password" value="<c:out value='${user.password}'/>" name="motdepasse" placeholder="Mot de passe">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                        <span>${form.erreurs['motdepasse']}</span>
					</div>

					
					<!--La confirmation de mot de passe -->
					
					 <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" type="password" name="confirmationmotdepasse" placeholder="Confirmer mot de passe">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                    </div>
                    

                    <!--Question-->
                    <div style="text-align: left;">
                        <select name ="question" class="browser-default custom-select" style="margin-bottom: 12px; border-radius: 20px; background:#e6e6e6; width:435px;">
                          <option value="-1" selected>Question de sécurité</option>
                          <option value="3" >Quel est le prénom de votre enfant aîné?</option>
                          <option value="1" >Quel était le numéro de la maison et le nom de la rue dans lequel vous viviez enfant?</option>
                          <option value="4" >What time of the day were you born? (hh:mm)</option>
                          <option value="2" >Quels étaient les quatre derniers chiffres de votre numéro de téléphone d'enfance?</option>
                        </select>
                      </div>

                      <!--Reponse-->
                    <div class="wrap-input100 validate-input" data-validate = "Champ obligatoire">
						<input class="input100" type="text" value="<c:out value='${user.reponse}'/>" name="reponse" placeholder="La réponse">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-info-circle" aria-hidden="true"></i>
						</span>
                        <span>${form.erreurs['reponse']}</span>
					</div>
               <br> 
               
                   <!--Les checkbox-->
                       <div class="checkbox icheck-check1">
                        <input type="checkbox" checked id="check1" value="1" name="accepte"/>
                        <label for="check1">j'accepte <a href="">les termes et conditions et la politique de confidentialité</a></label>
                    </div>
                    <span>${form.erreurs['accepte']}</span>
                
                
                <!--Buton pour rejoindre-->
                
					<div class="container-inscription-form-btn" >
						<input type="submit" style="margin-right: 30px;" class="inscription-form-btn" value="Rejoindre" />
					</div>
				</form>
			</div>
		</div>
	</div>

  </section>

  
  

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
  