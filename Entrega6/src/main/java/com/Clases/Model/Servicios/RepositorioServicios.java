package  main.java.com.Clases.Model.Servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import  main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  main.java.com.Clases.Model.Shared.Utils;
@Repository
public interface RepositorioServicios extends JpaRepository<Servicio,Long> {

	Servicio findServicioByIdServicio(int id_Servicio);
	/*@Modifying
	@Transactional
    @Query("update Servicio set enFuncionamiento = ?2 where IdServicio=?1")
	int UpdateEnFuncionamientoByIdServicio(int idServicio, boolean estado);
	*/
	//@Modifying
	//@Transactional
    //@Query("SELECT * from servicio where id_entidad= (select id_entidad from entidad where linea_id_linea =?1 and estacion_id_estacion=?2 )")
	List<Servicio> findServicioByEntidadIdEntidad(int idEntidad);
}
