package  com.Clases.Model.IncidentesYNotificaciones;


public class NotificacionDeIncidente extends Notificacion{

    public NotificacionDeIncidente(Incidente incidente, Boolean estado) {
        super(incidente, estado);
    }

  //ENVIAR WPP y MAIL TENDRIA DISTINTO CONTENIDO QUE LA OTRA NOTIFICACION
}
