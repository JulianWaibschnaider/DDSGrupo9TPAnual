package main.java.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import java.util.Scanner;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;

import org.springframework.core.io.ClassPathResource;
import java.util.List;
import org.json.JSONObject;
import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.JpaServicies.IncidenteService;
import main.java.com.Clases.Model.JpaServicies.LineaService;
import main.java.com.Clases.Model.JpaServicies.ServicioService;
import main.java.com.Clases.Model.Servicios.Servicio;
import main.java.com.Clases.Model.ServiciosPublicos.Linea;
import java.io.IOException;
import java.io.InputStream;

@Controller
@CrossOrigin
public class IncidenteController {
	@Autowired
	private IncidenteService incidenteService;
	@Autowired
	private LineaService lineaService;
	@Autowired
	private ServicioService servicioService;

	@PostMapping(path = "/CrearIncidente")
	public ResponseEntity<Incidente> CrearIncidente(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		String observaciones = jsonObj.getString("observacion");
		// int IdComunidad = jsonObj.getInt(observaciones)
		String Email = jsonObj.getString("Email");
		int IdServicio = jsonObj.getInt("id");
		try {
			Incidente incidente = incidenteService.AbrirIncidente(Email, observaciones, IdServicio);
			return ResponseEntity.ok().body(incidente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping(path = "/CerrarIncidente")
	public ResponseEntity<Incidente> CerrarIncidente(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		int IdIncidente = jsonObj.getInt("IdIncidente");
		try {
			return ResponseEntity.ok().body(incidenteService.CerrarIncidente(IdIncidente));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PostMapping(path = "/ObtenerIncidentes")
	public ResponseEntity<List<Incidente>> ObtenerTodosIncidentes(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("IdPersona");
		try {
			return new ResponseEntity<>(incidenteService.ObtenerIncidentes(idPersona), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping(path = "/ObtenerLineas")
	public ResponseEntity<List<Linea>> ObtenerLineas() {
		try {
			return new ResponseEntity<>(lineaService.ObtenerLineas(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping(path = "/ObtenerServicios")
	public ResponseEntity<List<Servicio>> ObtenerServicios(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idLinea = jsonObj.getInt("idLinea");
		int idEstacion = jsonObj.getInt("idEstacion");
		try {
			return new ResponseEntity<>(servicioService.ObtenerServicioByLineaYEstacion(idLinea, idEstacion),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping(path = "/ObtenerIncidentePorEstado")
	public ModelAndView ObtenerIncidentePorEstado(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("idPersona");
		boolean estadoIncidente = jsonObj.getBoolean("EstadoIncidente");
		List<Incidente> incidentes;
		try {
			ModelAndView modelAndView = new ModelAndView("incidenteestado");
			incidentes = incidenteService.BuscarIncidentePorEstado(estadoIncidente, idPersona);
			modelAndView.addObject("incidentes", incidentes);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping(path = "/SugerenciaIncidente")
	public ModelAndView SugerenciaIncidente(@RequestBody String bodyJson) throws IOException {
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("idPersona");
		try {
			Incidente incidente = incidenteService.BuscarIncidentePorEstado(true, idPersona).get(0);
			ModelAndView modelAndView = new ModelAndView("sugerencia");
			modelAndView.addObject("incidente", incidente);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
