package Clases.EntidadesPrestadorasYOrganismosDeControl;

public class EntidadPropietaria {
    public String nombre;
    public EntidadPropietaria entidadPrestadora;
    public OrganismoDeControl organismoDeControl;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public EntidadPropietaria getEntidadPrestadora() {
        return entidadPrestadora;
    }
    public void setEntidadPrestadora(EntidadPropietaria entidadPrestadora) {
        this.entidadPrestadora = entidadPrestadora;
    }
    public OrganismoDeControl getOrganismoDeControl() {
        return organismoDeControl;
    }
    public void setOrganismoDeControl(OrganismoDeControl organismoDeControl) {
        this.organismoDeControl = organismoDeControl;
    }
}
