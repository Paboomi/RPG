package com.mycompany.rpg.Arma.ArmaDosManos;

/**
 *
 * @author saien
 */
public class Lanza extends ArmaDosManos {

    private final int aumentarFuerza = 20;
    private final int disminuirVelocidad = 10;

    public Lanza() {
        nombre = "Lanza";
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
