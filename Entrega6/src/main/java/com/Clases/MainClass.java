package main.java.com.Clases;

import javax.persistence.EntityManager;

import main.java.com.Clases.BD.HibernateManager;
import main.java.com.Clases.Model.ComunidadesYMiembros.Comunidad;
//import Clases.ComunidadesYMiembros.RepositorioUsuarios;
import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.PersonaEncargada;
public class MainClass {
	public static void main(String[] args) {
		/*
		 * Usuario usuario = new Usuario();
		 * System.out.print("Ingrese una contrasenia: "); Scanner s = new
		 * Scanner(System.in); String contrasenia = s.nextLine();
		 * 
		 * usuario.setContrasenia(contrasenia); s.close();
		 */
		// Login();
		// LlamadorDeAPI.llamarGeoREF();
		// ServiciosController.CargarEntidadesPrestadoraYOrganismosDeControl();

		EntityManager em = HibernateManager.getEntityManager();
		HibernateManager.comenzarTransaccion(em);

		 PersonaEncargada personita = new PersonaEncargada();
		 personita.setNombre("juan");
		 personita.setApellido("carlos segundo");
		 em.persist(personita);
		 HibernateManager.commit(em);
	}

	private static void Login() {
		Usuario.IniciarSesion();
	}
}