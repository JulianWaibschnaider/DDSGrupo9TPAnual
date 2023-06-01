package Clases;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Clases.EntidadesPrestadoras.EntidadPrestadora;
import Clases.EntidadesPrestadoras.OrganismoControl;


public class ServiciosController{

    public static void CargarEntidadesPrestadoraYOrganismosDeControl() {
        String archivoCSV = "/src/resources/Listadeentidadesprestadorasyorganismosdecontrol.csv";
        ArrayList<String> entidadesPrestadorasYOrganismosDeControl = new ArrayList<String>();
        try {          
            entidadesPrestadorasYOrganismosDeControl = (ArrayList<String>) Files.readAllLines(Paths.get(System.getProperty("user.dir") + archivoCSV));
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        for (String entidadPrestadoraYOrganismoDeControl : entidadesPrestadorasYOrganismosDeControl) {
            int i=1;
            String[] entidadPrestadoraYOrganismoDeControlSeparados = entidadPrestadoraYOrganismoDeControl.split(",");
            EntidadPrestadora entidadPrestadora = new EntidadPrestadora();
            entidadPrestadora.setNombre(entidadPrestadoraYOrganismoDeControlSeparados[0]);
            ArrayList<OrganismoControl> listaorganismosControl = new ArrayList<OrganismoControl>();
                while(entidadPrestadoraYOrganismoDeControlSeparados.length>i)
                {
                    OrganismoControl organismoControl = new OrganismoControl();
                    organismoControl.setNombre(entidadPrestadoraYOrganismoDeControlSeparados[i]);
                    listaorganismosControl.add(organismoControl); 
                    i++;
                }
            entidadPrestadora.setOrganismosControl(listaorganismosControl);
        }
    }
}
