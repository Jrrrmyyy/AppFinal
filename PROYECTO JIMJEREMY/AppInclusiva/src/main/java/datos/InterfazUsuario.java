/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 34689
 */
public interface InterfazUsuario {
     public int insertar(Usuario usuario);
    public List<Usuario> seleccionar() throws SQLException;
    public int actualizar(Usuario usuario);
    public int eliminar(Usuario usuario);
    public int actualizarID(Usuario u, String prevUsuario);
}
