package Clases.Servicios;

import java.util.ArrayList;
import Clases.ServiciosPublicos.Entidad;

public class Servicio {
    private Boolean enFuncionamiento;
    private Entidad entidad;

    public Boolean getEnFuncionamiento() {
        return enFuncionamiento;
    }

    public void setEnFuncionamiento(Boolean enFuncionamiento) {
        this.enFuncionamiento = enFuncionamiento;
        //Aca activo al notificador si es false
    }
}