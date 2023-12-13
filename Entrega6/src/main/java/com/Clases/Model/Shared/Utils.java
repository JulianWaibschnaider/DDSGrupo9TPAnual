package  main.java.com.Clases.Model.Shared;

import java.util.List;

public class Utils{

public static Double CalcularDistancia(Double latitud, Double longitud, Double latitudActual, Double longitudActual){
    Double distancia = Math.sqrt(Math.pow((latitud-latitudActual),2)+Math.pow((longitud-longitudActual),2));
    return distancia;
    //suponemos que la distancia que retorna esta en kilometros
}

}