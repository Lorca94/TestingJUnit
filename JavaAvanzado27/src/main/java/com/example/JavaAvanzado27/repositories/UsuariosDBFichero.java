package com.example.JavaAvanzado27.repositories;

import com.example.JavaAvanzado27.entities.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosDBFichero extends UsuariosDB {
    //Atributos
    public String ficheroDatos = "usuarios.txt";

    //Contructor
    public UsuariosDBFichero() {
    }

    //Metodos

    /**
     * Método para pasar usuarios del fichero txt a un array
     */
    @Override
    public ArrayList<Usuario> obtener() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(ficheroDatos)).useDelimiter("\n");

            while (sc.hasNext()) {
                String usuarioActual = sc.next();
                String[] partes = usuarioActual.split(",");

                Usuario usuario = new Usuario();
                usuario.nombreUsuario = partes[0];
                usuario.nombre = partes[1];
                usuario.apellidos = partes[2];
                usuario.email = partes[3];
                usuario.nivelAcceso = Integer.parseInt(partes[4]);

                usuarios.add(usuario);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return usuarios;
    }


    /**
     * Insertamos un usuario en BBDD
     *
     * @param usuario
     */
    @Override
    public void insertar(Usuario usuario) {
        //Separar usuario por comas
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(separarUsuariosPorComas(usuario));
            printStream.flush();
            printStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buscar un usuario en el fichero
     *
     * @param nombre
     */
    @Override
    public Usuario buscar(String nombre) {
        //Guardamos todos los usuarios en un array list
        ArrayList<Usuario> usuarios = obtener();
        //Iteramos buscando el nombre de usuario que le pasamos al metodo
        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.nombreUsuario.equalsIgnoreCase(nombre)) {
                return usuarioActual;
            }
        }
        return null;
    }


    /**
     * Eliminamos un usuario de BBDD
     * @param nombre
     */
    @Override
    public void borrar(String nombre) {
        //Convertimos el fichero en un arraylist
        ArrayList<Usuario> usuarios = obtener();

        //Iteramos en el arraylist
        for (int i = 0; i < usuarios.size(); i++) {
            //Buscamos el nombre de usuario para eliminarlo
            if (usuarios.get(i).nombreUsuario.equalsIgnoreCase(nombre)) {
                usuarios.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            //Iteramos en el arraylist con el nombre ya borrado
            for (Usuario usuarioActual : usuarios) {
                //Separamos los usuarios por comas
                String usuarioSeparadoComas = separarUsuariosPorComas(usuarioActual);
                //Escribimos en el fichero de nuevo.
                printStream.println(usuarioSeparadoComas);
            }
            printStream.close();
            printStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Devolveremos un texto con los datos del tipo usuario, separados por comas
     *
     * @param usuario
     * @return
     */
    private String separarUsuariosPorComas(Usuario usuario) {
        return usuario.nombreUsuario + ","
                + usuario.nombre + ","
                + usuario.apellidos + ","
                + usuario.email + ","
                + usuario.nivelAcceso + ",";
    }
}
