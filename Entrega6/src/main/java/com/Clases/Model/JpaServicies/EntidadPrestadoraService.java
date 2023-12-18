package main.java.com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.OrganismoDeControl;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.RepositorioEntidadesPrestadoras;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.RepositorioOrganismoControl;
import java.util.ArrayList;

@Service
public class EntidadPrestadoraService {

	@Autowired
	private RepositorioEntidadesPrestadoras repoEntPres;
	@Autowired
	RepositorioOrganismoControl repoOrgControl;

	public void GuardarEntidadesPrestadoras(List<EntidadPrestadora> entidadesPres) {
		for (EntidadPrestadora enti : entidadesPres) {
			if (repoEntPres.findEntidadPrestadoraByNombre(enti.getNombre()) == null) {
				List<OrganismoDeControl> orgs = new ArrayList<>();
				// enti.setOrganismosDeControl(null);
				for (OrganismoDeControl org : enti.getOrganismosDeControl()) {
					OrganismoDeControl organismo = repoOrgControl.findOrganismoDeControlBynombre(org.getNombre());
					if (organismo != null) {
						org.setIdOrganismoDeControl(organismo.getIdOrganismoDeControl());
					}
				}
				repoEntPres.save(enti);
			}
		}
	}

}
