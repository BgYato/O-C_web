<%-- 
    Document   : index
    Created on : 14/09/2023, 11:17:21 PM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- basic -->
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- mobile metas -->
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="viewport" content="initial-scale=1, maximum-scale=1">
   <!-- site metas -->
   <title>Opinión ciudadana</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <style>
    body {
      background-image: url('https://i.pinimg.com/originals/9c/99/f4/9c99f41d6a1fe15634c50f177a4548a6.png'); /* URL de tu imagen de fondo */
      background-size: cover;
      background-position-y: -100px;
      background-repeat: no-repeat;
      background-attachment: fixed;
      padding: 50px; /* Ajusta según sea necesario para el espacio en los lados */
    }
    .content {
      background-color: rgba(255, 255, 255, 0.8); /* Fondo semi-transparente para el contenido */
      padding: 20px;
      border-radius: 10px;
    }
  </style>
    </head>
    <%
        String mensaje = (String) request.getAttribute("mensaje");            
    %> 
    <body>
     <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="content">
          <h1 class="text-center">Bienvenido a nuestro sitio</h1>
          <p class="text-center">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in nisi eu ligula tincidunt blandit.</p>
          <div class="row">
              <div class="col-lg-6">
                <a href="usuario?navegacion=login" class="btn btn-primary d-block mx-auto">Iniciar sesión</a>
              </div>
              <div class="col-lg-6">
                <a href="usuario?navegacion=register" class="btn btn-primary d-block mx-auto">Registrarme</a>
              </div>
          </div
          <c:if test="${mensaje eq 'sin-permisos'}">
            <div class="m-4 alert alert-danger">
                <p>No tienes los suficientes permisos.</p>
            </div>
          </c:if>          
        </div>
      </div>
    </div>
    </div>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
