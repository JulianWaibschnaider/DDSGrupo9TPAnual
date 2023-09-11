package Clases.Model.IncidentesYNotificaciones;

import java.util.ArrayList;
import Clases.Model.ComunidadesYMiembros.Persona;
import java.util.Date;

public class NotificacionDeRevisionManual extends Notificacion {

    public NotificacionDeRevisionManual(Incidente incidente, Boolean estado) {
        super(incidente, estado);
    }

}
