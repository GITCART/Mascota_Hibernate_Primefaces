
package prueba;

import dao.MascotaDao;
import entidades.Mascota;

/**
 *
 * @author Computer
 */
public class ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MascotaDao mascotadao= new MascotaDao();
        Mascota mascota = new Mascota(11,"firulais", "jose", "pitbull");
        mascotadao.guardarMascota(mascota);
    }
    
}
