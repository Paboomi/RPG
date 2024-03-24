package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.ArmaUnaMano.Espada;

/**
 *
 * @author saien
 */
public class Paladin extends Trabajo {

    Arma[] inventarioArmas;
    boolean subioNivel = false;

    public Paladin() {
        this.nombre = "Paladin";
        inventarioArmas = new Arma[1];
        inventarioArmas[0] = new Espada();
    }
//METODOS PARA CAMBIAR ESTADISTICAS

    @Override
    public double AumentarDefensa() {
        return 0.25;
    }

    @Override
    public double AumentarPV() {
        return 0.15;
    }

    //GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
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
