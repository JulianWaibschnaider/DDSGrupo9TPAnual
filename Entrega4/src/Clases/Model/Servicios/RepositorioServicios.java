package Clases.Model.Servicios;

import java.util.ArrayList;

import Clases.Model.ServiciosPublicos.Entidad;
import Clases.Model.ServiciosPublicos.UbicacionGeografica;
import Clases.Model.Shared.Utils;

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
