package Clases;
import java.util.Scanner;

import Clases.ComunidadesYMiembros.RepositorioUsuarios;
//import Clases.ComunidadesYMiembros.Usuario;
import Clases.Shared.LlamadorDeAPI;

public class MainClass {
	public static void main(String[] args) {
		/*Usuario usuario = new Usuario();
		System.out.print("Ingrese una contrasenia: ");
		Scanner s = new Scanner(System.in);
		String contrasenia = s.nextLine();
		
		usuario.setContrasenia(contrasenia);
		s.close();*/
		Login();
		LlamadorDeAPI.llamarGeoREF();
		//ServiciosController.CargarEntidadesPrestadoraYOrganismosDeControl();
	}

	private static void Login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al sistema de login.");
		System.out.print("Ingrese su email: ");
		String email = scanner.nextLine();
		System.out.print("Ingrese su contrasenia: ");
		String password = scanner.nextLine();
		scanner.close();
		RepositorioUsuarios.IniciarSesion(email, password);
	}
}