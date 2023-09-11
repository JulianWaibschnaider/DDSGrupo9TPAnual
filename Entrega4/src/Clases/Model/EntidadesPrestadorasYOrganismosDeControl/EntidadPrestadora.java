package Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.ArrayList;
import Clases.Model.IncidentesYNotificaciones.Incidente;
import Clases.Model.RankingsEInformes.Informe;
import Clases.Model.ServiciosPublicos.Entidad;
import javax.persistence.*;

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
    private ArrayList<OrganismoDeControl> organismosDeControl;

    @ManyToMany
    @JoinTable(name = "InfXEPres", joinColumns = @JoinColumn(name = "idEntidadPrestadora"), inverseJoinColumns = @JoinColumn(name = "idInforme"))
    private ArrayList<Informe> informes;

    @ManyToMany
    @JoinTable(name = "IncXEPres", joinColumns = @JoinColumn(name = "idEntidadPrestadora"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
    private ArrayList<Incidente> incidentes;

    public ArrayList<Informe> getInformes() {
        return informes;
    }

    public void setInformes(ArrayList<Informe> informes) {
        this.informes = informes;
    }

    public void addInforme() {
        Informe informe = new Informe();
        informe.Generar();
        this.informes.add(informe);
    }

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

    public ArrayList<OrganismoDeControl> getOrganismosDeControl() {
        return organismosDeControl;
    }

    public void setOrganismosDeControl(ArrayList<OrganismoDeControl> organismosDeControl) {
        this.organismosDeControl = organismosDeControl;
    }
}
