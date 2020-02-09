<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>nom_de_admin| Espace Admin</title>
    <!-- Bootstrap CSS -->
    <link href="../ressources/bootstrapPack/css/bootstrap.min.css" rel="stylesheet">
    <link href="../ressources/bootstrapPack/css/style.css" rel="stylesheet">
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
  </head>
  <body>

    <c:import url="navbar.jsp"/>

    <header id="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1><span class="glyphicon glyphicon-cog"  aria-hidden="true"></span>Espace Admin <small>Gestion de platform</small></h1>
          </div>
        </div>
      </div>
    </header>

    <!--Chemin-->
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="admin.jsp">Principale</a></li>
          <li class="active">Offres</li>
        </ol>
      </div>
    </section>

    <section id="main">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
              <c:import url="list_group.jsp"/>

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
                  <h3 class="panel-title"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Offres</h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-hover">
                      <tr>
                        <th>Dépare</th>
                        <th>Destination</th>
                        <th>Date</th>
                        <th>Situation</th>
                        <th> <span style="margin-left: 80px;">Gérer</span>  </th>
                      </tr>
                      <tr>
                        <td>Rabat, Agdal</td>
                        <td>Tanger, Boukhalef</td>
                        <td>29 Janvier 2020</td>
                        <td>
                          <span class="glyphicon glyphicon-ok" style="color:rgb(13, 141, 62);"></span>
                        </td>
                        <td> <a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a> 
                        </td>
                      </tr>
                      <tr>
                        <td>Oujda, Boudire</td>
                        <td>Agadir</td>
                        <td>29 Janvier 2020</td>
                        <td>
                          <span class="glyphicon glyphicon-hourglass" style="color:rgb(206, 121, 24);"></span>
                        </td>
                        <td><a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a>  
                        </td>
                      </tr>
                      <tr>
                        <td>Nador, Arouit</td>
                        <td>Maknes</td>
                        <td>29 Janvier 2020</td>
                        <td>
                          <span class="glyphicon glyphicon-ok" style="color:rgb(13, 141, 62);"></span>
                        </td>
                        <td><a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a>  
                        </td>
                      </tr>
                      <tr>
                        <td>Tanger, centre ville</td>
                        <td>El jadida</td>
                        <td>28 Janvier 2020n</td>
                        <td>
                          <span class="glyphicon glyphicon-ok" style="color:rgb(13, 141, 62);"></span>
                        </td>
                        <td><a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a>  
                        </td>
                        <td></td>
                      </tr>
                      <tr>
                        <td>Fes</td>
                        <td>Guercif</td>
                        <td>28 Janvier 2020</td>
                        <td>
                          <span class="glyphicon glyphicon-hourglass" style="color:rgb(206, 121, 24);"></span>
                        </td>
                        <td><a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a>  
                        </td>
                      </tr>
                      <tr>
                        <td>Casablanca, Anfa</td>
                        <td>Kenitra</td>
                        <td>28 Janvier 2020</td>
                        <td>
                          <span class="glyphicon glyphicon-hourglass" style="color:rgb(206, 121, 24);"></span>
                        </td>
                        <td><a  class="btn btn-primary" data-toggle="modal" data-target="#email">Détaille</a >
                             <a class="btn btn-default" href="#"> <i class="glyphicon glyphicon-trash"></i> Supprimer</a>  
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
            <h4 class="modal-title" id="myModalLabel">Offre</h4>
          </div>
          <div class="modal-body">


           <div class="form-group">
                <label>Depart</label>
                <input type="text"  class="form-control" placeholder="Page Title" value="Depart" disabled>
           </div>

           <div class="form-group">
            <label>Destination</label>
            <input type="text" class="form-control" placeholder="Page Title" value="Destination" disabled>
           </div>

           <div class="form-group">
            <label>Date</label>
            <input type="text" class="form-control" placeholder="Page Title" value="Date" disabled>
           </div>

           <div class="form-group">
            <label>Nombre de passagers</label>
            <input type="text" class="form-control" placeholder="Page Title" value="Nombre des passagers" disabled>
           </div>


           <div class="form-group">
            <label>Prix par passager</label>
            <input type="text" class="form-control" placeholder="Page Title" value="Prix par passagers" disabled>
           </div>
                  

          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
            <button type="submit" class="btn btn-success">Approuver</button>
          </div>
        </form>
        </div>
      </div>
    </div>

    <script>
      CKEDITOR.replace( 'editor1' );
  </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../ressources/bootstrapPack/js/bootstrap.min.js"></script>
  </body>
</html>
