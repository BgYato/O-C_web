<%-- 
    Document   : rParticipacion
    Created on : 20/09/2023, 04:53:37 PM
    Author     : APRENDIZ
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.Conexion"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
       File reporte = new File(application.getRealPath("views/reports/pdf/miReporte.jasper"));
       Map<String,Object> parametros = new HashMap<String, Object>();
       
       String cIdCertificado = request.getParameter("idCertificado");
       String cIdCiudadano = request.getParameter("idCiudadano");
       parametros.put("cIdCertificado", cIdCertificado);
       parametros.put("cIdCiudadano", cIdCiudadano);
       
       Conexion conexion = new Conexion();
       Connection objetoConexion = conexion.obtenerConexion();
       byte[] bytes= JasperRunManager.runReportToPdf(reporte.getPath(), parametros, objetoConexion);
       response.setContentType("application/pdf");
       response.setContentLength(bytes.length);
       response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";" );
       ServletOutputStream salida = response.getOutputStream();
       salida.write(bytes,0,bytes.length);
       salida.flush();
       salida.close();
 
       %>
    </body>
</html>
