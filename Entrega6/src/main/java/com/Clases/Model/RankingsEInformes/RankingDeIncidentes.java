package  main.java.com.Clases.Model.RankingsEInformes;

import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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