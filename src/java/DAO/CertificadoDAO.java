/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.CertificadoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;
import util.Crud;

/**
 *
 * @author APRENDIZ
 */
public class CertificadoDAO extends Conexion implements Crud{
    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sql = "";
    private boolean operacion = false;
    
    public String identificador = "", fechaCert = "", idTema = "", idRespuesta = "", idCiudadano = "";

    public CertificadoDAO(CertificadoVO certificadoVO) {
        conexion = this.obtenerConexion();
        identificador = certificadoVO.getIdentificador();
        fechaCert = certificadoVO.getFechaCert();
        idTema = certificadoVO.getIdTema();
        idRespuesta = certificadoVO.getIdRespuesta();
        idCiudadano = certificadoVO.getIdCiudadano();
    }

    public CertificadoDAO() {
    }            

    @Override
    public boolean crearRegistro() {
        sql = "insert into certificado (idTema, idRespuesta, idCiudadano) values (?, ?, ?)";
        
        try {
            preparedStatement = conexion.prepareStatement(sql);            
            preparedStatement.setString(1, idTema);
            preparedStatement.setString(2, idRespuesta);
            preparedStatement.setString(3, idCiudadano);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.CertificadoDAO.crearRegistro() - Error: "+e.getMessage());
        }
        
        return operacion;
    } 

    @Override
    public boolean editarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
    
}
