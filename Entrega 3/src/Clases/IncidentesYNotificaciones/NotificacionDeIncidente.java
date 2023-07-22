package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;
import java.util.Date;
import Clases.ComunidadesYMiembros.Comunidad;
import Clases.Servicios.Servicio;

public class NotificacionDeIncidente implements Observer {
    private Incidente incidente;
    private String descripcion;
    private Date horario;
    private Boolean estado;

    public void EnviarA(Servicio servicio) {
        if (servicio.getEnFuncionamiento() == false) {

        }
    }
}
