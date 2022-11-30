/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Usuario;

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
public  class UsuarioDao implements InterfazUsuario{
    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    private static final String SQL_INSERT = "INSERT INTO Usuario (id, "
            + "Nombre,Apellidos,Nick,Email,Contraseña, "
            + "premium,activo,admin,codigo,fue_creado,sentimental,Discapacidad)"
            + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE Usuario SET "
            + "Nombre=?,Apellidos=?,Nick=?,Email=?,"
            + "Contraseña=?,premium=?,activo=?,admin=?,codigo=?,fue_creado=?, "
            + "sentimental=?,Discapacidad=? "
            + "WHERE id=?;";
  
           
    private static final String SQL_DELETE = "DELETE Usuario WHERE id=?";
    
     private static final String SQL_UPDATE_ID = "UPDATE usuario SET "
            + "Nick = ? WHERE Nick = ?;";
    
     public List<Usuario> usuarios = new ArrayList<>();
     
    
       public int insertar(Usuario usuario){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setInt(1, usuario.getid());
                stmt.setString(2, usuario.getNombre());
                stmt.setString(3, usuario.getApellidos());
                stmt.setString(4, usuario.getNick());
                stmt.setString(5, usuario.getEmail());
                stmt.setString(6, usuario.getContraseña());
                stmt.setBoolean(7,usuario.isPremium());
                stmt.setBoolean(8,usuario.isActivo());
                stmt.setBoolean(9,usuario.isAdmin());
                stmt.setString(10, usuario.getCodigo());
                stmt.setDate(11, usuario.getFue_creado());
                stmt.setString(12, usuario.getSentimental());
                stmt.setString(13, usuario.getDiscapacidad());
                
                
                
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
     public List<Usuario> seleccionar () throws SQLException {
        //INICIAR VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        List<Usuario> usuarios = new ArrayList<>();
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
       
        
        while(rs.next()){
            
            int id = rs.getInt("id");
            String Nombre = rs.getString("Nombre");
            String Apellidos = rs.getString("Apellidos");
            String Nick = rs.getString("Nick");
            String Email = rs.getString("Email");
            String Contraseña = rs.getString("Contraseña");
            Boolean premium = rs.getBoolean("premium");
            Boolean activo = rs.getBoolean("activo");
            Boolean admin = rs.getBoolean("admin");
            String codigo = rs.getString("codigo");
            Date fue_creado = rs.getDate("fue_creado");
            String sentimental = rs.getString("sentimental");
            String Discapacidad = rs.getString("Discapacidad");

           
            
            
            //Instancio nuevos objetos
            usuarios.add(new Usuario(id,Nombre,Apellidos,
            Nick,Email,Contraseña,premium,activo,admin,codigo,
            fue_creado,sentimental,Discapacidad));
            
        }
        close(rs);
        close(stmt);
        close(conn);
        return usuarios;
    }
     
      
    
      public int actualizarID (Usuario u, String prevUsuario){
        Connection conn =null;
        PreparedStatement stmt=null;
        int registro = 0;
        
        try{
        
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_UPDATE_ID);
            
            
            stmt.setString(1, u.getNick());
            stmt.setString(2, prevUsuario);
            
          
            
            registro = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            
            }
            
        }
        return registro;
    } 
    
    public int actualizar(Usuario usuario){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellidos());
                stmt.setString(3, usuario.getNick());
                stmt.setString(4, usuario.getEmail());
                stmt.setString(5, usuario.getContraseña());
                stmt.setBoolean(6, usuario.isPremium());
                stmt.setBoolean(7, usuario.isActivo());
                stmt.setBoolean(8, usuario.isAdmin());
                stmt.setString(9, usuario.getCodigo());
                stmt.setDate(10,usuario.getFue_creado());
                stmt.setString(11, usuario.getSentimental());
                stmt.setString(12, usuario.getDiscapacidad());
                stmt.setInt(13, usuario.getid());
                System.out.println(stmt);
                registros = stmt.executeUpdate();
                System.out.println(registros);
                
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
    
        public int eliminar(Usuario usuario){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1, usuario.getid());
                
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
