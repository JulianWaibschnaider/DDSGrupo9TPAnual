namespace ApiComunidades.Models
{
    public class ComunidadHandler
    {

        public static List<Sugerencia> SugerirFusion()
        {
            List<Comunidad> comunidades;
            List<Sugerencia> sugerencias = new List<Sugerencia>();
            comunidades = ObtenerComunidades();
            List<CalculadorCoincidencia> calculadorCoincidencias = AnalizadorManager.AnalizadorPorcentajes(comunidades);

            // Obtener la fecha actual
            DateTime fechaActual = DateTime.Now;

            foreach (CalculadorCoincidencia calculadorCoincidencia in calculadorCoincidencias)
            {
                // Verificar si las comunidades coinciden y cumplen con los porcentajes
                if (calculadorCoincidencia.Coinciden)
                {
                    int idComunidad1 = calculadorCoincidencia.IdComunidad1;
                    int idComunidad2 = calculadorCoincidencia.IdComunidad2;

                    if (!ExisteSugerencia(sugerencias, idComunidad1, idComunidad2))
                    {
                        // Crear una nueva sugerencia
                        Sugerencia sugerencia = new Sugerencia
                        {
                            Comunidad1 = ObtenerComunidadPorId(idComunidad1),
                            Comunidad2 = ObtenerComunidadPorId(idComunidad2),
                            FechaSugerencia = fechaActual
                        };

                        // Agregar la sugerencia a la lista de sugerencias
                        sugerencias.Add(sugerencia);
                    }
                }
            }
            GuardarSugerencias(sugerencias);
            return sugerencias;
        }

        public static bool ExisteSugerencia(List<Sugerencia> sugerencias, int idComunidad1, int idComunidad2)
        {
            return sugerencias.Any(s =>
                       (s.Comunidad1.IdComunidad == idComunidad1 || s.Comunidad2.IdComunidad == idComunidad2) ||
                       (s.Comunidad1.IdComunidad == idComunidad2 || s.Comunidad2.IdComunidad == idComunidad1));
        }

        public static List<CalculadorCoincidencia> VerCoincidencias()
        {
            List<Comunidad> comunidades = ObtenerComunidades();
            List<CalculadorCoincidencia> calculadorCoincidencias = AnalizadorManager.AnalizadorPorcentajes(comunidades);
            return calculadorCoincidencias;
        }

        public static List<Comunidad> ObtenerComunidades()
        {
            List<Comunidad> comunidades = new List<Comunidad>();

            comunidades = BDManager.ObtenerComunidades();

            return comunidades;
        }

        public static Comunidad ObtenerComunidadPorId(int idComunidad)
        {
            return BDManager.ObtenerComunidadPorId(idComunidad);
        }

        public static List<Comunidad> ObtenerComunidadesCompletas()
        {
            List<Comunidad> comunidades = new List<Comunidad>();

            comunidades = BDManager.ObtenerComunidades();
            foreach (Comunidad comunidad in comunidades)
            {
                comunidad.Personas = ObtenerPersonasXComunidades(comunidad.IdComunidad);
                comunidad.Servicios = ObtenerServiciosXComunidades(comunidad.IdComunidad);
            }

            return comunidades;
        }

        public static List<Persona> ObtenerPersonasXComunidades(int idComunidad)
        {
            List<Persona> personas = new List<Persona>();

            personas = BDManager.ObtenerPersonasXComunidad(idComunidad);

            return personas;
        }

        public static void GuardarSugerencias(List<Sugerencia> sugerencias)
        {
            foreach (Sugerencia sugerencia in sugerencias)
            {
                BDManager.GuardarSugerencia(sugerencia);
            }

        }

        public static List<Servicio> ObtenerServiciosXComunidades(int idComunidad)
        {
            List<Servicio> servicios = new List<Servicio>();

            servicios = BDManager.ObtenerServiciosXComunidad(idComunidad);

            return servicios;
        }

        public static Comunidad AceptarSugerencia(int idComunidad1, int idComunidad2)
        {
            Comunidad comunidad1 = new Comunidad();
            Comunidad comunidad2 = new Comunidad();
            Comunidad comunidadNueva = new Comunidad();
            bool existeSugerencia = BDManager.ExisteSugerencia(idComunidad1, idComunidad2);
            if (existeSugerencia)
            {

                comunidad1 = BDManager.ObtenerComunidadPorId(idComunidad1);
                comunidad2 = BDManager.ObtenerComunidadPorId(idComunidad2);
                comunidadNueva.IdComunidad = comunidad1.IdComunidad + comunidad2.IdComunidad;
                comunidadNueva.Nombre = comunidad1.Nombre + comunidad2.Nombre;

                comunidadNueva.Servicios = FusionarLista(BDManager.ObtenerServiciosXComunidad(idComunidad1), BDManager.ObtenerServiciosXComunidad(idComunidad2));
                comunidadNueva.Personas = FusionarLista(BDManager.ObtenerPersonasXComunidad(idComunidad1), BDManager.ObtenerPersonasXComunidad(idComunidad2));

              //  BDManager.GuardarComunidad(comunidadNueva);

            }

            return comunidadNueva;
        }


        private static List<T> FusionarLista<T>(List<T> lista1, List<T> lista2)
        {
            // Fusionar las dos listas utilizando conjuntos
            HashSet<T> conjuntoFusionado = new HashSet<T>(lista1);
            conjuntoFusionado.UnionWith(lista2);

            // Convertir el conjunto resultante de nuevo a una lista
            List<T> listaFusionada = conjuntoFusionado.ToList();
            return listaFusionada;
        }
    }
}
