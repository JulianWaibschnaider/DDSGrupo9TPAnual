package main.java.com.Clases.Model.JpaServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.ComunidadesYMiembros.Contrasenia;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioContrasenia;

@Service
public class ContraseniaService {
	@Autowired
	private RepositorioContrasenia repocontra;

	public Contrasenia ObtenerContraByUsuario(int id) {
		return repocontra.findContraseniaByIdContrasenia(id);
	}
}
