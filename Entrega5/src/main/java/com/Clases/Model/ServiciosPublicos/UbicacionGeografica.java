package  main.java.com.Clases.Model.ServiciosPublicos;
import javax.persistence.*;
import  main.java.com.Clases.Model.ComunidadesYMiembros.Localizacion;

@Entity
@Table(name="UbicacionGeografica")
@Embeddable
public class UbicacionGeografica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacionGeografica;
    private String calle;
    private Integer altura;
    @OneToOne
    @JoinColumn(name = "idLocalizacion")
    private Localizacion localizacion;
    private Double latitud;
    private Double longitud;
    
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public Integer getAltura() {
        return altura;
    }
    public void setAltura(Integer altura) {
        this.altura = altura;
    }
    public Localizacion getLocalizacion() {
        return localizacion;
    }
    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    } 
    
}
