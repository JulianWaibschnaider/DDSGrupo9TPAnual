package Clases.ServiciosPublicos;

import Clases.IncidentesYNotificaciones.Incidente;
import Clases.Servicios.Servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Entidad {
    private String nombre;
    private ArrayList<Servicio> servicios;
    private UbicacionGeografica UbicacionGeografica;
    private ArrayList<Incidente> incidentes;
    private float promedioCierre;
    public float getPromedioCierre() {
        return promedioCierre;
    }

    public void setPromedioCierre(float promedioCierre) {
        this.promedioCierre = promedioCierre;
    }

    public ArrayList<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(ArrayList<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void addIncidenteEntidad(Incidente incidente) {
        incidentes.add(incidente);
    }

    public void UpdateIncidenteEntidad(Incidente incidente) {
        for (Incidente incidenteActual : incidentes) {
            if (incidenteActual.getId() == incidente.getId()) {
                incidenteActual = incidente;
            }
        }
    }

    public void CalcularPromedioCierre() {
        int suma = 0;
        int cantidad = 0;
        LocalDate finDeSemana = LocalDate.now().with(DayOfWeek.SUNDAY);
        for (Incidente incidente : incidentes) {
            if (incidente.getEstado() == false) {
                LocalDate fechaCierre = incidente.getfechaCierre().toLocalDate();
                if (fechaCierre.isBefore(finDeSemana) || fechaCierre.isEqual(finDeSemana)) {
                    suma += Math.toIntExact(incidente.getDiferenciaCierreApertura());
                    cantidad++;
                }

            }
        }
         this.setPromedioCierre(cantidad != 0 ? suma / cantidad : 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public UbicacionGeografica getUbicacionGeografica() {
        return UbicacionGeografica;
    }

    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        UbicacionGeografica = ubicacionGeografica;
    }

}
