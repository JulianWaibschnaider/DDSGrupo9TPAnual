package Clases.Model.RankingsEInformes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import Clases.Model.IncidentesYNotificaciones.Incidente;
import Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import Clases.Model.ServiciosPublicos.Entidad;
import Clases.Model.ServiciosPublicos.RepositorioEntidades;

public class MayorCantidadIncidentes implements Rankear {

    public ArrayList<Entidad> Execute() {
        ArrayList<Entidad> rankingMayorCantidadIncidentes = new ArrayList<Entidad>();
        for (Entidad entidad : RepositorioEntidades.getEntidades()) {
            if (entidad.getIncidentesReportados() > 0) {
                rankingMayorCantidadIncidentes.add(entidad);
            }
        }
        rankingMayorCantidadIncidentes.sort(Comparator.comparingDouble(Entidad::getIncidentesReportados));
        return rankingMayorCantidadIncidentes;
    }
}
/*
 * entidades con mayor cantidad de incidentes reportados en la semana. Una vez
 * que un incidente sobre un servicio es reportado por algún usuario,
 * independientemente de la
 * comunidad de la que forma parte, no se consideran, para el presente ranking,
 * ningún incidente que
 * se genere sobre dicho servicio en un plazo de 24 horas siempre y cuando el
 * mismo continúe abierto
 * (un incidente reportado como cerrado anula el plazo sobre el servicio
 * y el siguiente incidente sí se considera para el cálculo);
 * 
 * 
 * TODO: sumar los incidentes reportados de la semana por entidad y si hay dos
 * incidentes en el mismo servicio, no sumar el segundo
 */