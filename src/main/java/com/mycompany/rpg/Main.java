
package com.mycompany.rpg;

import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Trabajo.*;


/**
 *
 * @author saien
 */
public class Main {
    
    public static void main(String[] args) {
        generarMapa mapa = new generarMapa(7, 7);
        
        mapa.mostrarTablero();
        
    }
    
}
