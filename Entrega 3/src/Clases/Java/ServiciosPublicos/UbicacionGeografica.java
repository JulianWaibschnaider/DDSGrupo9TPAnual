package Clases.ServiciosPublicos;

import Clases.ComunidadesYMiembros.Localizacion;


public class UbicacionGeografica {
    private String calle;
    private Integer altura;
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
