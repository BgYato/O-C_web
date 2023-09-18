/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author TOSHIBA
 */
public class RespuestaVO {
    String idRespuesta, respuesta, idCiudadano, idTema;

    public RespuestaVO() {
    }

    public RespuestaVO(String idRespuesta, String respuesta, String idCiudadano, String idTema) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.idCiudadano = idCiudadano;
        this.idTema = idTema;
    }

    public String getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(String idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }
    
    
}
