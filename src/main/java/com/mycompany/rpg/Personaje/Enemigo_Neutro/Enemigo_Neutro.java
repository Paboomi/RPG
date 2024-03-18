
package com.mycompany.rpg.Personaje.Enemigo_Neutro;

import com.mycompany.rpg.Personaje.Enemigo;

/**
 *
 * @author saien
 */
public class Enemigo_Neutro extends Enemigo{
    private int id=3;
    
    public Enemigo_Neutro(int nivel){
        super(nivel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
