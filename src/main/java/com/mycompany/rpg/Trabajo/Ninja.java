package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.ArmaCorta.Estilete;

/**
 *
 * @author saien
 */
public class Ninja extends Trabajo {

    Arma[] inventarioArmas;
    boolean subioNivel = false;
    private int numElementos;

    public Ninja() {
        this.nombre = "Ninja";
        this.numElementos = 0;
        inventarioArmas = new Arma[1];
        inventarioArmas[0] = new Estilete();
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

    //Metodos para aumentar estadisticas
    @Override
    public double AumentarVelocidad() {
        return 0.35;
    }

    @Override
    public double DisminuirDefensa() {
        return 0.20;
    }

    //GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }

    public int cantArmas() {
        return 2;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
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
