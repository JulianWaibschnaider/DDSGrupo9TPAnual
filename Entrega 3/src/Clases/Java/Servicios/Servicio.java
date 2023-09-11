package Clases.Servicios;

import java.util.ArrayList;

import Clases.IncidentesYNotificaciones.Incidente;
import Clases.ServiciosPublicos.Entidad;

public class Servicio {
    private Boolean enFuncionamiento;
    private Entidad entidad;

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Boolean getEnFuncionamiento() {
        return enFuncionamiento;
    }

    public void setEnFuncionamiento(Boolean enFuncionamiento) {
        this.enFuncionamiento = enFuncionamiento;
        //Aca activo al notificador si es false
    }
}