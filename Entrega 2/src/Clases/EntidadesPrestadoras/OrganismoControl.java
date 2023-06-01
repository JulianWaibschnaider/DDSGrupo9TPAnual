package Clases.EntidadesPrestadoras;
import java.util.ArrayList;

public class OrganismoControl{

    private String nombre;
    private ArrayList<EntidadPropietaria> entidadesPropietarias;
    private UsuarioEncargado usuarioEncargado;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<EntidadPropietaria> getEntidadesPropietarias() {
        return entidadesPropietarias;
    }
    public void setEntidadesPropietarias(ArrayList<EntidadPropietaria> entidadesPropietarias) {
        this.entidadesPropietarias = entidadesPropietarias;
    }
    public UsuarioEncargado getUsuarioEncargado() {
        return usuarioEncargado;
    }
    public void setUsuarioEncargado(UsuarioEncargado usuarioEncargado) {
        this.usuarioEncargado = usuarioEncargado;
    }

}