namespace ApiComunidades.Models
{
    public class CalculadorCoincidencia
    {
        public int IdComunidad1 { get; set; }

        public int IdComunidad2 { get; set; }

        public double PorcentajeEntidad { get; set; }

        public double PorcentajePersona { get; set; }

        public double PorcentajeConfianza { get; set; }

        public double PorcentajeServicio { get; set; }

        public bool Coinciden { get; set; }


        public CalculadorCoincidencia(int idComunidad1, int idComunidad2)
        {
            this.IdComunidad1 = idComunidad1;
            this.IdComunidad2 = idComunidad2;
            this.PorcentajeEntidad = this.CoincidenciaEntidades();
            this.PorcentajePersona = this.CoincidenciaPersonas();
            this.PorcentajeServicio = this.CoincidenciaServicio();
            this.Coinciden = this.CoincidenPorcentajes();
        }

        public static double CalcularPorcentaje<T>(List<T> list1, List<T> list2)
        {
            // Convertir las listas en conjuntos HashSet
            HashSet<T> set1 = new HashSet<T>(list1);
            HashSet<T> set2 = new HashSet<T>(list2);

            // Calcular el número total de elementos únicos
            int uniqueOccurrences = new HashSet<T>(list1.Concat(list2)).Count;

            // Encontrar elementos comunes únicos
            set1.IntersectWith(set2);
            int commonCount = set1.Count;

            // Calcular y devolver el porcentaje
            double coincidencePercentage = ((double)commonCount / uniqueOccurrences) * 100;
            return coincidencePercentage;
        }

        public double CoincidenciaEntidades()
        {
            List<Entidad> entidadComu1 = BDManager.ObtenerEntidadXComunidad(this.IdComunidad1);
            List<Entidad> entidadComu2 = BDManager.ObtenerEntidadXComunidad(this.IdComunidad2);

            return CalcularPorcentaje<Entidad>(entidadComu1, entidadComu2);
        }

        public double CoincidenciaPersonas()
        {
            List<Persona> personaComu1 = BDManager.ObtenerPersonasXComunidad(this.IdComunidad1);
            List<Persona> personaComu2 = BDManager.ObtenerPersonasXComunidad(this.IdComunidad2);

            return CalcularPorcentaje<Persona>(personaComu1, personaComu2);
        }

        public double CoincidenciaServicio()
        {
            List<Servicio> servicioComu1 = BDManager.ObtenerServiciosXComunidad(this.IdComunidad1);
            List<Servicio> servicioComu2 = BDManager.ObtenerServiciosXComunidad(this.IdComunidad2);

            return CalcularPorcentaje<Servicio>(servicioComu1, servicioComu2);
        }

        public bool CoincidenPorcentajes()
        {
            Valores valores = Valores.GetValores();
            return this.PorcentajeEntidad >= valores.ValorEntidad && PorcentajePersona >= valores.ValorPersona && PorcentajeServicio >= valores.ValorServicio;
        }

    }
}
