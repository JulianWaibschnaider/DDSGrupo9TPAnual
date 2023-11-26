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

public Usuario IniciarSesion(Usuario user) {
	Boolean esUsuario = false;
	if(!this.validarInicioSesion(user)) {
		return null;
	}
	Usuario usuario = repoUsuarios.findUsuarioByEmail(user.getEmail());
	if(usuario != null) {
		ContraseniaService contraService = new ContraseniaService();
		Contrasenia contra =  contraService.ObtenerContraByUsuario(usuario.getContrasenia().getIdContrasenia());
		 esUsuario = contra.getContrasenia().equals(user.getContrasenia().getContrasenia());
	}
	if(esUsuario) {return usuario;}
	return null;
}

public Boolean validarInicioSesion(Usuario user) {
	return repoUsuarios.existUserByEmail(user.getEmail());
}

}
