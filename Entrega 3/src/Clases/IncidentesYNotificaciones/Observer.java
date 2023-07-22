package Clases.IncidentesYNotificaciones;

import Clases.Servicios.Servicio; 

public interface Observer{
    void EnviarA(Servicio servicio);
}