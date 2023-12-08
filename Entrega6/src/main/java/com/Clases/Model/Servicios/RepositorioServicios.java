package  com.Clases.Model.Servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import com.Clases.Model.ComunidadesYMiembros.Usuario;
import  com.Clases.Model.ServiciosPublicos.Entidad;
import  com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  com.Clases.Model.Shared.Utils;
@Repository
public interface RepositorioServicios extends JpaRepository<Servicio,Long> {

	Servicio findServicioByIdServicio(int id_Servicio);
	/*@Modifying
	@Transactional
    @Query("update Servicio set enFuncionamiento = ?2 where IdServicio=?1")
	int UpdateEnFuncionamientoByIdServicio(int idServicio, boolean estado);
	*/
}
