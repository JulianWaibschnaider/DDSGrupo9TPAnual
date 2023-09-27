namespace ApiComunidades.Models
{
    public class AnalizadorManager
    {
        public static List<CalculadorCoincidencia> AnalizadorPorcentajes(List<Comunidad> comunidades)
        {
            List<CalculadorCoincidencia> coincidencias = new List<CalculadorCoincidencia>();

            for (int i = 0; i < comunidades.Count - 1; i++)
            {
                for (int j = i + 1; j < comunidades.Count; j++)
                {
                    CalculadorCoincidencia coincidencia = new CalculadorCoincidencia(comunidades[i].IdComunidad, comunidades[j].IdComunidad);
                    coincidencias.Add(coincidencia);
                }
            }
            return coincidencias;
        }
    }
}
