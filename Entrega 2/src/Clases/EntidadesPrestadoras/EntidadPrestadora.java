package Clases.EntidadesPrestadoras;

import java.util.ArrayList;
import Clases.ServiciosPublicos.Entidad;
public class EntidadPrestadora {
    public String nombre;
    public Entidad entidad;
    public UsuarioEncargado usuarioEncargado;
    public ArrayList<OrganismoControl> organismosControl;
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
    public UsuarioEncargado getUsuarioEncargado() {
        return usuarioEncargado;
    }
    public void setUsuarioEncargado(UsuarioEncargado usuarioEncargado) {
        this.usuarioEncargado = usuarioEncargado;
    }
    public ArrayList<OrganismoControl> getOrganismosControl() {
        return organismosControl;
    }
    public void setOrganismosControl(ArrayList<OrganismoControl> organismosControl) {
        this.organismosControl = organismosControl;
    }
}

