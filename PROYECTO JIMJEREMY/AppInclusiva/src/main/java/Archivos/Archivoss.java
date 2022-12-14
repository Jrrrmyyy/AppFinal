/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author 34689
 */
public class Archivoss {
     public static void crearArchivo(String nombre){
        String direccion = "src/main/java/datos/"+nombre;
        File archivo = new File(direccion);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    
    //DESCARTA EL CONTENIDO EXISTENTE Y AÑADE EL NUEVO
    public static void escribirArchivo(String nombre, String contenido){
        String direccion = "src/main/java/datos/"+nombre;
        PrintWriter salida = null;
        File archivo = new File(direccion);
        
         try{
            salida = new PrintWriter(archivo);
            salida.print(contenido);
            System.out.println("Se ha creado el archivo");
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
            
        }finally{
             salida.close(); //siempre se ejecuta
         }
    }
    
    
    //AGREGA CONTENIDO ADEMÁS DEL EXISTENTE
    public static void agregarArchivo(String nombre, String contenido){
        String direccion = "src/main/java/datos/"+nombre;
        PrintWriter salida = null;
        File archivo = new File(direccion);
        try {
           salida = new PrintWriter(new FileWriter(nombre,true));
           salida.print(contenido);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
             salida.close(); //siempre se ejecuta
        }
    }
    
   
    
    
    
     public static String cadenaArchivo(String nombre){
         String direccion = "src/main/java/datos/"+nombre;
         File archivo = new File(direccion);
         BufferedReader entrada = null;
         String total = "";
        try {
            entrada = new BufferedReader (new FileReader(archivo));
            int lectura = entrada.read();
            while(lectura != -1){
                total += ((char)lectura);
                lectura = entrada.read();
                
            }
            entrada.close();
            return total;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
        return null;
     }
     
     public static void leerArchivo(String nombre){
         String direccion = "src/main/java/datos/"+nombre;
         File archivo = new File(direccion);
         BufferedReader entrada = null;
        try {
            entrada = new BufferedReader (new FileReader(archivo));
            String lectura = entrada.readLine();
            while(lectura != null){
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
     }
     
     public static void leerArchivoPorPalabra(String nombre){
         String direccion = "src/main/java/datos/"+nombre;
         File archivo = new File(direccion);
         Scanner entrada = null;
         
        try {
          entrada = new Scanner(archivo);
          int cont = 0;
          while(entrada.hasNext()){
            String palabra = entrada.next();
            System.out.println(palabra);
            cont++;
          }
         System.out.println("Número de palabras: " + cont);
        } catch (FileNotFoundException ex) {
           
        }
     }
     
}
