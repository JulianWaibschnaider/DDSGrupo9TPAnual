package main.java.com.Controller;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.List;

import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.JpaServicies.IncidenteService;
import main.java.com.Clases.Model.JpaServicies.RankingService;
import main.java.com.Clases.Model.RankingsEInformes.RankingDeIncidentes;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
@Controller
@CrossOrigin
public class RankingController {
	@Autowired
	private RankingService rankingService;
	
	@PostMapping(path="/ObtenerRankingByFecha")
	public ResponseEntity<RankingDeIncidentes> ObtenerRankingByFecha(@RequestBody String bodyJson) throws ParseException{ 
		JSONObject jsonObj = new JSONObject(bodyJson);
		String Fecha = jsonObj.getString("Fecha");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(Fecha);  
		Instant instant=date.toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		try {
			return ResponseEntity.ok().body(rankingService.ObtenerRankingsXFecha(localDate));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(path="/ObtenerFechasRanking")
	public ResponseEntity<List<LocalDate>> ObtenerFechasRanking() throws ParseException{
		try {
			return new ResponseEntity<>(rankingService.ObtenerFechas(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	@PostMapping(path="/ObtenerRankingByFechaLiviano")
	public ModelAndView ObtenerRankingByFechaLiviano(@RequestBody String bodyJson) throws ParseException{ 
		List<Entidad> entidades = new ArrayList<Entidad>(); 
		JSONObject jsonObj = new JSONObject(bodyJson);
		String Fecha = jsonObj.getString("Fecha");
		int tipoRanking = jsonObj.getInt("TipoRanking");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(Fecha);  
		Instant instant= date.toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		try {
		RankingDeIncidentes ranking = rankingService.ObtenerRankingsXFecha(localDate);
		switch(tipoRanking) {
		case 0:
			entidades= ranking.getRankingMayorCantidadIncidentes();
			break;
		case 1: 
			entidades = ranking.getRankingMayorGradoDeImpacto();
			break;
		case 2:
			entidades = ranking.getRankingMayorTiempoPromedio();
			break;
		default: 
			break;
		}
		int puesto = 1; // Inicializamos el contador
		for (Entidad entidad : entidades) {
		    entidad.setPuesto(puesto++); // Suponiendo que hay un método setPuesto en tu clase Entidad
		}
	//	List<Incidente> incidente = ranking.getRankingMayorCantidadIncidentes();
		ModelAndView modelandview = new ModelAndView("tablarankingliviana");
		modelandview.addObject("entidades", entidades);
		return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
