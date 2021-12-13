package com.example.JavaAvanzadoEjercicio27.services;


import com.example.JavaAvanzadoEjercicio27.Respositories.CochesDBMemory;
import com.example.JavaAvanzadoEjercicio27.Respositories.CochesRepository;
import com.example.JavaAvanzadoEjercicio27.entities.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CochesService {
    //Atributos
    CochesRepository cochesRepository = new CochesDBMemory();


    //Constructor
    private void CochesService() { }

    //Metodos
    //Ver todos los usuarios
    public ArrayList<Coche> obtener(){
        return cochesRepository.obtener();
    }

    public Coche buscar(String modelo){
        return cochesRepository.buscar(modelo);
    }

    public void crear(Coche coche) {
        try{
            cochesRepository.crear(coche);
        } catch (Exception e) {
            System.out.println("Coche no creado ---> " + e);
        }

    }

    public void borrarTodos(){
        cochesRepository.borrarTodos();
    }

    public void borrar(String modelo){
        cochesRepository.borrarUno(modelo);
    }
}
