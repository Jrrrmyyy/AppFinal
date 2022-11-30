/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import Dominio.Recuperar;
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
public class RecuperarDao {
    private static final String SQL_SELECT = "SELECT * FROM Recuperar";
    private static final String SQL_INSERT = "INSERT INTO Recuperar(recuperarID, "
            + "codigo,activo,fueCreado,usuarioIDFK) VALUE(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET recuperarID=?, "
            + "codigo=?,activo=?,fueCreado=?,usuarioIDFK=?";
    private static final String SQL_DELETE = "DELETE Usuario WHERE recuperarID=?";
    
    
       public int insertar(Recuperar recuperar){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1,recuperar.getRecuperarID());
                stmt.setString(2,recuperar.getCodigo());
                stmt.setBoolean(3,recuperar.isActivo());
                stmt.setDate(4,recuperar.getFueCreado());
                stmt.setInt(5,recuperar.getUsuarioIDFK());
                
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
    
    
    
    
    
     public List<Recuperar> seleccionar () throws SQLException {
        //INICIAR VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Recuperar recupera = null;
        List<Recuperar> recuperar = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int recuperarID = rs.getInt("recuperarID");
            String codigo = rs.getString("codigo");
            boolean activo = rs.getBoolean("activo");
            Date fueCreado = rs.getDate("fueCreado");
            int usuarioIDFK = rs.getInt("usuarioIDFK");
            //Instancio nuevos objetos
            
            recuperar.add(new Recuperar(recuperarID,codigo,activo,fueCreado,usuarioIDFK));
        }
        close(rs);
        close(stmt);
        close(conn);
        return recuperar;
    }
    public int actualizar(Recuperar recuperar){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
               stmt.setInt(1,recuperar.getRecuperarID());
               stmt.setString(2,recuperar.getCodigo());
               stmt.setBoolean(3,recuperar.isActivo());
               stmt.setDate(4,recuperar.getFueCreado());
               stmt.setInt(5,recuperar.getUsuarioIDFK());
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
        
        
        public int eliminar(Recuperar recuperar){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1, recuperar.getRecuperarID());
                
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
}
