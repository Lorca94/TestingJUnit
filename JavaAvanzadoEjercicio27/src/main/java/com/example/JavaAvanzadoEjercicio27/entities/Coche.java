package com.example.JavaAvanzadoEjercicio27.entities;

public class  Coche {
    //Atributos
    String modelo;
    String marca;
    int puertas;


    //Metodos
    public int aceleracion(int velocidad, int aceleracion) {
        return velocidad + aceleracion;
    }
    public int deceleracion(int velocidad,int aceleracion) {
        return velocidad - aceleracion;
    }
    //Getter and Setter
    public String getModelo() { return modelo; }
    public void setModelo() { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca() { this.marca = marca; }

    public int getPuertas() { return puertas; }
    public void setPuertas() { this.puertas = puertas; }

}