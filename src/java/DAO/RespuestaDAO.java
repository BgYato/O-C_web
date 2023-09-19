/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.RespuestaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;
import util.Crud;

/**
 *
 * @author TOSHIBA
 */
public class RespuestaDAO extends Conexion implements Crud{
    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sql = "";
    private boolean operacion = false;
    
    String idRespuesta = "", respuesta = "", idCiudadano = "", idTema = "";

    public RespuestaDAO(RespuestaVO respuestaVO) {
        super();
        conexion = this.obtenerConexion();
        idRespuesta = respuestaVO.getIdRespuesta();
        respuesta = respuestaVO.getRespuesta();
        idCiudadano = respuestaVO.getIdCiudadano();
        idTema = respuestaVO.getIdTema();
    }

    public RespuestaDAO() {
    }
    
    public boolean existCommentBefore(String idCiudadano, String idTema){
        operacion = false;
     sql = "select * from respuestas where idCiudadano = ? and idTema = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, idCiudadano);
            preparedStatement.setString(2, idTema);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                operacion = true;
            }
        } catch (Exception e) {
            System.out.println("DAO.RespuestaDAO.existCommentBefore() - Error: "+e.getMessage());
        }
        return operacion;
    }

    @Override
    public boolean crearRegistro() {
        sql = "insert into respuestas (respuesta, idCiudadano, idTema) values (?, ?, ?)";
        try {
            System.out.println("DAO.RespuestaDAO.crearRegistro() - ID recibido "+idCiudadano);
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, respuesta);
            preparedStatement.setString(2, idCiudadano);
            preparedStatement.setString(3, idTema);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.RespuestaDAO.crearRegistro() - Error al registrar: " + e.getMessage());
        }
        return operacion;
    }

    @Override
    public boolean editarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<RespuestaVO> obtenerRespuestasPorTema(String idTema) {
        List<RespuestaVO> listaRespuesta = new ArrayList<>();
        sql = "SELECT * FROM respuestas WHERE idTema = ?";

        try {
            conexion = obtenerConexion();            

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, idTema);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RespuestaVO respuesta = new RespuestaVO();
                respuesta.setIdRespuesta(resultSet.getString("idRespuesta"));
                respuesta.setIdCiudadano(resultSet.getString("idCiudadano"));
                respuesta.setRespuesta(resultSet.getString("respuesta"));
                respuesta.setIdTema(resultSet.getString("idTema"));

                listaRespuesta.add(respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros: " + e.getMessage());
        }
        
        return listaRespuesta;
    }
        
}
