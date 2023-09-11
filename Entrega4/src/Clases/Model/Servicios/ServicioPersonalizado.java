package Clases.Model.Servicios;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "ServicioPersonalizado")

public class ServicioPersonalizado extends Servicio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicioPersonalizado;
    private String nombre;
    private String atributos;

    public String ObtenerAtributo(String json){
       //hacer
        return "Agregado";
    }
        
    }
