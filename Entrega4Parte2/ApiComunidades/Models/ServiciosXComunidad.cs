using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ApiComunidades.Models
{
    [Table("ServiciosXComunidad")]
    public class ServiciosXComunidad
    {
        [Key]
        [Column("IdServiciosXComunidad")]
        public int IdServiciosXComunidad { get; set; }

        public int IdServicio { get; set; }
        public int IdComunidad { get; set; }
    }
}
