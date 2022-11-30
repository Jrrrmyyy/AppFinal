/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Likes;
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
public class LikesDao implements InterfazLikes{
    
    private static final String SQL_SELECT = "SELECT * FROM Likes";
    private static final String SQL_INSERT = "INSERT INTO Likes (likesID, "
          + "typeID,refID,usuarioIDFK) VALUE (?,?,?,?) ";
   
    private static final String SQL_DELETE = "DELETE Likes WHERE likesID=?";
    
        public List<Likes> Likes = new ArrayList<>();
        public List<Likes> like = new ArrayList<>();
    
       public int insertar(Likes likes){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1, likes.getLikesID());
                stmt.setInt(2, likes.getTypeID());
                stmt.setInt(3, likes.getRefID());
                stmt.setInt(4,likes.getUsuarioIDFK());
                
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
        public int eliminar(Likes likes){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1,likes.getLikesID());
                
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
        public List<Likes> mostrar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = getConnection();
        stmt =conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int LikesID = rs.getInt("likesID");
            int usuarioIDFK = rs.getInt("usuarioIDFK");

            Likes.add(new Likes (LikesID, usuarioIDFK));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        return Likes;
    }
    
    
    
        
}

