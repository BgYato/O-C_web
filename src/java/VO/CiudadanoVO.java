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
public class CiudadanoVO {
    private String estrato, tipoDoc, doc, nombres, apellidos, sexo, celular, fijo, municipio, direccion, barrio, fechaNac, etnia, condicion, idUsuario, idCiudadano;

    public CiudadanoVO() {
    }

    public CiudadanoVO(String estrato, String tipoDoc, String doc, String nombres, String apellidos, String sexo, String celular, String fijo, String municipio, String direccion, String barrio, String fechaNac, String etnia, String condicion, String idUsuario) {
        this.estrato = estrato;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.celular = celular;
        this.fijo = fijo;
        this.municipio = municipio;
        this.direccion = direccion;
        this.barrio = barrio;
        this.fechaNac = fechaNac;
        this.etnia = etnia;
        this.condicion = condicion;
        this.idUsuario = idUsuario;
    }

    public CiudadanoVO(String estrato, String tipoDoc, String doc, String nombres, String apellidos, String sexo, String celular, String fijo, String municipio, String direccion, String barrio, String fechaNac, String etnia, String condicion, String idUsuario, String idCiudadano) {
        this.estrato = estrato;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.celular = celular;
        this.fijo = fijo;
        this.municipio = municipio;
        this.direccion = direccion;
        this.barrio = barrio;
        this.fechaNac = fechaNac;
        this.etnia = etnia;
        this.condicion = condicion;
        this.idUsuario = idUsuario;
        this.idCiudadano = idCiudadano;
    }        

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrado) {
        this.estrato = estrado;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }
    
    
    
}
