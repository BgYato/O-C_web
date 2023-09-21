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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<CertificadoVO> obtenerTodosLosRegistros() {
        List<CertificadoVO> listaCertificados = new ArrayList<>();
        sql = "SELECT * FROM certificado";

        try {
            conexion = obtenerConexion();            

            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CertificadoVO certificado = new CertificadoVO();
                certificado.setFechaCert(resultSet.getString("fechaCert"));
                certificado.setIdentificador(resultSet.getString("identificador"));
                certificado.setIdTema(resultSet.getString("idTema"));      
                certificado.setIdRespuesta(resultSet.getString("idRespuesta"));
                certificado.setIdCiudadano(resultSet.getString("idCiudadano"));

                listaCertificados.add(certificado);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros: " + e.getMessage());
        }
        
        return listaCertificados;
    }
    
    public List<CertificadoVO> obtenerCertificadosPorIdCiudadano(String cIdCiudadano) {
        List<CertificadoVO> listaCertificados = new ArrayList<>();
        sql = "SELECT * FROM certificado where idCiudadano = ?";

        try {
            conexion = obtenerConexion();            

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cIdCiudadano);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CertificadoVO certificado = new CertificadoVO();
                certificado.setFechaCert(resultSet.getString("fechaCert"));
                certificado.setIdentificador(resultSet.getString("identificador"));
                certificado.setIdTema(resultSet.getString("idTema"));      
                certificado.setIdRespuesta(resultSet.getString("idRespuesta"));
                certificado.setIdCiudadano(resultSet.getString("idCiudadano"));

                listaCertificados.add(certificado);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros: " + e.getMessage());
        }
        
        return listaCertificados;
    }

    @Override
    public boolean editarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
    
}
