/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.AdministradorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;
import util.Crud;

/**
 *
 * @author TOSHIBA
 */
public class AdministradorDAO extends Conexion implements Crud{
    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sql = "";
    private boolean operacion = false;
    
    public String idAdministrador = "", nombre = "", apellido = "", idUsuario = ""; 

    public AdministradorDAO(AdministradorVO administradorVO) {
        super();
        conexion = this.obtenerConexion();
        idAdministrador = administradorVO.getIdAdministrador();
        nombre = administradorVO.getNombre();
        apellido = administradorVO.getApellido();
        idUsuario = administradorVO.getIdUsuario();
    }

    public AdministradorDAO() {
    }

    @Override
    public boolean crearRegistro() {
        sql = "insert into administrador (nombre, apellido, idUsuario) values (?, ?, ?)";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, idUsuario);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.AdministradorDAO.crearRegistro() - Error al registrar: "+e);
        }
        return operacion;
    }

    @Override
    public boolean editarRegistro() {
        sql = "update administrador set nombre = ?, apellido = ?, idUsuario = ? where idAdministrador = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, idUsuario);
            preparedStatement.setString(4, idAdministrador);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.AdministradorDAO.editarRegistro() - Error al editar: "+e);
        }
        return operacion;
    }
    
    public AdministradorVO obtenerAdministradorPorIdUsuario(String id){
        AdministradorVO administrador = null;
        sql = "select * from administrador where idUsuario = ?";
        try {
            conexion = this.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                administrador = new AdministradorVO(resultSet.getString("idAdministrador"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("idUsuario"));
            }
        } catch (Exception e) {
            System.out.println("DAO.AdministradorDAO.obtenerAdministradorPorIdUsuario() - Error al obtener al administrador: "+ e.getMessage());
        }
        return administrador;
    }    
    
}
