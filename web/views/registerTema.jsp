<%-- 
    Document   : registerCiudadano
    Created on : 15/09/2023, 10:51:35 AM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #8fc4b7;">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-8 col-xl-6">
                  <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                      class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                      alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                      <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Crear un Tema</h3>

                      <form class="px-md-2" action="tema" method="post">

                        <div class="form-outline mb-4">
                          <input type="text" id="titulo" class="form-control" name="titulo"/>
                          <label class="form-label" for="titulo">Titulo</label>
                        </div>
                          
                        <div class="form-outline datepicker">
                            <input type="text" class="form-control" id="descripcion" name="descripcion" />
                          <label for="descripcion" class="form-label">Descripcion</label>
                        </div>                                                                                                                                       
                          
                        <div class="form-outline datepicker">
                          <input type="date" id="fechaIni" name="fechaIni" onchange="formatDateForMySQL(event)">
                          <br>
                          <label for="fechaIni" class="form-label">Fecha inicio</label>
                        </div>
                          
                        <div class="form-outline datepicker">
                          <input type="date" id="fechaFin" name="fechaFin" onchange="formatDateForMySQL(event)">
                          <br>
                          <label for="fechaFin" class="form-label">Fecha fin</label>
                        </div>  
                          
                        <select class="select" name="parametros">
                          <option value="ninguno" selected>Ninguno</option>
                          <option value="soloMujer">Solo mujeres</option>
                          <option value="soloHombre">Solo hombres</option>                          
                        </select>              
                        <br>
                        <label for="parametros" class="form-label">Parametros</label>                        
                                                 
                        <div class="form-outline">
                            <input type="text" id="pregunta" class="form-control" name="pregunta"/>
                          <label class="form-label" for="pregunta">Pregunta</label>
                        </div>                                                

                        <input type="hidden" name="accion" value="registrar"/>
                        <input type="hidden" name="id" value="${id}"/>
                        <button type="submit" class="btn btn-success btn-lg mb-1">Crear tema</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        
        <script>
            function formatDateForMySQL(event) {
              const inputDate = event.target.value;  // Obtiene la fecha del input en formato 'YYYY-MM-DD'
              event.target.value = inputDate;
            }
          </script>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
