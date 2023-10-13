package  main.java.com.Clases.Model.RankingsEInformes;

import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;
import java.util.List;
import  main.java.com.Clases.Model.ServiciosPublicos.Entidad;

public class RankingDeIncidentes{
    private Rankear estrategia;
    private List<Entidad> entidades;

    public List<Entidad> Rankear(){
        return estrategia.Execute();
    }

    public void setEstrategia(Rankear estrategia){
        this.estrategia = estrategia;
    }
}