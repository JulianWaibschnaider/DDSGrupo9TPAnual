package  main.java.com.Clases.Model.ComunidadesYMiembros;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.Clases.Model.IncidentesYNotificaciones.Incidente;

import java.util.ArrayList;

@Repository
public interface RepositorioPersonas extends JpaRepository<Persona,Long> {
    //public static List<Persona> personas = new ArrayList<Persona>();

    /* public List<Persona> getPersonas() {
        return personas;
    }

  

    public void addPersonas(Persona persona) {
        this.personas.add(persona);
    }*/
    
    
    Persona findPersonaByEmail(String Email);
    
    Persona findPersonaByidPersona(int id);
    
   /* public static Persona buscarPersona(String _email){
        //el identificador de la persona es el email
        for (Persona persona : personas) {
            if (persona.getEmail().equals(_email)) {
                return persona;
            }
        }
        return null;
    }*/


}
