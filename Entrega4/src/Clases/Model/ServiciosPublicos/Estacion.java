package Clases.Model.ServiciosPublicos;

import Clases.Model.Servicios.Servicio;
import java.util.ArrayList;
import javax.persistence.*;
@Entity
@Table(name="Estacion")

public class Estacion  extends Establecimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idEstacion;
    
    @ManyToMany
    @JoinTable(name = "estacion_linea", joinColumns = @JoinColumn(name = "idEstacion"), inverseJoinColumns = @JoinColumn(name = "idLinea"))
    private ArrayList<Linea> lineas;
}
