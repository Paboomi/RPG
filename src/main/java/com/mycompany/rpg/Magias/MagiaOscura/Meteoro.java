package com.mycompany.rpg.Magias.MagiaOscura;

import java.util.Random;

/**
 *
 * @author saien
 */
public class Meteoro extends MagiaOscura {

    Random rand = new Random();

    public Meteoro() {
        nombre = "Meteoro";
        bajoNivel = false;
    }

    public boolean siBajoNivel() {
        return bajoNivel;
    }

    public void setBajoNivel(boolean bajonivel) {
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
        return rand.nextInt(5) * 10 + 10;
    }

    @Override
    public boolean PerderTurno() {
        return Math.random() > 0.75;
    }

}
