package com.example.JavaAvanzado27.repositories;

import com.example.JavaAvanzado27.entities.Usuario;

import java.util.ArrayList;

abstract public class UsuariosDB {

    private int totalInserciones = 0;
    private int totalEliminaciones = 0;
    protected void incrementarInserciones() {totalInserciones++;}
    protected void incrementarEliminaciones() {totalEliminaciones++;}
    abstract public ArrayList<Usuario> obtener();
    abstract public Usuario buscar(String nombre);
    abstract public void insertar(Usuario usuario);
    abstract public void borrar(String nombre);

}