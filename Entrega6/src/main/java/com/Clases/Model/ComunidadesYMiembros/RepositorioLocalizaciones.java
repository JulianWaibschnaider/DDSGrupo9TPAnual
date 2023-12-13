package  main.java.com.Clases.Model.ComunidadesYMiembros;

import java.util.List;
import java.util.ArrayList;
public class RepositorioLocalizaciones{

    public List<Localizacion> localizaciones = new ArrayList<Localizacion>();

    public List<Localizacion> getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(List<Localizacion> localizaciones) {
        this.localizaciones = localizaciones;
    }

    public void addLocalizaciones(Localizacion localizacion) {
        this.localizaciones.add(localizacion);
    }



}