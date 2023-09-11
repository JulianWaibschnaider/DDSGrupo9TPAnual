package Clases.Model.ComunidadesYMiembros;

import java.util.Scanner;

import Clases.Model.ServiciosPublicos.UbicacionGeografica;
import Clases.Model.Shared.LlamadorDeAPI;
import Clases.Model.Shared.Mensajero;
import javax.persistence.*;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String email;
	@OneToOne
	@JoinColumn(name = "idContrasenia")
	private UbicacionGeografica localizacionActual;
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