package Clases.IncidentesYNotificaciones;

import java.util.ArrayList;
import Clases.ComunidadesYMiembros.Persona;
import java.util.Date; 

public class NotificacionDeRevisionManual {
	private Incidente incidente;
    private Persona persona;
    private Boolean estado;

    public void Enviar() {
		
	}

    public void NotificarPorLocalizacion() {
        
    }
    //lo que vamos a hacer es tomar como "cerca" que la localizacion actual de la persona y del servicio roto tengan el mismo municipio
    //cuando esas dos cosas coincidan, se notifica
    //cada 1 hora que mire la localizacion actual de las personas
}
