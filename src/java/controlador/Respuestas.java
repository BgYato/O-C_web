/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RespuestaDAO;
import VO.RespuestaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TOSHIBA
 */
public class Respuestas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                        response.sendRedirect("tema?navegacion=tema&idTema="+request.getParameter("idTema")+"&idCiudadano="+request.getParameter("idCiudadano")+"&mensaje=exito");
                    }
                }                
                break;
        }
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
