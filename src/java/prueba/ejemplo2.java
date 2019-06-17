/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author Computer
 */
public class ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MascotaDao mascotadao= new MascotaDao();
        ArrayList<Mascota> listamascota =new ArrayList<>();
        listamascota =  mascotadao.listarMascotas();
        for (int i = 0; i <listamascota.size(); i++) {
            System.out.println(listamascota.get(i).getNombreCliente());
        }
        /*for (Mascota mascota : listamascota) {
            JOptionPane.showMessageDialog(null, mascota.getNombreCliente());
        }*/
    }
    
}
