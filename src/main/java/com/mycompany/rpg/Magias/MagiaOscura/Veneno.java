package com.mycompany.rpg.Magias.MagiaOscura;

import java.util.Random;

/**
 *
 * @author saien
 */
public class Veneno extends MagiaOscura {

    Random rand = new Random();

    public Veneno() {
        nombre = "Veneno";
        bajoNivel = false;
    }

    public boolean esBajonivel() {
        return bajoNivel;
    }

    public void setBajonivel(boolean bajonivel) {
        this.bajoNivel = bajonivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int Damage() {
        return rand.nextInt(3) * 10 + 10;
    }
}
