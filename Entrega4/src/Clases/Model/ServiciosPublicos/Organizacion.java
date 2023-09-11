package Clases.Model.ServiciosPublicos;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Organizacion")

public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOrganizacion;

    @OneToOne
    @JoinColumn(name = "idTipoOrganizacion")
    private TipoOrganizacion tipoOrganizacion;

    @ManyToMany
    @JoinTable(
        name = "SucursalesXOrganizacion",
        joinColumns = @JoinColumn(name = "idOrganizacion"),
        inverseJoinColumns = @JoinColumn(name = "idSucursal")
    )
    private ArrayList<Sucursal> sucursales;
}
