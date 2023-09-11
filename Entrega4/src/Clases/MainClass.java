package Clases;
import java.util.Scanner;

import javax.persistence.EntityManager;

import Clases.BD.HibernateManager;
import Clases.Model.ComunidadesYMiembros.Comunidad;

//import Clases.ComunidadesYMiembros.RepositorioUsuarios;
import Clases.Model.ComunidadesYMiembros.Usuario;
import Clases.Model.Shared.LlamadorDeAPI;
public class MainClass {
	public static void main(String[] args) {
		/*Usuario usuario = new Usuario();
		System.out.print("Ingrese una contrasenia: ");
		Scanner s = new Scanner(System.in);
		String contrasenia = s.nextLine();
		
		usuario.setContrasenia(contrasenia);
		s.close();*/
		//Login();
		//LlamadorDeAPI.llamarGeoREF();
		//ServiciosController.CargarEntidadesPrestadoraYOrganismosDeControl();
		
		EntityManager em = HibernateManager.getEntityManager();
		HibernateManager.comenzarTransaccion(em);
		
		
		Comunidad comunidad = new Comunidad();
				em.persist(comunidad);
		
	}

	private static void Login() {
		Usuario.IniciarSesion();
	}
}