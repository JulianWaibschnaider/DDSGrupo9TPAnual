package Clases.Shared;

public class Mensajero {
    
    public static void MensajeContrasenia(int codigo) {
        if(codigo == 1)
            System.out.println("Su contrasenia es segura.");
        else if(codigo == -1)
         System.out.println("Su contrasenia es débil. Por favor, elija otra contrasenia."); 
    }
}
