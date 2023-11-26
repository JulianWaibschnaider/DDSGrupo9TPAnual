package main.java.com.Controller;


import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import main.java.com.Clases.BD.HibernateManager;
import main.java.com.Clases.Model.ComunidadesYMiembros.Comunidad;
//import Clases.ComunidadesYMiembros.RepositorioUsuarios;
import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.PersonaEncargada;

@SpringBootApplication
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
		//EntityManager em = HibernateManager.getEntityManager();
		//HibernateManager.comenzarTransaccion(em);
		 SpringApplication.run(MainClass.class, args);
	}


}