package com.mycompany.rpg.Magias.MagiaBlanca;

import java.util.Random;

/**
 *
 * @author saien
 */
public class MagiaEscudo extends MagiaBlanca{
    Random rand = new Random();

    public MagiaEscudo() {
        nombre = "Escudo";
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
    public int aumentarDefensa() {
        return rand.nextInt(6)*5+5;
    }
    @Override
    public int generarTurnos(){
        return rand.nextInt(2)+1;
    }

  

}
