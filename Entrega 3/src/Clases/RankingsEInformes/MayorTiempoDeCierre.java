package Clases.RankingsEInformes;

import java.time.DayOfWeek;
import java.time.LocalDate;

import Clases.IncidentesYNotificaciones.Incidente;
import Clases.IncidentesYNotificaciones.RepositorioIncidentes;
import Clases.ServiciosPublicos.Entidad;
import Clases.ServiciosPublicos.RepositorioEntidades;

public class MayorTiempoDeCierre implements Rankear{
    
    public void Execute(){        
        //recorrer lista de incidentesd y buscar el que tenga mayor tiempo de cierre
        //devolvemos la entidad que tiene ese incidente
        RepositorioIncidentes incidentes = new RepositorioIncidentes();
        LocalDate inicioSemana = LocalDate.now().with(DayOfWeek.MONDAY);
       /*  for (Incidentes incidente : incidentes) {
            if (incidente.getHorarioApertura().isAfter(inicioSemana)){
                

            }
        }*/
            
        


    }
}