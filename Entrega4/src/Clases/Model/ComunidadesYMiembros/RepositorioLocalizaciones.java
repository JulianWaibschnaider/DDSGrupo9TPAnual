package Clases.Model.ComunidadesYMiembros;

import java.util.ArrayList;

public class RepositorioLocalizaciones{

    public ArrayList<Localizacion> localizaciones = new ArrayList<Localizacion>();

    public ArrayList<Localizacion> getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(ArrayList<Localizacion> localizaciones) {
        this.localizaciones = localizaciones;
    }

    public void addLocalizaciones(Localizacion localizacion) {
        this.localizaciones.add(localizacion);
    }



}