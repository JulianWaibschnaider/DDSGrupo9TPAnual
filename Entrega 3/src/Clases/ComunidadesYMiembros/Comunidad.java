package Clases.ComunidadesYMiembros;

import java.util.ArrayList;
import Clases.Servicios.Servicio;
import Clases.ServiciosPublicos.Entidad;
import java.util.Date; 
import Clases.IncidentesYNotificaciones.Incidente;

public class Comunidad {
	private String nombre;
	private ArrayList<Persona> usuariosObservadores;
    private ArrayList<Persona> usuariosAfectados;
    private ArrayList<Persona> administradoresComunidad;
    private ArrayList<Persona> miembrosComunidad;
    private ArrayList<Servicio> servicios;
    private ArrayList<Incidente> incidentes;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Persona> getUsuariosObservadores() {
        return usuariosObservadores;
    }
    public void setUsuariosObservadores(ArrayList<Persona> usuariosObservadores) {
        this.usuariosObservadores = usuariosObservadores;
    }
    public ArrayList<Persona> getUsuariosAfectados() {
        return usuariosAfectados;
    }
    public void setUsuariosAfectados(ArrayList<Persona> usuariosAfectados) {
        this.usuariosAfectados = usuariosAfectados;
    }
    public ArrayList<Persona> getAdministradoresComunidad() {
        return administradoresComunidad;
    }
    public void setAdministradoresComunidad(ArrayList<Persona> administradoresComunidad) {
        this.administradoresComunidad = administradoresComunidad;
    }
    public ArrayList<Persona> getMiembrosComunidad() {
        return miembrosComunidad;
    }
    public void setMiembrosComunidad(ArrayList<Persona> miembrosComunidad) {
        this.miembrosComunidad = miembrosComunidad;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    public ArrayList<Incidente> getIncidentes() {
        return incidentes;
    }
    public void setIncidentes(ArrayList<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
}