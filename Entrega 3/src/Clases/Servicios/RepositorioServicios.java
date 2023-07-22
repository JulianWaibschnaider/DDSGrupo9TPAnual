package Clases.Servicios;

import java.util.ArrayList;

import Clases.IncidentesYNotificaciones.Observer;

public class RepositorioServicios {
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    private ArrayList<Observer> observadores = new ArrayList<Observer>();

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    public void addServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

    public void notificarObservadores(Servicio servicio) {
        for (Observer observador : observadores) {
            observador.EnviarA(servicio);
        }
    }


}
