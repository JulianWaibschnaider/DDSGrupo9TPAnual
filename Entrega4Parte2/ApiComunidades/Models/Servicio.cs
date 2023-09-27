using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ApiComunidades.Models
{
    [Table("Servicio")]
    public class Servicio
    {
        [Key]
        [Column("IdServicio")]
        public int IdServicio { get; set; }
        public Entidad Entidad { get; set; }   = new Entidad();



        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            Servicio other = (Servicio)obj;
            return IdServicio == other.IdServicio;
        }

        // Sobrescribir el método GetHashCode para garantizar consistencia con Equals
        public override int GetHashCode()
        {
            return IdServicio.GetHashCode();
        }

    }
}
