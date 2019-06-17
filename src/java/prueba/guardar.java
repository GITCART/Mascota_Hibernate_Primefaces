/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import dao.MascotaDao;
import entidades.Mascota;
import managedBean.MascotaBean;

/**
 *
 * @author Computer
 */
public class guardar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MascotaDao bean = new MascotaDao();
        Mascota mascota= new Mascota();
        //mascota.getIdMascota();
        //Mascota mascota = new Mascota(2, "masito", "Juan", "perro peruano");
       // bean.getMascota(mascota.getIdMascota());
       /* boolean res= bean.eliminarM(mascota);
        System.out.println(res);*/
    }
    
}
