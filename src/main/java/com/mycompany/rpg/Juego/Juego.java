package com.mycompany.rpg.Juego;

import com.mycompany.rpg.Mapas.Casillas.Casilla;
import com.mycompany.rpg.Mapas.Casillas.CasillaCiudad;
import com.mycompany.rpg.Mapas.Casillas.CasillaEnemigo;
import com.mycompany.rpg.Mapas.Casillas.CasillaPasto;
import com.mycompany.rpg.Mapas.Casillas.CasillaPosada;
import com.mycompany.rpg.Mapas.Casillas.CasillaTienda;
import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Varios;
import java.util.Scanner;

/**
 *
 * @author saien
 */
public class Juego {

    generarMapa mapa;
    Varios varios;
    Scanner sc = new Scanner(System.in);
    //Agregados para batalla
    Jugador jugador;
    //CasillaEnemigo enemigo;

    //Logos objetos
    String ciudad = new String("\uD83C\uDFF0");
    String tienda = new String("\uD83C\uDFEA");
    String posada = new String("\uD83C\uDFE5");
    String pasto = new String("\uD83C\uDF42");
    String logoJugador = new String("\uD83D\uDC66");
    //Variables para generar personajes
    private int cantEnemigos;
    private int posX;
    private int posY;
    private int posEX;
    private int posEY;

    //Constructor 
    public Juego() {
        //instanciamos las clases
        mapa = new generarMapa();
        varios = new Varios();
        jugador = Jugador.getInstance();
        //enemigo = new CasillaEnemigo();
        //Llamamos a las funcionalidades
        generarPersonajes();
        movimientos();
    }

    private void generarPersonajes() {
        int contEnemigos = 0;

        //Generamos al jugador en una posicion aleatoria
        do {
            posX = varios.numeroAleatorio(0, mapa.getAncho());
            posY = varios.numeroAleatorio(0, mapa.getLargo());

        } while ((mapa.getCasilla(posX, posY) instanceof CasillaCiudad) || (mapa.getCasilla(posX, posY) instanceof CasillaPosada) || (mapa.getCasilla(posX, posY) instanceof CasillaTienda) || (mapa.getCasilla(posX, posY) instanceof CasillaEnemigo));
        //Guardamos la posicion del jugador en el tablero y mostramos su logo
        mapa.setCasilla(logoJugador, posX, posY);

        //Generamos enemigos aleatorios dependiendo el tamaño del mapa
        cantEnemigos = varios.cantEnemigos(mapa.getLargo());
        do {
            do {
                posEX = varios.numeroAleatorio(0, mapa.getAncho());
                posEY = varios.numeroAleatorio(0, mapa.getLargo());

            } while (!(mapa.getCasilla(posEX, posEY) instanceof CasillaPasto) || (mapa.getCasilla(posEX, posEY).getLogo().equals(logoJugador)));
            //Guardamos los enemigos en las casillas del tablero y los escondemos
            mapa.setCasillaEnemigo(posEX, posEY);
            contEnemigos++;
        } while (contEnemigos <= cantEnemigos);

        mapa.mostrarTablero();
    }

    private void movimientos() {
        varios.instructionMov();
        char op;
        boolean salir = false;
        int tempX = posX;
        int tempY = posY;

        do {
            System.out.println("Ingrese la direccion en la que desea moverse");
            op = sc.nextLine().charAt(0);

            switch (op) {
                //Movimiento hacia arriba
                case 'w':
                    tempX = tempX - 1;

                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempX < 0) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempX = tempX + 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");
                       
                        } else if (casillaNueva instanceof CasillaPasto) {
                           
                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");
                           
                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                           
                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                            
                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                //Movimiento hacia abajo
                case 's':
                    tempX = tempX + 1;

                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempX >= mapa.getAncho()) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempX = tempX - 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");
                           
                        } else if (casillaNueva instanceof CasillaPasto) {
                            
                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");
                         
                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                           
                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                           
                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                //Movimiento hacia la izquierda
                case 'a':
                    tempY = tempY - 1;
                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempY < 0) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempY = tempY + 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");
                            
                        } else if (casillaNueva instanceof CasillaPasto) {
                            
                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");
                           
                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                            
                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                           
                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;
                case 'd':
                    tempY = tempY + 1;
                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempY >= mapa.getLargo()) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempY = tempY - 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");
                            
                        } else if (casillaNueva instanceof CasillaPasto) {
                           
                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");
                          
                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());                   
                        
                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                           
                            CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
                            
                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                case 'q':
                    salir = true;
                    break;
                default:
                    varios.pintarRojoBrillante("Seleccione una direccion valida");
            }
        } while (!salir);

    }

    private void logOriginal() {
        int x = posX;
        int y = posY;

        if (mapa.getCasilla(x, y) instanceof CasillaPasto) {
            mapa.setCasilla(pasto, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaTienda) {
            mapa.setCasilla(tienda, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaPosada) {
            mapa.setCasilla(posada, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaCiudad) {
            mapa.setCasilla(ciudad, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaEnemigo) {
            mapa.setCasilla(pasto, x, y);
        }
    }

}
