package main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.ArrayList;
import java.util.List;

public class ListasEntidadesYorganismos {
	private List<OrganismoDeControl> listaOrganismostotal = new ArrayList<>();
	private List<EntidadPrestadora> entidadespresta = new ArrayList<>();
	public List<OrganismoDeControl> getListaOrganismostotal() {
		return listaOrganismostotal;
	}
	public void setListaOrganismostotal(List<OrganismoDeControl> listaOrganismostotal) {
		this.listaOrganismostotal = listaOrganismostotal;
	}
	public List<EntidadPrestadora> getEntidadespresta() {
		return entidadespresta;
	}
	public void setEntidadespresta(List<EntidadPrestadora> entidadespresta) {
		this.entidadespresta = entidadespresta;
	}
}
