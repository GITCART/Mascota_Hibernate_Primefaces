/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Computer
 */
public interface IMascota {

    public abstract boolean guardarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarMascotas();

    public abstract boolean actualizarMascota(Mascota mascota);

    public abstract List<Mascota> listarMascotaRaza(String raza);

    public abstract List<Mascota> listarNombreMascota(String nombreMascota);

    public abstract Integer ContadorMascota();

    public abstract boolean eliminarMascota(Mascota mascota);

}
