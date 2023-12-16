package main.java.com.Clases.Model.JpaServicies;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.Clases.Model.RankingsEInformes.RankingDeIncidentes;
import main.java.com.Clases.Model.RankingsEInformes.RepositorioRankings;

@Service
public class RankingService {

	@Autowired
	private RepositorioRankings repoRanking;
	public RankingDeIncidentes ObtenerRankingsXFecha(LocalDate localDate) {
		return repoRanking.findRankingDeIncidentesByFecha(localDate);
	}
	
	public List<LocalDate> ObtenerFechas(){
		return repoRanking.findAllFechas();
	}
}
