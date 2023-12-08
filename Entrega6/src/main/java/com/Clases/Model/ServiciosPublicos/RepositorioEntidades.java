package  com.Clases.Model.ServiciosPublicos;

import java.util.List;
import java.util.ArrayList;
import  com.Clases.Model.Shared.Utils;

public class RepositorioEntidades {
    
    private static List<Entidad> entidades = new ArrayList<Entidad>();

    public static List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    public void addEntidad(Entidad entidad) {
        this.entidades.add(entidad);
    }


}
