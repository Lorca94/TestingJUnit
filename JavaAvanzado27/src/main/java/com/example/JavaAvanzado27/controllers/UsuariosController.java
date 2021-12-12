package com.example.JavaAvanzado27.controllers;

import com.example.JavaAvanzado27.entities.Usuario;
import com.example.JavaAvanzado27.services.UsuariosService;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
public class UsuariosController {
    //Instanciamos los services
    private final UsuariosService usuarioService;

    public UsuariosController(UsuariosService usuarioService) { this.usuarioService = usuarioService; }

    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarTodos() { return usuarioService.obtener(); }

    @GET
    @Path("/usuarios/{nombre}")
    public Usuario listarUno( @PathParam("nombre") String nombre ) { return usuarioService.buscar(nombre);}

    @POST
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario){
        usuarioService.insertar(usuario);

        return Response.created(
                URI.create("/usuarios/" + usuario.nombreUsuario)
        ).build();
    }

    @DELETE
    @Path("/usuarios/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("nombre") String nombre) {
        usuarioService.borrar(nombre);

        return Response.ok().build();
    }

}
