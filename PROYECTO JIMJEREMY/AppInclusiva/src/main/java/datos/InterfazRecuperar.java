/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Recuperar;

/**
 *
 * @author 34689
 */
public interface InterfazRecuperar {
      public int insertar(Recuperar recuperar);
    public int seleccionar(Recuperar recuperar);
    public int actualizar(Recuperar recuperar);
    public int eliminar(Recuperar recuperar);
}
