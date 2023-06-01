package Clases.Comunidades;

import java.util.ArrayList;
import Clases.Servicios.Servicio;
import Clases.ServiciosPublicos.Entidad;
public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private Contrasenia contrasenia;
	private ArrayList<Servicio> serviciosDeInteres;
	private ArrayList<Entidad> serviciosPublicosDeInteres;
	private Localizacion localizacion;

	public Contrasenia getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia contra = new Contrasenia(contrasenia);
		if (contra.ValidarContrasenia())
			this.contrasenia = contra;
	}

}