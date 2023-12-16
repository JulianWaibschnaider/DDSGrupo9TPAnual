package main.java.com.Clases.Model.RankingsEInformes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;

@Repository
public interface RepositorioRankings extends JpaRepository<RankingDeIncidentes,Long>  {
	RankingDeIncidentes findRankingDeIncidentesByFecha(LocalDate localDate);
	 @Query("SELECT r.fecha FROM RankingDeIncidentes r")
	    List<LocalDate> findAllFechas();}
