package Clases.Model.EntidadesPrestadorasYOrganismosDeControl;
import javax.persistence.*;
import java.util.ArrayList;
import Clases.Model.RankingsEInformes.Informe;

@Entity
@Table(name = "OrganismoDeControl")

public class OrganismoDeControl {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOrganismoDeControl;
    private String nombre;
    
    @ManyToMany
    @JoinTable(name = "EPropXOrCrl", joinColumns = @JoinColumn(name = "idOrganismoDeControl"), inverseJoinColumns = @JoinColumn(name = "idEntidadPropietaria"))
    private ArrayList<EntidadPropietaria> entidadesPropietarias;

    @ManyToOne
    @JoinColumn(name = "idPersonaEncargada")
    private PersonaEncargada personaEncargada;

    private ArrayList<Informe> informes;

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

    public ArrayList<EntidadPropietaria> getEntidadesPropietarias() {
        return entidadesPropietarias;
    }

    public void setEntidadesPropietarias(ArrayList<EntidadPropietaria> entidadesPropietarias) {
        this.entidadesPropietarias = entidadesPropietarias;
    }

    public PersonaEncargada getPersonaEncargada() {
        return personaEncargada;
    }

    public void setPersonaEncargada(PersonaEncargada personaEncargada) {
        this.personaEncargada = personaEncargada;
    }

}