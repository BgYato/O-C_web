/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.CiudadanoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;
import util.Crud;

/**
 *
 * @author TOSHIBA
 */
public class CiudadanoDAO extends Conexion implements Crud{
    
    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private String sql = "";
    private boolean operacion = false;
    
    private String estrato = "", tipoDoc = "", doc = "", nombres = "", apellidos = "", sexo = "", celular = "", fijo = "", municipio = "", direccion = "", barrio = "", fechaNac = "", etnia = "", condicion = "", idUsuario = "", idCiudadano = "";

    public CiudadanoDAO(CiudadanoVO ciudadanoVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            estrato = ciudadanoVO.getEstrato();
            tipoDoc = ciudadanoVO.getTipoDoc();
            doc = ciudadanoVO.getDoc();
            nombres = ciudadanoVO.getNombres();
            apellidos = ciudadanoVO.getApellidos();
            sexo = ciudadanoVO.getSexo();
            celular = ciudadanoVO.getCelular();
            fijo = ciudadanoVO.getFijo();
            municipio = ciudadanoVO.getMunicipio();
            direccion = ciudadanoVO.getDireccion();
            barrio = ciudadanoVO.getBarrio();
            fechaNac = ciudadanoVO.getFechaNac();
            etnia = ciudadanoVO.getEtnia();
            condicion = ciudadanoVO.getCondicion();
            idUsuario = ciudadanoVO.getIdUsuario();
            idCiudadano = ciudadanoVO.getIdCiudadano();
        } catch (Exception e) {
            System.out.println("Error al inicializar ciudadanoDAO, error: "+e.getMessage());
        }
    }

    public CiudadanoDAO() {        
    }

    @Override
    public boolean crearRegistro() {
        sql = "INSERT INTO ciudadano (estrato, tipoDoc, doc, nombres, apellidos, sexo, celular, fijo, municipio, direccion, barrio, fechaNac, etnia, condicion, idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, estrato);
            preparedStatement.setString(2, tipoDoc);
            preparedStatement.setString(3, doc);
            preparedStatement.setString(4, nombres);
            preparedStatement.setString(5, apellidos);
            preparedStatement.setString(6, sexo);
            preparedStatement.setString(7, celular);
            preparedStatement.setString(8, fijo);
            preparedStatement.setString(9, municipio);
            preparedStatement.setString(10, direccion);
            preparedStatement.setString(11, barrio);
            preparedStatement.setString(12, fechaNac);
            preparedStatement.setString(13, etnia);
            preparedStatement.setString(14, condicion);
            preparedStatement.setString(15, idUsuario);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error al registrar ciudadano en CiudadanoDAO, error: "+e.getMessage());
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión en ciudadanoDAO, error: "+e.getMessage());
            }
        }
        return operacion;
    }
    
    public CiudadanoVO obtenerCiudadanoPorIdUsuario(String id) {
        CiudadanoVO ciudadano = null;
        sql = "SELECT * FROM ciudadano WHERE idUsuario = ?";
        
        try {
            conexion = obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // Encontramos un usuario, creamos un objeto Usuario
                ciudadano = new CiudadanoVO();
                ciudadano.setIdCiudadano(resultSet.getString("idCiudadano"));
                ciudadano.setEstrato(resultSet.getString("estrato"));
                ciudadano.setTipoDoc(resultSet.getString("tipoDoc"));
                ciudadano.setDoc(resultSet.getString("doc"));
                ciudadano.setNombres(resultSet.getString("nombres"));
                ciudadano.setApellidos(resultSet.getString("apellidos"));
                ciudadano.setSexo(resultSet.getString("sexo"));
                ciudadano.setCelular(resultSet.getString("celular"));
                ciudadano.setFijo(resultSet.getString("fijo"));
                ciudadano.setMunicipio(resultSet.getString("municipio"));
                ciudadano.setDireccion(resultSet.getString("direccion"));
                ciudadano.setBarrio(resultSet.getString("barrio"));
                ciudadano.setFechaNac(resultSet.getString("fechaNac"));
                ciudadano.setEtnia(resultSet.getString("etnia"));
                ciudadano.setCondicion(resultSet.getString("condicion"));
                ciudadano.setIdUsuario(resultSet.getString("idUsuario"));
            }                        
            
        } catch (Exception e) {
            System.out.println("Error al obtener ciudadano por ID en CiudadanoDAO, error: " + e.getMessage());
        }
        
        return ciudadano;
    }
    
    public CiudadanoVO obtenerCiudadanoPorId(String id) {
        CiudadanoVO ciudadano = null;
        sql = "SELECT * FROM ciudadano WHERE idCiudadano = ?";
        
        try {
            conexion = obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // Encontramos un usuario, creamos un objeto Usuario
                ciudadano = new CiudadanoVO();
                ciudadano.setIdCiudadano(resultSet.getString("idCiudadano"));
                ciudadano.setEstrato(resultSet.getString("estrato"));
                ciudadano.setTipoDoc(resultSet.getString("tipoDoc"));
                ciudadano.setDoc(resultSet.getString("doc"));
                ciudadano.setNombres(resultSet.getString("nombres"));
                ciudadano.setApellidos(resultSet.getString("apellidos"));
                ciudadano.setSexo(resultSet.getString("sexo"));
                ciudadano.setCelular(resultSet.getString("celular"));
                ciudadano.setFijo(resultSet.getString("fijo"));
                ciudadano.setMunicipio(resultSet.getString("municipio"));
                ciudadano.setDireccion(resultSet.getString("direccion"));
                ciudadano.setBarrio(resultSet.getString("barrio"));
                ciudadano.setFechaNac(resultSet.getString("fechaNac"));
                ciudadano.setEtnia(resultSet.getString("etnia"));
                ciudadano.setCondicion(resultSet.getString("condicion"));
                ciudadano.setIdUsuario(resultSet.getString("idUsuario"));
            }                        
            
        } catch (Exception e) {
            System.out.println("Error al obtener ciudadano por ID en CiudadanoDAO, error: " + e.getMessage());
        }
        
        return ciudadano;
    }

    @Override
    public boolean editarRegistro() {
        sql = "UPDATE ciudadano SET estrato = ?, tipoDoc = ?, doc = ?, nombres = ?, apellidos = ?, sexo = ?, celular = ?, fijo = ?, municipio = ?, direccion = ?, barrio = ?, fechaNac = ?, etnia = ?, condicion = ? where idCiudadano = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, estrato);
            preparedStatement.setString(2, tipoDoc);
            preparedStatement.setString(3, doc);
            preparedStatement.setString(4, nombres);
            preparedStatement.setString(5, apellidos);
            preparedStatement.setString(6, sexo);
            preparedStatement.setString(7, celular);
            preparedStatement.setString(8, fijo);
            preparedStatement.setString(9, municipio);
            preparedStatement.setString(10, direccion);
            preparedStatement.setString(11, barrio);
            preparedStatement.setString(12, fechaNac);
            preparedStatement.setString(13, etnia);
            preparedStatement.setString(14, condicion);
            preparedStatement.setString(15, idCiudadano);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error al editar ciudadano en CiudadanoDAO, error: "+e.getMessage());
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión en ciudadanoDAO, error: "+e.getMessage());
            }
        }
        return operacion;
    }
    
    
}
