package com.mycompany.rpg.Magias.MagiaOscura;

import java.util.Random;

/**
 *
 * @author saien
 */
public class Fuego extends MagiaOscura{
 
    Random rand = new Random();
    public Fuego(){
        nombre = "Fuego";
        bajoNivel = true;
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
        return rand.nextInt(2)*10+10;
    }
    
    
    
}
