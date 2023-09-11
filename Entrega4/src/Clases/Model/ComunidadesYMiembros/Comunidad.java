package Clases.Model.ComunidadesYMiembros;

import java.time.LocalDate;
import java.util.ArrayList;
import Clases.Model.Servicios.Servicio;
import Clases.Model.ServiciosPublicos.Entidad;
import java.util.Date;
import Clases.Model.IncidentesYNotificaciones.Incidente;
import Clases.Model.IncidentesYNotificaciones.Observer;
import Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import javax.persistence.*;
@Entity
@Table(name="Comunidad")
public class Comunidad implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComunidad;
    private String nombre;

    @ManyToMany(mappedBy = "comunidades")
    private ArrayList<Persona> usuariosObservadores;
    private ArrayList<Persona> usuariosAfectados;
    private ArrayList<Persona> administradoresComunidad;
    private ArrayList<Persona> miembrosComunidad;
    @ManyToMany
    @JoinTable(name = "ServiciosXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idServicio"))
    private ArrayList<Servicio> servicios;
    @ManyToMany
    @JoinTable(name = "IncidentesXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
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

    public void addUsuariosObservadores(Persona persona) {
        this.usuariosObservadores.add(persona);
    }

    public ArrayList<Persona> getUsuariosAfectados() {
        return usuariosAfectados;
    }

    public void setUsuariosAfectados(ArrayList<Persona> usuariosAfectados) {
        this.usuariosAfectados = usuariosAfectados;
    }

    public void addUsuariosAfectados(Persona persona) {
        this.usuariosAfectados.add(persona);
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

    public void AgregarIncidente(Incidente incidente) {
        this.incidentes.add(incidente);
    }

    public void QuitarIncidente(Incidente incidente) {
        this.incidentes.remove(incidente);
    } 

    @Override
    public void NotificarIncidente(Incidente incidente) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.addAll(this.usuariosAfectados);
        personas.addAll(this.usuariosObservadores);
        
        for (Persona persona : personas) {
            if (persona.getHorariosDeDisponibilidad().stream().anyMatch(horario -> horario.equals(LocalDate.now()))
                    && (incidente.getEstado() == true)) {
                persona.NotificarIncidente(incidente);
            } else if (incidente.getEstado() == true) {
                RepositorioIncidentes.addIncidenteNoEnviado(incidente);
                //falta hacer que los que no envio, vuelva a consultar en el proximo horario
            }
        }
    }
}