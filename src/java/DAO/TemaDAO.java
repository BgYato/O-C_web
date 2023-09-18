package DAO;

import VO.TemaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;
import util.Crud;

public class TemaDAO extends Conexion implements Crud{
    private Connection conexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sql = "";
    private boolean operacion = false;
    
    public String idTema = "", titulo = "", descripcion = "", fechaInicio = "", fechaFin = "", parametros = "", pregunta = "", idAdministrador = "";

    public TemaDAO(TemaVO temaVO) {
        super();
        conexion = this.obtenerConexion();
        idTema = temaVO.getIdTema();
        titulo = temaVO.getTitulo();
        descripcion = temaVO.getDescripcion();
        fechaInicio = temaVO.getFechaInicio();
        fechaFin = temaVO.getFechaFin();
        parametros = temaVO.getParametros();
        pregunta = temaVO.getPregunta();
        idAdministrador = temaVO.getIdAdministrador();
    }

    public TemaDAO() {        
    }

    @Override
    public boolean crearRegistro() {
        sql = "insert into tema (titulo, descripción, fechaInicio, fechaFin, parametros, pregunta, idAdministrador) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setString(3, fechaInicio);
            preparedStatement.setString(4, fechaFin);
            preparedStatement.setString(5, parametros);
            preparedStatement.setString(6, pregunta);
            preparedStatement.setString(7, idAdministrador);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.TemaDAO.crearRegistro() - Error al crear un tema: " + e.getMessage());
        }
        return operacion;
    }    

    @Override
    public boolean editarRegistro() {
        sql = "update tema set titulo = ?, descripcion = ?, fechaInicio = ?, fechaFin = ?, parametros = ?, pregunta = ?, idAdministrador = ? where idTema = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setString(3, fechaInicio);
            preparedStatement.setString(4, fechaFin);
            preparedStatement.setString(5, parametros);
            preparedStatement.setString(6, pregunta);
            preparedStatement.setString(7, idAdministrador);
            preparedStatement.setString(8, idTema);
            preparedStatement.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("DAO.TemaDAO.editarRegistro() - Error al editar un tema: " + e.getMessage());
        }
        return operacion;
    }

    public List<TemaVO> obtenerTodosLosRegistros() {
        List<TemaVO> listaTemas = new ArrayList<>();
        sql = "SELECT * FROM tema";

        try {
            conexion = obtenerConexion();            

            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TemaVO tema = new TemaVO();
                tema.setIdTema(resultSet.getString("idTema"));
                tema.setTitulo(resultSet.getString("titulo"));
                tema.setDescripcion(resultSet.getString("descripción"));
                tema.setFechaInicio(resultSet.getString("fechaInicio"));
                tema.setFechaFin(resultSet.getString("fechaFin"));
                tema.setParametros(resultSet.getString("parametros"));
                tema.setPregunta(resultSet.getString("pregunta"));
                tema.setIdAdministrador("idAdministrador");

                listaTemas.add(tema);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros: " + e.getMessage());
        }
        
        return listaTemas;
    }

    public TemaVO findTelaById(String id) {
        TemaVO tema = new TemaVO();
        sql = "SELECT * FROM tema where idTema = ?";

        try {
            conexion = obtenerConexion();            

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                tema.setIdTema(resultSet.getString("idTema"));
                tema.setTitulo(resultSet.getString("titulo"));
                tema.setDescripcion(resultSet.getString("descripción"));
                tema.setFechaInicio(resultSet.getString("fechaInicio"));
                tema.setFechaFin(resultSet.getString("fechaFin"));
                tema.setParametros(resultSet.getString("parametros"));
                tema.setPregunta(resultSet.getString("pregunta"));
                tema.setIdAdministrador(resultSet.getString("idAdministrador"));               
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros: " + e.getMessage());
        }
        
        return tema;
    }
    
    
}
