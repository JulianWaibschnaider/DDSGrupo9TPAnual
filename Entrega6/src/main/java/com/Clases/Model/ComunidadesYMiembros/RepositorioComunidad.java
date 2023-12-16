package main.java.com.Clases.Model.ComunidadesYMiembros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioComunidad extends JpaRepository<Comunidad,Integer>{
	
	Comunidad findComunidadByIdComunidad(int id);
	
	Comunidad findComunidadNombreComunidadusuariosObservadoresComunidadusuariosAfectadosByIdComunidad(int id);
	
	//Comunidad findPersonasObservadorasXComunidadByPersonaIdPersona(int id);
}
