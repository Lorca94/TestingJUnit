package Sesion18.repositories;

import Sesion18.entities.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosDBFicheros extends UsuariosDB {
    public String ficheroDatos = "fichero.txt";

/*
    public void crearFichero(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.flush();
            printStream.close();

        } catch (Exception e){
        }
    }*/

    /**
     * Leer y grabar usuarios en memoria.
     *
     */
    public ArrayList<Usuario> obtener(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File(ficheroDatos)).useDelimiter("\n");

            while (sc.hasNext()) {
                String usuarioActual = sc.next();
                String []partes = usuarioActual.split(",");

                Usuario usuario = new Usuario();
                usuario.nombreUsuario = partes[0];
                usuario.nombre = partes[1];
                usuario.apellidos = partes[2];
                usuario.email = partes[3];
                usuario.nivel = Integer.parseInt(partes[4]);

                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception e) {
            System.out.println("No puedo abrir el fichero desde bbdd");;
            return null;
        }
    }

    //Leer fichero y devolver un usuario
    @Override
    public Usuario buscar(Usuario usuario){
        ArrayList<Usuario> usuarios = obtener();

        for(Usuario usuarioActual: usuarios) {
            if(usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)){
                return usuarioActual;
            }
        }
        return null;
    }

    @Override
    public void insertar(Usuario usuario) {


    }

    @Override
    public void borrar(Usuario usuario) {

    }
}
