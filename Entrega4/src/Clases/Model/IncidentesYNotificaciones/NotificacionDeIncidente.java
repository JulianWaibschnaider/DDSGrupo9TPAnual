package Clases.Model.IncidentesYNotificaciones;

import java.util.ArrayList;
import java.util.Date;
import Clases.Model.ComunidadesYMiembros.Comunidad;
import Clases.Model.ComunidadesYMiembros.TipoMedioComunicacion;
import Clases.Model.Servicios.Servicio;

public class NotificacionDeIncidente extends Notificacion{

    public NotificacionDeIncidente(Incidente incidente, Boolean estado) {
        super(incidente, estado);
    }

  //ENVIAR WPP y MAIL TENDRIA DISTINTO CONTENIDO QUE LA OTRA NOTIFICACION
}
