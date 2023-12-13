package  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEntidadesPrestadoras {
    public List<EntidadPrestadora> entidadesPrestadoras;

    public RepositorioEntidadesPrestadoras() {
        this.entidadesPrestadoras = new ArrayList<>();
    }

    public List<EntidadPrestadora> getEntidadesPrestadoras() {
        return entidadesPrestadoras;
    }

    public void setEntidadesPrestadoras(List<EntidadPrestadora> entidadesPrestadoras) {
        this.entidadesPrestadoras = entidadesPrestadoras;
    }

    public void addEntidadesPrestadoras(EntidadPrestadora entidadPrestadora) {
        this.entidadesPrestadoras.add(entidadPrestadora);
    }

}
