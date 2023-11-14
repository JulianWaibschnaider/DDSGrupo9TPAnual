package  main.java.com.Clases.Model.IncidentesYNotificaciones;

import  main.java.com.Clases.Model.Servicios.Servicio; 

public interface Observer{
    void NotificarIncidente(Incidente incidente);
}