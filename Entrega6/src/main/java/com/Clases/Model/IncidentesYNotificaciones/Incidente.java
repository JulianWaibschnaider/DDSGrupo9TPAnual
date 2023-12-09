package com.Clases.Model.IncidentesYNotificaciones;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.Clases.Model.ComunidadesYMiembros.Persona;
import com.Clases.Model.ComunidadesYMiembros.Comunidad;
import com.Clases.Model.Servicios.Servicio;
import jakarta.persistence.*;

@Entity
@Table(name = "Incidente")
public class Incidente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idPersona")
	private Persona persona;
	private String observaciones;
	@ManyToOne
	@JoinColumn(name = "idServicio")
	private Servicio servicio;
	private Boolean estado;// true es abierto y false es cerrado
	//@ManyToMany(mappedBy = "incidentes")
	//private List<Comunidad> comunidades;
	private LocalDateTime fechaApertura;
	private LocalDateTime fechaCierre;
	private long diferenciaCierreApertura;

	public long getDiferenciaCierreApertura() {
		return diferenciaCierreApertura;
	}

	public void setDiferenciaCierreApertura() {
		this.diferenciaCierreApertura = ChronoUnit.DAYS.between(fechaCierre, fechaApertura);
	}

	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


	public void Abrir(String _email, String _observaciones, Servicio _servicio, Persona persona) {
		// this.id = RepositorioIncidentes.incidentes.size() + 1;
		this.persona = persona;
		this.setObservaciones(_observaciones);
		this.servicio = _servicio;
		// this.comunidades = persona.getComunidades();
		this.fechaApertura = LocalDateTime.now();
		this.fechaCierre = null;
		this.estado = true;// el estado del incidente es abierto
		this.servicio.setEnFuncionamiento(false); // ponemos el servicio fuera de servicio
	//	this.servicio.getEntidad().addIncidenteEntidad(this);
		// NotificarIncidente();
		// RepositorioIncidentes.addIncidentes(this);
	}

	public void Cerrar() {
		this.servicio.setEnFuncionamiento(true);// ponemos el servicio en funcionamiento nuevamente
		this.estado = false;
		this.fechaCierre = LocalDateTime.now();
		// RepositorioIncidentes.UpdateIncidentes(this);
		// this.servicio.getEntidad().UpdateIncidenteEntidad(this);
		this.setDiferenciaCierreApertura();
	}

	public List<Comunidad> getComunidades() {
		return null;//comunidades;
	}

	public Boolean getEstado() {
		return estado;
	}

	/*public void NotificarIncidente() {
		for (Comunidad comunidad : comunidades) {
			comunidad.NotificarIncidente(this);
		}
	}
*/
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
