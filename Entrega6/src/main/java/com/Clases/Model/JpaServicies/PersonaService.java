package main.java.com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaQuery;
import main.java.com.Clases.Model.ComunidadesYMiembros.Comunidad;
import main.java.com.Clases.Model.ComunidadesYMiembros.Persona;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioComunidad;
import main.java.com.Clases.Model.ComunidadesYMiembros.RepositorioPersonas;
import java.util.ArrayList;
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
		// persona.setEsAfectado(comu);
		repoPersonas.save(persona);
		return persona;
	}

	public List<Comunidad> BuscarRolesComunidadesPorPersona(int idPersona) {
		// Persona persona = repoPersonas.findPersonaByidPersona(idPersona);
		List<Comunidad> comunidades = BuscarComunidadesPorPersona(idPersona);
		for (Comunidad comu : comunidades) {
			if (!comu.ExisteUsuarioAfectado(idPersona)) {
				comu.ExisteUsuarioObservador(idPersona);
			}
		}
		return comunidades;
	}

	public Persona BuscarPersonaPorEmail(String email) {
		return repoPersonas.findPersonaByEmail(email);
	}

	public List<Comunidad> BuscarComunidadesPorPersona(int idPersona) {
		List<Integer> idsComus = BuscarIdsComunidadesPorPersona(idPersona);
		List<Comunidad> comunidades = new ArrayList<> ();
		for (int idComu : idsComus) {	
		 comunidades.add(repoComunidad.findComunidadByIdComunidad(idComu));
		}
		return comunidades;
	}

	public List<Integer> BuscarIdsComunidadesPorPersona(int idPersona) {
		return repoPersonas.findIdComunidadByidPersona(idPersona);
	}

}
