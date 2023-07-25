package Clases.Servicios;

import java.util.ArrayList;


public class RepositorioServicios {
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    public void addServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

}
