package Clases.Model.ServiciosPublicos;

import java.util.ArrayList;
import Clases.Model.ComunidadesYMiembros.Localizacion;
import Clases.Model.ServiciosPublicos.Estacion;
import javax.persistence.*;
@Entity
@Table(name = "Linea")

public class Linea extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idLinea;

    @ManyToMany(mappedBy = "lineas")

    @ManyToOne
    @JoinColumn(name = "idEstacionOrigen")
    private Estacion estacionOrigen;
    @ManyToOne
    @JoinColumn(name = "idEstacionDestino")
    private Estacion estacionDestino;

    @ManyToMany
    @JoinTable(name = "EstacionesXLinea", joinColumns = @JoinColumn(name = "idLinea"), inverseJoinColumns = @JoinColumn(name = "idEstacion"))
    private ArrayList<Estacion> estacionesConformantes;
    private TipoTransporte tipoTransporte;

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

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