package com.mycompany.rpg.Arma.Escudo;

/**
 *
 * @author saien
 */
public class EscudoHierro extends Escudo {

    private final int aumentarDefensa = 30;

    public EscudoHierro() {
        nombre = "Escudo Hierro";
    }

    @Override
    public int AumentarDefensa() {
        return aumentarDefensa;
    }
}
