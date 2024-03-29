package entidades;
// Generated 14-jul-2019 23:18:37 by Hibernate Tools 4.3.1



/**
 * Usuario generated 
 */
public class Usuario  implements java.io.Serializable {


     private int idusuario;
     private Personal personal;
     private String usuario;
     private String password;
     private String perfil;
     private Character estado;

    public Usuario() {
    }

	
    public Usuario(int idusuario, Personal personal) {
        this.idusuario = idusuario;
        this.personal = personal;
    }
    public Usuario(int idusuario, Personal personal, String usuario, String password, String perfil, Character estado) {
       this.idusuario = idusuario;
       this.personal = personal;
       this.usuario = usuario;
       this.password = password;
       this.perfil = perfil;
       this.estado = estado;
    }
   
    public int getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }




}


