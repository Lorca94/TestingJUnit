package com.example.JavaAvanzado27.repositories;

import com.example.JavaAvanzado27.entities.Usuario;

import java.util.ArrayList;

public class UsuariosDBMemoria extends UsuariosDB{
    private int totalEliminaciones = 0;
    private int totalInserciones = 0;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public ArrayList<Usuario> obtener() {
        return usuarios;
    }

    @Override
    public Usuario buscar(String nombre) {
        for(Usuario usuarioActual: usuarios) {
            if(usuarioActual.nombreUsuario.equalsIgnoreCase(nombre)){
                return usuarioActual;
            }
        }
        return null;
    }

    @Override
    public void insertar(Usuario usuario) {
        if (buscar(usuario.nombreUsuario) != null) {
            System.out.println("Este usuario ya existe en memoria. \n" + usuario);
            return;
        }
        usuarios.add(usuario);
        incrementarInserciones();
    }

    @Override
    public void borrar(String nombre) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).nombreUsuario.equalsIgnoreCase(nombre)){
                usuarios.remove(i);
            }
        }
        incrementarEliminaciones();
    }
}

