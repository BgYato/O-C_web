<%-- 
    Document   : accountUser
    Created on : 15/09/2023, 01:41:49 PM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your account</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            String correo = (String) request.getAttribute("correo");
        %> 
        <section style="background-color: #eee;">
            <div class="container py-5">
              <div class="row">
                <div class="col">
                  <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                      <li class="breadcrumb-item"><a href="/sondeos">Inicio</a></li>
                      <li class="breadcrumb-item"><a href="#">Admin</a></li>
                      <li class="breadcrumb-item active" aria-current="page">Admin Profile</li>
                    </ol>
                  </nav>
                </div>
              </div>

              <div class="row">
                <div class="col-lg-4">
                  <div class="card mb-4">
                    <div class="card-body text-center">
                      <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                        class="rounded-circle img-fluid" style="width: 150px;">
                      <h5 class="my-3"></h5>
                      <p class="text-muted mb-1"></p>
                      <p class="text-muted mb-4"></p>
                      <div class="d-flex justify-content-center mb-2">
                          <a href="tema?navegacion=register&idAdministrador=${administrador.idAdministrador}" class="btn btn-primary">Crear tema</a>
                          <a href="tema?navegacion=readAll" class="btn btn-outline-primary ms-1">Ver temas</a>
                      </div>
                        <c:if test="${mensaje eq 'exito-tema'}">
                          <div class="m-4 alert alert-success">
                              <p>Se ha registrado el tema.</p>
                          </div>
                        </c:if>
                        <c:if test="${mensaje eq 'error-tema'}">
                            <div class="m-4 alert alert-danger">
                                <p>No se ha podido registrar el tema.</p>
                            </div>
                        </c:if>
                    </div>
                  </div>
                  <div class="card mb-4 mb-lg-0">
                    <div class="card-body p-0">
                      <ul class="list-group list-group-flush rounded-3">
                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                          <i class="fas fa-globe fa-lg text-warning"></i>
                          <p class="mb-0">https://mdbootstrap.com</p>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                          <i class="fab fa-github fa-lg" style="color: #333333;"></i>
                          <p class="mb-0">mdbootstrap</p>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                          <i class="fab fa-twitter fa-lg" style="color: #55acee;"></i>
                          <p class="mb-0">@mdbootstrap</p>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                          <i class="fab fa-instagram fa-lg" style="color: #ac2bac;"></i>
                          <p class="mb-0">mdbootstrap</p>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                          <i class="fab fa-facebook-f fa-lg" style="color: #3b5998;"></i>
                          <p class="mb-0">mdbootstrap</p>
                        </li>
                      </ul>
                        </div>
                      </div>
                </div>
                <div class="col-lg-8">
                  <div class="card mb-4">
                    <div class="card-body">
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Nombre completo</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0"></p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Correo eléctronico</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0"></p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Telefono fijo</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0"></p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Número celular</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0"></p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Dirección domicilio</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0"></p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-body">
                      <p class="mb-4"><span class="text-primary font-italic me-1">Crea un nuevo</span> ADMINISTRADOR</p>
                      <form action="administrador" method="post">
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="correo">Correo eléctronico</label>
                              <input type="email" class="form-control" id="correo" name="usuCorreo">
                            </div>
                            <div class="form-group">
                              <label for="contrasenna">Contraseña</label>
                              <input type="password" class="form-control" id="contrasenna" name="usuContrasenna">
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="nombre">Nombre</label>
                              <input type="text" class="form-control" id="nombre" name="nombre">
                            </div>
                            <div class="form-group">
                              <label for="apellido">Apellido</label>
                              <input type="text" class="form-control" id="apellido" name="apellido">
                            </div>
                          </div>
                        </div>
                        <input type="hidden" name="accion" value="registrar">
                        <button type="submit" class="btn btn-primary mt-4">Crear administrador</button>
                      </form>
                        <c:if test="${mensaje eq 'exito'}">
                            <div class="m-4 alert alert-success">
                                <p>La operación se ha realizado con éxito.</p>
                            </div>
                        </c:if>
                        <c:if test="${mensaje eq 'error'}">
                            <div class="m-4 alert alert-danger">
                                <p>Ha ocurrido un error en el proceso.</p>
                            </div>
                        </c:if>
                    </div>
                  </div>

                  <div class="row mt-4">
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        <div class="card-body">
                          <p class="mb-4"><span class="text-primary font-italic me-1">Edita tu </span> USUARIO
                          </p>
                          <form action="usuario" method="post">
                            <div class="form-group">
                              <label for="usuCorreo">Correo eléctronico</label>
                              <input type="email" class="form-control" id="usuCorreo" name="usuCorreo" value="${usuario.usuCorreo}">
                            </div>
                            <div class="form-group">
                              <label for="contrasenna">Contraseña</label>
                              <input type="password" class="form-control" id="contrasenna" name="usuContrasenna">
                            </div>
                              <input type="hidden" name="accion" value="actualizar">
                              <input type="hidden" name="id" value="${usuario.usuId}">
                              <button type="submit" class="btn btn-primary mt-4">Editar usuario</button>
                          </form>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        <div class="card-body">
                          <p class="mb-4"><span class="text-primary font-italic me-1">Edita tu perfil</span> ADMINISTRADOR
                          </p>
                          <form action="administrador" method="post">
                            <div class="form-group">
                              <label for="nombre">Nombre</label>
                              <input type="text" class="form-control" id="nombre" name="nombre" value="${administrador.nombre}">
                            </div>
                            <div class="form-group">
                              <label for="apellido">Apellido</label>
                              <input type="text" class="form-control" id="apellido" name="apellido" value="${administrador.apellido}"> 
                            </div>
                              <input type="hidden" name="accion" value="actualizar">
                              <input type="hidden" name="idAdministrador" value="${administrador.idAdministrador}">
                              <input type="hidden" name="idUsuario" value="${administrador.idUsuario}">
                              <button type="submit" class="btn btn-primary mt-4">Editar administrador</button>
                          </form>
                            <c:if test="${mensaje eq 'exito-actualizar'}">
                                <div class="m-4 alert alert-success">
                                    <p>La operación se ha realizado con éxito.</p>
                                </div>
                            </c:if>
                            <c:if test="${mensaje eq 'error-actualizar'}">
                                <div class="m-4 alert alert-danger">
                                    <p>Ha ocurrido un error en el proceso.</p>
                                </div>
                            </c:if>
                        </div>
                      </div>
                    </div>
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
