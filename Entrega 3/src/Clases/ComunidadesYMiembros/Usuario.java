package Clases.ComunidadesYMiembros;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String email;
	private Contrasenia contrasenia;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    private void IniciarSesion(){
		//hacer
    }

    public Contrasenia getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia contra = new Contrasenia(contrasenia);
		if (contra.ValidarContrasenia())
			this.contrasenia = contra;
	}
}