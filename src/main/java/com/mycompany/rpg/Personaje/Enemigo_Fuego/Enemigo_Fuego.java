package com.mycompany.rpg.Personaje.Enemigo_Fuego;

import com.mycompany.rpg.Personaje.Enemigo;

/**
 *
 * @author saien
 */
public class Enemigo_Fuego extends Enemigo {

    private int id = 1;

    public Enemigo_Fuego(int nivel) {
        super(nivel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
