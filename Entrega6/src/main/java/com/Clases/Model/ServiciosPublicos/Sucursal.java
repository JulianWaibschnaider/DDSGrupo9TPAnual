package  main.java.com.Clases.Model.ServiciosPublicos;
import jakarta.persistence.*;
@Entity
@Table(name="Sucursal")
//@PrimaryKeyJoinColumn(name = "idSucursal")
public class Sucursal/* extends Entidad */{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;
}
