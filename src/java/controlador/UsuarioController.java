/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.AdministradorDAO;
import DAO.CertificadoDAO;
import DAO.CiudadanoDAO;
import DAO.TemaDAO;
import DAO.UsuarioDAO;
import VO.AdministradorVO;
import VO.CertificadoVO;
import VO.CiudadanoVO;
import VO.TemaVO;
import VO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TOSHIBA
 */
public class UsuarioController extends HttpServlet {

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
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String navegacion = request.getParameter("navegacion");
        if (navegacion!=null) {
            switch(navegacion){
            case "register":
                request.getRequestDispatcher("views/registerUser.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
                break;
            case "edit":              
                String id = request.getParameter("id");
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                UsuarioVO usuarioVO = usuarioDAO.obtenerUsuarioPorId(id);
                request.setAttribute("usuario", usuarioVO);
                request.getRequestDispatcher("views/editUser.jsp").forward(request, response);
                break;
            }
        } else {
            HttpSession sessionActiva = (HttpSession) request.getSession(false);
            if (sessionActiva != null) {
                sessionActiva.invalidate();
                response.sendRedirect("usuario?navegacion=login");
            } else {
                response.sendRedirect("usuario?navegacion=login");
            }
        }             
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("controlador.UsuarioController.doPost() - Se accedio al DoPost con valor: "+accion);
        
        switch(accion){
            case "registrar":                
                String correo = request.getParameter("usuCorreo");
                String pass = request.getParameter("usuContrasenna");
                
                request.setAttribute("correo", correo);
                request.setAttribute("pass", pass);
                request.getRequestDispatcher("views/registerCiudadano.jsp").forward(request, response);
                break;
                
            case "ingreso":                
                String correo_i = request.getParameter("correo");
                String pass_i = request.getParameter("pass");
                
                UsuarioVO usuarioVO = new UsuarioVO(null, correo_i, pass_i);
                UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioVO);
                System.out.println("controlador.UsuarioController.doPost() - Correo: "+correo_i);
                if (usuarioDAO.existUserEmail(correo_i)) {
                    if (usuarioDAO.iniciarSesion(correo_i, pass_i)) {
                        String id = usuarioDAO.findIdByEmail(correo_i); 
                        HttpSession sesion = request.getSession(true);
                        if (usuarioDAO.isAdmin(id)) {
                            sesion.setAttribute("rol", 0);
                            usuarioVO = usuarioDAO.obtenerUsuarioPorId(id);
                            AdministradorDAO administradorDAO = new AdministradorDAO();
                            AdministradorVO administradorVO = administradorDAO.obtenerAdministradorPorIdUsuario(id);
                            request.setAttribute("usuario", usuarioVO);
                            request.setAttribute("administrador", administradorVO);
                            request.getRequestDispatcher("views/accountAdmin.jsp").forward(request, response);
                        } else if (usuarioDAO.isCiudadano(id)) {                               
                            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();                            
                            CiudadanoVO ciudadanoVO = ciudadanoDAO.obtenerCiudadanoPorIdUsuario(id);
                            
                            sesion.setAttribute("rol", 1);
                            sesion.setAttribute("sCiudadano", ciudadanoVO);
                            inicioExistoso(request, response, id);
                        }
                    } else {
                        request.setAttribute("mensaje", "incorrecto");
                        request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "no-existe");
                    request.setAttribute("correo", correo_i);
                    request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
                }                                
                break;   
            case "actualizar":                                
                
                usuarioVO = new UsuarioVO(request.getParameter("id"), request.getParameter("usuCorreo"), request.getParameter("usuContrasenna"));
                usuarioDAO = new UsuarioDAO(usuarioVO);                
                if (usuarioDAO.editarRegistro()) {                                        
                    request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);                    
                } else {                    
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }                                
                break;  
        }
    }
    
    public void inicioExistoso(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioVO usuarioVO = usuarioDAO.obtenerUsuarioPorId(id);
        CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
        CiudadanoVO ciudadanoVO = ciudadanoDAO.obtenerCiudadanoPorIdUsuario(id);
        TemaDAO temaDAO = new TemaDAO();
        List<TemaVO> listaTemas = temaDAO.obtenerTodosLosRegistros();
        CertificadoDAO certificadoDAO = new CertificadoDAO();
        List<CertificadoVO> listaCertificados = certificadoDAO.obtenerCertificadosPorIdCiudadano(ciudadanoVO.getIdCiudadano());
                
        request.setAttribute("listaTemas", listaTemas);
        request.setAttribute("listaCertificados", listaCertificados);
        request.setAttribute("usuario", usuarioVO);
        request.setAttribute("ciudadano", ciudadanoVO);
        request.getRequestDispatcher("views/accountUser.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
