package Clases.Model.EntidadesPrestadorasYOrganismosDeControl;
import javax.persistence.*;
@Entity
@Table(name="PersonaEncargada")

public class PersonaEncargada {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPersonaEncargada;
    private String nombre;
    private String apellido;
    
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
