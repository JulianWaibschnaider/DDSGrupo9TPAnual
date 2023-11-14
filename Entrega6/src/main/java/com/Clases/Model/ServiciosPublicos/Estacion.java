package  main.java.com.Clases.Model.ServiciosPublicos;

import  main.java.com.Clases.Model.Servicios.Servicio;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="Estacion")

public class Estacion  /*extends Entidad*/{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idEstacion;
    
    @ManyToMany
    @JoinTable(name = "estacion_linea", joinColumns = @JoinColumn(name = "idEstacion"), inverseJoinColumns = @JoinColumn(name = "idLinea"))
    private List<Linea> lineas;
}
