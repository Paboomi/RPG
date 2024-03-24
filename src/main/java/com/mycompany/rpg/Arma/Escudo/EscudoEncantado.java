package com.mycompany.rpg.Arma.Escudo;

/**
 *
 * @author saien
 */
public class EscudoEncantado extends Escudo{

    private final int aumentarDefensa = 25;
    
       
    public EscudoEncantado(){
        nombre = "Escudo Encantado";
    }

    @Override
    public int AumentarDefensa() {
        return aumentarDefensa;
    }
}
