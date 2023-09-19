<%-- 
    Document   : loginUser
    Created on : 15/09/2023, 12:19:58 PM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login user</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            String correo = (String) request.getAttribute("correo");
        %> 
        <section class="vh-100">
            <div class="container py-5 h-100">
              <div class="row d-flex align-items-center justify-content-center h-100">
                <div class="col-md-8 col-lg-7 col-xl-6">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                    class="img-fluid" alt="Phone image">
                </div>
                <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                    <form action="usuario" method="post">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="correo" class="form-control form-control-lg" name="correo" />
                      <label class="form-label" for="correo">Correo eléctronico</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="pass" class="form-control form-control-lg" name="pass"/>
                      <label class="form-label" for="pass">Contraseña</label>
                    </div>
                    
                    <input type="hidden" name="accion" value="ingreso">                        

                    <!-- Submit button -->
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Ingresar"/>
                   
                    <c:if test="${mensaje eq 'no-existe'}">
                    <div class="m-4 alert alert-danger">
                        <p>El correo ${correo} no existe.</p>
                    </div>
                    </c:if> 
                    <c:if test="${mensaje eq 'incorrecto'}">
                        <div class="m-4 alert alert-danger">
                            <p>La contraseña es incorrecta.</p>
                        </div>
                    </c:if> 
                    <c:if test="${mensaje eq 'exito'}">
                        <div class="m-4 alert alert-success">
                            <p>La operación se ha realizado con éxito.</p>
                        </div>
                    </c:if> 
                    <c:if test="${mensaje eq 'sin-sesion'}">
                        <div class="m-4 alert alert-danger">
                            <p>No has iniciado sesión.</p>
                        </div>
                    </c:if> 
                  </form>
                </div>
              </div>                
            </div>            
          </section>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
