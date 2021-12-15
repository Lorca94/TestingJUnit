package usuarios;

import java.util.ArrayList;

public class Usuarios {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean crearBoolean(Usuario usuario) {
        return usuarios.add(usuario);


    }

    public Usuario crear(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public String buscar(Usuario usuario) {
        for(Usuario usuarioActual: usuarios){
            if (usuarioActual.nombre.equalsIgnoreCase(usuario.nombre)){
                return usuarioActual.nombre;
            }
        }
        return null;
    }

    public boolean borrar (Usuario usuario) {
        return usuarios.remove(usuario);
    }
}
