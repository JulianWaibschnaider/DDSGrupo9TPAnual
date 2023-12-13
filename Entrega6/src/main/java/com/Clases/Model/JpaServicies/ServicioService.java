package com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import main.java.com.Clases.Model.Servicios.RepositorioServicios;
import main.java.com.Clases.Model.Servicios.Servicio;
import main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import main.java.com.Clases.Model.ServiciosPublicos.RepositorioEntidades;


@Service
public class ServicioService {

	@Autowired
	private RepositorioServicios repoServicio;
	
	@Autowired
	private RepositorioEntidades repoEntidad;

	public List<Servicio> ObtenerServicioByLineaYEstacion(int linea, int estacion) {
		Entidad entidad = repoEntidad.findByLineaIdLineaAndEstacionIdEstacion(linea, estacion);
		
		return repoServicio.findServicioByEntidadIdEntidad(entidad.getIdEntidad());
	}
}
