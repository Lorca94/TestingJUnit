public class Main {

    public static void main(String[] args) {
        //Creacion del objeto usuario
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = "Incognito";
        usuario.nombre = "Sr";
        usuario.apellidos = "De Incognito";
        usuario.email = "1234";
        usuario.nivelAcceso = 10;

        //Creacion del objeto usuario2
        Usuario usuario2 = new Usuario();
        usuario2.nombreUsuario = "SableDorado";
        usuario2.nombre = "Sb";
        usuario2.apellidos = "Dorado";
        usuario2.email = "4567";
        usuario2.nivelAcceso = 1;

        UsuariosDB usuariosDB;

        String tipo = "memoria";

        if (tipo.equalsIgnoreCase("fichero")){
            usuariosDB = new UsuariosDBFichero();
        } else {
            usuariosDB = new UsuariosDBMemoria();
        }

        //Creción del objeto Usuarios --> CRUD
        Usuarios usuarios = new Usuarios(usuariosDB);
        //Inserción en la BBDD
        usuarios.insertar(usuario);
        usuarios.insertar(usuario2);


        //Creamos un objeto para buscar solo por nombre

        Usuario sbDorado = new Usuario();
        sbDorado.nombreUsuario = "SableDorado";
        System.out.println(usuarios.buscar(sbDorado));


        //Imprimimos los usuarios con sus propiedades en consola
        for(Usuario a : usuarios.obtener()){
            System.out.println("Usuario Actual: ---------> "+ a.nombreUsuario);
            System.out.println(a);
            System.out.println("--------------------------------------------------------------------");
        }

        //Borramos el usuario que hemos creado antes de la BBDD
        usuarios.borrar(sbDorado);
        imprimirEstadisticas(usuariosDB);
    }

    public static void imprimirEstadisticas(UsuariosDB usuariosDB) {
        if (usuariosDB instanceof UsuariosDBMemoria) {
            System.out.println("Inserciones --> " + ((UsuariosDBMemoria) usuariosDB).getTotalInserciones());
            System.out.println("Eliminaciones --> " + ((UsuariosDBMemoria) usuariosDB).getTotalEliminaciones());
        } else {
            System.out.println("No hay estadísticas disponibles");
        }
    }

}
