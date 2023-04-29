package Clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Para limitar o incrementar el tiempo de respuesta de cada intento fallido de inicio de sesión,
//vamos a utilizar un mecanismo de bloqueo o retraso exponencial. 
//Es decir, cada vez que se produce un intento fallido de inicio de sesión, se aumenta el tiempo de espera antes del siguiente intento,
//y este tiempo de espera se incrementa exponencialmente con cada intento fallido adicional.

public class Contrasenia {
	private String contrasenia;

	public Contrasenia(String contra) {
		this.setContrasenia(contra);
	}

	public Contrasenia() {
	}

	public Boolean ValidarContrasenia() {

		if (this.ContraseniaNotTopMil(this.contrasenia) && !this.RegexContrasenia(this.contrasenia)) {
			System.out.println("Su contrasenia es segura.");
			return true;
		} else {
			System.out.println("Su contrasenia es débil. Por favor, elija otra contrasenia.");
			return false;
		}
	}

	private Boolean RegexContrasenia(String contraValidar) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?!.*(.)\\1{2,})(?!.*(\\d{2,}|[a-zA-Z]{2,}|[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{2,})).{8,64}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(contraValidar);
		return matcher.matches();

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