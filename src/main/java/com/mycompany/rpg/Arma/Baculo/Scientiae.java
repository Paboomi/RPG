package com.mycompany.rpg.Arma.Baculo;

/**
 *
 * @author saien
 */
public class Scientiae extends Baculo{
    private final int aumentarPV = 10;
    private final int aumentarConcentracion = 25;
    
    public Scientiae(){
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
