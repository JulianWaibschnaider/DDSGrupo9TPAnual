using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ApiComunidades.Models
{
    [Table("Comunidad")]
    public class Comunidad
    {
        [Key]
        [Column("IdComunidad")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdComunidad { get; set; }
        public string Nombre { get; set; }

        public List<Persona> Personas { get; set; } = new List<Persona>();

        public List<Servicio> Servicios { get; set; } = new List<Servicio>();

    }
}
