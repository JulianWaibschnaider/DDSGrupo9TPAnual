package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.json.JSONObject;
import com.Clases.Model.IncidentesYNotificaciones.Incidente;
import com.Clases.Model.JpaServicies.IncidenteService;
import java.util.List;

@Controller
@CrossOrigin
public class IncidenteController {
	@Autowired
	private IncidenteService incidenteService;

	@PostMapping(path = "/CrearIncidente")
	public ResponseEntity<Incidente> CrearIncidente(@RequestBody String bodyJson) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		String observaciones = jsonObj.getString("observacion");
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

	@PostMapping("/ObtenerIncidentePorEstado")
	public String ObtenerIncidentePorEstado(@RequestBody String bodyJson, Model model) {
		JSONObject jsonObj = new JSONObject(bodyJson);
		boolean estadoIncidente = jsonObj.getBoolean("EstadoIncidente");
		try {
			List<Incidente> incidentes = incidenteService.BuscarIncidentePorEstado(estadoIncidente);
			model.addAttribute("incidentes", incidentes);
			return "incidenteList"; // This should match the Thymeleaf template name
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
