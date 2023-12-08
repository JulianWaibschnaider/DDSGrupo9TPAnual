package  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;
import jakarta.persistence.*;
import com.Clases.Model.ComunidadesYMiembros.Usuario;
@Entity
@Table(name="PersonaEncargada")

public class PersonaEncargada {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPersonaEncargada;
    private String nombre;
    private String apellido;
    private String Email;
    @OneToOne
	@JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
