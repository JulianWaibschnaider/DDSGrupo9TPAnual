package main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOrganismoControl extends JpaRepository<OrganismoDeControl,Long> {

	OrganismoDeControl findOrganismoDeControlBynombre(String nombre);
}
