package Clases.ServiciosPublicos;

import Clases.Servicios.Servicio;
import java.util.ArrayList;

public class Entidad {
    private String nombre;
    private ArrayList<Servicio> servicios;
    private UbicacionGeografica UbicacionGeografica;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    public UbicacionGeografica getUbicacionGeografica() {
        return UbicacionGeografica;
    }
    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        UbicacionGeografica = ubicacionGeografica;
    }

    
}
