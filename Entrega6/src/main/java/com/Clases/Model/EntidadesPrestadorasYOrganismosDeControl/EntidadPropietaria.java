package  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;
import jakarta.persistence.*;
@Entity
@Table(name = "EntidadPropietaria")

public class EntidadPropietaria {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEntidadPropietaria;
    private String nombre;

    /*@OneToOne
    @JoinColumn(name = "idEntidadPrestadora")
    private EntidadPropietaria entidadPrestadora;*/

    //@OneToOne
   // @JoinColumn(name = "idOrganismoDeControl")
   // private OrganismoDeControl organismoDeControl;

   // @ManyToMany(mappedBy = "entidadesPropietarias")
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  /*  public EntidadPropietaria getEntidadPrestadora() {
        return entidadPrestadora;
    }
    public void setEntidadPrestadora(EntidadPropietaria entidadPrestadora) {
        this.entidadPrestadora = entidadPrestadora;
    }
    public OrganismoDeControl getOrganismoDeControl() {
        return organismoDeControl;
    }
    public void setOrganismoDeControl(OrganismoDeControl organismoDeControl) {
        this.organismoDeControl = organismoDeControl;
    }*/
}
