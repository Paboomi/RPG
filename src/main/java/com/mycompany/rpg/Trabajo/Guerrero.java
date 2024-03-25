package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.ArmaUnaMano.Espada;

/**
 *
 * @author saien
 */
public class Guerrero extends Trabajo {

    Arma[] inventarioArmas;
    boolean subioNivel = false;
    private String nombre;
    private int numElementos;

    public Guerrero() {
        this.nombre = "Guerrero";
        this.numElementos = 0;
        this.inventarioArmas = new Arma[1];
        inventarioArmas[0] = new Espada();

    }
@Override
    public void agregarArma(Arma arma, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementos == inventarioArmas.length) {
                //si asi es lo ampliamos
                ampliarInventarioArmas();
            }
            //agregamos el nuevo objeto al inventario
            inventarioArmas[numElementos] = arma;
            numElementos++;
        }
    }

    private void ampliarInventarioArmas() {
        //doblamos el inventario
        Arma[] nuevoInventario = new Arma[inventarioArmas.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventarioArmas.length; i++) {
            nuevoInventario[i] = inventarioArmas[i];

        }
        //asignamos el nuevo inventario al original
        inventarioArmas = nuevoInventario;

    }

//Metodos para aumentar estadisitcas a la hora de equipar el trabajo
    @Override
    public double AumentarFuerza() {
        return 0.25;
    }

    @Override
    public double DisminuirVelocidad() {
        return 0.15;
    }

//GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Arma[] getInventarioArmas() {
        return inventarioArmas;
    }

    @Override
    public void setInventarioArmas(Arma[] inventarioArmas) {
        this.inventarioArmas = inventarioArmas;
    }

}
