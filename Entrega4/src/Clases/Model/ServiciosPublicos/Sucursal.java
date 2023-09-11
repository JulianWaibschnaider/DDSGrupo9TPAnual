package Clases.Model.ServiciosPublicos;
import javax.persistence.*;
@Entity
@Table(name = "Sucursal")

public class Sucursal extends Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;
}
