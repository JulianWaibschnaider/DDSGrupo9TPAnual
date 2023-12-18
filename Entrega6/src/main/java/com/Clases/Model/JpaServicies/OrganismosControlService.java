package main.java.com.Clases.Model.JpaServicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.OrganismoDeControl;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.RepositorioOrganismoControl;

@Service
public class OrganismosControlService {

	@Autowired
	RepositorioOrganismoControl repoOrgControl;
	
	public void GuardarOrganismosControl(List<OrganismoDeControl> listaOrgs) {
		for(OrganismoDeControl orgs : listaOrgs) {
			if(repoOrgControl.findOrganismoDeControlBynombre(orgs.getNombre()) == null) {
				repoOrgControl.save(orgs);
				
			}
		}
	}
	
}
