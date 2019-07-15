/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaporClienteDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
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
//@RequestScoped
@ViewScoped
public class MascotaporClienteBean implements Serializable {

    private ArrayList listaClientes;
    private ArrayList listaMascotas;
    private int idCliente;
    private int idMacota;

    private MascotaporClienteDao mascotaporCienteDao;
    private Mascotaporcliente mascotaporcliente;
    private MascotaporclienteId mascotaporclienteId;

    public MascotaporClienteBean() {
        listaClientes = new ArrayList();
        mascotaporclienteId= new MascotaporclienteId();
        mascotaporcliente= new Mascotaporcliente();
        combos();
    }
   
    public void combos() {
        ClienteDao clienteDao = new ClienteDao();
        listaClientes = clienteDao.listarCliente();
        MascotaDao mascotaDao = new MascotaDao();
        listaMascotas = mascotaDao.listarMascotas();
    }
    
    public String guardarMascotaCliente(){
         try {

            MascotaporClienteDao mascotaporClienteDao = new MascotaporClienteDao();
            mascotaporclienteId.setCodigoCliente(idCliente);
            mascotaporclienteId.setIdMascota(idMacota);
            mascotaporcliente.setId(mascotaporclienteId);
            boolean respuesta = mascotaporClienteDao.guardarMascotaporcliente(mascotaporcliente);
             System.out.println("ERRRO BOL::"+respuesta);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RClienteMascota";
    }
    public ArrayList<Mascotaporcliente> listarMascotaCliente() {
        ArrayList<Mascotaporcliente> lista = new ArrayList<>();
        MascotaporClienteDao mascotaporClienteDao = new MascotaporClienteDao();
        lista = mascotaporClienteDao.listarMascotaporcliente();
        return lista;
    }

    public MascotaporClienteDao getMascotaporCienteDao() {
        return mascotaporCienteDao;
    }

    public void setMascotaporCienteDao(MascotaporClienteDao mascotaporCienteDao) {
        this.mascotaporCienteDao = mascotaporCienteDao;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMacota() {
        return idMacota;
    }

    public void setIdMacota(int idMacota) {
        this.idMacota = idMacota;
    }

    public ArrayList getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }
    
}
