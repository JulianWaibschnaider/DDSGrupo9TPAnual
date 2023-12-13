package  com.Clases.Model.ServiciosPublicos;

import java.util.List;
import  com.Clases.Model.ComunidadesYMiembros.Localizacion;
import  com.Clases.Model.ServiciosPublicos.Estacion;
import jakarta.persistence.*;
@Entity
@Table(name = "Linea")
public class Linea/* extends Entidad*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idLinea;
    
    public int getIdLinea() {
    	return idLinea;
    }
    

    @ManyToMany(mappedBy = "lineas")

    @ManyToOne
    @JoinColumn(name = "idEstacionOrigen")
    private Estacion estacionOrigen;
    @ManyToOne
    @JoinColumn(name = "idEstacionDestino")
    private Estacion estacionDestino;
    private String nombre;

    @ManyToMany
    @JoinTable(name = "EstacionesXLinea", joinColumns = @JoinColumn(name = "idLinea"), inverseJoinColumns = @JoinColumn(name = "idEstacion"))
    private List<Estacion> estacionesConformantes;
    @Enumerated(EnumType.ORDINAL)
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

    public List<Estacion> getEstacionesConformantes() {
        return estacionesConformantes;
    }

    public void setEstacionesConformantes(List<Estacion> estacionesConformantes) {
        this.estacionesConformantes = estacionesConformantes;
    }

    public List<Localizacion> ObtenerLocalizaciones(){
        //hacer
        return null;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

