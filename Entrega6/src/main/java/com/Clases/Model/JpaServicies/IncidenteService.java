package main.java.com.Clases.Model.JpaServicies;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.ComunidadesYMiembros.Persona;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioPersonas;
import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import main.java.com.Clases.Model.Servicios.RepositorioServicios;
import main.java.com.Clases.Model.Servicios.Servicio;

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
		persona.setComunidades(personaService.BuscarComunidadesPorPersona(persona.getIdPersona()));
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
	
	public List<Incidente>ObtenerIncidentes(int idPersona){
		List<Integer> idsComunidades = personaService.BuscarIdsComunidadesPorPersona(idPersona);
		List<Incidente> incidentes = new ArrayList<>();
		for(int idComus : idsComunidades){
			incidentes.addAll(repoIncidentes.findIncidentesByComunidadesIdComunidad(idComus));
		}
		return incidentes;
	}

	public List<Incidente> BuscarIncidentePorEstado(Boolean estado) {
		List<Incidente> listaIncidentes = repoIncidentes.findAllIncidenteByEstado(estado);
		return listaIncidentes;
	}
}
