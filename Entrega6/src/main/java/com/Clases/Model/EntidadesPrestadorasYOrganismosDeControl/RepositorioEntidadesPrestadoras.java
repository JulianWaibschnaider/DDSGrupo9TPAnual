package  main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.Clases.Model.ServiciosPublicos.Entidad;

@Repository
public interface RepositorioEntidadesPrestadoras extends JpaRepository<EntidadPrestadora,Long>{
	EntidadPrestadora findEntidadPrestadoraByNombre(String nombre);
}