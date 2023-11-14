package  main.java.com.Clases.Model.RankingsEInformes;

import java.time.LocalDateTime;
import java.util.List;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

public class Informe {
    private List<Entidad> rankingMayorCantidadIncidentes;
    private List<Entidad> rankingMayorTiempoPromedioDeCierre;
    // private List<Entidad> rankingMayorGradoDeImpacto; ESTE ES EL CRITERIO QUE FALTA
    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    public List<Entidad> getRankingMayorCantidadIncidentes() {
        return rankingMayorCantidadIncidentes;
    }

    public List<Entidad> getRankingMayorTiempoPromedioDeCierre() {
        return rankingMayorTiempoPromedioDeCierre;
    }

    public void setRankingsDeLaSemana() {
        RankingDeIncidentes ranking = new RankingDeIncidentes();
        ranking.setEstrategia(new MayorGradoDeImpacto());
        rankingMayorCantidadIncidentes = ranking.Rankear();
        ranking.setEstrategia(new MayorTiempoPromedioDeCierre());
        rankingMayorTiempoPromedioDeCierre = ranking.Rankear();
    }

    public void Generar() {
        this.setFecha();
        this.setRankingsDeLaSemana();
    }
}