package  main.java.com.Clases.Model.Servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import main.java.com.Clases.Model.ComunidadesYMiembros.Usuario;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import  main.java.com.Clases.Model.ServiciosPublicos.UbicacionGeografica;
import  main.java.com.Clases.Model.Shared.Utils;
@Repository
public interface RepositorioServicios extends JpaRepository<Servicio,Long> {

	Servicio findServicioByIdServicio(int id_Servicio);

}
