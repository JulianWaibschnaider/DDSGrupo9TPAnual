package com.Clases.Model.JpaServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clases.Model.Servicios.RepositorioServicios;

@Service
public class ServicioService {

	@Autowired
	private RepositorioServicios repoServicio;
}
