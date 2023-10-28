package  main.java.com.Clases.Model.ServiciosPublicos;

import  main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;
import  main.java.com.Clases.Model.Servicios.Servicio;
import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="Entidad")

//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntidad;
    private String nombre;
    @ManyToMany
    @JoinTable(name = "ServiciosXEntidad", joinColumns = @JoinColumn(name = "idEntidad"), inverseJoinColumns = @JoinColumn(name = "idServicio"))
    private List<Servicio> servicios;
    @OneToOne
    @JoinColumn(name = "idUbiacionGeografica")
    private UbicacionGeografica UbicacionGeografica;
    @ManyToMany
    @JoinTable(name = "IncidentesXEntidad", joinColumns = @JoinColumn(name = "idEntidad"), inverseJoinColumns = @JoinColumn(name = "idIncidente"))
    private List<Incidente> incidentes;
    private float promedioCierreIncidentes;
    private int incidentesReportados;

    public int getIncidentesReportados() {
        CalcularCantidadIncidentesReportados();
        return incidentesReportados;
    }

    public void setIncidentesReportados(int incidentesReportados) {
        this.incidentesReportados = incidentesReportados;
    }

    public float getPromedioCierreIncidentes() {
        CalcularPromedioCierreIncidentes();
        return promedioCierreIncidentes;
    }

    public void setPromedioCierreIncidentes(float promedio) {
        this.promedioCierreIncidentes = promedio;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void addIncidenteEntidad(Incidente incidente) {
        if (incidentes.size() == 0) {
            incidentes.add(incidente);
        } else {
            for (Incidente incidenteEnLista : incidentes) {
                if (incidenteEnLista.getfechaApertura().plusHours(24).isAfter(LocalDateTime.now())
                        && incidenteEnLista.getServicio() == incidente.getServicio()) {
                    incidentes.add(incidente);
                    break;
                }
            }
        }
    }

    public void UpdateIncidenteEntidad(Incidente incidente) {
        for (Incidente incidenteActual : incidentes) {
            if (incidenteActual.getId() == incidente.getId()) {
                incidenteActual = incidente;
            }
        }
    }

    public void CalcularPromedioCierreIncidentes() {
        int suma = 0;
        int cantidad = 0;
        LocalDate finDeSemana = LocalDate.now().with(DayOfWeek.SUNDAY);
        for (Incidente incidente : incidentes) {
            if (incidente.getEstado() == false) {
                LocalDate fechaCierre = incidente.getfechaCierre().toLocalDate();
                if (fechaCierre.isBefore(finDeSemana) || fechaCierre.isEqual(finDeSemana)) {
                    suma += Math.toIntExact(incidente.getDiferenciaCierreApertura());
                    cantidad++;
                }
            }
        }
        this.setPromedioCierreIncidentes(cantidad != 0 ? suma / cantidad : 0);
    }

    public void CalcularCantidadIncidentesReportados() {
        int cantidad = 0;
        LocalDate finDeSemana = LocalDate.now().with(DayOfWeek.SUNDAY);
        for (Incidente incidente : incidentes) {
            if (incidente.getfechaApertura().toLocalDate().isBefore(finDeSemana)) {
                cantidad++;
            }
        }
        this.setIncidentesReportados(cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public UbicacionGeografica getUbicacionGeografica() {
        return UbicacionGeografica;
    }

    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        UbicacionGeografica = ubicacionGeografica;
    }

}
