package Clases.RankingsEInformes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import Clases.IncidentesYNotificaciones.Incidente;
import Clases.IncidentesYNotificaciones.RepositorioIncidentes;
import Clases.ServiciosPublicos.Entidad;
import Clases.ServiciosPublicos.RepositorioEntidades;

public class MayorTiempoPromedioDeCierre implements Rankear {

    public ArrayList<Entidad> Execute() {
        // recorrer lista de incidentes y buscar el que tenga mayor tiempo de cierre
        // devolvemos la entidad que tiene ese incidente
        ArrayList<Entidad> rankingMayorTiempoPromedioDeCierre = new ArrayList<Entidad>();

        for (Entidad entidad : RepositorioEntidades.getEntidades()) {
            if (entidad.getPromedioCierreIncidentes() > 0) {
                rankingMayorTiempoPromedioDeCierre.add(entidad);
            }
        }
        
        rankingMayorTiempoPromedioDeCierre.sort(Comparator.comparingDouble(Entidad::getPromedioCierreIncidentes));
        return rankingMayorTiempoPromedioDeCierre;
    }
}