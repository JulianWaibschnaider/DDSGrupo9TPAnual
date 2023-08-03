package Clases.ComunidadesYMiembros;

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

    public static boolean IniciarSesion(String email, String contrasenia) {
        Usuario usuario = buscarUsuario(email);
        if (usuario != null) {
            if (usuario.getContrasenia().getContrasenia().equals(contrasenia)) {
                System.out.println("Inicio de sesion exitoso");
                return true;
            } else {
                System.out.println("Credenciales incorrectas. Inténtelo nuevamente.");
                return false;
            }
        } else {
            System.out.println("El usuario no existe");
            return false;
        }
    }

}