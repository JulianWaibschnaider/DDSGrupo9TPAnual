package Clases.Model.RankingsEInformes;

import Clases.Model.ServiciosPublicos.Entidad;
import java.util.ArrayList;
import Clases.Model.ServiciosPublicos.Entidad;

public class RankingDeIncidentes{
    private Rankear estrategia;
    private ArrayList<Entidad> entidades;

    public ArrayList<Entidad> Rankear(){
        return estrategia.Execute();
    }

    public void setEstrategia(Rankear estrategia){
        this.estrategia = estrategia;
    }
}