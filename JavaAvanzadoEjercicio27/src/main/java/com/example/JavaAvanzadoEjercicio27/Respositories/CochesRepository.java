package com.example.JavaAvanzadoEjercicio27.Respositories;

import com.example.JavaAvanzadoEjercicio27.entities.Coche;

import java.util.ArrayList;

public interface CochesRepository {

    //Metodos
    public ArrayList<Coche> obtener();
    public Coche buscar(String modelo);
    public void crear(Coche coche);
    public void borrarTodos();
    public void borrarUno(String modelo);
}
