package  main.java.com.Clases.Model.RankingsEInformes;

import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

@Entity
@Table(name = "RankingDeIncidentes")


public class RankingDeIncidentes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRankingDeIncidentes;

    private transient Rankear estrategia;

    private transient List<Entidad> entidades;

    public List<Entidad> Rankear(){
        entidades = estrategia.Execute();
        return entidades;
    }

	@ManyToMany
	@JoinTable(name = "rankingMayorTiempoPromedio", joinColumns = @JoinColumn(name = "idRankingDeIncidentes"), inverseJoinColumns = @JoinColumn(name = "IdEntidad"))
    private List<Entidad> rankingMayorTiempoPromedio;
	@ManyToMany
	@JoinTable(name = "rankingMayorGradoDeImpacto", joinColumns = @JoinColumn(name = "idRankingDeIncidentes"), inverseJoinColumns = @JoinColumn(name = "IdEntidad"))
    private List<Entidad> rankingMayorGradoDeImpacto;
	@ManyToMany
	@JoinTable(name = "rankingMayorCantidadIncidentes", joinColumns = @JoinColumn(name = "idRankingDeIncidentes"), inverseJoinColumns = @JoinColumn(name = "IdEntidad"))
    private List<Entidad> rankingMayorCantidadIncidentes;
    
    
    public void setEstrategia(Rankear estrategia){
        this.estrategia = estrategia;
    }

     public List<Entidad> getRankingMayorTiempoPromedio() {
		return rankingMayorTiempoPromedio;
	}

	public void setRankingMayorTiempoPromedio(List<Entidad> rankingMayorTiempoPromedio) {
		this.rankingMayorTiempoPromedio = rankingMayorTiempoPromedio;
	}

	public List<Entidad> getRankingMayorGradoDeImpacto() {
		return rankingMayorGradoDeImpacto;
	}

	public void setRankingMayorGradoDeImpacto(List<Entidad> rankingMayorGradoDeImpacto) {
		this.rankingMayorGradoDeImpacto = rankingMayorGradoDeImpacto;
	}

	public List<Entidad> getRankingMayorCantidadIncidentes() {
		return rankingMayorCantidadIncidentes;
	}

	public void setRankingMayorCantidadIncidentes(List<Entidad> rankingMayorCantidadIncidentes) {
		this.rankingMayorCantidadIncidentes = rankingMayorCantidadIncidentes;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	private LocalDate fecha = LocalDate.now();
}