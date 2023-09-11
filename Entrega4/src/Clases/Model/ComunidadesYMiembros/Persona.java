package Clases.Model.ComunidadesYMiembros;

import java.time.LocalDate;
import java.util.ArrayList;
import Clases.Model.Servicios.Servicio;
import Clases.Model.ServiciosPublicos.Entidad;
import Clases.Model.ServiciosPublicos.UbicacionGeografica;

import java.util.Date;
import Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import Clases.Model.IncidentesYNotificaciones.Incidente;
import Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import Clases.Model.IncidentesYNotificaciones.NotificacionDeIncidente;
import Clases.Model.IncidentesYNotificaciones.NotificacionDeRevisionManual;
import Clases.Model.Shared.Mensajero;
import Clases.Model.Servicios.RepositorioServicios;
import javax.persistence.*;

@Entity
@Table(name = "Persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private String nroTelefono;
	@ManyToMany
	@JoinTable(name = "PersonasXComunidad", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idComunidad"))
	private ArrayList<Comunidad> comunidades;

	@ManyToMany
	@JoinTable(name = "ServiciosXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idServicio"))
	private ArrayList<Servicio> serviciosDeInteres;

	@ManyToMany
	@JoinTable(name = "EntidadesXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idEntida"))
	private ArrayList<Entidad> serviciosPublicosDeInteres;

	@OneToOne
	@JoinColumn(name = "idLocalizacion")
	private Localizacion localizacionDeInteres;

	@OneToOne
	@JoinColumn(name = "idUbicacionGeografica")
	private UbicacionGeografica localizacionActual;

	@ManyToMany
	@JoinTable(name = "IncidentesXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
	private ArrayList<Incidente> incidentes;

	@OneToOne
	@JoinColumn(name = "idTipoMedioComunicacion")
	private TipoMedioComunicacion medioDeComunicacionElegido;
	
	@OneToMany
	@JoinTable(name = "HorariosDeDisponibilidadXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "Horarios"))
	private ArrayList<LocalDate> horariosDeDisponibilidad;// son horarios (momentos) especificos en los que se le puede
															// notificar, NO en un rango
	@ManyToMany
	@JoinTable(name = "EntidadesPrestadorasXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idEntidadPrestadora"))
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

	public UbicacionGeografica getLocalizacionActual() {
		return localizacionActual;
	}

	public void setLocalizacionActual(UbicacionGeografica localizacionActual) {
		this.localizacionActual = localizacionActual;
		NotificarCercaniaAIncidente();
		// si esta cerca del servicio de un incidente, se le notifica para que vaya a revisarlo manualmente
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
		ArrayList<Incidente> incidentes = new ArrayList<Incidente>();
		if (_estado) {
			incidentes = RepositorioIncidentes.GetIncidentesPorEstado(true);
		} else {
			incidentes = RepositorioIncidentes.GetIncidentesPorEstado(false);
		}

		return incidentes;
	}

	public void NotificarIncidente(Incidente incidente) {
		NotificacionDeIncidente notificacion = new NotificacionDeIncidente(incidente, false);
		if (this.medioDeComunicacionElegido == TipoMedioComunicacion.EMAIL) {
			notificacion.enviarNotificacionCorreo(this.email);
		} else if (this.medioDeComunicacionElegido == TipoMedioComunicacion.WHATSAPP) {
			notificacion.enviarNotificacionWhatsApp(this.nroTelefono);
		}

	}

	private void NotificarCercaniaAIncidente() {
		Incidente incidenteCercano = RepositorioIncidentes.BuscarLocalizacionCercana(this.localizacionActual);
		if (incidenteCercano != null) {
			NotificacionDeRevisionManual notificacionDeRevisionManual = new NotificacionDeRevisionManual(
					incidenteCercano, false);
			if (this.medioDeComunicacionElegido == TipoMedioComunicacion.EMAIL) {
				notificacionDeRevisionManual.enviarNotificacionCorreo(this.email);
			} else if (this.medioDeComunicacionElegido == TipoMedioComunicacion.WHATSAPP) {
				notificacionDeRevisionManual.enviarNotificacionWhatsApp(this.nroTelefono);
			}
		}
	}

}