package  main.java.com.Clases.Model.ServiciosPublicos;
import javax.persistence.*;
//@Entity
//@Table(name="Establecimiento")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Establecimiento extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstablecimiento;
}
