<%-- 
    Document   : registerCiudadano
    Created on : 15/09/2023, 10:51:35 AM
    Author     : TOSHIBA
--%>

<%@include  file="sessions/session.jsp" %>
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
        <section class="bg-dark" style="height: 200vh;">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col">
                  <div class="card card-registration my-4">
                    <div class="row g-0">
                      <div class="col-xl-6 d-none d-xl-block">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                          alt="Sample photo" class="img-fluid"
                          style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                      </div>
                      <div class="col-xl-6">
                        <div class="card-body p-md-5 text-black">
                          <h3 class="mb-5 text-uppercase">Datos personales de ${ciudadano.nombres}</h3>
                          <form action="ciudadano" method="POST">                          
                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="text" id="nombre" class="form-control form-control-lg" name="nombre" value="${ciudadano.nombres}" required/>
                                <label class="form-label" for="nombre">Nombres</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="text" id="apellido" class="form-control form-control-lg" name="apellido" value="${ciudadano.apellidos}" required/>
                                <label class="form-label" for="apellido">Apellidos</label>
                              </div>
                            </div>
                          </div>

                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">                                
                                <select id="tipoDoc" name="tipoDoc" required>           
                                      <option value="null">-- Sel --</option>
                                      <option value="TI">Tarjeta de identidad</option>
                                      <option value="CC">Cedula de ciudadania</option>                                      
                                      <option value="CE">Cédula de extranjería </option>   
                                </select>
                                <label class="form-label" for="tipoDoc" required>Tipo documento</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="number" id="doc" class="form-control form-control-lg" name="doc" value="${ciudadano.doc}" required/>
                                <label class="form-label" for="doc">Número documento</label>
                              </div>
                            </div>
                          </div>
                              
                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">                                
                                <input type="number" id="celular" class="form-control form-control-lg" name="celular" value="${ciudadano.celular}" required/>
                                <label class="form-label" for="celular">Número de celular</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="number" id="fijo" class="form-control form-control-lg" name="fijo" value="${ciudadano.fijo}" required/>
                                <label class="form-label" for="fijo">Telefono fijo</label>
                              </div>
                            </div>
                          </div>                         

                          <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                            <h6 class="mb-0 me-4">Sexo: </h6>

                            <div class="form-check form-check-inline mb-0 me-4">
                              <input class="form-check-input" type="radio" name="sexo" id="hombre"
                                value="Hombre" selected/>
                              <label class="form-check-label" for="hombre">Hombre</label>
                            </div>

                            <div class="form-check form-check-inline mb-0 me-4">
                              <input class="form-check-input" type="radio" name="sexo" id="mujer"
                                value="Mujer" />
                              <label class="form-check-label" for="mujer">Mujer</label>
                            </div>

                            <div class="form-check form-check-inline mb-0">
                              <input class="form-check-input" type="radio" name="sexo" id="intersexual"
                                value="Intersexual" />
                              <label class="form-check-label" for="intersexual">Intersexual</label>
                            </div>

                          </div>
                              
                          <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">
                                                        
                            <div class="form-check form-check-inline mb-0">
                              <input class="form-check-input" type="radio" name="sexo" id="indefinido"
                                value="indefinido" />
                              <label class="form-check-label" for="indefinido">Indefinido</label>
                            </div>
                            
                            <div class="form-check form-check-inline mb-0">
                              <input class="form-check-input" type="radio" name="sexo" id="na"
                                value="N/A" />
                              <label class="form-check-label" for="na">Prefiero no decir</label>
                            </div>

                          </div>
                              
                          <div class="form-outline mb-4">
                            <input type="text" id="fechaNac" class="form-control form-control-lg" name="fechaNac" required value="${ciudadano.fechaNac}"/>
                            <label class="form-label" for="fechaNac">Fecha de nacimiento</label>
                          </div>     
                           
                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">                                
                                <input type="text" id="municipio" class="form-control form-control-lg" name="municipio" value="${ciudadano.municipio}" required/>
                                <label class="form-label" for="municipio">Municipio</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="text" id="barrio" class="form-control form-control-lg" name="barrio" value="${ciudadano.barrio}" required/>
                                <label class="form-label" for="barrio">Barrio</label>
                              </div>
                            </div>
                          </div>                                                        
                              
                          <div class="form-outline mb-4">
                            <input type="text" id="direccion" class="form-control form-control-lg" name="direccion" value="${ciudadano.direccion}" required/>
                            <label class="form-label" for="direccion">Dirección</label>
                          </div>     
                              
                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">                                
                                <input type="text" id="etnia" class="form-control form-control-lg" name="etnia" value="${ciudadano.etnia}" required/>
                                <label class="form-label" for="etnia">Etnia</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                  <input type="text" id="etnia" class="form-control form-control-lg" name="condicion" value="${ciudadano.condicion}" required/>
                                <label class="form-label" for="barrio">Condicion</label>
                              </div>
                            </div>
                          </div>       
                          
                          <div class="form-outline mb-4">
                              <input type="number" id="estrato" class="form-control form-control-lg" name="estrato" value="${ciudadano.estrato}" required/>
                            <label class="form-label" for="estrato">Estrato </label>
                          </div>  

                          <div class="d-flex justify-content-end pt-3">                            
                            <input type="submit" class="btn btn-warning btn-lg ms-2" value="Actualizar"/>
                          </div>
                          <input type="hidden" name="id" value="${ciudadano.idCiudadano}">
                          <input type="hidden" name="accion" value="editar">
                          </form>
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
