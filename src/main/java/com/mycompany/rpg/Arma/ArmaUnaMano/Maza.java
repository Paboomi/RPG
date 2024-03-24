package com.mycompany.rpg.Arma.ArmaUnaMano;

/**
 *
 * @author saien
 */
public class Maza extends ArmaUnaMano {

    private final int aumentarFuerza = 20;

    public Maza() {
        nombre = "Maza";
    }

    @Override
    public int AumentarFuerza() {
        return aumentarFuerza;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
