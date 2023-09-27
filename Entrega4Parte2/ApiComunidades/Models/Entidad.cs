using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ApiComunidades.Models
{
    [Table("Entidad")]
    public class Entidad
    {
        [Key]
        [Column("IdEntidad")]
        public int IdEntidad { get; set; }
        public string Nombre { get; set; }

        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            Entidad other = (Entidad)obj;
            return IdEntidad == other.IdEntidad;
        }

        // Sobrescribir el método GetHashCode para garantizar consistencia con Equals
        public override int GetHashCode()
        {
            return IdEntidad.GetHashCode();
        }



    }
}
