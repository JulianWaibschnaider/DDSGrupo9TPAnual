package Clases.Model.Servicios;

import java.util.ArrayList;

import javax.persistence.*;

import Clases.Model.ComunidadesYMiembros.Persona;
@Entity
@Table(name = "Banio")
public class Banio extends Servicio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBanio;
    private TipoBanio tipoBanio;

    public Boolean PuedeUsar(Persona persona){
        //hacer
        return true;
    }
}