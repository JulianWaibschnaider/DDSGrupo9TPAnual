package main.java.com.Clases.Model.Shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.ListasEntidadesYorganismos;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.OrganismoDeControl;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.RepositorioEntidadesPrestadoras;
import main.java.com.Clases.Model.JpaServicies.ContraseniaService;
import main.java.com.Clases.Model.JpaServicies.EntidadPrestadoraService;
import main.java.com.Clases.Model.JpaServicies.OrganismosControlService;

public class LlenadorDeCSV {



	public static ListasEntidadesYorganismos llenarCSVEntidadesYOrganismos(MultipartFile file) {
		// RepositorioEntidadesPrestadoras repoEntidadPrestadora = new
		// RepositorioEntidadesPrestadoras();
		// String archivoCSV =
		// "/src/resources/Listadeentidadesprestadorasyorganismosdecontrol.csv";
		List<String[]> entidadesPrestadorasYOrganismosDeControl = new ArrayList<>();
		List<OrganismoDeControl> listaOrganismostotal = new ArrayList<>();
		List<EntidadPrestadora> entidadespresta = new ArrayList<>();
		ListasEntidadesYorganismos entidadesYorganismos = new ListasEntidadesYorganismos();
		try (Reader reader = new InputStreamReader(file.getInputStream());
				CSVReader csvReader = new CSVReader(reader)) {
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				entidadesPrestadorasYOrganismosDeControl.add(nextRecord);
			}
		} catch (IOException | CsvValidationException e) {
			System.out.println("Error al leer el archivo CSV: " + e.getMessage());
		}
		for (String[] entidadPrestadoraYOrganismoDeControl : entidadesPrestadorasYOrganismosDeControl) {
			EntidadPrestadora entidadPrestadora = new EntidadPrestadora();
			entidadPrestadora.setNombre(entidadPrestadoraYOrganismoDeControl[0]);
			List<OrganismoDeControl> listaOrganismosControl = new ArrayList<>();
			System.out.println(entidadPrestadora.getNombre());

			// Empezamos desde 1 ya que el primer elemento es el nombre de la entidad
			for (int i = 1; i < entidadPrestadoraYOrganismoDeControl.length; i++) {
				OrganismoDeControl organismoControl = new OrganismoDeControl();
				organismoControl.setNombre(entidadPrestadoraYOrganismoDeControl[i]);
				System.out.println("    "+organismoControl.getNombre());
				listaOrganismosControl.add(organismoControl);
				if (!listaOrganismostotal.stream().anyMatch(org -> org.getNombre().equals(organismoControl.getNombre()))) {
				    listaOrganismostotal.add(organismoControl);
				}
			}
			

			entidadPrestadora.setOrganismosDeControl(listaOrganismosControl);
	
				entidadespresta.add(entidadPrestadora);		
			
		}
		
		entidadesYorganismos.setEntidadespresta(entidadespresta);
		entidadesYorganismos.setListaOrganismostotal(listaOrganismostotal);
		return entidadesYorganismos;
	}

	public void GuardarOrganismosControl(List<OrganismoDeControl> orgControl) {
		
	}
}