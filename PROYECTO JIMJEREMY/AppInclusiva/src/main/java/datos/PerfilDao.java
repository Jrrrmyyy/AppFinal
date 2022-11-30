/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Perfil;

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
public class PerfilDao implements InterfazPerfil{
    private static final String SQL_SELECT = "SELECT * FROM Perfil";
    private static final String SQL_INSERT = "INSERT INTO Perfil (cumpleaños, "
            + "genero,biografia,tlfno,email,,"
            + "likes,dislikes,paisIDFK,usuarioIDFK)"
            + "VALUE(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Perfil SET cumpleaños=?, "
            + "genero=?,biografia=?,tlfno=?, "
            + "email=?,likes=?,dislikes=?,paisIDFK=?,usuarioIDFK=?,";
    private static final String SQL_DELETE = "DELETE Perfil WHERE usuarioIDFK=?";
    
    public List<Perfil> perfil = new ArrayList<>();
    @Override
       public int insertar(Perfil perfil){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1,perfil.getCumpleaños());
                stmt.setString(2,perfil.getGenero());
                stmt.setString(3,perfil.getBiografia());
                stmt.setString(4,perfil.getTlfno());
                stmt.setString(5,perfil.getEmail());
                stmt.setInt(6,perfil.getLikes());
                stmt.setInt(7,perfil.getDislikes());
                stmt.setInt(8,perfil.getPaisIDFK());
                stmt.setInt(9, perfil.getUsuarioIDFK());

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
    
    
    
    
    
     public List<Perfil> seleccionar () throws SQLException {
        //INICIAR VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Perfil> perfiles = new ArrayList<>();
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int cumpleaños = rs.getInt("cumpleaños");
            String genero = rs.getString("genero");
            String biografia = rs.getString("biografia");
            String tlfno = rs.getString("tlfno");
            String email = rs.getString("email");
            int likes = rs.getInt("likes");
            int dislikes = rs.getInt("dislikes");
            int paisIDFK = rs.getInt("paisIDFK");
            int usuarioIDFK = rs.getInt("usuarioIDFK");
            
            
            
            
            perfiles.add(new Perfil(cumpleaños,genero,biografia,tlfno,email,
            likes,dislikes,paisIDFK,usuarioIDFK));
        }
        close(rs);
        close(stmt);
        close(conn);
        return perfiles;
    }
    @Override
    public int actualizar(Perfil perfil){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
               stmt.setInt(1, perfil.getCumpleaños());
               stmt.setString(2,perfil.getGenero());
               stmt.setString(3, perfil.getBiografia());
               stmt.setString(5,perfil.getTlfno());
               stmt.setString(6,perfil.getEmail());
               stmt.setInt(7, perfil.getLikes());
               stmt.setInt(8,perfil.getDislikes());
               stmt.setInt(9, perfil.getPaisIDFK());
               stmt.setInt(10, perfil.getUsuarioIDFK());
               
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
        public int eliminar(Perfil perfil){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1,perfil.getUsuarioIDFK());
                
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
    public List<Perfil> mostrar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
        
        

  

}
