package Clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;

	public Boolean ValidarContrasenia(String contraValidar) {
		ArrayList<String> contraseniasDebiles = new ArrayList<String>();
		String archivoContraseniasDebiles = "/src/Resources/peores_contrasenias.txt";
		try {
			contraseniasDebiles = (ArrayList<String>) Files.readAllLines(Paths.get(System.getProperty("user.dir")+ archivoContraseniasDebiles));
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo: " + e.getMessage());
			return false;
		}

		if (contraseniasDebiles.contains(contraValidar)) {
			System.out.println("Su contraseña es débil. Por favor, elija otra contraseña.");
			return false;
		} else {
			System.out.println("Su contraseña es segura. ¡Buen trabajo!");
			return true;
		}
	}

}