package Clases.EntidadesPrestadorasYOrganismosDeControl;
import java.util.ArrayList;
import Clases.RankingsEInformes.Informe;

public class OrganismoDeControl{

    private String nombre;
    private ArrayList<EntidadPropietaria> entidadesPropietarias;
    private PersonaEncargada personaEncargada;
    private ArrayList<Informe> informes;
    
    public ArrayList<Informe> getInformes() {
        return informes;
    }
    public void setInformes(ArrayList<Informe> informes) {
        this.informes = informes;
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