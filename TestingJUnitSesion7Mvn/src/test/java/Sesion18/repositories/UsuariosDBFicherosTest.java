package Sesion18.repositories;

import Sesion18.entities.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UsuariosDBFicherosTest {

    @Test
    void buscar() {
        UsuariosDB usuariosDB = new UsuariosDBFicheros();

        Usuario usuario = new Usuario();
        usuario.nombreUsuario="pepe";

        Usuario resultado = usuariosDB.buscar(usuario);
        assertEquals("pepe",resultado.nombreUsuario);
    }

}