/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Perfil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 34689
 */
public interface InterfazPerfil{
    
 public List <Perfil> seleccionar() throws SQLException ;
    
    public int insertar(Perfil perfil);
    public int actualizar(Perfil perfil);
    public int eliminar(Perfil perfil);
    public List<Perfil> mostrar() throws SQLException;
}
