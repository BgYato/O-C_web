/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.CiudadanoDAO;
import DAO.UsuarioDAO;
import VO.CiudadanoVO;
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
public class CiudadanoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CiudadanoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CiudadanoController at " + request.getContextPath() + "</h1>");
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
                request.getRequestDispatcher("views/registerCiudadano.jsp").forward(request, response);
                break;
            case "edit":
                String id = request.getParameter("id");
                System.out.println("controlador.CiudadanoController.doGet() - ID: "+id);
                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(); 
                CiudadanoVO ciudadanoVO = ciudadanoDAO.obtenerCiudadanoPorIdUsuario(id);
                System.out.println("controlador.CiudadanoController.doGet() - ciudadanoVO: "+ciudadanoVO);
                request.setAttribute("ciudadano", ciudadanoVO);                
                request.getRequestDispatcher("views/editCiudadano.jsp").forward(request, response);
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
                registrarCiudadano(request, response);
                break;
            case "editar":
                actualizarCiudadano(request, response);
                break;
        }
        
        processRequest(request, response);
    }
    
    public void registrarCiudadano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        UsuarioVO usuarioVO = new UsuarioVO(null, correo, pass);
        UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioVO);
        if (usuarioDAO.crearRegistro()) {
            String id = usuarioDAO.findIdByEmail(correo);
            CiudadanoVO ciudadanoVO = new CiudadanoVO(
                    request.getParameter("estrato"), 
                    request.getParameter("tipoDoc"), 
                    request.getParameter("doc"), 
                    request.getParameter("nombre"), 
                    request.getParameter("apellido"), 
                    request.getParameter("sexo"),
                    request.getParameter("celular"),
                    request.getParameter("fijo"),
                    request.getParameter("municipio"),
                    request.getParameter("direccion"),
                    request.getParameter("barrio"),
                    request.getParameter("fechaNac"),
                    request.getParameter("etnia"),
                    request.getParameter("condicion"),
                    id);
            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(ciudadanoVO);
            if(ciudadanoDAO.crearRegistro()){
                request.setAttribute("mensaje", "exito");
                request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "error");
                request.getRequestDispatcher("views/registerUser.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensaje", "error");
            request.getRequestDispatcher("views/registerUser.jsp").forward(request, response);
        }
    }        

    public void actualizarCiudadano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        String id = request.getParameter("id");
        CiudadanoVO ciudadanoVO = new CiudadanoVO(
                request.getParameter("estrato"), 
                request.getParameter("tipoDoc"), 
                request.getParameter("doc"), 
                request.getParameter("nombre"), 
                request.getParameter("apellido"), 
                request.getParameter("sexo"),
                request.getParameter("celular"),
                request.getParameter("fijo"),
                request.getParameter("municipio"),
                request.getParameter("direccion"),
                request.getParameter("barrio"),
                request.getParameter("fechaNac"),
                request.getParameter("etnia"),
                request.getParameter("condicion"),
                null,
                id);       
        CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(ciudadanoVO);
        if(ciudadanoDAO.editarRegistro()){            
            request.getRequestDispatcher("views/loginUser.jsp").forward(request, response);
        } else {            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
