package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
