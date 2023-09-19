<%-- 
    Document   : session
    Created on : 18/09/2023, 07:34:02 PM
    Author     : TOSHIBA
--%>

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
             try {
                rol = Integer.parseInt(buscarSesion.getAttribute("rol").toString());

                if (rol == 0) {
                    System.out.print("El rol es igual a 0");
                } else {
                    request.setAttribute("mensaje", "sin-permisos");
                    request.getRequestDispatcher("/index.jsp").forward(request, response); 
                }
            } catch (NumberFormatException e) {
                System.out.println("No se pudo convertir 'rol' a entero: " + e.getMessage());
            }
          } else {
               request.setAttribute("mensaje", "sin-sesion");
               request.getRequestDispatcher("loginUser.jsp").forward(request, response); 
          }
      %>
    <body>        
    </body>
</html>
