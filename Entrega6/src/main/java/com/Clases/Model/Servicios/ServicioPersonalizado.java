package  main.java.com.Clases.Model.Servicios;

import java.util.List;
import jakarta.persistence.*;

@Entity
//@Table(name = "ServicioPersonalizado")
@DiscriminatorValue("SERVICIOPERSONALIZADO")  
public class ServicioPersonalizado extends Servicio{
    /*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicioPersonalizado;*/
    private String nombre;
    private String atributos;

    public String ObtenerAtributo(String json){
       //hacer
        return "Agregado";
    }
        
    }
