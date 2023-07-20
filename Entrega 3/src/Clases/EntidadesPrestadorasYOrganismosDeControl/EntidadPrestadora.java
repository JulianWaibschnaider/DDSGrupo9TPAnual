package Clases.EntidadesPrestadorasYOrganismosDeControl;

import java.util.ArrayList;
import Clases.IncidentesYNotificaciones.Incidente;
import Clases.RankingsEInformes.Informe;
import Clases.ServiciosPublicos.Entidad;

public class EntidadPrestadora {
    public String nombre;
    public Entidad entidad;
    public PersonaEncargada personaEncargada;
    public ArrayList<OrganismoDeControl> organismosDeControl;
    public ArrayList<Informe> informes;
    public ArrayList<Incidente> incidentes;

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

