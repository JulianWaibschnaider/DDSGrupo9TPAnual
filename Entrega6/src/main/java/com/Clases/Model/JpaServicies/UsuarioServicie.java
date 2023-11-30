package main.java.com.Clases.Model.JpaServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.json.mgmt.users.User;

import main.java.com.Clases.Model.ComunidadesYMiembros.Contrasenia;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioUsuarios;
import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;

@Service
public class UsuarioServicie {
	@Autowired
	private RepositorioUsuarios repoUsuarios;

	@Autowired
	ContraseniaService contraService;

	public Usuario IniciarSesion(Usuario user) throws Exception {

		Boolean esUsuario = false;
		if (!this.validarInicioSesion(user)) {
			throw new Exception("Error obteniendo el usuario");
		}
		Usuario usuario = repoUsuarios.findUsuarioByEmail(user.getEmail());
		if (usuario != null) {
			Contrasenia contra = contraService.ObtenerContraByUsuario(usuario.getContrasenia().getIdContrasenia());
			esUsuario = contra.getContrasenia().equals(user.getContrasenia().getContrasenia());
		}
		if (esUsuario) {
			return usuario;
		}
		throw new Exception("Error obteniendo el usuario");
	}

	public Boolean validarInicioSesion(Usuario user) {
		return repoUsuarios.existsUsuarioByEmail(user.getEmail());
	}

}
