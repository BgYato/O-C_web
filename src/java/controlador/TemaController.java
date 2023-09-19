/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RespuestaDAO;
import DAO.TemaDAO;
import VO.RespuestaVO;
import VO.TemaVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TOSHIBA
 */
public class TemaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TemaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TemaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String navegacion = request.getParameter("navegacion");
        
        switch(navegacion){
            case "register":
                request.setAttribute("id", request.getParameter("idAdministrador"));
                request.getRequestDispatcher("views/registerTema.jsp").forward(request, response);
                break;
            case "readAll":                               
                TemaDAO temaDAO = new TemaDAO();
                List<TemaVO> listaTemas = temaDAO.obtenerTodosLosRegistros();    
                request.setAttribute("listaTemas", listaTemas);
                request.getRequestDispatcher("views/listarTemas.jsp").forward(request, response);
                break;
            case "tema":                
                temaDAO = new TemaDAO();
                RespuestaDAO respuestasDAO = new RespuestaDAO();
                TemaVO detalleTema = temaDAO.findTelaById(request.getParameter("idTema"));
                List<RespuestaVO> respuestas = respuestasDAO.obtenerRespuestasPorTema(request.getParameter("idTema"));
                request.setAttribute("tema", detalleTema);
                request.setAttribute("respuestas", respuestas);
                request.setAttribute("idCiudadano", request.getParameter("idCiudadano"));
                request.getRequestDispatcher("views/detailsTema.jsp").forward(request, response);
                break;
        }
        
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "registrar":
                TemaVO temaVO = new TemaVO(
                        null, 
                        request.getParameter("titulo"), 
                        request.getParameter("descripcion"), 
                        request.getParameter("fechaIni"), 
                        request.getParameter("fechaFin"), 
                        request.getParameter("parametros"), 
                        request.getParameter("pregunta"), 
                        request.getParameter("id"));
                TemaDAO temaDAO = new TemaDAO(temaVO);
                if (temaDAO.crearRegistro()) {
                    request.setAttribute("mensaje", "exito-tema");
                    request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "error-tema");
                    request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                }
                break;
        }                
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
