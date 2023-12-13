package main.java.com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.ServiciosPublicos.Linea;
import main.java.com.Clases.Model.ServiciosPublicos.RepositorioLineas;

@Service
public class LineaService {
	@Autowired
	private RepositorioLineas repoLineas;

	public List<Linea> ObtenerLineas() {
		return repoLineas.findAll();
	}

}
