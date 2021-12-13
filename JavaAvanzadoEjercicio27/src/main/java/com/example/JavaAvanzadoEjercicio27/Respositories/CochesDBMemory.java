package com.example.JavaAvanzadoEjercicio27.Respositories;

import com.example.JavaAvanzadoEjercicio27.entities.Coche;

import java.util.ArrayList;

public class CochesDBMemory implements CochesRepository{
    //Generamos ArrayList del objeto Coche
    ArrayList<Coche> coches = new ArrayList<>();

    /**
     * Metodo para devolver todos los coches en memoria
     *
     */
    @Override
    public ArrayList<Coche> obtener() {
        return coches;
    }

    /**
     * Metodo para buscar un coche por modelo
     * @param modelo buscar por modelo de coche
     *
     */
    @Override
    public Coche buscar(String modelo) {
        for(Coche cocheActual: coches){
            if(cocheActual.getModelo().equalsIgnoreCase(modelo)){
                return cocheActual;
            }
        }
        System.out.println("Coche no encontrado.");
        return null;
    }

    /**
     * Metodo para crear un coche nuevo
     * @param coche se le pasa un objeto del tipo coche
     */
    @Override
    public void crear(Coche coche) {
        if(buscar(coche.getModelo())!=null){
            System.out.println("El coche ya existe en memoria");
            return;
        }
        coches.add(coche);
    }

    /**
     * Metodo para borrar todos los usuarios en memoria
     */
    @Override
    public void borrarTodos() {
        for (int i = 0; i < coches.size(); i++) {
            coches.remove(i);
        }
    }

    /**
     * Metodo para borrar coches por modelo
     * @param modelo propiedad del objeto coche
     */
    @Override
    public void borrarUno(String modelo) {
        for (Coche cocheActual: coches) {
            if (cocheActual.getModelo().equalsIgnoreCase(modelo))
            coches.remove(cocheActual);
        }
    }


}
