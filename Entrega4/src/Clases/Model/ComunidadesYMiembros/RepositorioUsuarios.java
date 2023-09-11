package Clases.Model.ComunidadesYMiembros;

import java.util.ArrayList;

public class RepositorioUsuarios{
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuario) {
        this.usuarios = usuario;
    }

    public void addPersonas(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    
    public static Usuario buscarUsuario(String _email){
        //el identificador de la persona es el email
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(_email)) {
                return usuario;
            }
        }
        return null;
    }


}