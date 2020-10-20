/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simétrica;

/**
 *
 * @author LuisEnrique
 */
public class CriptografiaSimetrica {
    
    //Variable estatica para manejar nuestra instancia de clase estilo singleton
    private static CriptografiaSimetrica instancia = null;
    
    
    //Password de encriptacion
    private String password;
    
    //Mensaje
    private String msj;
    
    //Constructor
    private CriptografiaSimetrica(){
        //Valores por defecto
        msj = null;
        password = "634";
    }
    
    //Metodo para obtener instancia singleton
    public static CriptografiaSimetrica obtenerInstancia() {
        if(instancia == null){
            instancia = new CriptografiaSimetrica();
        }
        return instancia;
    }
    
    //Meotodos relacionados con proceso de criptologia
    //Metodo para asignar contraseña
    public void setPassword(String password){
        
        /*Se debe tener en cuenta que si ya existe un mensaje previamente 
        guardado, se debe descifrar primero para obtenerlo en su forma origina, 
        ya que si cambiamos la clabe y no desciframos mensaje antes de 
        esto, ya no podremos descifrarlo con la nueva clave, 
        nos arrojara un resultado erroneo*/
        if(msj != null)
            descifrarMensaje(this.password);
        
        //Asignar nuevo password
        this.password = password;
        
        /*Se debe validar si existe mensaje (previamente desencriptado), para
        volver a encriptar con la nueva clave*/
        if(msj != null)
            cifrarMensaje(msj);
    }
    
    /*Metodo que permite asignar un nuevo mensaje y encriptarlo.
      Recibe como parametro el mensaje a encriptar*/
    
    public void setMsj(String msj){
        //Llamado al metodo de encriptacion
        this.msj = cifrarMensaje(msj);
    }
    
    /*Metodo para obtener y visualizar el mensaje en el estado que este
    se encuente (Encriptado o no), validando de antemano la clave.*/
    
    public String getMsj(String clave){
        if(msj == null)
            return "Error. No hay un mensaje configurado\n";
        if(!clave.equals(password))
            return "Clave incorrecta\n";
        return msj;
    }
    
    protected String cifrarMensaje(String msj){
        
        //Dividimos mensaje en caracteres que lo componen
        String caracteres[] = msj.split("");
        
        //Contador
        int i = 0;
        
        //Contador de longitud de contraseña
        int max = password.length() - 1;
        
        //Dividimos contraseña en caracteres
        String pass[] = password.split("");
        
        //Buffer para mensaje encriptado
        StringBuffer cripto_pass = new StringBuffer();
        
        //Recorremos cada caracter del mensaje y lo asociamos con un numero de la contraseña
        for(String caracter : caracteres){
            
            /*Si el mensaje es mas extenso que la contrasela, reiniciamos la
            asignacion de digitos de la contraseña*/
            if(i > max){
                i = 0;
            }
            
            /*Aqui se obtiene el nuevo caracter al desplazar a la derecha, tantas
            posiciones como lo indique el digito asociado de la contraseña, el
            caracter original del mensaje*/
            
            cripto_pass.append((char) ((int) caracter.charAt(0) + Integer.parseInt(pass[i])));
            
            //Desplasamiento al siguiente digito de contraseña
            i++;
        }
        
        //Se asigna nuevo mensaje encriptado a variable (atributo) msj
        this.msj = cripto_pass.toString();
        return this.msj;    
    }
    
    /*Metodo que returna el mensaje descifrado*/
    protected String descifrarMensaje(String clave){
        //Validacion de clave
        if(!clave.equals(password)){
            return "clave incorrecta\n";
        }
        
        //Obtener digitos de contraseña
        String caracteres[] = msj.split("");
        
        //Variable de control iguale que metodo de cifrado
        int i = 0;
        int max = password.length() - 1;
        String pass[] = password.split("");
        
        //Buffer para almacenar caracteres de mensaje descifrado
        StringBuffer decripto_pass = new StringBuffer();
        for(String caracter : caracteres){
            if(i > max){
                i = 0;
            }
            
            /*Para el caso de descifrar, el desplazamiento en el codigo ASCII
            se realiza hacia la izquierda, esto es devolviendo las posiciones
            que indica la clave, en dicho codigo*/
            decripto_pass.append((char) ((int) caracter.charAt(0) - Integer.parseInt(pass[i])));
            i++;
        }
        
        //Se asigna mensaje decodificado
        this.msj = decripto_pass.toString();
        
        //Retorna mensaje
        return this.msj;
    }
    
    /*Metodo que construye menu de opciones para criptografia simetrica.*/
    public String generarMenuOpciones(){
        StringBuilder menu = new StringBuilder();
        
        menu.append("\n\n");
        menu.append("**Criptologia Simetrica**");
        menu.append("\n");
        menu.append("--Menu--");
        menu.append("\n");
        menu.append("1. Cambiar clave\n");
        menu.append("2. Encriptar Mensaje\n");
        menu.append("3. Desencriptar\n");
        menu.append("4. Ver mensaje\n");
        menu.append("9. Regresar\n");
        
        return menu.toString();
    }
    
}
