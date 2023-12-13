package main.java.com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.ComunidadesYMiembros.Comunidad;
import main.java.com.Clases.Model.ComunidadesYMiembros.Persona;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioComunidad;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioPersonas;

@Service
public class PersonaService {

	@Autowired
	private RepositorioPersonas repoPersonas;

	@Autowired
	private RepositorioComunidad repoComunidad;

	public Persona definirRolEn(int idPersona, int idComunidad, boolean afectado) {
		Persona persona = repoPersonas.findPersonaByidPersona(idPersona);
		Comunidad comu = repoComunidad.findComunidadByIdComunidad(idComunidad);
		persona.definirRolEn(comu, afectado);
		//persona.setEsAfectado(comu);
		repoPersonas.save(persona);
		return persona;
	}
	
	public Persona BuscarPersonaPorEmail(String email) {
		return repoPersonas.findPersonaByEmail(email);
	}
	
	public Comunidad BuscarComunidadesPorPersona(int idPersona)
	{
		return repoPersonas.findComunidadesdByidPersona(idPersona);
	}
}


