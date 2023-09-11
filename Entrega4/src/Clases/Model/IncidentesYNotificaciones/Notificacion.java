package Clases.Model.IncidentesYNotificaciones;
public class Notificacion{

private Incidente incidente;
private Boolean estado; //true es enviado y false es no enviado

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

public void enviarNotificacionCorreo(String email) {
    // Logica para enviar la notificacion por correo
}

public void enviarNotificacionWhatsApp(String nroTelefono) {
    // Logica para enviar la notificacion por WhatsApp
}

public Notificacion(Incidente incidente, Boolean estado) {
    this.incidente = incidente;
    this.estado = estado;
}
    
}