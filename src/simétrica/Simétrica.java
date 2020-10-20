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
public class Simétrica {

    /**
     Metodo main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Control de ejecución
        boolean ejecutar = true;
        
        //Entrada de texto por linea
        Scanner entrada = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        
        //Menu principal
        menu.append("Menu\n");
        menu.append("Seleccione una opcion\n");
        menu.append("1. Criptografía Simetrica\n");
        menu.append("9. Salir");
        
        //Opcion a seleccionar de menú
        int option;
        
        //Mensaje y clave
        String mensaje;
        String clave;
        
        //Manager para control de criptografia y pronto asimetrica
        ManejadorCriptografia manejador = new ManejadorCriptografia();
        
        
        while(ejecutar){
            System.out.println(menu.toString());
            option = Integer.parseInt(entrada.nextLine());
            
            switch(option){
                
                case 1:
                    manejador.criptografiaSimetrica();
                    
                    break;
                
                case 9:
                    ejecutar = false;
                    break;
                
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
    
}
