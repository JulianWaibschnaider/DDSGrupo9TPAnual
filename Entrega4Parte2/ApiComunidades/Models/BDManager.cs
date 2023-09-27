using Microsoft.EntityFrameworkCore;
using System.Data.Entity;
using System.Data.SqlClient;


namespace ApiComunidades.Models
{

    public class BDManager
    {
        public static List<Comunidad> ObtenerComunidades()
        {

            List<Comunidad> comunidades = new List<Comunidad>();
            using (var context = new BDContext())
            {
                comunidades = context.Comunidades.ToList();
            }
            return comunidades;

        }
        public static Comunidad ObtenerComunidadPorId(int id)
        {
            Comunidad comunidad = new Comunidad();
            using (var dbContext = new BDContext())
            {
                comunidad = dbContext.Comunidades.FirstOrDefault(c => c.IdComunidad == id);
            }
            return comunidad;
        }

        public static List<Persona> ObtenerPersonasXComunidad(int idComunidad)
        {
            List<Persona> personas = new List<Persona>();
            using (var dbContext = new BDContext())
            {
                personas = dbContext.Personas
             .Join(
                 dbContext.PersonasXComunidad,
                 persona => persona.IdPersona,
                 personaComunidad => personaComunidad.IdPersona,
                 (persona, personaComunidad) => new { Persona = persona, PersonaComunidad = personaComunidad }
             )
             .Where(joinResult => joinResult.PersonaComunidad.IdComunidad == idComunidad)
             .Select(joinResult => joinResult.Persona)
             .ToList();
            }
            return personas;
        }

        public static List<Servicio> ObtenerServiciosXComunidad(int idComunidad)
        {
            List<Servicio> servicios = new List<Servicio>();
            using (var dbContext = new BDContext())
            {
                servicios = (from s in dbContext.Servicios
                             join e in dbContext.Entidades on s.Entidad.IdEntidad equals e.IdEntidad
                             join sc in dbContext.ServiciosComunidad on s.IdServicio equals sc.IdServicio
                             where sc.IdComunidad == idComunidad
                             select new Servicio
                             {
                                 IdServicio = s.IdServicio,
                                 Entidad = e
                             }).ToList();
            }

            return servicios;
        }

        public static List<Entidad> ObtenerEntidadXComunidad(int idComunidad)
        {
            List<Entidad> entidades = new List<Entidad>();
            List<Servicio> servicios = ObtenerServiciosXComunidad(idComunidad);
            foreach (Servicio servicio in servicios)
            {
                entidades.Add(servicio.Entidad);
            }

            return entidades;
        }

        public static void GuardarSugerencia(Sugerencia sugerencia)
        {
            using (var dbContext = new BDContext())
            {
                bool sugerenciaExistente = dbContext.Sugerencias
                  .Any(s => (s.IdComunidad1 == sugerencia.Comunidad1.IdComunidad && s.IdComunidad2 == sugerencia.Comunidad2.IdComunidad) ||
                  (s.IdComunidad1 == sugerencia.Comunidad2.IdComunidad && s.IdComunidad2 == sugerencia.Comunidad1.IdComunidad));

                if (!sugerenciaExistente)
                {
                    // Si no existe la sugerencia, puedes proceder a insertarla
                    var nuevaSugerencia = new SugerenciaPersistida
                    {
                        IdComunidad1 = sugerencia.Comunidad1.IdComunidad,
                        IdComunidad2 = sugerencia.Comunidad2.IdComunidad,
                        FechaSugerencia = DateTime.Now
                    };

                    dbContext.Sugerencias.Add(nuevaSugerencia);
                    dbContext.SaveChanges();
                }
            }
        }

        public static bool ExisteSugerencia(int idComunidad1, int idComunidad2)
        {
            bool sugerenciaExistente;
            using (var dbContext = new BDContext())
            {
                sugerenciaExistente = dbContext.Sugerencias
                 .Any(s => (s.IdComunidad1 == idComunidad1 && s.IdComunidad2 == idComunidad2) ||
                 (s.IdComunidad1 == idComunidad2 && s.IdComunidad2 == idComunidad1));
            }
            return sugerenciaExistente;
        }

      /*  public static int GuardarComunidad(Comunidad comunidad)
        {
            using (var dbContext = new BDContext())
            {
                dbContext.Comunidades.Add(comunidad);
                dbContext.SaveChanges();
            }
            return comunidad.IdComunidad;
        }*/


    }
}
