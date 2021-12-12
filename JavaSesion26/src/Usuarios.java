import java.util.ArrayList;

public class Usuarios {

    UsuariosDB usuariosDB;

    public Usuarios(UsuariosDB usuariosDB) { this.usuariosDB = usuariosDB; }

    protected Usuarios() {}

    /**
     * Ver todos los usuarios creados
     */
    public ArrayList<Usuario> obtener() {
        //Devolvemos todos los usuarios en el fichero txt
        return usuariosDB.obtener();
    }

    /**
     * Buscar un usuario por un nombre de usuario concreto
     * @param usuario  nombre de usuario
     */
    public Usuario buscar(Usuario usuario) {

        return usuariosDB.buscar(usuario);
    }

    /**
     * Crear un nuevo usuario comprobando que no exista ya
     * @param usuario tipo de dato usuario
     */
    public void insertar(Usuario usuario) {
        //Consultamos si el usuario está creado
        if (buscar(usuario) != null) {
            return;
        }
        usuariosDB.insertar(usuario);
    }


    /**
     * Borrar Usuario
     * @param usuario nombre de usuario
     */
    public void borrar(Usuario usuario) {
        usuariosDB.borrar(usuario);
    }
}
