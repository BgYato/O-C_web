<%-- 
    Document   : registerUser
    Created on : 14/09/2023, 10:39:38 PM
    Author     : TOSHIBA
--%>

<%@include  file="sessions/session.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register user</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%
        String mensaje = (String) request.getAttribute("mensaje");
        %>        
        <section class="vh-100" style="background-color: #eee;">
            <div class="container h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                  <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                      <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                          <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Editar usuario.</p>

                          <form class="mx-1 mx-md-4" method="post" action="usuario">

                            <div class="d-flex flex-row align-items-center mb-4">
                              <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                              <div class="form-outline flex-fill mb-0">
                                <input type="email" id="usuCorreo" class="form-control" name="usuCorreo" value="${usuario.usuCorreo}"/>
                                <label class="form-label" for="usuCorreo">Tu correo</label>
                              </div>
                            </div>


                            <div class="d-flex flex-row align-items-center mb-4">
                              <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                              <div class="form-outline flex-fill mb-0">
                                  <input type="password" id="usuContrasenna" class="form-control" name="usuContrasenna" required/>
                                <label class="form-label" for="usuContrasenna">Tu contraseña</label>
                              </div>
                            </div>

                              <input type="hidden" name="accion" value="actualizar" />
                              <input type="hidden" name="id" value="${usuario.usuId}" />
                              
                            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                              <input type="submit" class="btn btn-primary btn-lg" value="Confirmar"/>
                            </div>

                          </form>

                        </div>
                        <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                            class="img-fluid" alt="Sample image">

                        </div>
                      </div>
                        <c:if test="${mensaje eq 'exito'}">
                            <div class="alert alert-success">
                                <p>La operación se ha realizado con éxito.</p>
                            </div>
                        </c:if>        
                        <c:if test="${mensaje eq 'error'}">
                            <div class="alert alert-danger">
                                <p>La operación ha fallado.</p>
                            </div>
                        </c:if>   
                    </div>
                  </div>
                </div>                
              </div>
            </div>
          </section>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
