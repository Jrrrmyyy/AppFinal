/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Archivos.Archivoss;
import datos.InterfazPerfil;
import datos.PerfilDao;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Perfil implements Serializable{

    
    private int cumpleaños;
    private String genero;
    private String biografia;
    private String tlfno;
    private String email;
    private int likes;
    private int dislikes;
    private int paisIDFK;
    private int usuarioIDFK;
    
    

    public Perfil(String tlfno, String email) {
        this.tlfno = tlfno;
        this.email = email;
       
    }

    public Perfil( String tlfno, String email, Date pcreacion) {
        
        this.tlfno = tlfno;
        this.email = email;
       
    }

    public Perfil(int cumpleaños, String genero, String biografia, String tlfno, String email, int likes, int dislikes, int paisIDFK, int usuarioIDFK) {
        this.cumpleaños = cumpleaños;
        this.genero = genero;
        this.biografia = biografia;
        this.tlfno = tlfno;
        this.email = email;

        this.likes = likes;
        this.dislikes = dislikes;
        this.paisIDFK = paisIDFK;
        this.usuarioIDFK = usuarioIDFK;
    }

        
    

 
 
    public Perfil() {
    }

    
    
    public int getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(int cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

 

    public String getTlfno() {
        return tlfno;
    }

    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getPaisIDFK() {
        return paisIDFK;
    }

    public void setPaisIDFK(int paisIDFK) {
        this.paisIDFK = paisIDFK;
    }

    public int getUsuarioIDFK() {
        return usuarioIDFK;
    }

    public void setUsuarioIDFK(int usuarioIDFK) {
        this.usuarioIDFK = usuarioIDFK;
    }

    @Override
    public String toString() {
        return "Perfil: " + "-- cumplea\u00f1os: " + cumpleaños + "-- genero: " + genero + "-- biografia: " 
                + biografia +  "-- tlfno: " + tlfno + "-- email: " 
                + email + "-- likes: " + likes + "-- dislikes: " + dislikes ;
    }

public String escribir(){
    return 'º' + cumpleaños + 'º' + genero + 'º' + biografia  
            + 'º' + tlfno + 'º' + email + 'º' + likes + 'º' + dislikes + 'º' + '|';
}
    
 public static boolean entrada(String email){
        Perfil perfil = null;
        boolean existe = false;
        for (int i = 0; i < perfil.listarPerfiles().size() ; i++) {
            if(email.equals(perfil.listarPerfiles().get(i).getEmail())){
                existe = true;
            }
        }
        return existe;
    }
 
 
 public static Perfil perfilEmail(String email){
        Perfil pf = new Perfil();
        for (int i = 0; i < Perfil.listarPerfiles().size(); i++) {
            
            if(Perfil.listarPerfiles().get(i).getEmail().equals(email)){
                pf = Perfil.listarPerfiles().get(i);
            }
        }
        return pf;
    }

//genero.biografia,direccion,tlfno,email
 
  public static void eliminarPerfil(){
        
        Scanner in = new Scanner (System.in);
        InterfazPerfil perfilDao = new PerfilDao();
        Perfil pf = new Perfil();
        System.out.println("TABLA PERFILES:\n\n");
        for (int i = 0; i < Perfil.listarPerfiles().size(); i++) {
            System.out.println(Perfil.listarPerfiles().get(i).toString());
        }

        System.out.println("Inserte el email del perfil que quiere eliminar");
        String email = in.nextLine();
        while(!entrada(email)){
            System.out.println("Esta direccion de correo no existe.\n"
                    + "Introduzca un correo correcto.");
            email = in.nextLine();
        }
        perfilDao.eliminar(perfilEmail(email));
    }
   public static List <Perfil> listarPerfiles (){
        InterfazPerfil perfilDao = new PerfilDao();
        List <Perfil> perfiles = null;
        try{
            perfiles = perfilDao.seleccionar();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return perfiles;
    }
    public static Perfil perfilActualizar(){
        Perfil perfil = new Perfil();
        InterfazPerfil perfilDao = new PerfilDao();
        int opcion;
        opcion = -1;
        System.out.println("LISTA DE PERFILES:\n\n");
        for (int i = 0; i < Perfil.listarPerfiles().size(); i++) {
            System.out.println(Perfil.listarPerfiles().get(i).toString());
        }
        Scanner in = new Scanner (System.in);
        System.out.println("Inserte el EMAIL del perfil que quiere cambiar");
        String email = in.nextLine();
        perfil = perfilEmail(email);
        
        System.out.println(perfil.toString());
        System.out.println("Seleccione lo que quiere editar:");
        
        
        /***************************************************/
   //genero.biografia,direccion,tlfno,email     
        while (opcion != 0){
            
            System.out.println("\tATRIBUTOS");
            System.out.println("----------------------------------------------------\n");
            System.out.println("1 - GENERO: "+perfil.genero);
            System.out.println("2 - BIOGRAFIA "+ perfil.biografia);
            System.out.println("4 - TELEFONO: "+perfil.tlfno);
            System.out.println("5 - EMAIL: "+perfil.email);
            System.out.println("0 - Salir");
            System.out.println("Selecciones una opción");
            opcion = in.nextInt();
            in.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Introduzca su nuevo género con el que se siente identificado:");
                    String generos = in.nextLine();
                    Perfil pfl = new Perfil();
                    
                    while(generos.isEmpty()){
                        System.out.println("Este campo no puede ser vacío."
                                + " Introduca un género válido:");
                        generos = in.nextLine();
                    }
                    System.out.println(pfl);
                    pfl.setGenero(generos);
                    System.out.println(pfl);
                    perfil.setGenero(generos);
                    perfilDao.actualizar(perfil);
                    break;
                
                case 2:
                    
                    System.out.println("Introduzca su nueva BIOGRAFÍA:");
                    String pff = in.nextLine();
                    pff = in.nextLine();
                    
                    while(pff.isEmpty()){
                        System.out.println("Este campo no puede ser vacío."
                                + " Introduca una Biografía:");
                        pff = in.nextLine();
                    }
                    perfil.setBiografia(pff);
                    perfilDao.actualizar(perfil);
                    break;
                
               
                case 3:
                    System.out.println("Introduzca su nuevo número de teléfono:");
                    pff = in.nextLine();
                    
                    while(pff.isEmpty()){
                        System.out.println("Este campo no puede ser vacío."
                                + " Introduca un número válido(9 números):");
                        pff = in.nextLine();
                    }
                    perfil.setTlfno(pff);
                    perfilDao.actualizar(perfil);
                    break;
                    
                case 4:
                   System.out.println("Introduzca la nueva direccion de correo electronico:");
                    pff = in.nextLine();
                    
                    while(pff.isEmpty()){
                        System.out.println("Este campo no puede ser vacío."
                                + " Introduca un valor:");
                        pff = in.nextLine();
                    }
                    perfil.setEmail(pff);
                    perfilDao.actualizar(perfil);

                    break;
                
                default:
                    break;
            }
        }
        return perfil;
    }
       public static void actualizarArchivoPerfiles(){
        Perfil perfil = null;
        String contenido ="";
        for (int i = 0; i < perfil.listarPerfiles().size(); i++) {
            
            contenido += (perfil.listarPerfiles().get(i).escribir());
        }
        Archivoss.escribirArchivo("perfil.txt",contenido);
    }
    public static Perfil pCreacion(){
        Scanner in = new Scanner (System.in);
        InterfazPerfil perfilDao = new PerfilDao();
        System.out.println("Introduzca su correo electronico");
        String email = in.nextLine();
        while(Perfil.entrada(email)){
            System.out.println("Este correo ya está en uso. "
                    + "Proporcione otra direccion de correo electronico");
            email = in.nextLine();
        }
        System.out.println("Introduzca su numero de telefono");
        String ntlfono = in.nextLine();
        Perfil perfil = new Perfil(12-01-2001,"masculino","Me gusta comer ensalada",ntlfono,"XDXD@gmail.com",7,3,4,8);
        System.out.println(perfil);
        perfilDao.insertar(perfil);
        actualizarArchivoPerfiles();
        return perfil;
    }
        public static void buscarPerfilGenero(String genero) {
        Perfil pf = new Perfil ();
        for (int i = 0; i < pf.listarPerfiles().size();i++){
           if(pf.listarPerfiles().get(i).getGenero().equals(genero) ||
                 pf.listarPerfiles().get(i).getGenero().contains(genero)){
            pf = pf.listarPerfiles().get(i);
             System.out.println(pf);  
        
        }
        }
    }
}

   

