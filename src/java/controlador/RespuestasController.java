/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.CertificadoDAO;
import DAO.CiudadanoDAO;
import DAO.RespuestaDAO;
import DAO.UsuarioDAO;
import VO.CertificadoVO;
import VO.CiudadanoVO;
import VO.RespuestaVO;
import VO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TOSHIBA
 */
public class RespuestasController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Respuestas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Respuestas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "registrar":
                System.out.println("controlador.Respuestas.doPost() - Res: "+request.getParameter("idCiudadano"));
                RespuestaVO respuestaVO = new RespuestaVO();
                respuestaVO.setIdCiudadano(request.getParameter("idCiudadano"));
                respuestaVO.setRespuesta(request.getParameter("respuesta"));
                respuestaVO.setIdTema(request.getParameter("idTema"));
                RespuestaDAO respuestaDAO = new RespuestaDAO(respuestaVO);
                if (respuestaDAO.existCommentBefore(request.getParameter("idCiudadano"), request.getParameter("idTema"))) {
                    response.sendRedirect("tema?navegacion=tema&idTema="+request.getParameter("idTema")+"&idCiudadano="+request.getParameter("idCiudadano")+"&mensaje=existe");                    
                } else {
                    if (respuestaDAO.crearRegistro()) {                        
                        String idRespuesta = respuestaDAO.idRespuestaByOthersId(request.getParameter("idCiudadano"), request.getParameter("idTema"));
                        CertificadoVO certificadoVO = new CertificadoVO(null, null, request.getParameter("idTema"), idRespuesta, request.getParameter("idCiudadano"));
                        CertificadoDAO certificadoDAO = new CertificadoDAO(certificadoVO);
                        if (certificadoDAO.crearRegistro()) {
                            
                            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
                            CiudadanoVO ciudadanoVO = ciudadanoDAO.obtenerCiudadanoPorId(request.getParameter("idCiudadano"));
                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            UsuarioVO usuarioVO = usuarioDAO.obtenerUsuarioPorId(ciudadanoVO.getIdUsuario());                            
                            
                            if (enviarCorreo(request, response, ciudadanoVO, usuarioVO)) {
                              response.sendRedirect("tema?navegacion=tema&idTema="+request.getParameter("idTema")+"&idCiudadano="+request.getParameter("idCiudadano")+"&mensaje=exito");
                            } else {
                                response.sendRedirect("tema?navegacion=tema&idTema="+request.getParameter("idTema")+"&idCiudadano="+request.getParameter("idCiudadano")+"&mensaje=error");
                            }                            
                        } else {
                            response.sendRedirect("tema?navegacion=tema&idTema="+request.getParameter("idTema")+"&idCiudadano="+request.getParameter("idCiudadano")+"&mensaje=error");
                        }                        
                    }
                }                
                break;
        }
        
        processRequest(request, response);
    }
    
    public boolean enviarCorreo(HttpServletRequest request, HttpServletResponse response, CiudadanoVO ciudadanoVO, UsuarioVO usuarioVO){
        String host;
        String puerto;
        String usuario;
        String clave;

        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        puerto = context.getInitParameter("puerto");
        usuario = context.getInitParameter("usuario");
        clave = context.getInitParameter("clave");
        
        String receptor = usuarioVO.getUsuCorreo();
        String asunto = "CERTIFICADO, PARTICIPACIÓN CIUDADANA";
        String contenido = "Señor (a) "+ciudadanoVO.getNombres()+", recientemente ha participado en un tema, puede ver su certificado en la web.";

        Boolean operacion = false;        

        try {
            CorreoController.envioCorreo(host, puerto, usuario, clave, receptor, asunto, contenido);            
            operacion = true;
            System.out.println("controlador.RespuestasController.enviarCorreo() - Correo enviado");
        } catch (Exception e) {
            e.printStackTrace();            
            System.out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
