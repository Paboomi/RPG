package com.mycompany.rpg.Arma.ArmaDosManos;

/**
 *
 * @author saien
 */
public class Alabarda extends ArmaDosManos {

    private final int aumentarFuerza = 25;
    private final int disminuirVelocidad = 15;

    public Alabarda() {
        nombre = "Alabarda";
    }

    @Override
    public int DisminuirVelocidad() {
        return disminuirVelocidad;
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
