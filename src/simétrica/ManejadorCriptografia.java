/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simétrica;

import java.util.Scanner;

/**
 *
 * @author LuisEnrique
 */
public class ManejadorCriptografia {
    
    //Mensaje a encriptar
    String mensaje;
    
    //Datos de entrada por linea de comandos
    Scanner entrada;
    
    //Opcion seleccionada
    int option;
    
    public ManejadorCriptografia(){
        entrada = new Scanner(System.in);
    }
    
    //Metodo que maneja las opciones relacionadas a criptografia simetrica
    
    public void criptografiaSimetrica(){
        
        //Obtener instaica de criptografiaSimetricaa
        CriptografiaSimetrica cSimetrica = CriptografiaSimetrica.obtenerInstancia();
        String clave = "";
        
        //Control de ejecucion
        boolean ejecutar = true;
        String submenu = cSimetrica.generarMenuOpciones();
        
        while(ejecutar){
            //Mostrar menu
            System.out.println(submenu);
            option = Integer.parseInt(entrada.nextLine());
            
            switch(option){
                //Asignar nueva clave
                case 1:
                    System.out.println("Ingrese la nueva clave");
                    clave = entrada.nextLine();
                    cSimetrica.setPassword(clave);
                    break;
                
                //Encriptar mensaje
                case 2:
                    System.out.println("Ingrese el mensaje");
                    mensaje = entrada.nextLine();
                    cSimetrica.cifrarMensaje(mensaje);
                    break;
                    
                //Desencriptar mensaje
                case 3:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje original es: " + cSimetrica.descifrarMensaje(clave));
                    break;
                    
                //Mostrar mensaje encriptado
                case 4:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje encriptado es: " + cSimetrica.getMsj(clave));
                    break;
                    
                
                //Salir de cifrado simetrico
                case 9:
                    ejecutar = false;
                    break;
                default:
                    System.out.println("\nOpcion incorrecta\n");
                    break;
                    
            }
            System.out.println("\n");
        }
    }
    
}
