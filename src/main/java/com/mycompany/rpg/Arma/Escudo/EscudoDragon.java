package com.mycompany.rpg.Arma.Escudo;

/**
 *
 * @author saien
 */
public class EscudoDragon extends Escudo{

    private final int aumentarDefensa = 35;
    
    public EscudoDragon(){
        nombre = "Escudo Dragón";
    }

    @Override
    public int AumentarDefensa() {
        return aumentarDefensa;
    }
    
    
}
