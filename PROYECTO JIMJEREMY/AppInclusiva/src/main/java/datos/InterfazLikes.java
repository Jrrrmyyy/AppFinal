/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Likes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 34689
 */
public interface InterfazLikes {
    public List<Likes> likes = new ArrayList<>();
    public int insertar (Likes likes);
    public int eliminar (Likes likes);
    public List<Likes> mostrar() throws SQLException;
}
