
package VO;

/**
 *
 * @author TOSHIBA
 */
public class AdministradorVO {
    public String idAdministrador, nombre, apellido, idUsuario;

    public AdministradorVO() {
    }

    public AdministradorVO(String idAdministrador, String nombre, String apellido, String idUsuario) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
