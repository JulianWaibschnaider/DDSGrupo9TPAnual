package  main.java.com.Clases.Model.IncidentesYNotificaciones;

import java.util.List;
import  main.java.com.Clases.Model.ComunidadesYMiembros.Persona;
import java.util.Date;

public class NotificacionDeRevisionManual extends Notificacion {

    public NotificacionDeRevisionManual(Incidente incidente, Boolean estado) {
        super(incidente, estado);
    }

}
