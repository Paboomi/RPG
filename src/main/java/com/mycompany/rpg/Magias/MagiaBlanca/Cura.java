package com.mycompany.rpg.Magias.MagiaBlanca;

import java.util.Random;

/**
 *
 * @author saien
 */
public class Cura extends MagiaBlanca{
    Random rand = new Random();

    public Cura() {
        nombre = "Cura";
        bajoNivel = true;
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
    public int recuperarPV() {
        return rand.nextInt(2) * 10 + 10;
    }

}
