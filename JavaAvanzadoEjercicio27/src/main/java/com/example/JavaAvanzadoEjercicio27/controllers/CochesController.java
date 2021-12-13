package com.example.JavaAvanzadoEjercicio27.controllers;

import com.example.JavaAvanzadoEjercicio27.entities.Coche;
import com.example.JavaAvanzadoEjercicio27.services.CochesService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;

@Component
public class CochesController {
    //Aquí indicare las rutas para CRUD  (Create/Read/Update/Delete)
    //Instanciamos Service
    CochesService cochesService;

    public CochesController(CochesService cochesService) { this.cochesService = cochesService;}

    @GET
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Coche> obtenerTodosCoches() {return cochesService.obtener();}

    @GET
    @Path("/coches/{modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coche obtenerCocheModelo(@PathParam("modelo") String modelo) { return cochesService.buscar(modelo);}

    @POST
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Coche coche) {
        cochesService.crear(coche);
        return Response.created(
                URI.create("/coches/" + coche.getModelo())
        ).build();
    }

    @DELETE
    @Path("/coches")
    public Response eliminar(){
        cochesService.borrarTodos();
        return Response.ok().build();
    }

    @DELETE
    @Path("/coches/{modelo}")
    public Response eliminar(@PathParam("modelo") String modelo) {
        cochesService.borrar(modelo);
        return Response.ok().build();
    }
}
