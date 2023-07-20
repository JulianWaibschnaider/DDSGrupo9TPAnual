package Clases.ComunidadesYMiembros;

import java.util.ArrayList;
import Clases.Servicios.Servicio;
import Clases.ServiciosPublicos.Entidad;
import java.util.Date;
import Clases.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import Clases.IncidentesYNotificaciones.Incidente;

public class Persona {
	private String nombre;
	private String apellido;
	private String email;
	private String nroTelefono;
	private ArrayList<Comunidad> comunidades;
	private ArrayList<Servicio> serviciosDeInteres;
	private ArrayList<Entidad> serviciosPublicosDeInteres;
	private Localizacion localizacionDeInteres;
	private Localizacion localizacionActual;
	private ArrayList<Incidente> incidentes;
	private TipoMedioComunicacion medioDeComunicacionElegiddo;
	private ArrayList<Date> horariosDeDisponibilidad;	
	private ArrayList<EntidadPrestadora> recibirNotificacionesDe;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public ArrayList<Comunidad> getComunidades() {
		return comunidades;
	}

	public void setComunidades(ArrayList<Comunidad> comunidades) {
		this.comunidades = comunidades;
	}

	public ArrayList<Servicio> getServiciosDeInteres() {
		return serviciosDeInteres;
	}

	public void setServiciosDeInteres(ArrayList<Servicio> serviciosDeInteres) {
		this.serviciosDeInteres = serviciosDeInteres;
	}

	public ArrayList<Entidad> getServiciosPublicosDeInteres() {
		return serviciosPublicosDeInteres;
	}

	public void setServiciosPublicosDeInteres(ArrayList<Entidad> serviciosPublicosDeInteres) {
		this.serviciosPublicosDeInteres = serviciosPublicosDeInteres;
	}

	public Localizacion getLocalizacionDeInteres() {
		return localizacionDeInteres;
	}

	public void setLocalizacionDeInteres(Localizacion localizacionDeInteres) {
		this.localizacionDeInteres = localizacionDeInteres;
	}

	public Localizacion getLocalizacionActual() {
		return localizacionActual;
	}

	public void setLocalizacionActual(Localizacion localizacionActual) {
		this.localizacionActual = localizacionActual;
	}

	public ArrayList<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(ArrayList<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public TipoMedioComunicacion getMedioDeComunicacionElegiddo() {
		return medioDeComunicacionElegiddo;
	}

	public void setMedioDeComunicacionElegiddo(TipoMedioComunicacion medioDeComunicacionElegiddo) {
		this.medioDeComunicacionElegiddo = medioDeComunicacionElegiddo;
	}

	public ArrayList<Date> getHorariosDeDisponibilidad() {
		return horariosDeDisponibilidad;
	}

	public void setHorariosDeDisponibilidad(ArrayList<Date> horariosDeDisponibilidad) {
		this.horariosDeDisponibilidad = horariosDeDisponibilidad;
	}

	public ArrayList<EntidadPrestadora> getRecibirNotificacionesDe() {
		return recibirNotificacionesDe;
	}

	public void setRecibirNotificacionesDe(ArrayList<EntidadPrestadora> recibirNotificacionesDe) {
		this.recibirNotificacionesDe = recibirNotificacionesDe;
	}

	public void definirRolEn(Comunidad comunidad){

	}


}