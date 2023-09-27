using ApiComunidades.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ApiComunidades.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ConfigController : ControllerBase
    {
        // GET: api/<ConfigController>
        [HttpGet]
        public Valores Get()
        {
            return Valores.GetValores();
        }


        // PUT api/<ConfigController>/5
        [HttpPut("PutValorServicio")]
        public void PutValorServicio(double valor, [FromBody] int value)
        {
            Valores valores = Valores.GetValores();
            valores.ValorServicio = valor;
        }

        [HttpPut("PutValorPersona")]
        public void PutValorPersona(double valor, [FromBody] int value)
        {
            Valores valores = Valores.GetValores();
            valores.ValorPersona = valor;
        }

        [HttpPut("PutValorEntidad")]
        public void PutValorEntidad(double valor, [FromBody] int value)
        {
            Valores valores = Valores.GetValores();
            valores.ValorEntidad = valor;
        }

    }
}
