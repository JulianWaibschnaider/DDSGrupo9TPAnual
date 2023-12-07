package main.java.com.Clases.Model.ComunidadesYMiembros;

import java.time.LocalDate;
import java.util.List;
import main.java.com.Clases.Model.Servicios.Servicio;
import main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;

import java.util.Date;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import main.java.com.Clases.Model.IncidentesYNotificaciones.NotificacionDeIncidente;
import main.java.com.Clases.Model.IncidentesYNotificaciones.NotificacionDeRevisionManual;
import main.java.com.Clases.Model.Shared.Mensajero;
import main.java.com.Clases.Model.Servicios.RepositorioServicios;
import jakarta.persistence.*;

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
	private List<Comunidad> comunidades;

	@ManyToMany
	@JoinTable(name = "ServiciosXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idServicio"))
	private List<Servicio> serviciosDeInteres;

	@ManyToMany
	@JoinTable(name = "EntidadesXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idEntida"))
	private List<Entidad> serviciosPublicosDeInteres;

	@OneToOne
	@JoinColumn(name = "idLocalizacion")
	private Localizacion localizacionDeInteres;

	@OneToOne
	@JoinColumn(name = "idUbicacionGeografica")
	private UbicacionGeografica localizacionActual;

	@ManyToMany
	@JoinTable(name = "IncidentesXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
	private List<Incidente> incidentes;

	@Enumerated(EnumType.ORDINAL)
	private TipoMedioComunicacion medioDeComunicacionElegido;

	private Boolean EsAfectado;
	// @JoinTable(name = "HorariosDeDisponibilidadXPersona", joinColumns =
	// @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name =
	// "Horarios"))
	@ElementCollection
	@CollectionTable(name = "horarios_de_disponibilidad", joinColumns = @JoinColumn(name = "idPersona"))
	@Column(name = "horario_disponibilidad")
	private List<LocalDate> horariosDeDisponibilidad;// son horarios (momentos) especificos en los que se le puede
														// notificar, NO en un rango
	@ManyToMany
	@JoinTable(name = "EntidadesPrestadorasXPersona", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idEntidadPrestadora"))
	private List<EntidadPrestadora> recibirNotificacionesDe;

	public void setEsAfectado(Comunidad comunidad) {
		this.EsAfectado = comunidad.ExisteUsuarioAfectado(idPersona);
	}

	public Boolean getEsAfectado() {
		return EsAfectado;
	}

	public int getIdPersona() {
		return idPersona;
	}

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

	public List<Comunidad> getComunidades() {
		return comunidades;
	}

	public void setComunidades(List<Comunidad> comunidades) {
		this.comunidades = comunidades;
	}

	public List<Servicio> getServiciosDeInteres() {
		return serviciosDeInteres;
	}

	public void setServiciosDeInteres(List<Servicio> serviciosDeInteres) {
		this.serviciosDeInteres = serviciosDeInteres;
	}

	public List<Entidad> getServiciosPublicosDeInteres() {
		return serviciosPublicosDeInteres;
	}

	public void setServiciosPublicosDeInteres(List<Entidad> serviciosPublicosDeInteres) {
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
		// si esta cerca del servicio de un incidente, se le notifica para que vaya a
		// revisarlo manualmente
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public TipoMedioComunicacion getMedioDeComunicacionElegido() {
		return medioDeComunicacionElegido;
	}

	public void setMedioDeComunicacionElegido(TipoMedioComunicacion medioDeComunicacionElegido) {
		this.medioDeComunicacionElegido = medioDeComunicacionElegido;
	}

	public List<LocalDate> getHorariosDeDisponibilidad() {
		return horariosDeDisponibilidad;
	}

	public void setHorariosDeDisponibilidad(List<LocalDate> horariosDeDisponibilidad) {
		this.horariosDeDisponibilidad = horariosDeDisponibilidad;
	}

	public List<EntidadPrestadora> getRecibirNotificacionesDe() {
		return recibirNotificacionesDe;
	}

	public void setRecibirNotificacionesDe(List<EntidadPrestadora> recibirNotificacionesDe) {
		this.recibirNotificacionesDe = recibirNotificacionesDe;
	}

	public void definirRolEn(Comunidad comunidad, Boolean rol) {
		// true es usuario afectado y false es usuario observador
		if (rol) {
			if (!comunidad.ExisteUsuarioAfectado(idPersona)) {
				comunidad.addUsuariosAfectados(this);
				comunidad.deleteUsuariosObservadores(this);
			}
		} else {
			if (!comunidad.ExisteUsuarioObservador(idPersona))
				comunidad.addUsuariosObservadores(this);
			comunidad.deleteUsuariosAfectados(this);
		}
		this.setEsAfectado(comunidad);
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
		List<Comunidad> comunidades = _incidente.getComunidades();
		for (Comunidad comunidad : comunidades) {
			comunidad.QuitarIncidente(_incidente);
		}
	}

	public List<Incidente> ObtenerIncidentesPorEstado(Boolean _estado) {
		List<Incidente> incidentes;
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