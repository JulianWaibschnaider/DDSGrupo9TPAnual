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
	@Enumerated(EnumType.ORDINAL)
	private TipoElevacion tipoElevacion;
	private Integer distanciaCalle;
	private Integer distanciaAnden;

}