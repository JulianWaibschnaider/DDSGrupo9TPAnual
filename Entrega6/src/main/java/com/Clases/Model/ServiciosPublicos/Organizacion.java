package  com.Clases.Model.ServiciosPublicos;
import jakarta.persistence.*;
import java.util.List;

/*@Entity
@Table(name = "Organizacion")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOrganizacion;

    @Enumerated(EnumType.ORDINAL)
    private TipoOrganizacion tipoOrganizacion;

    @ManyToMany
    @JoinTable(
        name = "SucursalesXOrganizacion",
        joinColumns = @JoinColumn(name = "idOrganizacion"),
        inverseJoinColumns = @JoinColumn(name = "idSucursal")
    )
    private List<Sucursal> sucursales;
}
//FUERA*/
