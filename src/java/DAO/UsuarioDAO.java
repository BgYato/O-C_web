package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.UsuarioVO;
import util.Conexion;
import util.Crud;

public class UsuarioDAO extends Conexion implements Crud{

    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sql = "";
    private boolean operacion = false;

    public String usuId = "", usuCorreo = "", usuContrasenna = "";

    public UsuarioDAO(UsuarioVO usuVo){
        super();
        try {
            conexion = this.obtenerConexion();
            usuId = usuVo.getUsuId();
            usuCorreo = usuVo.getUsuCorreo();
            usuContrasenna = usuVo.getUsuContrasenna();
        } catch (Exception e) {
            System.out.println("Error al inicializar UsuarioDAO, error: "+e.getMessage());
        }        
    }

    public UsuarioDAO() {        
    }

    public String findIdByEmail(String email){
        sql = "select idUsuario from usuarios where correo = ?";
        String id = "";
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, email);            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getString(1);
                System.out.println("DAO.UsuarioDAO.findIdByEmail() - ID: "+id);
            }            
        } catch (Exception e) {
            System.out.println("Error al buscar por email en UsuarioDAO, error: "+e.getMessage());
        }
        return id;
    }
    
    public Boolean isAdmin(String id){
        sql = "select idUsuario from administrador where idUsuario = ?";
        operacion = false;
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                operacion = true;
            }            
        } catch (Exception e) {
            System.out.println("Error al comprobar si es admin en UsuarioDAO, error: "+e.getMessage());
        }        
        return operacion;
    }
    
    public Boolean isCiudadano(String id){
        sql = "select idUsuario from ciudadano where idUsuario = ?";
        operacion = false;
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                operacion = true;
            }            
        } catch (Exception e) {
            System.out.println("Error al comprobar si es ciudadano en UsuarioDAO, error: "+e.getMessage());
        }        
        return operacion;
    }
    
    public boolean existUserEmail(String email){
        sql = "select * from usuarios where correo = ?";        
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, email);            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                operacion = true;
            }            
        } catch (Exception e) {
            System.out.println("Error al encontrar un usuario en UsuarioDAO, error: "+e.getMessage());
        }
        return operacion;
    }
    
    public UsuarioVO obtenerUsuarioPorId(String id) {
        UsuarioVO usuario = null;
        sql = "SELECT * FROM usuarios WHERE idUsuario = ?";
        
        try {
            conexion = obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // Encontramos un usuario, creamos un objeto Usuario
                usuario = new UsuarioVO();
                usuario.setUsuId(resultSet.getString("idUsuario"));
                usuario.setUsuCorreo(resultSet.getString("correo"));
                usuario.setUsuContrasenna(resultSet.getString("contrasenna"));
            }                        
            
        } catch (Exception e) {
            System.out.println("Error al obtener usuario por ID: " + e.getMessage());
        }
        
        return usuario;
    }
    
    @Override
    public boolean crearRegistro() {
        sql = "insert into usuarios(correo, contrasenna) values(?, ?)";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuCorreo);
            preparedStatement.setString(2, usuContrasenna);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error al registrar usuario en UsuarioDAO, error: "+e.getMessage());
        }
        return operacion;
    }

    @Override
    public boolean editarRegistro() {
        sql = "update usuarios set correo=?, contrasenna=? where idUsuario=?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuCorreo);
            preparedStatement.setString(2, usuContrasenna);
            preparedStatement.setString(3, usuId);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error al editar usuario en UsuarioDAO, error: "+e.getMessage());
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión en UsuarioDAO, error: "+e.getMessage());
            }
        }
        return operacion;
    }
    
    public boolean iniciarSesion(String usuario, String pass){
        sql = "select * from usuarios where correo = ? and contrasenna = ?";
        operacion = false;
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                operacion = true;   
            }            
        } catch (Exception e) {
            System.out.println("Error al iniciar Sesión en UsuarioDAO, error: "+e.getMessage());
        }
        return operacion;
    }
}