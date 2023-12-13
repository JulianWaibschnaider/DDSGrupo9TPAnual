package com.Clases.Model.JpaServicies;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clases.Model.RankingsEInformes.RankingDeIncidentes;
import com.Clases.Model.RankingsEInformes.RepositorioRankings;

@Service
public class RankingService {

	@Autowired
	private RepositorioRankings repoRanking;
	public RankingDeIncidentes ObtenerRankingsXFecha(LocalDate localDate) {
		return repoRanking.findRankingDeIncidentesByFecha(localDate);
	}
	
}
