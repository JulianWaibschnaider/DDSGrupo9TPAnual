package  com.Clases.Model.Shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.EntidadPrestadora;
import  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.OrganismoDeControl;
import  com.Clases.Model.EntidadesPrestadorasYOrganismosDeControl.RepositorioEntidadesPrestadoras;
public class LlenadorDeCSV {

    public static void llenarCSVEntidadesYOrganismos(){
        RepositorioEntidadesPrestadoras repoEntidadPrestadora = new RepositorioEntidadesPrestadoras();
    String archivoCSV = "/src/resources/Listadeentidadesprestadorasyorganismosdecontrol.csv";
        List<String> entidadesPrestadorasYOrganismosDeControl = new ArrayList<String>();
        try {          
            entidadesPrestadorasYOrganismosDeControl = (List<String>) Files.readAllLines(Paths.get(System.getProperty("user.dir") + archivoCSV));
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        for (String entidadPrestadoraYOrganismoDeControl : entidadesPrestadorasYOrganismosDeControl) {
            int i=1;
            String[] entidadPrestadoraYOrganismoDeControlSeparados = entidadPrestadoraYOrganismoDeControl.split(",");
            EntidadPrestadora entidadPrestadora = new EntidadPrestadora();
            entidadPrestadora.setNombre(entidadPrestadoraYOrganismoDeControlSeparados[0]);
            List<OrganismoDeControl> listaorganismosControl = new ArrayList<OrganismoDeControl>();
                while(entidadPrestadoraYOrganismoDeControlSeparados.length>i)
                {
                    OrganismoDeControl organismoControl = new OrganismoDeControl();
                    organismoControl.setNombre(entidadPrestadoraYOrganismoDeControlSeparados[i]);
                    listaorganismosControl.add(organismoControl); 
                    i++;
                }
            entidadPrestadora.setOrganismosDeControl(listaorganismosControl);
            repoEntidadPrestadora.addEntidadesPrestadoras(entidadPrestadora);
        }
    }
}
