package Clases;
import java.util.Scanner;

import Clases.Comunidades.Usuario;

public class MainClass {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		System.out.print("Ingrese una contrasenia: ");
		Scanner s = new Scanner(System.in);
		String contrasenia = s.nextLine();
		
		usuario.setContrasenia(contrasenia);
		s.close();
	}
}