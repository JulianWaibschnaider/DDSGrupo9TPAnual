package  main.java.com.Clases.Model.ServiciosPublicos;

import  main.java.com.Clases.Model.Servicios.Servicio;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name="Estacion")

public class Estacion  /*extends Entidad*/{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idEstacion;
   
   public int getidEstacion() {
	   return idEstacion;
   }
   
    
   private String nombre;
  /*  @ManyToMany
    @JoinTable(name = "estacion_linea", joinColumns = @JoinColumn(name = "idEstacion"), inverseJoinColumns = @JoinColumn(name = "idLinea"))
    private List<Linea> lineas;*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
