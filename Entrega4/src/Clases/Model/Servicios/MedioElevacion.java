package Clases.Model.Servicios;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "MedioElevacion")
public class MedioElevacion extends Servicio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedioElevacion;
    private TipoElevacion tipoElevacion;
    private Integer distanciaCalle;
    private Integer distanciaAnden;

}