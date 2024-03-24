package com.mycompany.rpg.Arma.ArmaCorta;

/**
 *
 * @author saien
 */
public class Daga extends ArmaCorta {

    private final int aumentarVelocidad = 15;

    public Daga() {
        nombre = "Daga";
    }
@Override
    public int AumentarVelocidad() {
        return aumentarVelocidad;
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
