/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author Computer
 */
public class MascotaDao implements IMascota {

    //funcion para guardar
    @Override
    public boolean guardarMascota(Mascota mascota) {
        Session session = null;
        boolean respuesta = true;
        try {
            //construir una nueva session y transaccion
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction(); //inicia
            //registra en la base de datos
            session.save(mascota);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("Error al guardar. " + e);
            respuesta = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return respuesta;
    }

    //funcion para listar
    @Override
    public ArrayList<Mascota> listarMascotas() {
        Session session = null;
        ArrayList<Mascota> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //consulta hacia la base de datos
            String hql = "FROM Mascota";
            Query query = session.createQuery(hql);
            //ejecuta la consulta y obtener la lista. array: castea
            lista = (ArrayList<Mascota>) query.list();
        } catch (Exception e) {
            System.out.println("ERROR EN LISTAR::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return lista;
    }

    @Override
    public boolean actualizarMascota(Mascota mascota) {
        System.out.println("erer" + mascota.getNombreCliente());
        boolean resp = true;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction();
            session.update(mascota);
            transaccion.commit();
        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ACTU::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resp;
    }

    @Override
    public List<Mascota> listarMascotaRaza(String raza) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = " from Mascota where raza='" + raza + "'";
        Query query = session.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return lista;
    }

    @Override
    public List<Mascota> listarNombreMascota(String nombreMascota) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = " from Mascota where nombreMascota='" + nombreMascota + "'";
        Query query = session.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return lista;
    }

    @Override
    public Integer ContadorMascota() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select count(*) from Mascota";
        Query query = session.createQuery(hql);
        Long FilasTab = (Long) query.uniqueResult();
        Integer cont = FilasTab.intValue();
        return cont;
    }

    @Override
    public boolean eliminarMascota(Mascota mascota) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascota);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DAO::" + e);
            resp = false;
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return resp;
    }

}
