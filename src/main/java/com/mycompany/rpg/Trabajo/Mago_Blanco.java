package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.Baculo.Scientiae;
import com.mycompany.rpg.Magias.Magia;
import com.mycompany.rpg.Magias.MagiaBlanca.Divinidad;

/**
 *
 * @author saien
 */
public class Mago_Blanco extends Trabajo {

    Magia[] inventarioMagias;
    Arma[] inventarioArmas;
    boolean subioNivel = false;

    private int numElementosArma;
    private int numElementosMagia;

    public Mago_Blanco() {
        this.nombre = "Mago Blanco";
        this.numElementosArma = 0;
        this.numElementosMagia = 0;
        inventarioMagias = new Magia[1];
        inventarioArmas = new Arma[1];
        inventarioMagias[0] = new Divinidad();
        inventarioArmas[0] = new Scientiae();
    }

    public void agregarMagia(Magia magia, int cantidad) {
        numElementosMagia = 0;
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementosMagia == inventarioMagias.length) {
                //si asi es lo ampliamos
                ampliarInventarioMagia();
            }
            //agregamos el nuevo objeto al inventario
            inventarioMagias[numElementosMagia] = magia;
            numElementosMagia++;

        }
    }

    private void ampliarInventarioMagia() {
        //doblamos el inventario
        Magia[] nuevoInventario = new Magia[inventarioMagias.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventarioMagias.length; i++) {
            nuevoInventario[i] = inventarioMagias[i];

        }
        //asignamos el nuevo inventario al original
        inventarioMagias = nuevoInventario;

    }

    public void agregarArma(Arma arma, int cantidad) {
        numElementosArma = 0;
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementosArma == inventarioArmas.length) {
                //si asi es lo ampliamos
                ampliarInventarioArmas();
            }
            //agregamos el nuevo objeto al inventario
            inventarioArmas[numElementosArma] = arma;
            numElementosArma++;

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
    public double DisminuirFuerza() {
        return 0.50;
    }

    @Override
    public double AumentarDefensa() {
        return 0.15;
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
    public Magia[] getInventarioMagias() {
        return inventarioMagias;
    }

    @Override
    public void setInventarioMagias(Magia[] inventarioMagias) {
        this.inventarioMagias = inventarioMagias;
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
