package Clases.EntidadesPrestadorasYOrganismosDeControl;

import java.util.ArrayList;

public class RepositorioEntidadesPrestadoras {
    public ArrayList<EntidadPrestadora> entidadesPrestadoras;
   
    public ArrayList<EntidadPrestadora> getEntidadesPrestadoras() {
        return entidadesPrestadoras;
    }

    public void setEntidadesPrestadoras(ArrayList<EntidadPrestadora> entidadesPrestadoras) {
        this.entidadesPrestadoras = entidadesPrestadoras;
    }

    public void addEntidadesPrestadoras(EntidadPrestadora entidadPrestadora) {
        this.entidadesPrestadoras.add(entidadPrestadora);
    }

}