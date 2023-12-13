package  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.List;
import  com.Clases.Model.IncidentesYNotificaciones.Incidente;
import  com.Clases.Model.RankingsEInformes.Informe;
import  com.Clases.Model.ServiciosPublicos.Entidad;
import jakarta.persistence.*;

@Entity
@Table(name = "EntidadPrestadora")

public class EntidadPrestadora {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEntidadPrestadora;
    private String nombre;

    @OneToOne
    @JoinColumn(name = "idEntidad")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "idPersonaEncargada")
    private PersonaEncargada personaEncargada;

    @ManyToMany
   	@JoinTable(name = "OrCrlXEPres", joinColumns = @JoinColumn(name = "idEntidadPrestadora"), inverseJoinColumns = @JoinColumn(name = "idOrganismoDeControl"))
    private List<OrganismoDeControl> organismosDeControl;



    @ManyToMany
    @JoinTable(name = "IncXEPres", joinColumns = @JoinColumn(name = "idEntidadPrestadora"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
    private List<Incidente> incidentes;

    



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public PersonaEncargada getPersonaEncargada() {
        return personaEncargada;
    }

    public void setPersonaEncargada(PersonaEncargada personaEncargada) {
        this.personaEncargada = personaEncargada;
    }

    public List<OrganismoDeControl> getOrganismosDeControl() {
        return organismosDeControl;
    }

    public void setOrganismosDeControl(List<OrganismoDeControl> organismosDeControl) {
        this.organismosDeControl = organismosDeControl;
    }
}
