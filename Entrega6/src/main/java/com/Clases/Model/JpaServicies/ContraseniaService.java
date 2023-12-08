package com.Clases.Model.JpaServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clases.Model.ComunidadesYMiembros.Contrasenia;
import com.Clases.Model.ComunidadesYMiembros.RepositorioContrasenia;

@Service
public class ContraseniaService {
	@Autowired
	private RepositorioContrasenia repocontra;

	public Contrasenia ObtenerContraByUsuario(int id) {
		return repocontra.findContraseniaByIdContrasenia(id);
	}
}
