package Clases.IncidentesYNotificaciones;

import Clases.Servicios.Servicio; 

public interface Observer{
    void NotificarIncidente(Incidente incidente);
}