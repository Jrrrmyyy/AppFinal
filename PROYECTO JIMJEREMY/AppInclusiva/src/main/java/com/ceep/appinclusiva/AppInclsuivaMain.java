/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.appinclusiva;


import Archivos.Archivoss;
import Dominio.Likes;
import datos.*;
import Dominio.Usuario;
import Dominio.Perfil;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Alumno Mañana
 */
public class AppInclsuivaMain {
    
        public static Scanner a = new Scanner(System.in);
        //Daos
        static InterfazUsuario usuarioDao = new UsuarioDao();
        static  InterfazPerfil perfilDao = new PerfilDao();
        static InterfazNotificaciones notificacionesDao = (InterfazNotificaciones) new NotificacionesDao();
        static InterfazAmigos amigosDao = new AmigosDao();
        //admin
        static Usuario administrador = new Usuario("admin","1234");
        //users
        static Usuario u1 = new Usuario(1,"Marcos","Lopez Fernandez","MarcosLF","mlc@gmail.com","MCL123","893032",Date.valueOf(LocalDate.now()),"Soltero","Discapacidad sensorial");
        

 
   
        //Archivoss
        static String Usuarios = "Usuarios.txt";
        static String Perfiles = "Perfiles.txt";
        
        //AList
        static ArrayList<Usuario> UserList = new ArrayList<>();
        static ArrayList<Perfil> PerfilList = new ArrayList<>();
   
    
        
public static void main(String [] args){
    
    
    
          menu();
          
         
          
    }      
    public static void menu(){
              Usuario.actualizarArchivoUsuarios();
              int opcion; 
              
              opcion = -1;
              
               

               while (opcion != 0){
            
            System.out.println("\tCONNECT TO PEOPLE\n");
            System.out.println("INICIAR SESIÓN");
            System.out.println("-----------------------------\n");
            System.out.println("1 - Iniciar sesión como ADMINISTRADOR");
            System.out.println("2 - Iniciar sesión como USUARIO");
            System.out.println("3 - Registrarse ");
            System.out.println("0 - Salir");
            System.out.println("Selecciones una opción: ");
            opcion = a.nextInt();
            a.nextLine();
            
            switch (opcion) {
                case 1:
                    // INICIAR SESION (ADMIN)
                    Usuario.iniciarSesion(administrador.getNick());
                    menuEntidad(true);
                    break;
                case 2:
                    // FUNCION INICIAR SESIÓN (USUARIO)
                    System.out.println("Introduzca su usuario:");
                    String nick = a.nextLine();
                    //Introducir user+pass
                    if(Usuario.entrada(nick)){
                        System.out.println("Introduzca contraseña: ");
                        String pass = a.nextLine();
                        if(pass.isEmpty()){
                            break;
                        }
                        while(!pass.equals(Usuario.comprobarId(nick).getContraseña())){
                            System.out.println("Contraseña incorrecta, inténtelo de nuevo: ");
                            pass = a.nextLine();
                            if(pass.isEmpty()){
                                break;
                            }
                        }
                        if(pass.isEmpty()){
                                break;
                        }
                        
    
                        u1 = Usuario.comprobarId(nick);
                        menuEntidad(false);
                        //Para crear new user
                    }else{
                        char lm;
                        System.out.println("Este usuario no existe ¿Desea darse de alta? \n Sí(1) / No(2)");
                        lm = a.nextLine().charAt(0);
                        //Se equivoca de pass
                        while(lm != '1' && lm != '2'){
                            System.out.println("Introduzca Sí (1) o No (2)");
                            lm = a.nextLine().charAt(0);
                        }
                        if (lm == '1'){
                            u1 = Usuario.Creacion();
                        }else{
                            //Se equivoca
                            System.out.println("Operación cancelada.");
                            break;
                        }

                    }
                    
                    break;
                case 3:
                    // REGISTRAR UN NUEVO USUARIO
                    u1 = Usuario.Creacion();
                    menuEntidad(false);
                    break;
                case 0:
                    Usuario.actualizarArchivoUsuarios();
                    System.out.println("");
                    break;
                default:
                    
                    System.out.println("Seleccione una opción entre 0 y 3");
                    // The user input an unexpected choice.
            }
            
            
        }
       
    }
    //Admin?
    public static void menuEntidad(boolean admin){   
        int opcion;
     
        opcion = -1;

     //Admin = Acceso a todo.
     //Usuario = Su Perfil solo.
        
        while (opcion != 0){
            if (admin){
                System.out.println("\n\n"+"ADMINISTRADOR");
                System.out.println("-------------------------\n");
                System.out.println("1 - USUARIOS");
                System.out.println("2 - PERFILES DE USUARIOS");
                System.out.println("3 - NOTIFICACIONES");
                System.out.println("4 - AMIGOS");
                System.out.println("0 - Salir");
                opcion = a.nextInt();
                a.nextLine();

                switch (opcion) {
                    case 1:
                        menuCRUD("USUARIO",admin);
                        break;
                    case 2:
                        // Perform "encrypt number" case.
                        menuCRUD("PERFILES DE USUARIOS",admin);
                        break;
                    case 3:
                        // Perform "decrypt number" case.
                        //menuCRUD("NOTIFICACIONES",admin);
                        break;
                    case 4:
                        // Perform "decrypt number" case.
                        //menuCRUD("AMIGOS",admin);
                        break;
                    case 0:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Seleccione una opción entre 0 y 5");
                }
            
            }else if(!admin){
                
                Usuario.actualizarArchivoUsuarios();
                System.out.println("\n\n"+"USUARIO: "+ u1.getNick());
                System.out.println("-------------------------\n");
                System.out.println("1 - PERFIL");
                System.out.println("2 - NOTIFICACIONES");
                System.out.println("3 - LIKES");
                System.out.println("0 - Salir");
                opcion = a.nextInt();
                a.nextLine();

                switch (opcion) {
                    case 1:
                        menuCRUD("PERFIL",admin);
                        break;
                    case 2:
                        menuCRUD("NOTIFICACIONES",admin);
                        break;
                    case 3:
                        menuCRUD("LIKES",admin);
                        break;
                    case 0:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Seleccione una opción entre 0 y 3");
                }
            }
            
        }
       
    }
     //genero.biografia,direccion,tlfno,email 
    //Compruba si es Administrador o no.  
    public static void menuCRUD(String entidad, boolean admin){
         int opcion;
       
        opcion = -1;
        
        while (opcion != 0){
            if(admin){
                System.out.println("\n\nADMINISTRADOR: "+entidad);
                System.out.println("-------------------------\n");
                System.out.println("1 - BUSCAR");
                System.out.println("2 - INSERTAR");
                System.out.println("3 - ACTUALIZAR");
                System.out.println("4 - ELIMINAR");
                System.out.println("0 - Salir");
                opcion = a.nextInt();
                a.nextLine();
                
                switch(entidad){
                    case "USUARIO":
                        switch (opcion) {
                            case 1:
                                
                                //BUSCAR USUARIOS
                                System.out.println("BUSCADOR DE USUARIOS\n\n");
                                for (int i = 0; i < Usuario.listarUsuarios().size();i++){
                                    System.out.println(Usuario.listarUsuarios().get(i).toString());
                                }
                                
                                 String buscar;
                                    int opc = -1;
                                    while(opc != 0){
                                        System.out.println("\tBÚSQUEDA POR:");
                                        System.out.println("\t1 - NOMBRE:");
                                        System.out.println("\t2 - APELLIDOS:");
                                        System.out.println("\t3 - DISCAPACIDAD");
                                        System.out.println("\t0 - SALIR:");
                                        opc = a.nextInt();
                                        a.nextLine();
                                        switch(opc){
                                            case 1:
                                                System.out.println("Introduzca el nombre por el que quiere buscar:");
                                                buscar = a.nextLine();
                                                Usuario.buscarUsuarioNombre(buscar);
                                                break;
                                            case 2:
                                                System.out.println("Introduzca el apellido por el que quiere buscar:");
                                                buscar = a.nextLine();
                                                Usuario.buscarUsuarioApellido(buscar);
                                                break;
                                            case 0:
                                                break;
                                            case 3:
                                                System.out.println("Introduzca el nombre de la Discapacidad por el que quiere buscar:");
                                                buscar = a.nextLine();
                                                Usuario.buscarUsuarioDiscapacidad(buscar);
                                            default:
                                                System.out.println("Seleccione una de las opciones (0 - 3)");
                                                break;
                                        }
                                    }
                                break;
                            case 2:
                                //AÑADIR USUARIO
                                System.out.println("AÑADIR USUARIO");
                                Scanner in = new Scanner (System.in);
                                System.out.println("Introduzca su usuario");
                                String usuario = in.nextLine();
                                while(Usuario.entrada(usuario)){
                                         System.out.println("Este nombre ya existe. "
                                                + "Escoja otro nombre de usuario");
                                        usuario = in.nextLine();
                                 }
                                System.out.println("Introduzca su contraseña:");
                                String contraseña = in.nextLine();
                                System.out.println("Introduzca su nombre:");
                                String nombre = in.nextLine();
                                System.out.println("Introduzca su apellido:");
                                String apellido = in.nextLine();
                                System.out.println("Introduzca su correo electronico:");
                                String email = in.nextLine();
                                System.out.println("Índica si quieres acceso Premium ( Sí (1) No (2)):");
                                String premium = in.nextLine();
                                Boolean indicadorPremium;
                                if (premium.equals("1")){ 
                                    indicadorPremium = true;}
                                else if (premium.equals("2")){
                                    indicadorPremium = false;
                                }
                                System.out.println("Introduzca su codigo:");
                                String codigo = in.nextLine();
                                System.out.println("Introduzca su situación sentimental:");
                                String sentimental = in.nextLine();
                                System.out.println("Introduzca el nombre de discapacidad:");
                                String nDiscapacidad = in.nextLine();
                                Usuario usuarioo = new Usuario( nombre, apellido , usuario,email,contraseña, codigo,sentimental, nDiscapacidad);
                                usuarioo.setPremium(false);
                                usuarioo.setAdmin(false);
                                usuarioo.setActivo(false);
                                Usuario.Creacion2(usuarioo);

                                break;
                            case 3:
                                System.out.println("ACTUALIZAR USUARIO");
                                Usuario.actualizarUsuario();
                                break;
                            case 4:
                                
                                System.out.println("ELIMINAR USUARIO");
                                Usuario.eliminarUsuario();
                                opcion = 0;
                                break;
                            case 0:
                                Usuario.actualizarArchivoUsuarios();
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Seleccione una opción entre 0 y 4");
                        }
                        break;
                    case "PERFILES DE USUARIOS":

                        switch (opcion) {
                            case 1:
                                System.out.println("LISTA DE PERFILES");
                                for (int i = 0; i < Perfil.listarPerfiles().size(); i++) {
                                    System.out.println(Perfil.listarPerfiles().get(i));
                                }
                                
                                //ESTO ES NUEVO
                                String buscar;
                                int opcionn = -1;
                                while(opcionn != 0){
                                    System.out.println("\tBÚSQUEDA POR:");
                                    System.out.println("\t1 - GENERO:");
                                    System.out.println("\t2 - DIRECCION:");
                                    System.out.println("\t0 - SALIR");
                                    opcionn = a.nextInt();
                                    a.nextLine();
                                    switch(opcionn){
                                        case 1:
                                            System.out.println("Introduzca su búsqueda:");
                                            buscar = a.nextLine();
                                            Perfil.buscarPerfilGenero(buscar);
                                            break;
                                        case 2:
                                            System.out.println("Introduzca su búsqueda:");
                                            buscar = a.nextLine();
                                           // Perfil.buscarPerfilDireccion(buscar);
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Seleccione -> 0 o 1");
                                            break;
                                    }
                                }
                                
                                //HASTA AQUÍ ES LO NUEVO
                                break;
                            case 2:
                                System.out.println("INTRODUCIR PERFIL:");
                                // Perfil.pCreacion();
                                break;
                            case 3:
                                System.out.println("ACTUALIZAR PERFIL");
                                 Perfil.perfilActualizar();
                                break;

        
                            case 4:
                                System.out.println("ELIMINAR PERFIL");
                                Perfil.eliminarPerfil();
                                opcion = 0;
                                break;
                            case 0:
                                Perfil.actualizarArchivoPerfiles();
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Seleccione una opción entre 0 y 4");
                        }
                        break;
                    
                }
            }
        }
    }
}



    
         
    
    
                      

