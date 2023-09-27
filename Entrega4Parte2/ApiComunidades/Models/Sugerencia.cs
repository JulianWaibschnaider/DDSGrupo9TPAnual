using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ApiComunidades.Models
{

    public class Sugerencia
    {

        [ForeignKey("IdComunidad1")]
        public Comunidad Comunidad1 { get; set; }
        [ForeignKey("IdComunidad2")]
        public Comunidad Comunidad2 { get; set; }
        public DateTime FechaSugerencia { get; set; } 


    }
}
