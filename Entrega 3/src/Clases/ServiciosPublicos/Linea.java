package Clases.ServiciosPublicos;

import java.util.ArrayList;
import Clases.ComunidadesYMiembros.Localizacion;
import Clases.ServiciosPublicos.Estacion;

public class Linea extends Entidad {
    private Estacion estacionOrigen;
    private Estacion estacionDestino;
    private ArrayList<Estacion> estacionesConformantes;

    public Estacion getEstacionOrigen() {
        return estacionOrigen;
    }

    public void setEstacionOrigen(Estacion estacionOrigen) {
        this.estacionOrigen = estacionOrigen;
    }

    public Estacion getEstacionDestino() {
        return estacionDestino;
    }

    public void setEstacionDestino(Estacion estacionDestino) {
        this.estacionDestino = estacionDestino;
    }

    public ArrayList<Estacion> getEstacionesConformantes() {
        return estacionesConformantes;
    }

    public void setEstacionesConformantes(ArrayList<Estacion> estacionesConformantes) {
        this.estacionesConformantes = estacionesConformantes;
    }

    public ArrayList<Localizacion> ObtenerLocalizaciones(){
        //hacer
        return null;
    }

}