package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;
import java.util.Date;
import Clases.ComunidadesYMiembros.Comunidad;
import Clases.ComunidadesYMiembros.TipoMedioComunicacion;
import Clases.Servicios.Servicio;

public class NotificacionDeIncidente {
    private Incidente incidente;
    private Boolean estado;//true es enviado y false es no enviado

    public Incidente getIncidente() {
        return incidente;
    }
    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public NotificacionDeIncidente(Incidente incidente, Boolean estado) {
        this.incidente = incidente;
        this.estado = estado;
    }

    public void enviarNotificacionCorreo(String email) {
        // Logica para enviar la notificacion por correo
    }

    public void enviarNotificacionWhatsApp(String nroTelefono) {
        // Logica para enviar la notificacion por WhatsApp
    }
}
