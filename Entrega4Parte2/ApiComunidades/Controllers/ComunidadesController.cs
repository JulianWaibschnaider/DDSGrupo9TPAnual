using ApiComunidades.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ApiComunidades.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ComunidadesController : ControllerBase
    {
        // GET: api/<ComunidadesController>
        [HttpGet("Sugerir")]
        public List<Sugerencia> Sugerir()
        {
            return ComunidadHandler.SugerirFusion();
        }
        [HttpGet("VerCoincidencias")]
        public List<CalculadorCoincidencia> VerCoincidencias()
        {
            return ComunidadHandler.VerCoincidencias();
        }

        // GET api/<ComunidadesController>
        [HttpGet("GetComunidades")]
        public List<Comunidad> GetComunidades()
        {
            return ComunidadHandler.ObtenerComunidadesCompletas();
        }

        [HttpPost("AceptarSugerencia")]
        public Comunidad AceptarSugerencias(int idComunidad1, int idComunidad2)
        {
            return ComunidadHandler.AceptarSugerencia(idComunidad1, idComunidad2);
        }

    }
}
