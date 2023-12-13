package com.Clases.Model.ComunidadesYMiembros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioComunidad extends JpaRepository<Comunidad,Long>{
	
	Comunidad findComunidadByIdComunidad(int id);	
}
