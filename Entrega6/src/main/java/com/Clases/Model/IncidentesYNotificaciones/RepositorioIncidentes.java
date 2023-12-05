package  main.java.com.Clases.Model.IncidentesYNotificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import  main.java.com.Clases.Model.Servicios.Servicio;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import  main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  main.java.com.Clases.Model.Shared.Utils;
//import javax.swing.Timer;
@Repository
public interface RepositorioIncidentes extends JpaRepository<Incidente,Long>{
    public static List<Incidente> incidentes = new ArrayList<Incidente>();
    @Modifying
    @Transactional
    @Query("update Incidente set estado = ?2 where id=?1")
    int updateEstadoById(int id, boolean estado);
    
    Incidente findIncidenteByid(int id);
	List<Incidente> findAllIncidenteByEstado(boolean estado);

    
    public static List<Incidente> getIncidentes() {
        return incidentes;
    }

    public static void addIncidentes(Incidente incidente) {
        RepositorioIncidentes.incidentes.add(incidente);
    }

    public static void deleteIncidentes(Incidente incidente) {
        RepositorioIncidentes.incidentes.remove(incidente);
    }

    public static void UpdateIncidentes(Incidente incidente) {
        for (Incidente incidenteActual : incidentes) {
            if (incidenteActual.getId() == incidente.getId()) {
                incidenteActual = incidente;
            }
        }
    }

    public static List<Incidente> GetIncidentesPorEstado(Boolean estado) {
        // estamos permitiendo que una persona haga la consulta de incidentes por
        // estado, de todos los incidentes que existen en el sistema.
        // la consigna no especifica si debería ser de los incidentes de la comunidad en
        // la que la persona está.
        List<Incidente> incidentesPorEstado = new ArrayList<Incidente>();
        for (Incidente incidente : incidentes) {
            if (incidente.getEstado() == estado) {
                incidentesPorEstado.add(incidente);
            }
        }
        return incidentesPorEstado;
    }

    public static List<Incidente> incidentesNoEnviados = new ArrayList<Incidente>();

    public static void addIncidenteNoEnviado(Incidente incidente) {
        incidentesNoEnviados.add(incidente);
    }


    public static void EnviarIncidentesNoEnviados() {
       //aca va el timer que se ejecuta cada 30 min 
        for (Incidente incidentenoEnviado : incidentesNoEnviados) {
            incidentenoEnviado.NotificarIncidente();
        }
    }

    public static Incidente BuscarLocalizacionCercana(UbicacionGeografica ubicacion) {
        // la que llega por parametro es la ubicacion actual de la persona
        // pactamos que "cerca" es estar a 500 metros del lugar del incidente
        for (Incidente incidente : incidentes) {
            if (incidente.getEstado() == true) {// si el incidente esta abierto
                Servicio servicio = incidente.getServicio();
                // se supone que todos los servicios que estan en esta lista de incidentes estan
                // fuera de servicio, porque el incidente esta abierto
                Entidad entidad = servicio.getEntidad();

                Double longitud = entidad.getUbicacionGeografica().getLongitud();
                Double latitud = entidad.getUbicacionGeografica().getLatitud();

                Double distancia = Utils.CalcularDistancia(longitud, latitud, ubicacion.getLongitud(),
                        ubicacion.getLatitud());

                if (distancia <= 0.5) {// suponemos que son km
                    return incidente;
                }
            }
        }
        return null;
    }




}
