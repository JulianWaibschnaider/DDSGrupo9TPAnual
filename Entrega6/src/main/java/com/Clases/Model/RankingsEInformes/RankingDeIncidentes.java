package  main.java.com.Clases.Model.RankingsEInformes;

import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @OneToMany  
    @JoinColumn(name = "idEntidad")
    private List<Entidad> entidades;

    public List<Entidad> Rankear(){
        entidades = estrategia.Execute();
        return entidades;
    }

    public void setEstrategia(Rankear estrategia){
        this.estrategia = estrategia;
    }

     private LocalDate fecha = LocalDate.now();
}