/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


import Archivos.Archivoss;
import datos.InterfazUsuario;
import datos.UsuarioDao;
import static datos.conexion.getConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable {
    
    private int id;
    private String Nombre;
    private String Apellidos;
    private String Nick;
    private String Email;
    private String Contraseña;
    private boolean premium;
    private boolean activo;
    private boolean admin;
    private String codigo;
    private Date fue_creado;
    private String sentimental;
    private String Discapacidad;

   
    
    public Usuario() {
    }
    public Usuario(String Nick, String Contraseña) {
        this.Nick = Nick;
        this.Contraseña = Contraseña;
        this.fue_creado = Date.valueOf(LocalDate.now());
    }
    public Usuario(String Nick, String Contraseña, Date fue_creado) {
        this.Nick = Nick;
        this.Contraseña = Contraseña;
        this.fue_creado = fue_creado;
    } 
    public Usuario(String Nombre, String Apellidos, String Nick, String Email, String Contraseña, String codigo, String sentimental, String Discapacidad) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Nick = Nick;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.fue_creado = Date.valueOf(LocalDate.now());
        this.codigo = codigo;
        this.sentimental = sentimental;
        this.Discapacidad = Discapacidad;
    }
    public Usuario(int id, String Nombre, String Apellidos, String Nick, String Email, String Contraseña, String codigo, Date fue_creado, String sentimental, String Discapacidad) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Nick = Nick;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.codigo = codigo;
        this.fue_creado = fue_creado;
        this.sentimental = sentimental;
        this.Discapacidad = Discapacidad;
    }
    public Usuario(int id, String Nombre, String Apellidos, String Nick, String Email, String Contraseña, String codigo, String sentimental, String Discapacidad) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Nick = Nick;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.codigo = codigo;
        this.sentimental = sentimental;
        this.Discapacidad = Discapacidad;
    }

    public Usuario(int id, String Nombre, String Apellidos, String Nick, String Email, String Contraseña, Boolean premium, Boolean activo, Boolean admin, String codigo, Date fue_creado, String sentimental, String Discapacidad) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Nick = Nick;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.premium = premium;
        this.activo = activo;
        this.admin = admin;
        this.codigo = codigo;
        this.fue_creado = fue_creado;
        this.sentimental = sentimental;
        this.Discapacidad = Discapacidad;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    public String getNick() {
        return Nick;
    }
    public void setNick(String Nick) {
        this.Nick = Nick;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Date getFue_creado() {
        return fue_creado;
    }
    public void setFue_creado(Date fue_creado) {
        this.fue_creado = fue_creado;
    }
    public String getSentimental() {
        return sentimental;
    }
    public void setSentimental(String sentimental) {
        this.sentimental = sentimental;
    }
    public String getDiscapacidad() {
        return Discapacidad;
    }
    public void setDiscapacidad(String Discapacidad) {
        this.Discapacidad = Discapacidad;
    }
    @Override
    public String toString() {
        return "Nombre del Usuario: " + Nombre + " -- Apellidos del Usuario: " 
                + Apellidos + "-- Nick: " + Nick + "-- Email: " + Email 
                + " Contraseña: " + Contraseña + "-- Premium:" + premium + "-- Activo: " 
                + activo + "-- Admin: " + admin + "-- Codigo: " + codigo + "-- fue_creado: " 
                + fue_creado + "-- Sentimental: " + sentimental + "-- Discapacidad: " + Discapacidad + '.';
    }
    public String escribir() {
       return Nick + "º" + Contraseña + "º" + fue_creado + "º"  
               + Nombre + "º"  + Apellidos + "º" + codigo + "º" + '.' ;
 
   } 
    public static List <Usuario> listarUsuarios(){
        InterfazUsuario usuarioDao = new UsuarioDao();
        List <Usuario> usuario = null;
        try{
            usuario = usuarioDao.seleccionar();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return usuario;
    }    
    public static List <Usuario> listarUsuariosNickName(){
        InterfazUsuario usuarioDao = new UsuarioDao();
        List <Usuario> usuario = null;
        try{
            usuario = usuarioDao.seleccionar();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return usuario;
    }
    public static void actualizarArchivoUsuarios(){
        Usuario usuario = null;
        String contenido ="";
        for (int i = 0; i < Usuario.listarUsuarios().size(); i++) {
            
            contenido += (Usuario.listarUsuarios().get(i).escribir());
        }
        Archivoss.escribirArchivo("usuario.txt",contenido);
    }       
    public static Usuario comprobarId(String primaryKey){
        Usuario usuario = new Usuario("admin","1234");
        for (int i = 0; i < listarUsuariosNickName().size(); i++) {
//            System.out.println(listarUsuariosClave().get(i).toString());
            if(listarUsuariosNickName().get(i).getNick().equals(primaryKey)){
                usuario = listarUsuariosNickName().get(i);
            }
        }
        return usuario;
    }
    public static boolean entrada(String nick){
        boolean existe = false;
        for (int i = 0; i < Usuario.listarUsuarios().size() ; i++) {
            if(nick.equals(Usuario.listarUsuarios().get(i).getNick())){
                existe = true;
            }
        }
        return existe;
    }
    public static void eliminarUsuario(){
        Scanner in = new Scanner (System.in);
        System.out.println("Introduzca el usuario que quiere eliminar:");
        String usuario = in.nextLine();
        if(entrada(usuario)){
            System.out.println("¿Desea eliminar este usuario? Sí (1) o No (2)");
            char ac = in.nextLine().charAt(0);
            while(ac != '1' && ac != '2'){
                System.out.println("Introduzca Sí (1) o No (2)");
                ac = in.nextLine().charAt(0);
            }
            if (ac == '1'){
                
                InterfazUsuario usuarioDao = new UsuarioDao();
                usuarioDao.eliminar(comprobarId(usuario));
                
            }else{
                System.out.println("Operación cancelada.");
            }
        }
    }
    public static void buscarUsuarioNombre(String nombre){
       
        for (int i = 0; i <listarUsuarios().size();i++){
            if(listarUsuarios().get(i).getNombre().equals(nombre) ||
                    listarUsuarios().get(i).getNombre().contains(nombre)){
                System.out.println(listarUsuarios().get(i));
            }
        }
    }
    
    public static void buscarUsuarioApellido(String apellido){
        for (int i = 0; i < listarUsuarios().size(); i++) {
            if(listarUsuarios().get(i).getApellidos().equals(apellido) ||
                    listarUsuarios().get(i).getApellidos().contains(apellido)){
                System.out.println(listarUsuarios().get(i));
            }
        } 
    }
    public static void buscarUsuarioDiscapacidad(String discapacidad){
       
        for (int i = 0; i <listarUsuarios().size();i++){
            if(listarUsuarios().get(i).getDiscapacidad().equals(discapacidad) ||
                    listarUsuarios().get(i).getDiscapacidad().contains(discapacidad)){
                System.out.println(listarUsuarios().get(i));
            }
        }
    }
    public static Usuario buscarUsuarioId(Integer id){
        System.out.println(listarUsuarios());
        for (int i = 0; i < listarUsuarios().size(); i++) {
            if(listarUsuarios().get(i).getid()==(id))   
        return listarUsuarios().get(i);
        }
        
        return  listarUsuarios().get(0);
    }
    public static void iniciarSesion(String Administrador){
        Scanner in = new Scanner (System.in);
        System.out.println("Introduzca la contraseña del Administrador:");
        String key = in.nextLine();
        while(!key.equals(Usuario.comprobarId(Administrador).Contraseña)){
            System.out.println("Contraseña incorrecta, pruebe de nuevo:");
            key = in.nextLine();
        }
    }
    public static Usuario Creacion(){
        Scanner in = new Scanner (System.in);
        InterfazUsuario usuarioDao = new UsuarioDao();
        System.out.println("Introduzca su usuario");
        String usuario = in.nextLine();
        while(Usuario.entrada(usuario)){
            System.out.println("Este nombre ya existe. "
                    + "Escoja otro nombre de usuario");
            usuario = in.nextLine();
        }
        System.out.println("Introduzca su contraseña:");
        String contraseña = in.nextLine();
        Usuario usuarioo = new Usuario("" , "", usuario, "", contraseña, "", "", "");
        usuarioo.setPremium(false);
        usuarioo.setAdmin(false);
        usuarioo.setActivo(false);
        System.out.println(usuarioo);
        usuarioDao.insertar(usuarioo);
        actualizarArchivoUsuarios();
        return usuarioo;
    }  
    public static Usuario Creacion2(Usuario u1){

        InterfazUsuario usuarioDao = new UsuarioDao();
        Usuario usuarioo = new Usuario();
        usuarioo.setPremium(false);
        usuarioo.setAdmin(false);
        usuarioo.setActivo(false);
        usuarioDao.insertar(u1);
        actualizarArchivoUsuarios();
        return usuarioo;
    }            
   
    public static void actualizarUsuario(){
        Usuario usuarioo = new Usuario("admin","1234");
        Usuario usuario = new Usuario();
         InterfazUsuario usuarioDao = new UsuarioDao();
        int opcion;
        Scanner input = new Scanner(System.in);
        opcion = -1;
        /***************************************************/
        
        while (opcion != 0){
            
            System.out.println("\n\n\n\t\t"+ usuario.getNick());
            System.out.println("ELIGE LA OPCIÓN QUE QUIERAS");
            System.out.println("-----------------------------\n");
            System.out.println("1 - NOMBRE DE USUARIO: " +usuario.Nick);
            System.out.println("2 - NOMBRE: " +usuario.Nombre);
            System.out.println("3 - APELLIDO: " +usuario.Apellidos);
            System.out.println("4 - EMAIL: " +usuario.Email);
            System.out.println("5 - CONTRASEÑA"+usuario.Contraseña);
            System.out.println("6 - CODIGO: "+usuario.codigo);
            System.out.println("7 - SENTIMENTAL: "+usuario.sentimental);
            System.out.println("8 - TIPO DISCAPACIDAD: "+usuario.Discapacidad);
            System.out.println("0 - SALIR");
            System.out.println("Selecciones una opción");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    // CAMBIO DE NICKNAME
                    System.out.println("Introduzca tu contraseña:");
                    String llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    } 
                    System.out.println("Que usuario quieres modificar?");
                    String ID = input.nextLine();
                    Usuario u5 = buscarUsuarioId(Integer.valueOf(ID));
                    String prevUsuario = usuario.getNick();
                    System.out.println("Introduzca el nuevo nombre de usuario:");
                    String nick = input.nextLine();
                    while(entrada(nick) || nick.isEmpty()){
                        if(nick.equals("")){
                            System.out.println("Este campo es obligatorio");
                            nick = input.nextLine();
                        }else{
                            System.out.println("Ese nombre ya existe, introduzca otro");
                            nick = input.nextLine();
                        }
                    }
                    System.out.println(u5);
                    u5.setNick(nick);
                    u5.setid(Integer.parseInt(ID));
                    System.out.println(u5);
                    usuarioDao.actualizar(u5);
                    usuarioDao.actualizarID(usuario,prevUsuario);
                    
                    break;
                case 2:
                    // CAMBIAR NOMBRE
                    System.out.println("Introduce tu contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Introduzca su nombre:");
                    String nombre = input.nextLine();
                    while(nombre.isEmpty()){
                      System.out.println("Este campo es obligatorio");
                        nombre = input.nextLine();
                    }
                    usuario.setNombre(nombre);
                    usuarioDao.actualizar(usuario);
                    break;
                case 3:
                    // CAMBIAR APELLIDOS
                    System.out.println("Introduzca su contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Introduzca sus apellidos:");
                    String apellidos = input.nextLine();
                    while(apellidos.isEmpty()){
                        System.out.println("Este campo es obligatorio");
                        apellidos = input.nextLine();
                    }
                    usuario.setApellidos(apellidos);
                    usuarioDao.actualizar(usuario);
                    break;
                case 4:
                    // CAMBIAR EMAIL
                    System.out.println("Introduzca su contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Introduzca su direccion de correo electronico: ");
                    String email = input.nextLine();
                     while(email.isEmpty()){
                        System.out.println("Este campo es obligatorio");
                        email = input.nextLine();
                    }
                    usuario.setEmail(email);
                    usuarioDao.actualizar(usuario);
                    break;
                case 5:
                    // CAMBIAR CONTRASEÑA
                    System.out.println("Introduzca su antigua contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Introduzca la nueva contraseña:");
                    nombre = input.nextLine();
                    usuario.setContraseña(nombre);
                    usuarioDao.actualizar(usuario);
                    break;
                case 6:
                    //CAMBIAR CODIGO
                     System.out.println("Introduzca su contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Introduzca su nuevo codigo: ");
                    String codigo = input.nextLine();
                     while(codigo.isEmpty()){
                        System.out.println("Este campo es obligatorio");
                        codigo = input.nextLine();
                    }
                    usuario.setCodigo(codigo);
                    usuarioDao.actualizar(usuario);
                    break;
                case 7:
                    //CAMBIAR SITUACION SENTIMENTAL
                     System.out.println("Introduzca su contraseña: ");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Actualiza tu situación: ");
                    String sentimental = input.nextLine();
                     while(sentimental.isEmpty()){
                        System.out.println("Este campo es obligatorio");
                        sentimental = input.nextLine();
                    }
                    usuario.setSentimental(sentimental);
                    usuarioDao.actualizar(usuario);
                    break;
                case 8:
                    //CAMBIAR TIPO DE DISCAPACIDAD
                    System.out.println("Introduzca su contraseña:");
                    llave = input.nextLine();
                    while(!usuarioo.getContraseña().equals(llave)){
                        System.out.println("Contraseña incorrecta\nInténtelo otra vez");
                        llave = input.nextLine();
                    }
                    System.out.println("Actualiza tu grado de Discapacidad/Añade Discapacidad: ");
                    String tDiscapacidad = input.nextLine();
                     while(tDiscapacidad.isEmpty()){
                        System.out.println("Este campo es obligatorio");
                        tDiscapacidad = input.nextLine();
                    }
                    usuario.setDiscapacidad(tDiscapacidad);
                    usuarioDao.actualizar(usuario);
                    break;
                case 0:
                    System.out.println("");
                    break;
                default:
                    Usuario.actualizarArchivoUsuarios();
                    System.out.println("Seleccione una opción entre 0 y 3");
                    // The user input an unexpected choice.
            }
            
            
        }
       
    }   
}
