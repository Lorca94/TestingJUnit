package com.example.JavaAvanzado27.services;

import com.example.JavaAvanzado27.entities.Usuario;
import com.example.JavaAvanzado27.repositories.UsuariosDB;
import com.example.JavaAvanzado27.repositories.UsuariosDBFichero;
import com.example.JavaAvanzado27.repositories.UsuariosDBMemoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuariosService {
    UsuariosDB usuariosDB = new UsuariosDBMemoria();

    public void Usuarios(UsuariosDB usuariosDB) { this.usuariosDB = usuariosDB; }

    private void Usuarios() { }

    /**
     * Ver todos los usuarios creados
     */
    public ArrayList<Usuario> obtener() {
        //Devolvemos todos los usuarios en el fichero txt
        return usuariosDB.obtener();
    }

    /**
     * Buscar un usuario por un nombre de usuario concreto
     * @param nombre  nombre de usuario
     */
    public Usuario buscar(String nombre) {

        return usuariosDB.buscar(nombre);
    }

    /**
     * Crear un nuevo usuario comprobando que no exista ya
     * @param usuario tipo de dato usuario
     */
    public void insertar(Usuario usuario) {
        //Consultamos si el usuario está creado
        if (buscar(usuario.nombre) != null) {
            return;
        }
        usuariosDB.insertar(usuario);
    }


    /**
     * Borrar Usuario
     * @param nombre nombre de usuario
     */
    public void borrar(String nombre) {
        usuariosDB.borrar(nombre);
    }
}
