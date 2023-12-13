package com.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.Clases.Model.ComunidadesYMiembros.Persona;
import com.Clases.Model.ComunidadesYMiembros.Usuario;
import com.Clases.Model.JpaServicies.PersonaService;

@Controller
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
}
