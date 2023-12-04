package main.java.com.Clases.Model.JpaServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Incidente AbrirIncidente(String _email, String _observaciones, int idServicio) throws Exception {

		Incidente incidente = new Incidente();
		Servicio servicio = repoServicio.findServicioByIdServicio(idServicio);
		incidente.Abrir(_email, _observaciones, servicio);
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

}
