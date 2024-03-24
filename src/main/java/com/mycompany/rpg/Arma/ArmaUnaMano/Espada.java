package com.mycompany.rpg.Arma.ArmaUnaMano;

/**
 *
 * @author saien
 */
public class Espada extends ArmaUnaMano {

    private final int aumentarFuerza = 10;

    public Espada() {
        nombre = "Espada";
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
