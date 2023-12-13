package  main.java.com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl;

import java.util.List;

public class RepositorioEntidadesPrestadoras {
    public List<EntidadPrestadora> entidadesPrestadoras;
   
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