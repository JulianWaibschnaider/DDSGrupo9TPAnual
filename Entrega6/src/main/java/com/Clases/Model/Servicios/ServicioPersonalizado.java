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

	private transient String TipoServicio= "Servicio personalizado";
	public String getTipoServicio() {
		return TipoServicio;
	}
    
    public String ObtenerAtributo(String json){
       //hacer
        return "Agregado";
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}
        
    }
