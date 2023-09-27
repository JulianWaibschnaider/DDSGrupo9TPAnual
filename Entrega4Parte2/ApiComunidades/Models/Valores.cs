namespace ApiComunidades.Models
{
    public class Valores
    {
        public double ValorEntidad { get; set; } = 75;
        public double ValorServicio { get; set; } = 75;
        public double ValorPersona { get; set; } = 5;

        private static Valores valores;

        public static Valores GetValores()
        {
            if (valores == null)
            {
                valores = new Valores();
            }
            return valores;
        }

        public void SetValorServicio(double valorNuevo)
        {
            this.ValorServicio = valorNuevo;
        }

    }
}
