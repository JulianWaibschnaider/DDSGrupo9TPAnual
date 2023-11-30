package  main.java.com.Clases.Model.ComunidadesYMiembros;

import java.util.Scanner;

import  main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  main.java.com.Clases.Model.Shared.LlamadorDeAPI;
import  main.java.com.Clases.Model.Shared.Mensajero;
import main.java.com.Clases.Model.ComunidadesYMiembros.*;
import main.java.com.Clases.Model.JpaServicies.UsuarioServicie;
import jakarta.persistence.*;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String email;
    @OneToOne
	@JoinColumn(name = "idUbicacionGeografica")
    @Embedded
    private UbicacionGeografica localizacionActual;
	@OneToOne
	@JoinColumn(name = "idContrasenia")
	@Embedded
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
    
    
    
}