package Clases.Model.IncidentesYNotificaciones;

import Clases.Model.Servicios.Servicio; 

public interface Observer{
    void NotificarIncidente(Incidente incidente);
}