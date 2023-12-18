package main.java.com.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.ListasEntidadesYorganismos;
import main.java.com.Clases.Model.JpaServicies.EntidadPrestadoraService;
import main.java.com.Clases.Model.JpaServicies.OrganismosControlService;
import main.java.com.Clases.Model.Shared.LlenadorDeCSV;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller
public class EntidadesPrestadorasYOrganismosDeControlController {

	@Autowired
	EntidadPrestadoraService enPreService;

	@Autowired
	OrganismosControlService orgControl;

		@PostMapping(path = "/CargarArchivo")
		public ModelAndView CrearIncidente(@RequestParam MultipartFile file) {
			ListasEntidadesYorganismos entidadesYorganismos;
			entidadesYorganismos = LlenadorDeCSV.llenarCSVEntidadesYOrganismos(file);
			orgControl.GuardarOrganismosControl(entidadesYorganismos.getListaOrganismostotal());
			enPreService.GuardarEntidadesPrestadoras(entidadesYorganismos.getEntidadespresta());
			ModelAndView modelAndView = new ModelAndView("tablaorgyentes");
			modelAndView.addObject("entidades", entidadesYorganismos.getEntidadespresta());
			modelAndView.addObject("organismos", entidadesYorganismos.getListaOrganismostotal());
			modelAndView.addObject("fecha",new Date());
			return modelAndView;
		}
}
