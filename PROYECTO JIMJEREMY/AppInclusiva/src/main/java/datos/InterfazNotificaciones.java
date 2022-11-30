  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Notificaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 34689
 */
public interface InterfazNotificaciones {
   public List<Notificaciones> notificaciones = new ArrayList<>();
   public List<Notificaciones> notificacion = new ArrayList<>();
   public int insertar (Notificaciones notificaciones);
   public int elinminar (Notificaciones notificaciones);
   public List<Notificaciones> mostrar() throws SQLException;
}
