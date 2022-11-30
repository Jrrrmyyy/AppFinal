/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Amigos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class AmigosDao implements InterfazAmigos{


    private static final String SQL_SELECT = "SELECT * FROM Amigos";
    private static final String SQL_INSERT = "INSERT INTO Amigos(amigosID, "
            + "esAceptado,esLeido) VALUE(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET amigosID=?, "
            + "esAceptado=?,esLeido=?";
    private static final String SQL_DELETE = "DELETE Amigos WHERE amigosID=?";
    
    
       public int insertar(Amigos amigos){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1, amigos.getAmigosID());
                stmt.setBoolean(2,amigos.isEsAceptado());
                stmt.setBoolean(3, amigos.isEsLeido());
                
                
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
    
    
    
    
    
     public List<Amigos> seleccionar () throws SQLException {
        //INICIAR VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Amigos amigo = null;
        List<Amigos> amigos = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int amigosID = rs.getInt("amigosID");
            boolean esAceptado = rs.getBoolean("esAceptado");
            boolean esLeido = rs.getBoolean("esLeido");
            
            
            //Instancio nuevos objetos
            
            amigos.add(new Amigos(amigosID,esAceptado,esLeido));
        }
        close(rs);
        close(stmt);
        close(conn);
        return amigos;
    }
    public int actualizar(Amigos amigo){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
               stmt.setInt(1,amigo.getAmigosID());
               stmt.setBoolean(2,amigo.isEsAceptado());
               stmt.setBoolean(3,amigo.isEsLeido())
                       ;
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
        
        
        public int eliminar(Amigos amigo){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1, amigo.getAmigosID());
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }

    @Override
    public int seleccionar(Amigos amigos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}


