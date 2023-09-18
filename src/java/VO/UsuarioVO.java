package VO;

public class UsuarioVO {
    public String usuId, usuCorreo, usuContrasenna;

    public UsuarioVO() {
    }

    public UsuarioVO(String usuId, String usuCorreo, String usuContrasenna) {
        this.usuId = usuId;
        this.usuCorreo = usuCorreo;
        this.usuContrasenna = usuContrasenna;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuContrasenna() {
        return usuContrasenna;
    }

    public void setUsuContrasenna(String usuContrasenna) {
        this.usuContrasenna = usuContrasenna;
    }

        
}
