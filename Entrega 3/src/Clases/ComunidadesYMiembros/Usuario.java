package Clases.ComunidadesYMiembros;

import java.util.Scanner;

import Clases.Shared.LlamadorDeAPI;
import Clases.Shared.Mensajero;

public class Usuario {
    private String email;
    private Contrasenia contrasenia;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contrasenia getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia pass = new Contrasenia(contrasenia);
        if (pass.ValidarContrasenia())
            this.contrasenia = pass;
    }
    
    public static Boolean IniciarSesion() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Ingrese Email: ");
    	String email=s.nextLine();
   
    	System.out.println("Ingrese contraseña: ");
 		String contra = s.nextLine();
        s.close();
    return LlamadorDeAPI.llamarAuth0(email, contra);
    	
    }
    
    
}