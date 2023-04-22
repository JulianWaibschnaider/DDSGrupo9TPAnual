package Clases;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		System.out.print("Ingrese una contra: ");
		Scanner s = new Scanner(System.in);
		String contrasenia = s.nextLine();
		
		usuario.ValidarContrasenia(contrasenia);
	}
}
