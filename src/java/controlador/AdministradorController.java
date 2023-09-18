/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.AdministradorDAO;
import DAO.UsuarioDAO;
import VO.AdministradorVO;
import VO.UsuarioVO;
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
public class AdministradorController extends HttpServlet {

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
            out.println("<title>Servlet AdministradorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministradorController at " + request.getContextPath() + "</h1>");
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
                UsuarioVO usuarioVO = new UsuarioVO(null, request.getParameter("usuCorreo"), request.getParameter("usuContrasenna"));
                UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioVO);
                if (usuarioDAO.crearRegistro()) {
                    String id = usuarioDAO.findIdByEmail(request.getParameter("usuCorreo"));
                    AdministradorVO administradorVO = new AdministradorVO(null, request.getParameter("nombre"), request.getParameter("apellido"), id);
                    AdministradorDAO administradorDAO = new AdministradorDAO(administradorVO);
                    if (administradorDAO.crearRegistro()) {
                        request.setAttribute("mensaje", "exito");
                        request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "error");
                        request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                    }
                }                
                break;
                
            case "actualizar":                                                
                AdministradorVO administradorVO = new AdministradorVO(request.getParameter("idAdministrador"), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("idUsuario"));
                AdministradorDAO administradorDAO = new AdministradorDAO(administradorVO);
                if (administradorDAO.editarRegistro()) {
                    request.setAttribute("mensaje", "exito-actualizar");
                    request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "error-actualizar");
                    request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
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

