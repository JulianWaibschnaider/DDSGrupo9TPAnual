package  com.Clases.Model.ComunidadesYMiembros;

import java.util.Scanner;

import  com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  com.Clases.Model.Shared.LlamadorDeAPI;
import  com.Clases.Model.Shared.Mensajero;
import com.Clases.Model.ComunidadesYMiembros.*;
import com.Clases.Model.JpaServicies.UsuarioServicie;
import jakarta.persistence.*;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String email;

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
