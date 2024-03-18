
package com.mycompany.rpg.Personaje.Enemigo_Hielo;

import com.mycompany.rpg.Personaje.Enemigo;

/**
 *
 * @author saien
 */
public class Enemigo_Hielo extends Enemigo{
    
    private int id=2;

    
    public Enemigo_Hielo(int nivel){
        super(nivel);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
