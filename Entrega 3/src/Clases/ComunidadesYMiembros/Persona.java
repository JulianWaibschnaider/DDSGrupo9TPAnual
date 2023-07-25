package Clases.ComunidadesYMiembros;

import java.time.LocalDate;
import java.util.ArrayList;
import Clases.Servicios.Servicio;
import Clases.ServiciosPublicos.Entidad;
import java.util.Date;
import Clases.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import Clases.IncidentesYNotificaciones.Incidente;
import Clases.IncidentesYNotificaciones.RepositorioIncidentes;
import Clases.IncidentesYNotificaciones.NotificacionDeIncidente;
import Clases.Shared.Mensajero;

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
	private TipoMedioComunicacion medioDeComunicacionElegido;
	private ArrayList<LocalDate> horariosDeDisponibilidad;//son horarios (momentos) especificos en los que se le puede notificar, NO en un rango
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

	public TipoMedioComunicacion getMedioDeComunicacionElegido() {
		return medioDeComunicacionElegido;
	}

	public void setMedioDeComunicacionElegido(TipoMedioComunicacion medioDeComunicacionElegido) {
		this.medioDeComunicacionElegido = medioDeComunicacionElegido;
	}

	public ArrayList<LocalDate> getHorariosDeDisponibilidad() {
		return horariosDeDisponibilidad;
	}

	public void setHorariosDeDisponibilidad(ArrayList<LocalDate> horariosDeDisponibilidad) {
		this.horariosDeDisponibilidad = horariosDeDisponibilidad;
	}

	public ArrayList<EntidadPrestadora> getRecibirNotificacionesDe() {
		return recibirNotificacionesDe;
	}

	public void setRecibirNotificacionesDe(ArrayList<EntidadPrestadora> recibirNotificacionesDe) {
		this.recibirNotificacionesDe = recibirNotificacionesDe;
	}

	public void definirRolEn(Comunidad comunidad, Boolean rol) {
		// true es usuario afectado y false es usuario observador
		if (rol) {
			comunidad.addUsuariosAfectados(this);
		} else {
			comunidad.addUsuariosObservadores(this);
		}
	}

	public void AbrirIncidente(Servicio _servicio) {
		Incidente incidente = new Incidente();
		String _observaciones = Mensajero.IngresarMensaje("Ingrese las observaciones del incidente:");
		incidente.Abrir(this.getEmail(), _observaciones, _servicio);
		this.incidentes.add(incidente);

		for (Comunidad comunidad : comunidades) {
			comunidad.AgregarIncidente(incidente);
			
		}
	}

	public void CerrarIncidente(Incidente _incidente) {
		_incidente.Cerrar();
		ArrayList<Comunidad> comunidades = _incidente.getComunidades();
		for (Comunidad comunidad : comunidades) {
			comunidad.QuitarIncidente(_incidente);
		}
	}

	public ArrayList<Incidente> ObtenerIncidentesPorEstado(Boolean _estado) {
		ArrayList<Incidente> incidentes =  new ArrayList<Incidente>();	
		if (_estado) {
			 incidentes = RepositorioIncidentes.GetIncidentesPorEstado(true);
		} else {
			 incidentes = RepositorioIncidentes.GetIncidentesPorEstado(false);
		}

		return incidentes;
	}

	public void NotificarIncidente(Incidente incidente){
		NotificacionDeIncidente notificacion = new NotificacionDeIncidente(incidente, false);
		if(this.medioDeComunicacionElegido== TipoMedioComunicacion.EMAIL){
			notificacion.enviarNotificacionCorreo(this.email);
		}else if(this.medioDeComunicacionElegido== TipoMedioComunicacion.WHATSAPP){
			notificacion.enviarNotificacionWhatsApp(this.nroTelefono);
		}
		
	}

}