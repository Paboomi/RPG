package com.mycompany.rpg.Magias.MagiaBlanca;

import com.mycompany.rpg.Magias.Magia;
import java.util.Random;

/**
 *
 * @author saien
 */
public class Divinidad extends MagiaBlanca {

    Random rand = new Random();

    public Divinidad() {
        nombre = "Divinidad";
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

}
