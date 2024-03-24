package com.mycompany.rpg.Arma.Baculo;

/**
 *
 * @author saien
 */
public class Vivificantem extends Baculo{

    private final int aumentarPV = 25;
    private final int aumentarConcentracion = 10;

    public Vivificantem() {
        nombre = "Scientiae";
    }

    @Override
    public int AumentarConcentracion() {
        return aumentarConcentracion;
    }

    @Override
    public int AumentarPV() {
        return aumentarPV;
    }
}
