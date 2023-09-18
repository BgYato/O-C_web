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
        
        <div class="card d-flex" style="width: 48rem">
            <div class="card-body">
              <!--Table-->
              <table class="table-responsive">
              </table>
              <table class="table table-hover table-forum text-center">
                <!--Table head-->
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">Temas</th>
                    <th>Respuestas</th>
                  </tr>
                </thead>                
                <tbody>
                    <c:forEach var="tema" items="${listaTemas}">
                  <tr>
                    <td scope="row" class="text-nowrap">

                      <a href="tema?navegacion=tema&idTema=${tema.idTema}" type="button" class="btn btn-outline-dark-green btn-sm p-1 m-0 waves-effect">
                        <span class="value">Tema #${tema.idTema}</span>                        
                      </a>
                    </td>
                    <td class="text-start">
                      <a href="tema?navegacion=tema&idTema=${tema.idTema}" class="font-weight-bold blue-text">
                          ${tema.titulo}
                      </a>
                      <div class="my-2">
                        <a class="blue-text">
                          <strong>${tema.descripcion}</strong>
                        </a>                        
                        <span>inicio en ${tema.fechaInicio} - finaliza el ${tema.fechaFin}</span>
                        <div></div>
                      </div>
                    </td>
                    <td>
                      <a href="#" class="text-dark">
                        <span>0</span>
                        <i class="fas fa-comments ml-1"></i>
                      </a>
                    </td>
                  </tr>
                  </c:forEach>                  
                </tbody>                
              </table>                            
            </div>
          </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
