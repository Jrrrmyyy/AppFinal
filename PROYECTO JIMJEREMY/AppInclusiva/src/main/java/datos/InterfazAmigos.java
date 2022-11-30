/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Dominio.Amigos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 34689
 */
public interface InterfazAmigos {
    public List<Amigos> amigos = new ArrayList<>();
    public int insertar(Amigos amigos);
    public int seleccionar(Amigos amigos);
    public int actualizar(Amigos amigos);
    public int eliminar(Amigos amigos);
    
}
