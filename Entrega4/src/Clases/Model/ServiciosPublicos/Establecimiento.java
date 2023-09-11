package Clases.Model.ServiciosPublicos;
import javax.persistence.*;
@Entity
@Table(name = "Establecimiento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Establecimiento extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstablecimiento;
}
