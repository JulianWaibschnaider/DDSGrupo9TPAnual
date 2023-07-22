package Clases.ComunidadesYMiembros;

import java.util.ArrayList;

public class RepositorioPersonas {
    public static ArrayList<Persona> personas = new ArrayList<Persona>();

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> persona) {
        this.personas = persona;
    }

    public void addPersonas(Persona persona) {
        this.personas.add(persona);
    }
    
    public static Persona buscarPersona(String _email){
        //el identificador de la persona es el email
        for (Persona persona : personas) {
            if (persona.getEmail().equals(_email)) {
                return persona;
            }
        }
        return null;
    }


}
