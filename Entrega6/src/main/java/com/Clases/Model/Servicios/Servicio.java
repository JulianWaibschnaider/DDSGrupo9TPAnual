package  main.java.com.Clases.Model.Servicios;

import java.util.List;

import  main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import jakarta.persistence.*;

@Entity
//@MappedSuperclass
@Table(name = "Servicio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_servicio")
public class Servicio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
    
    public int getIdServicio() {
    	return idServicio;
    }
    private Boolean enFuncionamiento;
    @OneToOne
    @JoinColumn(name = "idEntidad")
    private Entidad entidad;

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Boolean getEnFuncionamiento() {
        return enFuncionamiento;
    }

    public void setEnFuncionamiento(Boolean enFuncionamiento) {
        this.enFuncionamiento = enFuncionamiento;
        //Aca activo al notificador si es false
    }
}