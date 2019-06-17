/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import dao.MascotaDao;

/**
 *
 * @author Computer
 */
public class ejemplo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MascotaDao mascotadao = new MascotaDao();
        int cantidad = mascotadao.ContadorMascota();
        System.out.println("Cantidad de mascotas:: "+cantidad);
        
    }
    
}
