package com.mycompany.rpg.Arma.Baculo;

/**
 *
 * @author saien
 */
public class Statera extends Baculo{

    private final int aumentarPV = 15;
    private final int aumentarConcentracion = 15;
    
        public Statera(){
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
