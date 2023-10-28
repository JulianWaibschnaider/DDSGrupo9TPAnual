package  main.java.com.Clases.Model.Servicios;

import java.util.List;
import java.util.ArrayList;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import  main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  main.java.com.Clases.Model.Shared.Utils;

public class RepositorioServicios {
    private List<Servicio> servicios = new ArrayList<Servicio>();

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void addServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }



}
