package main.java.com.Clases.Model.ServiciosPublicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.Clases.Model.Servicios.Servicio;

@Repository
public interface RepositorioLineas extends JpaRepository<Linea,Long> {

	
}
