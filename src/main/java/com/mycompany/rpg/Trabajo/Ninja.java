package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Ninja {

    boolean subioNivel = false;

    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }

}
