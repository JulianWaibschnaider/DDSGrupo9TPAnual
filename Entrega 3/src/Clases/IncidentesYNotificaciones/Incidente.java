package Clases.IncidentesYNotificaciones;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date; 
import Clases.ComunidadesYMiembros.Persona;
import Clases.ComunidadesYMiembros.RepositorioPersonas;
import Clases.ComunidadesYMiembros.Comunidad;
import Clases.Servicios.Servicio;


public class Incidente {
	private Persona persona;
	private String observaciones;
    private Servicio servicio;
    private Boolean estado;//true es abierto y false es cerrado
    private ArrayList<Comunidad> comunidades;
    private LocalDateTime horarioApertura;
    private LocalDateTime horarioCierre;

    public void Abrir(String _email, String _observaciones, Servicio _servicio) {
        this.persona = RepositorioPersonas.buscarPersona(_email);
        this.observaciones = _observaciones;
        this.servicio = _servicio;
        this.servicio.setEnFuncionamiento(false); //ponemos el servicio fuera de servicio
        this.comunidades = persona.getComunidades();
        this.horarioApertura = LocalDateTime.now();                 
        this.horarioCierre = null;
        this.estado = true;
	}

    public void Cerrar() {
		this.servicio.setEnFuncionamiento(true);//ponemos el servicio en funcionamiento nuevamente
        this.estado = false;
        this.horarioCierre = LocalDateTime.now();
    }

    public ArrayList<Comunidad> getComunidades() {
        return comunidades;
    }

    public Boolean getEstado(){
        return estado;
    }
}
