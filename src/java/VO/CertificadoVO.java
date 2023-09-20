/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author APRENDIZ
 */
public class CertificadoVO {
    public String identificador, fechaCert, idTema, idRespuesta, idCiudadano;

    public CertificadoVO() {
    }

    public CertificadoVO(String identificador, String fechaCert, String idTema, String idRespuesta, String idCiudadano) {
        this.identificador = identificador;
        this.fechaCert = fechaCert;
        this.idTema = idTema;
        this.idRespuesta = idRespuesta;
        this.idCiudadano = idCiudadano;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getFechaCert() {
        return fechaCert;
    }

    public void setFechaCert(String fechaCert) {
        this.fechaCert = fechaCert;
    }

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(String idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }
    
    
}
