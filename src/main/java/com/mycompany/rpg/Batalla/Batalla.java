package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;

/**
 *
 * @author saien
 */
public class Batalla {
    Aliado aliados[];
    Enemigo enemigos[];
    
    public Batalla(Aliado[] aliado, Enemigo[] enemigo){
        this.aliados = aliado;
        this.enemigos = enemigo;
    }
    public Batalla(){
        
    }
    
    public void verNivelEnemigo(){
        for (int i = 0; i < enemigos.length; i++) {
            System.out.println(enemigos[i].getNivel());
            
        }
    }

    public Aliado[] getAliados() {
        return aliados;
    }

    public void setAliados(Aliado[] aliados) {
        this.aliados = aliados;
    }

    public Enemigo[] getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(Enemigo[] enemigos) {
        this.enemigos = enemigos;
    }
    
}
