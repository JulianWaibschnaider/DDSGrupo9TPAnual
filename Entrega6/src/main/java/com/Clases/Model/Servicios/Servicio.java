package  com.Clases.Model.Servicios;

import java.util.List;

import  com.Clases.Model.IncidentesYNotificaciones.Incidente;
import  com.Clases.Model.ServiciosPublicos.Entidad;
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
