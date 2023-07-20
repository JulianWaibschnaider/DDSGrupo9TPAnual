package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;
import Clases.ComunidadesYMiembros.Persona;
import Clases.ComunidadesYMiembros.Comunidad;
import java.util.Date; 
import Clases.Servicios.Servicio;


public class Incidente {
	private Persona persona;
	private String observaciones;
    private Servicio servicio;
    private Boolean estado;
    private ArrayList<Comunidad> comunidades;
    private Date horarioApertura;
    private Date horarioCierre;

    public static void Abrir() {
		
	}

    public static void Cerrar() {
		
    }
}
