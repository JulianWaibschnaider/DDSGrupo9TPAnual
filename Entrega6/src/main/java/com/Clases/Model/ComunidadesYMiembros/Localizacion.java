package  main.java.com.Clases.Model.ComunidadesYMiembros;
import jakarta.persistence.*;

@Entity
@Table(name="Localizacion")
public class Localizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocalizacion;
    private String nombre;
   @Enumerated(EnumType.STRING)
    private TipoLocalizacion tipoLocalizacion;
    @OneToOne
    @JoinColumn(name = "idLocalizacion")
    private Localizacion localizacionSuperior;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TipoLocalizacion getTipoLocalizacion() {
        return tipoLocalizacion;
    }
    public void setTipoLocalizacion(TipoLocalizacion tipoLocalizacion) {
        this.tipoLocalizacion = tipoLocalizacion;
    }
    public Localizacion getLocalizacionSuperior() {
        return localizacionSuperior;
    }
    public void setLocalizacionSuperior(Localizacion localizacionSuperior) {
        this.localizacionSuperior = localizacionSuperior;
    }
}
