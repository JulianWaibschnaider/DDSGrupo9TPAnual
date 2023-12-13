package com.Clases.Model.ComunidadesYMiembros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioContrasenia extends JpaRepository<Contrasenia,Long> {
	Contrasenia findContraseniaByIdContrasenia(int Id);
}
