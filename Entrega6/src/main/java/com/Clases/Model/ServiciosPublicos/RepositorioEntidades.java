package  main.java.com.Clases.Model.ServiciosPublicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import main.java.com.Clases.Model.Servicios.Servicio;
import  main.java.com.Clases.Model.Shared.Utils;

@Repository
public interface RepositorioEntidades extends JpaRepository<Entidad,Long>{
	//@Modifying
	//	@Transactional
	 //@Query("Select * from entidad where linea_id_linea =?1 and estacion_id_estacion=?2 )")
	 Entidad findByLineaIdLineaAndEstacionIdEstacion(int idLinea, int idEstacion);

}
