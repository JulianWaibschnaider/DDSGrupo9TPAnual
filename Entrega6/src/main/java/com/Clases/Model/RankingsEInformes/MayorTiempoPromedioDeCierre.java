package  main.java.com.Clases.Model.RankingsEInformes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import main.java.com. Clases.Model.IncidentesYNotificaciones.Incidente;
import  main.java.com.Clases.Model.IncidentesYNotificaciones.RepositorioIncidentes;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import  main.java.com.Clases.Model.ServiciosPublicos.RepositorioEntidades;

public class MayorTiempoPromedioDeCierre implements Rankear {

    public List<Entidad> Execute() {
        // recorrer lista de incidentes y buscar el que tenga mayor tiempo de cierre
        // devolvemos la entidad que tiene ese incidente
        List<Entidad> rankingMayorTiempoPromedioDeCierre = new ArrayList<Entidad>();

       /* for (Entidad entidad : RepositorioEntidades.getEntidades()) {
            if (entidad.getPromedioCierreIncidentes() > 0) {
                rankingMayorTiempoPromedioDeCierre.add(entidad);
            }
        }
        
        rankingMayorTiempoPromedioDeCierre.sort(Comparator.comparingDouble(Entidad::getPromedioCierreIncidentes));*/
        return rankingMayorTiempoPromedioDeCierre;
    }
}