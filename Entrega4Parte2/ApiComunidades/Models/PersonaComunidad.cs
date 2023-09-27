using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ApiComunidades.Models
{
    [Table("PersonasXComunidad")]
    public class PersonaComunidad
    {
        [Key]
        [Column("IdPersonasXComunidad")]
        public int IdPersonaXComunidad { get; set; }

        [ForeignKey("IdPersona")]
        public int IdPersona { get; set; }
        public Persona Persona { get; set; } = new Persona();
        [ForeignKey("IdComunidad")]
        public int IdComunidad { get; set; }
        public Comunidad Comunidad { get; set; } = new Comunidad();
    }
}
