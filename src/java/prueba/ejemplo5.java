/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.List;

/**
 *
 * @author Computer
 */
public class ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MascotaDao mascotadao = new MascotaDao();
        List<Mascota> lista = mascotadao.listarNombreMascota("firulais");
        for (Mascota mascota : lista) {
            System.out.println(mascota.getRaza() + "+++"
                    + mascota.getNombreCliente());
        }
    }
    
}
