package Sesion18.repositories;

import Sesion18.entities.Usuario;

import java.io.FileNotFoundException;
import java.util.ArrayList;

abstract public class UsuariosDB {

    public abstract ArrayList<Usuario> obtener();

    public abstract Usuario buscar(Usuario usuario);

    public abstract void insertar(Usuario usuario);

    public abstract void borrar(Usuario usuario);
}
