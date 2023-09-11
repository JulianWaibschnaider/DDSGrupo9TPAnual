package Clases.Model.ComunidadesYMiembros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Clases.Model.Shared.Mensajero;
//Para limitar o incrementar el tiempo de respuesta de cada intento fallido de inicio de sesión,
//vamos a utilizar un mecanismo de bloqueo o retraso exponencial. 
//Es decir, cada vez que se produce un intento fallido de inicio de sesión, se aumenta el tiempo de espera antes del siguiente intento,
//y este tiempo de espera se incrementa exponencialmente con cada intento fallido adicional.
import javax.persistence.*;
@Entity
@Table(name = "Contrasenia")
public class Contrasenia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrasenia;
	private String contrasenia;

	public Contrasenia(String contra) {
		this.setContrasenia(contra);
	}

	public Contrasenia() {
	}

	public Boolean ValidarContrasenia() {

		if (this.ContraseniaNotTopMil(this.contrasenia) && this.RegexContrasenia(this.contrasenia)) {		
			Mensajero.MensajeContrasenia(1);
			return true;
		} else {
			Mensajero.MensajeContrasenia(-1);
			return false;
		}
	}

	private Boolean RegexContrasenia(String contraValidar) {
		String regex = "^(?=.{8,64}$)(?!.*(.)\\1{2}).*$";
		return contraValidar.matches(regex);

	}

	private Boolean ContraseniaNotTopMil(String contraValidar) {
		ArrayList<String> contraseniasDebiles = new ArrayList<String>();
		String archivoContraseniasDebiles = "/src/Resources/peores_contrasenias.txt";
		try {
			contraseniasDebiles = (ArrayList<String>) Files
					.readAllLines(Paths.get(System.getProperty("user.dir") + archivoContraseniasDebiles));					
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo: " + e.getMessage());
			return false;
		}
			return !contraseniasDebiles.contains(contraValidar);
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}