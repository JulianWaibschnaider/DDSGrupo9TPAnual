package Clases.ComunidadesYMiembros;

public class Localizacion {
    private String nombre;
    private TipoLocalizacion tipoLocalizacion;
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
