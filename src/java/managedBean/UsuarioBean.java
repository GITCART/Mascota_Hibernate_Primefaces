/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author Computer
 */

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
    private ArrayList listarUsuarios;
    private Usuario usuario;
     private boolean banderaSelect = false;
    
    
    public UsuarioBean(){
        this.usuario= new Usuario();
        listarUsuarios= new ArrayList();
        usuario = new Usuario();
        listarUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void listarUsuarios(){
        PersonalDao personalDao= new PersonalDao();
        listarUsuarios= personalDao.listarPersonal();
    }
    
    public String guardarUsuario() {
        try {

            UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.guardarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RUsuario";
    }

    public String actualizarUsuario() {
        try {
              UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.actualizarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RUsuario";

    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
         UsuarioDao usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuario();
        return lista;
    }

    public String eliminar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        boolean respuesta = usuarioDao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RUsuario";
    }
     public void selectBandera() {
        banderaSelect = true;
    }

    public ArrayList getListarUsuarios() {
        return listarUsuarios;
    }

    public void setListarUsuarios(ArrayList listarUsuarios) {
        this.listarUsuarios = listarUsuarios;
    }
    
      public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
      public String limpiar() {
        return "/RMascota";
    }
    
}
