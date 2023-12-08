package main.java.com.Controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import main.java.com.Clases.Model.JpaServicies.IncidenteService;
import main.java.com.Clases.Model.JpaServicies.RankingService;
import main.java.com.Clases.Model.RankingsEInformes.RankingDeIncidentes;

@Controller
@CrossOrigin
public class RankingController {
	@Autowired
	private RankingService rankingService;
	
	@GetMapping(path="/ObtenerRankingByFecha")
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
	
}
