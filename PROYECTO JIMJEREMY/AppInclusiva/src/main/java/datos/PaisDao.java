/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Pais;
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
public class PaisDao {
    
      private static final String SQL_SELECT = "SELECT * FROM Pais";
    private static final String SQL_INSERT = "INSERT INTO Pais(pasiID, "
            + "nombrePais,prefijoPais) VALUE(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET paisID=?, "
            + "nombrePais=?,prefijoPais=?";
    private static final String SQL_DELETE = "DELETE Pais WHERE paisID=?";
    
    
       public int insertar(Pais pais){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1,pais.getPaisID());
                stmt.setString(2,pais.getNombrePais());
                stmt.setString(3,pais.getPrefijoPais());
                
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
    
    
    
    
    
     public List<Pais> seleccionar () throws SQLException {
        //INICIAR VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pais paiss = null;
        List<Pais> pais = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int paisID = rs.getInt("paisID");
            String nombrePais = rs.getString("nombrePais");
            String prefijoPais = rs.getString("prefijoPais");
            
            //Instancio nuevos objetos
            
            pais.add(new Pais(paisID,nombrePais,prefijoPais));
        }
        close(rs);
        close(stmt);
        close(conn);
        return pais;
    }
    public int actualizar(Pais pais){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
               stmt.setInt(1,pais.getPaisID());
               stmt.setString(2,pais.getNombrePais());
               stmt.setString(3,pais.getPrefijoPais())
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
        
        
        public int eliminar(Pais pais){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1, pais.getPaisID());
                
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
