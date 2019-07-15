/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Computer
 */
public interface IUsuario {

    public abstract boolean guardarUsuario(Usuario usuario);

    public abstract ArrayList<Usuario> listarUsuario();

    public abstract boolean actualizarUsuario(Usuario usuario);

    public abstract boolean eliminarUsuario(Usuario usuario);

}





