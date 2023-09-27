using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ApiComunidades.Models
{
    [Table("Persona")]
    public class Persona
    {
        [Key]
        [Column("IdPersona")]
        public int IdPersona { get; set; }

        public string Nombre { get; set; }

        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            Persona other = (Persona)obj;
            return IdPersona == other.IdPersona;
        }

        // Sobrescribir el método GetHashCode para garantizar consistencia con Equals
        public override int GetHashCode()
        {
            return IdPersona.GetHashCode();
        }
    }
}
