package com.mycompany.rpg;

import com.mycompany.rpg.Juego.Juego;
import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Trabajo.*;

/**
 *
 * @author saien
 */
public class Main {

    public static void main(String[] args) {


        Juego juego = new Juego();
        Jugador jugador = new Jugador();
        jugador.verTrabajosAliados();
    }

}
