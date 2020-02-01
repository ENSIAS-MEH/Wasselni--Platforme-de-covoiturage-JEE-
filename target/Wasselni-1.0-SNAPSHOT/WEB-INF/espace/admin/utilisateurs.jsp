<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>nom_de_admin| Espace Admin</title>
    <!-- Bootstrap CSS -->
    <link href="../../../ressources/bootstrapPack/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../ressources/bootstrapPack/css/style.css" rel="stylesheet">
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
  </head>
  <body>

   <c:import url="./navbar.jsp"/>
    <header id="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1><span class="glyphicon glyphicon-cog"  aria-hidden="true"></span>Espace Admin <small>Gestion de platform</small></h1>
          </div>
          </div>
        </div>
      </div>
    </header>

    <!--Chemin-->
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="admin.jsp">Principale</a></li>
          <li class="active">Utilisateurs</li>
        </ol>
      </div>
    </section>

    <section id="main">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
              <c:import url="./list_group.jsp"/>

            <div class="well">
              <h4 style="font-size: 17px; font-weight: bold;">La Croissance par semaine</h4>
              <hr>
              <h5>inscrits</h5>
              <div class="progress">
                  <div class="progress-bar" role="progressbar progress-bar-success" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                      60%
                  </div>
              </div>
              <h5>Visitreurs</h5>
              <div class="progress">
                  <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                      80%
                  </div>
              </div>
              <h5>Offres</h5>
              <div class="progress">
                  <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%;">
                      45%
                  </div>
              </div>
              <h5>Demandes</h5>
              <div class="progress">
                  <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%;">
                      20%
                  </div>
              </div>

              
            
            </div>
          </div>
          <div class="col-md-9">
              <!-- Latest Users -->
              <div class="panel panel-default">
                <div class="panel-heading main-color-bg">
                  <h3 class="panel-title"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Utilisateurs</h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-hover">
                      <tr>
                        <th>Utilisateur</th>
                        <th>Review</th>
                        <th>Rejointe</th>
                        <th >Gérer </th>
                      </tr>
                      <tr>
                        <td>Abdellah Boufous</td>
                        <td>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                        </td>
                        <td>29 Janvier 2020</td>
                        <td> <a  class="btn btn-primary" href="#">Détaille</a >
                             <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Ilyas Bouziane</td>
                        <td>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                        </td>
                        <td>29 Janvier 2020</td>
                        <td><a  class="btn btn-primary" href="#">Détaille</a >
                          <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Ismail Barkani</td>
                        <td>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                        </td>
                        <td>29 Janvier 2020</td>
                        <td><a  class="btn btn-primary" href="#">Détaille</a >
                          <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Ahmed Adarraf</td>
                        <td> 
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                        </td>
                        <td>28 Janvier 2020n</td>
                        <td><a  class="btn btn-primary" href="#">Détaille</a >
                          <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Sara Yaakoubi</td>
                        <td>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                        </td>
                        <td>28 Janvier 2020</td>
                        <td><a  class="btn btn-primary" href="#">Détaille</a >
                          <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Abdesallam Zouhaire</td>
                        <td>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                          <span class="glyphicon glyphicon-star-empty"></span>
                        </td>
                        <td>28 Janvier 2020</td>
                        <td><a  class="btn btn-primary" href="#">Détaille</a >
                          <a class="btn btn-default"data-toggle="modal" data-target="#email"> <i class="glyphicon glyphicon-send"></i> Envoyer email</a> 
                        </td>
                      </tr>
                      
                    </table>

                   <center>
                    <div >
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
                   </center>


                </div>
              </div>
              
          </div>
        </div>
      </div>
    </section>

    <footer id="footer">
      <p>Copyright Wasselni, &copy; 2020</p>
    </footer>


    

    
    <div class="modal fade" id="email" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form>
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Envoyer un email</h4>
          </div>
          <div class="modal-body">


           <div class="form-group">
                    <label>Objet</label>
                    <input type="text" class="form-control" placeholder="Page Title" value="Wasselni.ma">
                  </div>
                  <div class="form-group">
                    <label>Message</label>
                    <textarea name="editor1" class="form-control" placeholder="Page Body">
                      Bonjour Monsieur / Madame XXXX, <br>
                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX <br>
                      Cordialement.
                    </textarea>
                  </div>



          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
            <button type="submit" class="btn btn-primary">Envoyer</button>
          </div>
        </form>
        </div>
      </div>
    </div>

    <script>
      CKEDITOR.replace( 'editor1' );
  </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../../../ressources/bootstrapPack/js/bootstrap.min.js"></script>
  </body>
</html>
