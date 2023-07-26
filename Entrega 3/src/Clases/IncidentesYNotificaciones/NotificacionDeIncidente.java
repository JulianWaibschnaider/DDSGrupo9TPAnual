package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;
import java.util.Date;
import Clases.ComunidadesYMiembros.Comunidad;
import Clases.ComunidadesYMiembros.TipoMedioComunicacion;
import Clases.Servicios.Servicio;

public class NotificacionDeIncidente extends Notificacion{

    public NotificacionDeIncidente(Incidente incidente, Boolean estado) {
        super(incidente, estado);
    }

  //ENVIAR WPP y MAIL TENDRIA DISTINTO CONTENIDO QUE LA OTRA NOTIFICACION
}
