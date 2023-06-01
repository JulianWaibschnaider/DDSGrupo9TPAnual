package Clases.Comunidades;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private Contrasenia contrasenia;

	public Contrasenia getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia contra = new Contrasenia(contrasenia);
		if (contra.ValidarContrasenia())
			this.contrasenia = contra;
	}

}