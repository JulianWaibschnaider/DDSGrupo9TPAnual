using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ApiComunidades.Models
{
    [Table("Sugerencia")]
    public class SugerenciaPersistida
    {
        [Key]
        [Column("IdSugerencia")]
        public int IdSugerencia { get; set; }
        public int IdComunidad1 { get; set; }
        public int IdComunidad2 { get; set; }

        public DateTime FechaSugerencia { get; set; }
    }
}
