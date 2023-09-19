<%-- 
    Document   : session
    Created on : 18/09/2023, 07:34:02 PM
    Author     : TOSHIBA
--%>

<%@page import="VO.CiudadanoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
    response.setDateHeader("Expires", 0);
    %>
    <%
          int rol = 0;
          HttpSession buscarSesion = (HttpSession) request.getSession();          

          if (buscarSesion.getAttribute("rol") != null) {
              CiudadanoVO sCiudadano = (CiudadanoVO) buscarSesion.getAttribute("sCiudadano");
             System.out.print("Iniciado correctamente");
          } else {
               request.setAttribute("mensaje", "sin-sesion");
               request.getRequestDispatcher("loginUser.jsp").forward(request, response); 
          }
      %>
    <body>
        
    </body>
</html>
