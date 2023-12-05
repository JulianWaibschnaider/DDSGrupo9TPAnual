package main.java.com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import main.java.com.Clases.Model.ComunidadesYMiembros.*;
import main.java.com.Clases.Model.JpaServicies.*;

@Controller
@CrossOrigin
public class LoginController {
	@Autowired
	UsuarioServicie usuarioService;

	@GetMapping(path = "/")

	public String mostrarLogin() {
		return "login";
	}

	@PostMapping(path = "/Iniciar")
	public ResponseEntity<Usuario> Iniciar(@RequestBody Usuario usuario) {
		Usuario userIniciado = new Usuario();
		
		try {
			userIniciado = usuarioService.IniciarSesion(usuario);
			return ResponseEntity.ok().body(userIniciado);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
}