package  main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;
import jakarta.persistence.*;
import java.util.List;
import  main.java.com.Clases.Model.RankingsEInformes.Informe;

@Entity
@Table(name = "OrganismoDeControl")

public class OrganismoDeControl {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOrganismoDeControl;
    private String nombre;
    
    @ManyToMany
    @JoinTable(name = "EPropXOrCrl", joinColumns = @JoinColumn(name = "idOrganismoDeControl"), inverseJoinColumns = @JoinColumn(name = "idEntidadPropietaria"))
    private List<EntidadPropietaria> entidadesPropietarias;

    @ManyToOne
    @JoinColumn(name = "idPersonaEncargada")
    private PersonaEncargada personaEncargada;

   /* private List<Informe> informes;

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }

    public void addInforme() {
        Informe informe = new Informe();
        informe.Generar();
        this.informes.add(informe);
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EntidadPropietaria> getEntidadesPropietarias() {
        return entidadesPropietarias;
    }

    public void setEntidadesPropietarias(List<EntidadPropietaria> entidadesPropietarias) {
        this.entidadesPropietarias = entidadesPropietarias;
    }

    public PersonaEncargada getPersonaEncargada() {
        return personaEncargada;
    }

    public void setPersonaEncargada(PersonaEncargada personaEncargada) {
        this.personaEncargada = personaEncargada;
    }

}