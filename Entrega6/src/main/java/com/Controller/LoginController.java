package main.java.com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.java.com.Clases.Model.ComunidadesYMiembros.*;
import main.java.com.Clases.Model.JpaServicies.*;
@Controller
@CrossOrigin
public class LoginController {
	 
		@GetMapping(path = "/")

		    public String mostrarLogin() {
		        return "login";
		    }
		
		 @PostMapping(path = "/Iniciar")
		 	public ResponseEntity<Usuario> Iniciar(@RequestBody Usuario usuario) {
			 Usuario userIniciadio = new Usuario();
			 userIniciadio = usuario.IniciarSesion();
			 if(userIniciadio != null) {
				 return ResponseEntity.ok().body(userIniciadio);
			 }
			 return ResponseEntity.ok().body(null);
		}
}
