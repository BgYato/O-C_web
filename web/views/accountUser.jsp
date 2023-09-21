<%-- 
    Document   : accountUser
    Created on : 15/09/2023, 01:41:49 PM
    Author     : TOSHIBA
--%>
<%@include  file="sessions/session.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your account</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
    %>
    <body>
        <section style="background-color: #eee;">
            <div class="container py-5">
              <div class="row">
                <div class="col">
                  <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                      <li class="breadcrumb-item"><a href="/sondeos/">Inicio</a></li>
                      <li class="breadcrumb-item"><a href="#">User</a></li>
                      <li class="breadcrumb-item active" aria-current="page">User Profile</li>
                    </ol>
                  </nav>
                </div>
              </div>
              
            <c:if test="${mensaje eq 'sin-permisos'}">
                <div class="m-4 alert alert-danger">
                    <p>No tienes los permisos para ingresar.</p>
                </div>                                
            </c:if>                

              <div class="row">
                <div class="col-lg-4">
                  <div class="card mb-4">
                    <div class="card-body text-center">
                      <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                        class="rounded-circle img-fluid" style="width: 150px;">
                      <h5 class="my-3">${sCiudadano.nombres}</h5>
                      <p class="text-muted mb-1">${usuario.usuCorreo}</p>
                      <p class="text-muted mb-4">${ciudadano.direccion}</p>
                      <div class="d-flex justify-content-center mb-2">
                          <a href="ciudadano?navegacion=edit&id=${ciudadano.idUsuario}" class="btn btn-primary">Editar mis datos</a>
                          <a href="usuario?navegacion=edit&id=${ciudadano.idUsuario}" class="btn btn-outline-primary ms-1">Editar mi usuario</a>
                      </div>
                    </div>
                  </div>
                  <div class="card mb-4 mb-lg-0">
                    <div class="card-body p-0">
                        <h4 class="text-center mt-4">Temas disponibles</h4>
                        <div class="list-group m-4">
                            <c:forEach var="tema" items="${listaTemas}">
                                <div class="mt-4">
                                <a href="#" class="list-group-item list-group-item-action">
                                    ${tema.idTema} - ${tema.titulo}
                                    <a href="tema?navegacion=tema&idTema=${tema.idTema}&idCiudadano=${ciudadano.idCiudadano}" class="btn btn-primary btn-sm float-end w-100">Ver detalles</a>
                                </a>
                                </div>
                            </c:forEach>
                        </div>
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
                          <p class="text-muted mb-0">${ciudadano.nombres} ${ciudadano.apellidos}</p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Correo eléctronico</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">${usuario.usuCorreo}</p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Telefono fijo</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">${ciudadano.fijo}</p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Número celular</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">${ciudadano.celular}</p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Dirección domicilio</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">${ciudadano.direccion}</p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        <div class="card-body">
                          <h4 class="text-center mt-4">Tus certificados</h4>
                            <div class="list-group m-4">
                                <c:forEach var="certificado" items="${listaCertificados}">
                                    <div class="mt-4">
                                    <a href="#" class="list-group-item list-group-item-action">
                                        Certificado No.${certificado.identificador}                                       
                                        <a 
                                            href="reporte?tipo=certificado&accion=download&idCertificado=${certificado.identificador}&idCiudadano=${sCiudadano.idCiudadano}" 
                                            class="btn btn-primary btn-sm float-end w-100 mt-2"
                                            target="_blank">
                                            Descargar PDF
                                        </a>                                    
                                        <a 
                                            href="reporte?tipo=certificado&accion=show&idCertificado=${certificado.identificador}&idCiudadano=${sCiudadano.idCiudadano}" 
                                            class="btn btn-success btn-sm float-end w-100 mt-2"
                                            target="_blank">
                                            Ver PDF
                                        </a>
                                    </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        <div class="card-body">
                          <p class="mb-4"><span class="text-primary font-italic me-1">assigment</span> Project Status
                          </p>
                          <p class="mb-1" style="font-size: .77rem;">Web Design</p>
                          <div class="progress rounded" style="height: 5px;">
                            <div class="progress-bar" role="progressbar" style="width: 80%" aria-valuenow="80"
                              aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                          <p class="mt-4 mb-1" style="font-size: .77rem;">Website Markup</p>
                          <div class="progress rounded" style="height: 5px;">
                            <div class="progress-bar" role="progressbar" style="width: 72%" aria-valuenow="72"
                              aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                          <p class="mt-4 mb-1" style="font-size: .77rem;">One Page</p>
                          <div class="progress rounded" style="height: 5px;">
                            <div class="progress-bar" role="progressbar" style="width: 89%" aria-valuenow="89"
                              aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                          <p class="mt-4 mb-1" style="font-size: .77rem;">Mobile Template</p>
                          <div class="progress rounded" style="height: 5px;">
                            <div class="progress-bar" role="progressbar" style="width: 55%" aria-valuenow="55"
                              aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                          <p class="mt-4 mb-1" style="font-size: .77rem;">Backend API</p>
                          <div class="progress rounded mb-2" style="height: 5px;">
                            <div class="progress-bar" role="progressbar" style="width: 66%" aria-valuenow="66"
                              aria-valuemin="0" aria-valuemax="100"></div>
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
