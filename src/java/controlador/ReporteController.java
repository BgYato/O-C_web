/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import VO.CiudadanoVO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import util.Conexion;

/**
 *
 * @author TOSHIBA
 */
public class ReporteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("controlador.ReporteController.processRequest()");
    }    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");        
        
        HttpSession session = request.getSession();
        CiudadanoVO ciudadanoVO = (CiudadanoVO) session.getAttribute("sCiudadano");
        
        String cIdCiudadano = request.getParameter("idCiudadano");
        
        if (ciudadanoVO != null && ciudadanoVO.getIdCiudadano().equals(cIdCiudadano)) {
            switch(tipo){
            case "certificado":
                String accion = request.getParameter("accion");
                if (accion.equals("download")) {
                    try {
                        descargarCertificado(request, response);
                    } catch (JRException ex) {
                        Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (accion.equals("show")) {
                    try {
                        mostrarCertificado(request, response);
                    } catch (JRException ex) {
                        Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        } else {
            request.setAttribute("mensaje", "sin-permisos");
            request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
        }                
    }
    
    
    public void descargarCertificado(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException{
        ServletContext servletContext = getServletContext();
        String jasperFilePath;
        jasperFilePath = servletContext.getRealPath("/views/reports/pdf/miReporte.jasper");
        File reporte = new File(jasperFilePath);
       Map<String,Object> parametros = new HashMap<String, Object>();
             
       String cIdCertificado = request.getParameter("idCertificado");
       String cIdCiudadano = request.getParameter("idCiudadano");
       parametros.put("cIdCertificado", cIdCertificado);
       parametros.put("cIdCiudadano", cIdCiudadano);
               
       String nombreArchivo = "reporte_" + cIdCertificado + ".pdf";
       
       Conexion conexion = new Conexion();
       Connection objetoConexion = conexion.obtenerConexion();
       byte[] bytes= JasperRunManager.runReportToPdf(reporte.getPath(), parametros, objetoConexion);
       response.setContentType("application/pdf");
       response.setContentLength(bytes.length);
       response.setHeader("Content-Disposition", "attachment; filename=\""+nombreArchivo+"\";" );
       ServletOutputStream salida = response.getOutputStream();
       salida.write(bytes,0,bytes.length);
       salida.flush();
       salida.close();
    }
    
    public void mostrarCertificado(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException{
        ServletContext servletContext = getServletContext();
        String jasperFilePath;
        jasperFilePath = servletContext.getRealPath("/views/reports/pdf/miReporte.jasper");
        File reporte = new File(jasperFilePath);
       Map<String,Object> parametros = new HashMap<String, Object>();
             
       String cIdCertificado = request.getParameter("idCertificado");
       String cIdCiudadano = request.getParameter("idCiudadano");
       parametros.put("cIdCertificado", cIdCertificado);
       parametros.put("cIdCiudadano", cIdCiudadano);                      
       
       Conexion conexion = new Conexion();
       Connection objetoConexion = conexion.obtenerConexion();
       
       String nombreArchivo = "certificado_" + cIdCertificado + ".pdf";
       response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
       
       byte[] bytes= JasperRunManager.runReportToPdf(reporte.getPath(), parametros, objetoConexion);
       response.setContentType("application/pdf");
       response.setContentLength(bytes.length);       
       ServletOutputStream salida = response.getOutputStream();
       salida.write(bytes,0,bytes.length);
       salida.flush();
       salida.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("controlador.ReporteController.doPost()");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
