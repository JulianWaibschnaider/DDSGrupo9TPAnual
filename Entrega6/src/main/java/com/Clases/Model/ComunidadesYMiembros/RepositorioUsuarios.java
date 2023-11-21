package  main.java.com.Clases.Model.ComunidadesYMiembros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario,Long>{
	 Usuario findUsuarioByEmail(String email);
	 Boolean existUserByEmail(String email);
}