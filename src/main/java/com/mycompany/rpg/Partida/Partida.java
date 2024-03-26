package com.mycompany.rpg.Partida;

import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Trabajo.Trabajo;

/**
 *
 * @author saien
 */
public class Partida {
    
    private int ciudadesRoconquistadas = 0;
    Enemigo[] enemigosDerrotados; // la cantidad de enemigos derrotados y el tipo de cada uno
    String nombre;
    Aliado[] aliados; // para las veces que cada guerrero murio y el daño de cada uno
    int ciudadesReconquistadas; //cantidad de ciudades que logro reconquistar
    boolean ganoPartida; // por si logro reconquistar las ciudades
    boolean salioPartida;//por si la partida termino al presionar Q
    Trabajo[] trabajos; //para las magias
    
    public Partida(){
        
    }
}
