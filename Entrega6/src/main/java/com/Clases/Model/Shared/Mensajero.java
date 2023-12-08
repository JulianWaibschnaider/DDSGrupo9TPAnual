package  com.Clases.Model.Shared;

import java.util.Scanner;

public class Mensajero {
    
    public static void MensajeContrasenia(int codigo) {
        if(codigo == 1)
            System.out.println("Su contrasenia es segura.");
        else if(codigo == -1)
         System.out.println("Su contrasenia es débil. Por favor, elija otra contrasenia."); 
    }

    public static String IngresarMensaje(String salida){
        System.out.println(salida);
		Scanner s = new Scanner(System.in);
		String entrada = s.nextLine();
        s.close();
        return entrada;
    }
}
