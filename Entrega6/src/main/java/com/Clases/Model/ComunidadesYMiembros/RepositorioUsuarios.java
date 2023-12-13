package  com.Clases.Model.ComunidadesYMiembros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario,Long>{
	
	 Usuario findUsuarioByEmail(String email);
	 Boolean existsUsuarioByEmail(String email);
	 
}
