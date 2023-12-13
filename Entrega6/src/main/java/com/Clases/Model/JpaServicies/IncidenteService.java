package com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clases.Model.ComunidadesYMiembros.Persona;
import com.Clases.Model.ComunidadesYMiembros.RepositorioPersonas;
import com.Clases.Model.IncidentesYNotificaciones.Incidente;
import com.Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import com.Clases.Model.Servicios.RepositorioServicios;
import com.Clases.Model.Servicios.Servicio;

@Service
public class IncidenteService {
	@Autowired
	private RepositorioIncidentes repoIncidentes;
	@Autowired
	private RepositorioServicios repoServicio;
	@Autowired
	private PersonaService personaService;

	public Incidente AbrirIncidente(String _email, String _observaciones, int idServicio) throws Exception {

		Incidente incidente = new Incidente();
		Servicio servicio = repoServicio.findServicioByIdServicio(idServicio);
		Persona persona = personaService.BuscarPersonaPorEmail(_email);
		incidente.Abrir(_email, _observaciones, servicio, persona);
		Incidente inci = repoIncidentes.save(incidente);
		if (inci != null) {
			return inci;
		}
		throw new Exception("Error insertando el incidente");
	}

	public Incidente CerrarIncidente(int idIncidente) {
		Incidente incidente = repoIncidentes.findIncidenteByid(idIncidente);
		//if (repoIncidentes.updateEstadoById(idIncidente, false)>=1) {
		// }
		incidente.Cerrar();
		repoIncidentes.save(incidente);
		return incidente; // falta poner el servicio en funcionamiento
	}
	
	public List<Incidente>ObtenerIncidentes(){
		return repoIncidentes.findAll();
	}

	public List<Incidente> BuscarIncidentePorEstado(Boolean estado) {
		List<Incidente> listaIncidentes = repoIncidentes.findAllIncidenteByEstado(estado);
		return listaIncidentes;
	}
}
