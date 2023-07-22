package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;

public class RepositorioIncidentes {
    public static ArrayList<Incidente> incidentes = new ArrayList<Incidente>();

    public ArrayList<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(ArrayList<Incidente> incidente) {
        this.incidentes = incidente;
    }

    public void addIncidentes(Incidente incidente) {
        this.incidentes.add(incidente);
    }

    public static ArrayList<Incidente> GetIncidentesPorEstado(Boolean estado){
        //estamos permitiendo que una persona haga la consulta de incidentes por estado, de todos los incidentes que existen en el sistema.
        //la consigna no especifica si debería ser de los incidentes de la comunidad en la que la persona está.
        ArrayList<Incidente> incidentesPorEstado = new ArrayList<Incidente>();
        for (Incidente incidente : incidentes) {
            if (incidente.getEstado() == estado) {
                incidentesPorEstado.add(incidente);
            }
        }
        return incidentesPorEstado;
    }

}
