package usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuariosTest {
    private final String nombrePorDefecto = "pruebas";
    //Intancio la clase usuarios, será la encargada de crear usuarios
    Usuarios usuarios = new Usuarios();

    //Instancio la clase usuario, que será el objeto que crearemos y le damos la propiedad
    Usuario usuario = new Usuario();

    //Inicializamos usuario
    @BeforeEach
    void inicializa() { usuario.nombre=nombrePorDefecto; }

    @Test
    void pruebaCrearUsuario() {

        usuarios.crear(usuario);
        Usuario usuarioCreado = usuarios.crear(usuario);
        assertEquals(usuarioCreado.nombre, nombrePorDefecto);
    }

    @Test
    void pruebaObtenerUsuario() {

        usuarios.crear(usuario);
        String usuarioCreado = usuarios.buscar(usuario);

        assertEquals(nombrePorDefecto,usuarioCreado);
    }

    @Test
    void pruebaObtenerUsuarioNoExistente() {
        String resultado = usuarios.buscar(usuario);
        assertNull(resultado);
    }

    @Test
    void testBorrarUsuario(){

        usuarios.crear(usuario);

        boolean resultado = usuarios.borrar(usuario);
        //assertEquals(true, usuarios.borrar(usuario));
        assertTrue(resultado);
    }

    @Test
    void borrarUsuarioNoExistente(){
        boolean resultado = usuarios.borrar(usuario);

        assertFalse(resultado);
    }
}