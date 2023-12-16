package main.java.com.Controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import main.java.com.Clases.Model.ComunidadesYMiembros.Comunidad;
import main.java.com.Clases.Model.ComunidadesYMiembros.Persona;
import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import main.java.com.Clases.Model.JpaServicies.PersonaService;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PersonaController {
	@Autowired
	PersonaService personaService;


	@PostMapping(path = "/DefinirRol")
	public ResponseEntity<Persona> DefinirRol(@RequestBody String bodyJson) {
		Persona persona;
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("IdPersona");
		int idComunidad = jsonObj.getInt("IdComunidad");
		boolean rol = jsonObj.getBoolean("rol");
		
		try {
			persona = personaService.definirRolEn(idPersona, idComunidad, rol);
			return ResponseEntity.ok().body(persona);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(path="/ObtenerPersona")
	public ResponseEntity<Persona> ObtenerPersona(@RequestBody String bodyJson){
		JSONObject jsonObj = new JSONObject(bodyJson);
		String email = jsonObj.getString("email");
		try {
			return ResponseEntity.ok().body(personaService.BuscarPersonaPorEmail(email));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@PostMapping(path ="/ObtenerComunidadesXpersona")
	public ResponseEntity<List<Comunidad>> ObtenerComunidadesXpersona(@RequestBody String bodyJson){
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("IdPersona");
		try {
			return new ResponseEntity<> (personaService.BuscarComunidadesPorPersona(idPersona),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping(path = "/ObtenerRolComunidadXPersona")
	public ResponseEntity<List<Comunidad>>ObtenerRolComunidadXPersona(@RequestBody String bodyJson){
		JSONObject jsonObj = new JSONObject(bodyJson);
		int idPersona = jsonObj.getInt("IdPersona");
		try {
			return new ResponseEntity<> (personaService.BuscarRolesComunidadesPorPersona(idPersona),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}
