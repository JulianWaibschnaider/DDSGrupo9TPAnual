package main.java.com.Clases.Model.Servicios;

import java.util.List;
import jakarta.persistence.*;

@Entity
//@Table(name = "MedioElevacion")
@DiscriminatorValue("MEDIOELEVACION")  
public class MedioElevacion extends Servicio {
  /* @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedioElevacion;*/
	//@Enumerated(EnumType.ORDINAL)
	private TipoElevacion tipoElevacion;
	private Integer distanciaCalle;
	private Integer distanciaAnden;
	
	private transient String TipoServicio= "Medio Elevacion";
	public String getTipoServicio() {
		return TipoServicio;
	}
	public Integer getDistanciaCalle() {
		return distanciaCalle;
	}
	public void setDistanciaCalle(Integer distanciaCalle) {
		this.distanciaCalle = distanciaCalle;
	}
	public Integer getDistanciaAnden() {
		return distanciaAnden;
	}
	public void setDistanciaAnden(Integer distanciaAnden) {
		this.distanciaAnden = distanciaAnden;
	}
	public TipoElevacion getTipoElevacion() {
		return tipoElevacion;
	}
	public void setTipoElevacion(TipoElevacion tipoElevacion) {
		this.tipoElevacion = tipoElevacion;
	}

}