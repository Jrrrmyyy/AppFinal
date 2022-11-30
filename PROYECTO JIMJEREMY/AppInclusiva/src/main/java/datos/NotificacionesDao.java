/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import Dominio.Notificaciones;
import static datos.conexion.close;
import static datos.conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class NotificacionesDao implements InterfazNotificaciones {
    
        private static final String SQL_SELECT = "SELECT * FROM Notificaciones";
    private static final String SQL_INSERT = "INSERT INTO Notificaciones (notificacionesID, "
          + "nottypeID,typeID,refID,esLeido,fueCreada) VALUE (?,?,?,?,?,?) ";
   
    private static final String SQL_DELETE = "DELETE Likes WHERE notificacionesID=?";
    
        public List<Notificaciones> Notificaciones = new ArrayList<>();
        public List<Notificaciones> Notificacion = new ArrayList<>();
    
       public int insertar(Notificaciones notificaciones){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1,notificaciones.getNotificacionesID());
                stmt.setInt(2,notificaciones.getNottypeID());
                stmt.setInt(3,notificaciones.getTypeID());
                stmt.setInt(4,notificaciones.getRefID());
                stmt.setBoolean(5,notificaciones.isEsLeido());
                stmt.setDate(6,notificaciones.getFueCreada());
                
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
    

        public int eliminar(Notificaciones notificaciones){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1,notificaciones.getNotificacionesID());
                
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
        
  public List<Notificaciones> mostrar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = getConnection();
        stmt =conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int notificacionesID = rs.getInt("notifacionesID");
            int typeID = rs.getInt("typeID");
            int refID = rs.getInt("refID");
            boolean esLeido = rs.getBoolean("esLeido");
            Date fueCreada = rs.getDate("fueCreada");
            
            Notificaciones.add(new Notificaciones (notificacionesID, typeID, refID, esLeido, fueCreada));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        return Notificaciones;
    }

    @Override
    public int elinminar(Notificaciones notificaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
    
}
