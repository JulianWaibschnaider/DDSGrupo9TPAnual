using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;

namespace ApiComunidades.Models
{
    public class BDContext : DbContext
    {
        public BDContext() : base(GetDbContextOptions())
        {
            Database.Migrate();
        }

        private static DbContextOptions GetDbContextOptions()
        {
            var optionsBuilder = new DbContextOptionsBuilder<BDContext>();
            optionsBuilder.UseSqlServer("Data Source=LAPTOP-SLLR9E60;Initial Catalog=basediseno;Trusted_Connection=True;TrustServerCertificate=True;");
            return optionsBuilder.Options;
        }
        public DbSet<Comunidad> Comunidades { get; set; }
        public DbSet<PersonaComunidad> PersonasXComunidad { get; set; }

        public DbSet<ServiciosXComunidad> ServiciosComunidad { get; set; }
        public DbSet<Servicio> Servicios { get; set; }
        public DbSet<Entidad> Entidades { get; set; }

        public DbSet<Persona> Personas { get; set; }
        public DbSet<SugerenciaPersistida> Sugerencias { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<SugerenciaPersistida>()
                 .HasKey(s => s.IdSugerencia)
                 .HasAnnotation("DatabaseGenerated", DatabaseGeneratedOption.Identity);

         

            modelBuilder.Entity<Comunidad>()
                   .HasMany(c => c.Personas)
                   .WithOne()
                   .HasForeignKey(p => p.IdPersona);

            modelBuilder.Entity<Comunidad>()
                .HasMany(c => c.Servicios)
                .WithOne()
                .HasForeignKey(s => s.IdServicio);


            modelBuilder.Entity<Servicio>()
             .HasOne(s => s.Entidad)
             .WithOne()
              .HasForeignKey<Entidad>(e => e.IdEntidad);
            // Otras configuraciones de relaciones si es necesario

            base.OnModelCreating(modelBuilder);
        }




    }
}
