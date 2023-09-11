package Clases.RankingsEInformes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Clases.ServiciosPublicos.Entidad;

public class Informe {
    private ArrayList<Entidad> rankingMayorCantidadIncidentes;
    private ArrayList<Entidad> rankingMayorTiempoPromedioDeCierre;
    // private ArrayList<Entidad> rankingMayorGradoDeImpacto; ESTE ES EL CRITERIO QUE FALTA
    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    public ArrayList<Entidad> getRankingMayorCantidadIncidentes() {
        return rankingMayorCantidadIncidentes;
    }

    public ArrayList<Entidad> getRankingMayorTiempoPromedioDeCierre() {
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