package main.java.com.Clases.Model.ComunidadesYMiembros;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.FetchProfile.FetchOverride;

import main.java.com.Clases.Model.Servicios.Servicio;
import main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import java.util.Date;
import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.IncidentesYNotificaciones.Observer;
import main.java.com.Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import jakarta.persistence.*;

@Entity
@Table(name = "Comunidad")
public class Comunidad implements Observer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComunidad;
	private String nombre;

	@ManyToMany
	@JoinTable(name = "PersonasObservadorasXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
	private List<Persona> usuariosObservadores;
	@ManyToMany
	@JoinTable(name = "PersonasAfectadasXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
	private List<Persona> usuariosAfectados;
	@ManyToMany
	@JoinTable(name = "PersonasAdminXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
	private List<Persona> administradoresComunidad;
	/*
	 * @ManyToMany(mappedBy = "comunidades") private List<Persona>
	 * miembrosComunidad;
	 */
	@ManyToMany
	@JoinTable(name = "ServiciosXComunidad", joinColumns = @JoinColumn(name = "idComunidad"), inverseJoinColumns = @JoinColumn(name = "idServicio"))
	private List<Servicio> servicios;
	@ManyToMany(mappedBy = "comunidades")
	private List<Incidente> incidentes;

	private transient String Rol;
	
	public int getIdComunidad() {
		return idComunidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getUsuariosObservadores() {
		return usuariosObservadores;
	}

	public void setUsuariosObservadores(List<Persona> usuariosObservadores) {
		this.usuariosObservadores = usuariosObservadores;
	}

	public void addUsuariosObservadores(Persona persona) {
		this.usuariosObservadores.add(persona);
	}

	public List<Persona> getUsuariosAfectados() {
		return usuariosAfectados;
	}

	public Boolean ExisteUsuarioAfectado(int idPersona) {
		boolean afectado = false;
		for (Persona persona : this.usuariosAfectados) {
			afectado = persona.getIdPersona() == idPersona;
			if (afectado) {
				break;
			}
		}
		this.Rol = afectado ? "Afectado" : null;
		return afectado;
	}

	public Boolean ExisteUsuarioObservador(int idPersona) {
		boolean observa = false;
		for (Persona persona : this.usuariosObservadores) {
			observa = persona.getIdPersona() == idPersona;
			if(observa) {
				break;
			}
		}
		this.Rol = observa ? "Observador" : null;
		return observa;
	}

	public void setUsuariosAfectados(List<Persona> usuariosAfectados) {
		this.usuariosAfectados = usuariosAfectados;
	}

	public void addUsuariosAfectados(Persona persona) {
		this.usuariosAfectados.add(persona);
	}

	public void deleteUsuariosAfectados(Persona persona) {
		this.usuariosAfectados.remove(persona);
	}

	public void deleteUsuariosObservadores(Persona persona) {
		this.usuariosObservadores.remove(persona);
	}

	public List<Persona> getAdministradoresComunidad() {
		return administradoresComunidad;
	}

	public void setAdministradoresComunidad(List<Persona> administradoresComunidad) {
		this.administradoresComunidad = administradoresComunidad;
	}

	/*
	 * public List<Persona> getMiembrosComunidad() { return miembrosComunidad; }
	 * 
	 * public void setMiembrosComunidad(List<Persona> miembrosComunidad) {
	 * this.miembrosComunidad = miembrosComunidad; }
	 */

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public void AgregarIncidente(Incidente incidente) {
		this.incidentes.add(incidente);
	}

	public void QuitarIncidente(Incidente incidente) {
		this.incidentes.remove(incidente);
	}

	public void NotificarIncidente(Incidente incidente) {
		List<Persona> personas = null;
		personas.addAll(this.usuariosAfectados);
		personas.addAll(this.usuariosObservadores);

		for (Persona persona : personas) {
			if (persona.getHorariosDeDisponibilidad().stream().anyMatch(horario -> horario.equals(LocalDate.now()))
					&& (incidente.getEstado() == true)) {
				persona.NotificarIncidente(incidente);
			} else if (incidente.getEstado() == true) {
				RepositorioIncidentes.addIncidenteNoEnviado(incidente);
				// falta hacer que los que no envio, vuelva a consultar en el proximo horario
			}
		}
	}

	public String getRol() {
		return Rol;
	}
}