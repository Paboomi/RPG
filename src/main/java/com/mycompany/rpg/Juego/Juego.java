package com.mycompany.rpg.Juego;

import com.mycompany.rpg.Mapas.Casillas.CasillaCiudad;
import com.mycompany.rpg.Mapas.Casillas.CasillaEnemigo;
import com.mycompany.rpg.Mapas.Casillas.CasillaPasto;
import com.mycompany.rpg.Mapas.Casillas.CasillaPosada;
import com.mycompany.rpg.Mapas.Casillas.CasillaTienda;
import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Varios;

/**
 *
 * @author saien
 */
public class Juego {

    generarMapa mapa;
    Varios varios;
    String ciudad = new String("\uD83C\uDFF0");
    String tienda = new String("\uD83C\uDFEA");
    String posada = new String("\uD83C\uDFE5");
    String pasto = new String("\uD83C\uDF42");
    String logoJugador = new String("\uD83D\uDC66");
    String logoEnemigo = new String("\uD83D\uDC7E");
    private int cantEnemigos;
    private int posX;
    private int posY;
    private int posEX;
    private int posEY;

    public Juego() {
        mapa = new generarMapa();
        varios = new Varios();
        generarPersonajes();
        mostrarEnemigos();

    }

    private void generarPersonajes() {
        int contEnemigos = 0;
        
        //Generamos al jugador en una posicion aleatoria
        do {
            posX = varios.numeroAleatorio(0, mapa.getAncho());
            posY = varios.numeroAleatorio(0, mapa.getLargo());

        } while ((mapa.getCasilla(posX, posY) instanceof CasillaCiudad) || (mapa.getCasilla(posX, posY) instanceof CasillaPosada) || (mapa.getCasilla(posX, posY) instanceof CasillaTienda));
        mapa.setCasilla(logoJugador, posX, posY);

        //Generamos enemigos aleatorios dependiendo el tamaño del mapa
        cantEnemigos = varios.cantEnemigos(mapa.getLargo());
        do {
            do {
                posEX = varios.numeroAleatorio(0, mapa.getAncho());
                posEY = varios.numeroAleatorio(0, mapa.getLargo());

            } while (!(mapa.getCasilla(posEX, posEY) instanceof CasillaPasto));
            mapa.setCasillaEnemigo(posEX, posEY);
            contEnemigos++;
        } while (contEnemigos <= cantEnemigos);
        
        mapa.mostrarTablero();
    }

    private void mostrarEnemigos() {
        int fila = mapa.getAncho();
        int columna = mapa.getLargo();
        
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                
                if (mapa.getCasilla(i, j) instanceof CasillaEnemigo) {
                    System.out.println("Hay un enemigo en [" + i +","+j+"]" );
                }
                
            }
            
        }
    }
    
    
    private void movimientos(){
        varios.instructionMov();
    }

}
