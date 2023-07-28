package Clases.ServiciosPublicos;

import java.util.ArrayList;
import Clases.Shared.Utils;

public class RepositorioEntidades {
    
    private static ArrayList<Entidad> entidades = new ArrayList<Entidad>();

    public static ArrayList<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidades = entidades;
    }

    public void addEntidad(Entidad entidad) {
        this.entidades.add(entidad);
    }


}
