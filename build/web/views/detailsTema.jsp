<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include  file="sessions/session.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        main {
            flex: 1;
        }
    </style>
    </head>
    <body>
        <%
            String idCiudadano = (String) request.getParameter("idCiudadano");
            String mensajeRecibido = request.getParameter("mensaje");
            mensajeRecibido = (mensajeRecibido != null && !mensajeRecibido.isEmpty()) ? mensajeRecibido : "";            
        %> 
        <section class="mx-auto mt-4" style="max-width: 42rem;">
          <div class="card" style="max-width: 42rem">
            <div class="card-body">
                <p class="small"><a href="usuario">Volver</a></p>
              <!-- Data -->
              <div class="d-flex mb-3">
                <a href="">
                  <img src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png" class="border rounded-circle me-2"
                    alt="Avatar" style="height: 40px" />
                </a>
                <div>
                  <a href="" class="text-dark mb-0">
                    <strong>Anna Doe</strong>
                  </a>
                  <a href="" class="text-muted d-block" style="margin-top: -6px">
                    <small>Creado el ${tema.fechaInicio}</small>
                  </a>
                </div>
              </div>
              <!-- Description -->
              <div>
                  <strong><p class="font-weight-bold">Tema No. ${tema.idTema} - ${tema.titulo}</p></strong>
                <p>
                  ${tema.descripcion}
                </p>
              </div>
            </div>             
            <div class="card-body">              
              <!-- Reactions -->

              <!-- Buttons -->
              <div class="d-flex justify-content-center text-center border-top border-bottom mb-4">                
                <button type="button" class="btn btn-link btn-lg" data-mdb-ripple-color="dark">
                  <i class="fas fa-comment-alt me-2"></i>Comment
                </button>                                                    
              </div>                    
                <c:choose>
                    <c:when test="${mensajeRecibido eq 'exito'}">
                        <div class="m-4 alert alert-success">
                            <p>La operación se ha realizado con éxito.</p>
                        </div>
                    </c:when>
                    <c:when test="${mensajeRecibido eq 'existe'}">
                        <div class="m-4 alert alert-danger">
                            <p>Ya tienes un comentario en este post.</p>
                        </div>
                    </c:when>
                    <c:otherwise>                        
                    </c:otherwise>
                </c:choose>

              <!-- Buttons -->

              <!-- Comments -->

              <!-- Input -->
              <div class="d-flex mb-3">
                <a href="">
                  <img src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png" class="border rounded-circle me-2"
                    alt="Avatar" style="height: 40px" />
                </a>
                <div class="form-outline w-100">
                    <form action="respuesta" method="POST">
                    <textarea class="form-control" id="respuesta" rows="2" name="respuesta"></textarea>
                  <div class="row">                      
                      <div class="col-lg-6">
                          <label class="form-label" for="respuesta">Deja un comentario</label>
                      </div>
                      <div class="col-lg-6">
                          <input type="submit" value="Enviar" />
                      </div>
                      <input type="hidden" name="idCiudadano" value="${idCiudadano}" />
                      <input type="hidden" name="idTema" value="${tema.idTema}" />
                      <input type="hidden" name="accion" value="registrar" />
                      </form>
                  </div>                  
                  
                </div>
              </div>
                <c:forEach var="respuesta" items="${respuestas}">
              <div class="d-flex mb-3">
                <a href="">
                  <img src="https://mdbcdn.b-cdn.net/img/new/avatars/8.webp" class="border rounded-circle me-2"
                    alt="Avatar" style="height: 40px" />
                </a>
                <div>
                  <div class="bg-light rounded-3 px-3 py-1">
                    <a href="" class="text-dark mb-0">
                      <strong>Ciudadano ID ${respuesta.idCiudadano}</strong>
                    </a>
                    <span class="text-muted d-block">
                      <small>${respuesta.respuesta}</small>
                    </span>
                  </div>
                  <a href="" class="text-muted small ms-3 me-2"><strong>Me gusta</strong></a>
                  <a href="" class="text-muted small me-2"><strong>Rep</strong></a>
                </div>
              </div>
              </c:forEach>
            </div>
            <!-- Interactions -->
          </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
