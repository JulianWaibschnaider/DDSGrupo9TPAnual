package Clases.Model.Servicios;

import java.util.ArrayList;

import Clases.Model.IncidentesYNotificaciones.Incidente;
import Clases.Model.ServiciosPublicos.Entidad;
import javax.persistence.*;

@Entity
@Table(name = "Servicio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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