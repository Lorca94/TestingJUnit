package Sesion17;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class UsuariosTest {
    Usuarios usuarios = new Usuarios();
    Usuario usuario = new Usuario();

    @ParameterizedTest
    @ValueSource(strings = {"pepe","juan","manolo"})
    void crear(String nombre){
        usuario.nombre=nombre;

        assertEquals(true, usuarios.crear(usuario));
    }

    @Nested
    public class UsuarioCreado {
        @BeforeEach
        void inicializar(){
            usuario.nombre="pepe";
            usuarios.crear(usuario);

        }

        @Test
        @Order(1)
        void borrar(){

            assertEquals(true, usuarios.borrar(usuario));

        }

        @Test
        @DisplayName("Tengo usuarios?")
        @Order(0)
        void listar() {

            ArrayList<Usuario> listado = usuarios.obtener();
            System.out.println(listado.size());
            assertNotEquals(listado.size() > 0, listado);
        }
    }

}
